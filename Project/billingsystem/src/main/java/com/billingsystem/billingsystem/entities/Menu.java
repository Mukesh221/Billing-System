package com.billingsystem.billingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	
	@Id
	private long menuId;
	private String itemName;
	private long itemCost;
	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public long getItemCost() {
		return itemCost;
	}
	public void setItemCost(long itemCost) {
		this.itemCost = itemCost;
	}
	public Menu(long menuId, String itemName, long itemCost) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
	

}
