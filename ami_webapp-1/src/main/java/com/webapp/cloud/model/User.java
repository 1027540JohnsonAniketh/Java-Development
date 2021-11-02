package com.webapp.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@EnableAutoConfiguration
@Table(name = "users")
public class User {
	@Id
	private String uuid;
	private String firstname;
	private String lastname;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private String username;
	private String accountcreated;
	private String accountupdated;
	public String getId() {
		return uuid;
	}
	public void setId(String uuid) {
		this.uuid = uuid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountcreated() {
		return accountcreated;
	}
	public void setAccountcreated(String accountcreated) {
		this.accountcreated = accountcreated;
	}
	public String getAccountupdated() {
		return accountupdated;
	}
	public void setAccountupdated(String accountupdated) {
		this.accountupdated = accountupdated;
	}
	@Override
	public String toString() {
		return "User [id=" + uuid + ", firstName=" + firstname + ", lastName=" + lastname + ", password=" + password
				+ ", username=" + username + ", accountCreated=" + accountcreated + ", accountUpdated=" + accountupdated
				+ "]";
	}

}