package com.webapp.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.cloud.model.Metadata;

public interface MetadataRepository extends JpaRepository<Metadata, String> {
	Metadata findByKey(String key);
	boolean existsByKey(String key); 

}
