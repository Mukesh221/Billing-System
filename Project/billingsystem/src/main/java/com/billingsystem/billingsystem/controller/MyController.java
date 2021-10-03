package com.billingsystem.billingsystem.controller;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
	
import com.billingsystem.billingsystem.entities.Admin;
import com.billingsystem.billingsystem.entities.Menu;
import com.billingsystem.billingsystem.entities.User;
import com.billingsystem.billingsystem.entities.Bill;
import com.billingsystem.billingsystem.services.AdminService;
import com.billingsystem.billingsystem.services.BillService;
import com.billingsystem.billingsystem.services.MenuService;
import com.billingsystem.billingsystem.services.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class MyController{

	 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private BillService billService;
	
	boolean checkuser = false;
	boolean checkadmin = false;
	
//-------------------------------bill----------------------------------------//
	 
	
	//Getting bills which are generated today
    @GetMapping("/today")
    public List<Bill> getBillToday(){
    	if(checkadmin==true && checkuser==true) {
    		System.out.println("User and Admin cannot use this application simultaneously. Please log out as a user to"
    				+ "see the bills");
    		return null;
    	}
    	else if(checkadmin) {
    		return this.billService.getBillToday();
    	}else {
    		System.out.println("You are not logged In. please login first"+"\n");
			return null;
    	}
    }
    
    //Getting bills which are generated this month
    @GetMapping("/month")
    public List<Bill> getBillMonth(){
    		return this.billService.getBillMonth();
   }
    
//-------------------------menu--------------------------------//
    
    //Getting the menu
	@GetMapping("/menu")
	public List<Menu> getMenu(){
		return this.menuService.getMenu();
		
	}
	
	//Selecting more than one option from the menu
	@PostMapping("/selectmenu")
	public void showMenu(@RequestBody LinkedHashMap mp){
		
	System.out.println(mp);
	System.out.println((String) mp.get("billDate"));
		this.menuService.showMenu(mp);
//			int n = arr.length;
//			for(int i=0; i<n; i++) {
//				if(arr[i]>8 || arr[i]<=0) {
//					System.out.println("Please enter sequence numbers from 1 to 8 because there are "
//							+ "only 8 items available in the menu");
//					return 0;
//				}
//			}
	}
	
	 
	
//-----------------------users--------------------------------//	
	
	//login of user
	@PostMapping("/loginuser")
	public ResponseEntity<Long> loginUser(@RequestBody User user) {
		if(checkuser) {
			System.out.println("\n"+"You are already logged in."+"\n");
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			boolean check = userService.loginUser(user);
			
			if(!check) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				checkuser=true;
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		
	}
	
	//logout of user
	@PostMapping("/logoutuser")
	public ResponseEntity<Long> logoutUser(){
		if(checkuser) {
			checkuser=false;
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			System.out.println("\n"+"You need to login first."+"\n");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//registration/creation of user
	@PostMapping("/register")
	public ResponseEntity<Long> registerUser(@RequestBody User user){
		if(checkuser) {
			System.out.println("You are already logged in. Please logout to register."+"\n");	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			 userService.registerUser(user);
			 return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	 
	
	//Read of CRUD
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	//Update of CRUD
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		 return this.userService.updateUser(user);
	}
	
	//Delete of CRUD
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable("id") String id) {
		if(checkadmin) {
			boolean check  = userService.deleteUser(Long.parseLong(id));
			if(!check) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}else {
			System.out.println("Please login first");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//------------------admins--------------------------------//
	
	@GetMapping("/admins")
	public List<Admin> getAdmins(){
		return this.adminService.getAdmins();
	}
	
	//login of admin
	@PostMapping("/admin")
	public ResponseEntity<Long> loginAdmin(@RequestBody Admin admin) {
		 
			boolean check = adminService.loginAdmin(admin);
			if(!check) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				checkadmin=true;
				return new ResponseEntity<>(HttpStatus.OK);
			}	
		}		
	
	
	//logout of Admin
	@GetMapping("/admin")
	public ResponseEntity<Long> logoutAdmin(){
		if(checkadmin) {
			checkadmin=false;
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			System.out.println("\n"+"You need to login first."+"\n");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
