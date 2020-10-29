package com.obmohamad.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obmohamad.app.ws.shared.Utils;
import com.obmohamad.app.ws.ui.model.request.UserDeetsRequestModel;
import com.obmohamad.app.ws.ui.model.response.UserRest;
import com.obmohamad.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
		
	}

	@Override
	public UserRest createUser(UserDeetsRequestModel userDetails) {
		UserRest userRest = new UserRest();
		userRest.setEmail(userDetails.getEmail());
		userRest.setFirstName(userDetails.getFirstName());
		userRest.setLastName(userDetails.getLastName());
		String userId = utils.generateUserId();
		userRest.setUserId(userId);
		if(users==null) users = new HashMap<>();
		users.put(userId, userRest);
		return userRest;
	}
	
	

}
