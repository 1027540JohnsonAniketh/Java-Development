package com.webapp.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
@Table(name = "metadata")
public class Metadata {
	@Id
	@Column(name="`key`")
	private String key;	
	@Column(name="`size`")
	private long size;
	@Column(name="`lastmodified`")
	private String lastmodified;
	@Column(name="`storageclass`")
	private String storageclass;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getLastModified() {
		return lastmodified;
	}
	public void setLastModified(String lastmodified) {
		this.lastmodified = lastmodified;
	}
	public String getStorageClass() {
		return storageclass;
	}
	public void setStorageClass(String storageclass) {
		this.storageclass = storageclass;
	}
	@Override
	public String toString() {
		return "Metadata [key=" + key + ", size=" + size + ", lastModified=" + lastmodified + ", storageClass="
				+ storageclass + "]";
	}
	
}
