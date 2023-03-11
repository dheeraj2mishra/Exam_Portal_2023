package com.exam.service;

import java.util.Set;

import com.exam.entities.User;
import com.exam.entities.UserRole;

public interface UserService {
	
	//create user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
