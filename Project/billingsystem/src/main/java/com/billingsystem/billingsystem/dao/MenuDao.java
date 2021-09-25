package com.billingsystem.billingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billingsystem.billingsystem.entities.Menu;

public interface MenuDao extends JpaRepository<Menu, Long> {

}
