package com.billingsystem.billingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingsystem.billingsystem.dao.BillDao;
import com.billingsystem.billingsystem.dao.MenuDao;
import com.billingsystem.billingsystem.entities.Bill;

import java.time.LocalDate;
import java.util.*;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillDao billDao;


	@Override
	public List<Bill> getBillToday(){
		List<Bill> temp = billDao.findAll();
		List<Bill> list = new ArrayList<Bill>();
		for(int i=0; i<temp.size(); i++){
			String s1 = temp.get(i).getBillDate();
			String s2 = java.time.LocalDate.now().toString();
			if(s1.equals(s2)) {
				list.add(temp.get(i));
			}
		}
		return list;
	}
	
	@Override
	public List<Bill> getBillMonth(){
		List<Bill> temp = billDao.findAll();
		List<Bill> list = new ArrayList<Bill>();
		int m1 = LocalDate.now().getMonthValue();
		
		for(int i=0; i<temp.size(); i++){
			String s1 = temp.get(i).getBillDate().substring(5, 7);
			int m2 = Integer.parseInt(s1);
			if(m1==m2){
				list.add(temp.get(i));
			}
		}
		return list;
	}

	 
	 
	
	
}
