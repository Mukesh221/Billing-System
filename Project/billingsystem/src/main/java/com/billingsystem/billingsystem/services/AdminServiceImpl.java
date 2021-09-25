package com.billingsystem.billingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingsystem.billingsystem.dao.AdminDao;
import com.billingsystem.billingsystem.entities.Admin;
import com.billingsystem.billingsystem.entities.User;

import java.util.*;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public AdminServiceImpl() {	
	}
	
	@Override
	public List<Admin> getAdmins(){
		return adminDao.findAll();
	}

	 

	@Override
	public boolean loginAdmin(Admin admin) {
		List<Admin> list = adminDao.findAll();
		int n=list.size();
		for(int i=0; i<n; i++){
			Admin temp = list.get(i);
			boolean c1=false, c2=false;
			 
			 if(admin.getAdminId()==temp.getAdminId()){
				 c1=true;
			 }
			 
			 if(admin.getAdminName().equals(temp.getAdminName()) & admin.getAdminPassword().equals(temp.getAdminPassword())) {  
				 c2=true; 
		     }
			 
			 if(c1&c2) {
				 System.out.println("You have successfully logged in.");
				 return true;
			 }
		}
		return false;
	}
	
}
