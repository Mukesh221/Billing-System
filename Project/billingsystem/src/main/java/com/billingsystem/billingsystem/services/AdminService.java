package com.billingsystem.billingsystem.services;
import java.util.*;

import com.billingsystem.billingsystem.entities.Admin;

public interface AdminService {
	public List<Admin> getAdmins();
	 
	public boolean loginAdmin(Admin admin);
}
