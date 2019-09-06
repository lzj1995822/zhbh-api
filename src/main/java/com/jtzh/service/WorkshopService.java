package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WorkshopAdm;
import com.jtzh.entity.WorkshopEnt;
import com.jtzh.entity.WorkshopEqu;
import com.jtzh.pojo.WorkshopParam;

public interface WorkshopService {
	
	// 企业档案
	public Object getWorkshopEntList(WorkshopParam param); // 查询
	
	public WorkshopEnt getWorkshopEnt(String id); // 查看详情
	
	public Object addWorkshopEnt(WorkshopEnt ent, LoginUserTest user); // 新建
	
	Object updateWorkshopEnt(WorkshopEnt param); // 修改
	
	public Object deleteWorkshopEnt(String id); // 删除
	
	// 厂区概况
	public Object getWorkshopAdmList(WorkshopParam param); // 查询
	
	public WorkshopAdm getWorkshopAdm(String id); // 查看详情
	
	public Object addWorkshopAdm(WorkshopAdm adm, LoginUserTest user); // 新建
	
	Object updateWorkshopAdm(WorkshopAdm param); // 修改
	
	public Object deleteWorkshopAdm(String id); // 删除
	
	public Object getAdmGis();
	
	// 器材管理
	public Object getWorkshopEquList(WorkshopParam param); // 查询
	
	public WorkshopEqu getWorkshopEqu(String id); // 查看详情
	
	public Object addWorkshopEqu(WorkshopEqu equ, LoginUserTest user); // 新建
	
	Object updateWorkshopEqu(WorkshopEqu param); // 修改
	
	public Object deleteWorkshopEqu(String id); // 删除
	
	public Object countAdmAllCountryside();

}
