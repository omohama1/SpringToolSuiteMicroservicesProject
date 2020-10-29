package com.obmohamad.photoapp.api.users.ui.model;

import javax.validation.constraints.*;

public class CreateUserRequestModel {
	
	@NotNull(message="user first name cannot be null")
	@Size(min=2,message="name must be at least two characters")
	private String firstName;
	
	@NotNull(message="user last name cannot be null")
	@Size(min=2,message="last name must be at least two characters")
	private String lastName;
	
	@NotNull(message="user password cannot be null")
	@Size(min=8, max=20,message="password must be between 8 and 20 characters")
	private String password;
	
	@NotNull(message="user email cannot be null")
	@Email
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
