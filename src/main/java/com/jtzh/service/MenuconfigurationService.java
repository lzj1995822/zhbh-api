package com.jtzh.service;

import com.jtzh.entity.Menuconfiguration;
import com.jtzh.pojo.MenuconfigurationPagination;

public interface MenuconfigurationService {
	public Object getMenuconfig(Integer id);

	public Object removeMenuconfig(Integer id);

	public Object addMenuconfig(Menuconfiguration detail);

	public Object modifyMenuconfig(Menuconfiguration detail);
	
	public Object getMenuconfigList(MenuconfigurationPagination param);
	
	public Object getAllMenuconfig();
}
