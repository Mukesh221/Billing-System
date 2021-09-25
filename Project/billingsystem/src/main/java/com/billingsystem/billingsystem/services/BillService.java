package com.billingsystem.billingsystem.services;
import java.util.*;

import com.billingsystem.billingsystem.entities.Bill;
public interface BillService {
	 public List<Bill> getBillToday();
	 public List<Bill> getBillMonth();
	  
	 
}
