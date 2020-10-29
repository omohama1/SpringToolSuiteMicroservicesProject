package com.obmohamad.app.ws.userservice;

import com.obmohamad.app.ws.ui.model.request.UserDeetsRequestModel;
import com.obmohamad.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDeetsRequestModel userDetails);
	

}
