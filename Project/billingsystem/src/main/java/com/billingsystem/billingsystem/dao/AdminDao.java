package com.billingsystem.billingsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.billingsystem.billingsystem.entities.Admin;

public interface AdminDao extends JpaRepository<Admin,Long>{

}
