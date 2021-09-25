package com.billingsystem.billingsystem.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingsystem.billingsystem.dao.BillDao;
import com.billingsystem.billingsystem.dao.MenuDao;
import com.billingsystem.billingsystem.entities.Bill;
import com.billingsystem.billingsystem.entities.Menu;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private BillDao billDao;
	
	@Override
	public List<Menu> getMenu() {
		 return menuDao.findAll();
	}

	@Override
	public Menu getOneMenu(long id) {
		 return menuDao.getOne(id);
		 
	}

	@Override
	 
	public void showMenu(LinkedHashMap mp) {
//		List<Menu> list = menuDao.findAll();
//		long finalBill = 0;
//		for(int i=0; i<arr.length; i++) {
//			 for(int j=0; j<list.size(); j++) {
//				 if(arr[i]==list.get(j).getMenuId()) {
//					 finalBill+=list.get(j).getItemCost();
//					 break;
//				 }
//				 
//			 }
//		}
		
		Bill temp = new Bill();
		 
		temp.setTotalAmount((Integer) mp.get("totalAmount"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate today = LocalDate.now( ZoneId.of( "Asia/Kolkata" ) ) ;
		dtf.format(today);
		String output = today.toString();   //Output string will store the date
		
		temp.setBillDate(output);
		billDao.save(temp);
		
		 
		
   }
	
	
}
