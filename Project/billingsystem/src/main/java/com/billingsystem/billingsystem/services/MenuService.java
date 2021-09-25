package com.billingsystem.billingsystem.services;
import java.util.*;

import com.billingsystem.billingsystem.entities.Menu;

public interface MenuService {
	public List<Menu> getMenu();
	public Menu getOneMenu(long id);
	public void showMenu(LinkedHashMap mp);
}
	 

