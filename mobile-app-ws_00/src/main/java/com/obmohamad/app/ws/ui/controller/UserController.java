package com.obmohamad.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obmohamad.app.ws.exceptions.UserServiceException;
import com.obmohamad.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.obmohamad.app.ws.ui.model.request.UserDeetsRequestModel;
import com.obmohamad.app.ws.ui.model.response.UserRest;
import com.obmohamad.app.ws.userservice.UserService;
import com.obmohamad.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("/users") // http://localhost:8080/users/[METHOD NAME]
public class UserController {
	
	@Autowired
	UserService userService;
	

	Map<String, UserRest> users;

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping
	public String getAllUsers(@RequestParam(value = "page", defaultValue="1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		return "get all users was called with value=" + page + " and limit =" + limit + " and sort = " + sort;
	}

	@PostMapping(
			consumes = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE },
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDeetsRequestModel userDeets) {
		UserRest returnValue = userService.createUser(userDeets);
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}

	@PutMapping(path="/{userId}", consumes = { 
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE },

	produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDeets) {
		UserRest storedUser = users.get(userId);
		storedUser.setFirstName(userDeets.getFirstName());
		storedUser.setLastName(userDeets.getLastName());
		users.put(userId, storedUser);
		return storedUser;
	}

	@DeleteMapping(path = "/{userId}",
			produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		UserRest storedUser = null;
			storedUser = users.get(userId);
			users.remove(userId);
			return ResponseEntity.noContent().build();
	}

}
