package com.webapp.cloud.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.webapp.cloud.model.User;


public class UserImpl {

	public String generateBcryptedPassword(String password) {
		String pwd = BCrypt.hashpw(password, BCrypt.gensalt());
		return pwd;
	}
	public String generateRandomUUID() {
		return UUID.randomUUID().toString();
	}
	public String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	public boolean checkForValidUpdateFields(User user) {
		boolean checkUserIdIsSet=user.getId()!=null;
		boolean checkUserNameIsSet=user.getUsername()!=null;
		boolean checkAccountCreatedIsSet=user.getAccountcreated()!=null;
		boolean checkAccountUpdatedIsSet=user.getAccountupdated()!=null;
		
		return (checkUserIdIsSet||checkUserNameIsSet||checkAccountCreatedIsSet||checkAccountUpdatedIsSet);
	}
	public boolean isValidUsername(String username) {
		return username.contains("@") && username.contains(".com");
	}
	
}
