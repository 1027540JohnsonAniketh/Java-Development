package com.webapp.cloud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.cloud.model.ImageEntity;


public interface ImageRepository extends JpaRepository<ImageEntity,String>{
	ImageEntity findByFileNameAndUserId(String fileName,String userId);
	ImageEntity findByFileName(String fileName);
	ImageEntity findByUserId(String userId);
	Optional<ImageEntity> findById(String id);
	boolean existsByUserId(String userId);
	boolean existsById(String id);
}
