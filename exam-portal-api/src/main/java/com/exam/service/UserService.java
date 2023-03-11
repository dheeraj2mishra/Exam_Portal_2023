package com.exam.service;

import java.util.Set;

import com.exam.entities.User;
import com.exam.entities.UserRole;

public interface UserService {
	
	//create user
	public User createUser(final User user, final Set<UserRole> userRoles) throws Exception;
	
	//Get User By user name
	public User getUserByUserName(final String userName);
	
	//Delete User by USer Name
	
	public void deleteUserByUserId(final Long userId);

}
