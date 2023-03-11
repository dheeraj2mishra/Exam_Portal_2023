package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// Create user End Point
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Role role = new Role(45L, "NORMAL");
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRoles.add(userRole);
		user = this.userService.createUser(user, userRoles);
		return user;

	}
	
	@GetMapping("/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) {
		return this.userService.getUserByUserName(userName);
		
	}

	@DeleteMapping("/{userId}")
	public void deleteUserByUserName(@PathVariable("userId") Long userId) {
		this.userService.deleteUserByUserId(userId);
		
	}
}
