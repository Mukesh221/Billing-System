package com.billingsystem.billingsystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.billingsystem.billingsystem.entities.User;

 

public interface UserService{
	public List<User> getUsers();
	
	public User updateUser(User user);
	public boolean deleteUser(long id);
	public boolean loginUser(User user);
	public User registerUser(User user); 
}
