package com.billingsystem.billingsystem.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billingsystem.billingsystem.dao.UserDao;
import com.billingsystem.billingsystem.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUsers(){
		return userDao.findAll();
	}

	@Override
	public User updateUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public boolean deleteUser(long id){
		List<User> list = userDao.findAll();
		int n=list.size();
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			User temp = (User) itr.next();
			if(id==temp.getUserId()){
				userDao.delete(temp);
				return true;
			}
		}
		return false;
 	}

	@Override
	public boolean loginUser(User user) {
		List<User> list = userDao.findAll();
		int n=list.size();
		for(int i=0; i<n; i++){
			User temp = list.get(i);
			boolean c1=false, c2=false;
			 
			 if(user.getUserId()==temp.getUserId()){
				 c1=true;
			 }
			 //System.out.println(user.getUserName()+"  "+temp.getUserName()+"\n");
			 if(user.getUserName().equals(temp.getUserName()) & user.getUserPassword().equals(temp.getUserPassword())) {  
				 c2=true; 
		     }
			 
			 if(c1&c2) {
				 System.out.println("You have successfully logged in.");
				 return true;
			 }
		}
		return false;
	}

	@Override
	public User registerUser(User user){
		List<User> list = userDao.findAll();
		int n=list.size();
		boolean check=false;
		for(int i=0; i<n; i++){
			User temp = list.get(i);
			if(temp.getUserName().equals(user.getUserName())){
				check=true;
				break;
			}
		}
		if(check){
			System.out.println("\n"+"Please login with different username. This username is already taken."+"\n");
			return user;
		}
		
		userDao.save(user);
		return user;
	}
}
