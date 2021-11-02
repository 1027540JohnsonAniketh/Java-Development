package com.webapp.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@EnableAutoConfiguration
@Table(name="images")
public class ImageEntity {
	
	@Id
	@Column(name="id")
	private String id;
	@Column(name="url")
	private String url;
	@Column(name="upload_date")
	private String uploadDate;
	@Column(name="user_id")
	private String userId;
	@Column(name="file_name")
	private String fileName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUpload_date() {
		return uploadDate;
	}
	public void setUpload_date(String upload_date) {
		this.uploadDate = upload_date;
	}
	public String getUser_id() {
		return userId;
	}
	public void setUser_id(String user_id) {
		this.userId = user_id;
	}
	public String getFile_name() {
		return fileName;
	}
	public void setFile_name(String file_name) {
		this.fileName = file_name;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + ", upload_date=" + uploadDate + ", user_id=" + userId
				+ ", file_name=" + fileName + "]";
	}
}
