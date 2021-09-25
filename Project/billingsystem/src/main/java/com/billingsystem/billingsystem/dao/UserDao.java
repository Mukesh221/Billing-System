package com.billingsystem.billingsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.billingsystem.billingsystem.entities.User;

public interface UserDao extends JpaRepository<User,Long> {
	 
}
