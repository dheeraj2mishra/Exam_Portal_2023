package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserName(String userName);
	public void deleteByUserName(String userName);

}
