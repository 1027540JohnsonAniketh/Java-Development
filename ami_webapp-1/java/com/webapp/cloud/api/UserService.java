package com.webapp.cloud.api;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.webapp.cloud.model.MyUserDetails;
import com.webapp.cloud.model.User;
import com.webapp.cloud.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class UserService implements UserDetailsService  {
	
	private UserImpl userHelper=new UserImpl();
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		loadUserByUsername(username);
		
		if (!userRepository.existsByUsername(username)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The User "+username+" does not exist");
		}
		
		return userRepository.findByUsername(username);
	}
	

	@GetMapping("/users")
	public List<User> getUsersAll() {
		
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		if (!userRepository.existsByUsername(user.getUsername()) && userHelper.isValidUsername(user.getUsername())) {
			String pwd=userHelper.generateBcryptedPassword(user.getPassword());
			String uuid = userHelper.generateRandomUUID();
			user.setId(uuid);
			user.setPassword(pwd);
			String date=userHelper.getDate();
			user.setAccountcreated(date);
			user.setAccountupdated(date);
		} else {
			
			if(!userHelper.isValidUsername(user.getUsername()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username is invalid");

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username is already present");
		}
		return userRepository.save(user);
	}

	
	
	@PutMapping("/users/{username}")
	public User updateUser(@RequestBody User updateUser, @PathVariable("username") String username) {
		
		loadUserByUsername(username);
		
		User user = userRepository.findByUsername(username);

		if (userHelper.checkForValidUpdateFields(updateUser))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You are not allowed to update some fields");

		if (!(updateUser.getFirstname() == null)) {
			user.setFirstname(updateUser.getFirstname());
		}

		if (!(updateUser.getLastname() == null)) {
			user.setLastname(updateUser.getLastname());
		}

		if (!(updateUser.getPassword() == null)) {
			String pwd=userHelper.generateBcryptedPassword(user.getPassword());
			
			user.setPassword(pwd);
		}
		String date=userHelper.getDate();
		user.setAccountupdated(date);

		return userRepository.save(user);
	}
	
	
		 @Override
		    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		        User user = userRepository.findByUsername(userId);
		        if(user==null) 
		        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The User "+userId+" does not exist");
		        else 
		        	return new MyUserDetails(user);
		    }

}
