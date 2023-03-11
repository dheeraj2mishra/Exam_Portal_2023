package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamPortalApiApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApiApplication.class, args);
		System.out.println("*************Dheeraj*******");
	}

	@Override
	public void run(String... args) throws Exception {
          System.out.println("******** Code Started ************");	
          User user = new User();
          user.setUserName("dheeraj123");
          user.setEmail("dheeraj@gmail.com");
          user.setFirstName("Dheeraj");
          user.setLastName("Mishra");
          user.setPassword("dheeraj");
          user.setProfile("abc.png");
          
          Role role = new Role(44L, "ADMIN");
          UserRole userRole= new UserRole();
          userRole.setUser(user);
          userRole.setRole(role);
          Set<UserRole> userRoles = new HashSet<>();
          userRoles.add(userRole);
          User newUser = this.userService.createUser(user, userRoles);
          System.out.println("newUser  : " +newUser);
	}
}
