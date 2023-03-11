package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User userAlredyExist = this.userRepository.findByUserName(user.getUserName());
		if(userAlredyExist != null) {
			System.out.println("User "  +user.getUserName() + " alredy exist !!");
			throw new Exception("User Alredy Present !!");
		} else {
			for( UserRole userRole: userRoles) {
				this.roleRepository.save(userRole.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			userAlredyExist = this.userRepository.save(user);
		}
		return userAlredyExist;
	}


	@Override
	public User getUserByUserName(String userName) {
		 User user= this.userRepository.findByUserName(userName);
		return user;
	}


	@Override
	public void deleteUserByUserName(String userName) {
		this.userRepository.deleteByUserName(userName);
	}

}
