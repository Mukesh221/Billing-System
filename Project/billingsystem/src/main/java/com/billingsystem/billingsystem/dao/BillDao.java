package com.billingsystem.billingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billingsystem.billingsystem.entities.Bill;

public interface BillDao extends JpaRepository<Bill, Long>{
	
}
