package com.webapp.cloud.api;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.webapp.cloud.EC2.EC2Info;
import com.webapp.cloud.model.ImageEntity;
import com.webapp.cloud.model.Metadata;
import com.webapp.cloud.model.User;
import com.webapp.cloud.repository.ImageRepository;
import com.webapp.cloud.repository.MetadataRepository;
import com.webapp.cloud.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class ImageService {
	@Value("${cloud.aws.region.bucket.name}")
    private String bucketName;
	
	private UserImpl userHelper=new UserImpl();
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private EC2Info ec2Info;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@Autowired
	private MetadataRepository metadataRepository;
	
	
	@GetMapping("/users/{username}/{imagename}")
	public ImageEntity getImage(@PathVariable("username") String username,@PathVariable("imagename")String imagename) {
		
		if (!userRepository.existsByUsername(username)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The User "+username+" does not exist");
		}
		if(imageRepository.findByFileNameAndUserId(imagename, userRepository.findByUsername(username).getId())==null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The User "+username+" does not have a profile image");
		
		return imageRepository.findByFileNameAndUserId(imagename, userRepository.findByUsername(username).getId());
	}
	
	@PostMapping(path="/users/{username}/{imagename}")
	@ResponseBody
	public ImageEntity fileUpload( @PathVariable("file")MultipartFile file,@PathVariable("username")String username,
			@PathVariable("imagename")String imagename) throws Exception {
		bucketName=bucketName.trim();
		if(!userRepository.existsByUsername(username))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The User "+username+" does not exist");
		User user=userRepository.findByUsername(username);
		ImageEntity update=imageRepository.findByUserId(user.getId());
		ImageEntity imageEntity=new ImageEntity();
		if(update!=null &&	imageRepository.existsById(update.getId())) {
			imagename=update.getUser_id()+imagename;
			update.setFile_name(imagename);
			String url=buildUrl(update.getUrl(),imagename);
			update.setUrl(url);
			ListObjectsV2Result result = amazonS3.listObjectsV2(bucketName);
	        List<S3ObjectSummary> objects = result.getObjectSummaries();
	        for (S3ObjectSummary os : objects) {
	        	if(os.getKey().contains(user.getId())) {
	        		amazonS3.deleteObject(bucketName, os.getKey());
	        		Metadata meta=metadataRepository.findByKey(os.getKey());
	        		metadataRepository.delete(meta);
	        		break;
	        	}
	        }
	        uploadToS3Bucket(bucketName,file,imagename);
			return imageRepository.save(update);
		}else if(!imageRepository.existsByUserId(user.getId())) {
			String uuid = userHelper.generateRandomUUID();
			imageEntity.setId(uuid);
			String date=userHelper.getDate();
			imageEntity.setUpload_date(date);
			imagename=user.getId()+imagename;
			StringBuilder sb=new StringBuilder(bucketName+"/"+user.getId()+"/"+imagename);
			imageEntity.setUrl(sb.toString());
			imageEntity.setFile_name(imagename);
			imageEntity.setUser_id(user.getId());
		} 		
		uploadToS3Bucket(bucketName,file,imagename);
		return imageRepository.save(imageEntity);
	}
	private void uploadToS3Bucket(String bucketName,MultipartFile file,String imagename) throws Exception {
		try {
			if (!amazonS3.doesBucketExistV2(bucketName)) {
				throw new Exception("Exception");
			}
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			amazonS3.putObject(bucketName, imagename, file.getInputStream(), metadata);
			Metadata meta=new Metadata();
			meta.setKey(imagename);
			meta.setLastModified(userHelper.getDate());
			meta.setSize(file.getSize());
			meta.setStorageClass(bucketName);
			metadataRepository.save(meta);
		} catch (SdkClientException | IOException e) {
			throw new Exception("Exception");
		}
	}
	private String buildUrl(String url, String imagename) {
		int lastIndex=url.lastIndexOf("/");
		StringBuilder sb=new StringBuilder(url);
		sb.delete(lastIndex+1,sb.length());
		sb.append(imagename);
		return sb.toString();
	}
	
	
	@DeleteMapping("/users/{username}/{imagename}")
	public String deleteImage(@PathVariable("username") String username ,@PathVariable("imagename") String imagename){
		bucketName=bucketName.trim();

		if(!userRepository.existsByUsername(username))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The User "+username+" does not exist");
		User user=userRepository.findByUsername(username);
		ImageEntity image=imageRepository.findByFileNameAndUserId(imagename,user.getId());
		if(image==null||!imageRepository.existsById(image.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The User with image "+imagename+" does not exist");
		}
		deleteImageFromS3Bucket(user.getId(),image.getFile_name());
		imageRepository.delete(image);
		return "Image "+imagename+" successfully deleted";
	}

	private String deleteImageFromS3Bucket(String userId,String file_name) {
		if (!amazonS3.doesBucketExistV2(bucketName)) {
			return "No Bucket Found";
		}
		ListObjectsV2Result result = amazonS3.listObjectsV2(bucketName);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
        	if(os.getKey().contains(userId)) {
        		amazonS3.deleteObject(bucketName, os.getKey());
        		Metadata meta=metadataRepository.findByKey(os.getKey());
        		metadataRepository.delete(meta);
        		break;
        	}
        }
		return "File deleted successfully";
	}
}
