package com.billingsystem.billingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {
	
	@Id
	private long billId;
	private String billDate;
	 
	private long totalAmount;
	
	
	public Bill(long billId, String billDate, long totalAmount) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		 
		this.totalAmount = totalAmount;
	}
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getBillId() {
		return billId;
	}
	public void setBillId(long billId) {
		this.billId = billId;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	 
	 
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	

}
