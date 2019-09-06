package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.HiddenDanger;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WorkshopAdm;
import com.jtzh.entity.WorkshopEnt;
import com.jtzh.entity.WorkshopEqu;
import com.jtzh.mapper.WorkshopAdmMapper;
import com.jtzh.mapper.WorkshopEntMapper;
import com.jtzh.mapper.WorkshopEquMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.WorkshopParam;

@Service("workshopService")
public class WorkshopServiceImpl implements WorkshopService {
	
	@Resource
	private WorkshopEntMapper workshopEntMapper;
	@Resource
	private WorkshopAdmMapper workshopAdmMapper;
	@Resource
	private WorkshopEquMapper workshopEquMapper;
	
	// 企业档案
	// 查询
	@Override
	public Object getWorkshopEntList(WorkshopParam param) {
		List<WorkshopEnt> list = workshopEntMapper.selectInfo(param);
		int total = workshopEntMapper.selectEntTotal(param);
		PageResult res = new PageResult();
		if (total > 0) {
			res.setOk(true);
			res.setRows(list);
			res.setTotal(total);
		} else {
			res.setOk(false);
			res.setTotal(0);
		}
		return res;
	}
		
	// 查询详情
	@Override
	public WorkshopEnt getWorkshopEnt(String id) {
		// 根据id去查询通知公告信息
		WorkshopEnt workshopEnt = workshopEntMapper.getWorkshopEnt(id);
		return workshopEnt;
	}
		
	// 修改
	@Override
	public Object updateWorkshopEnt(WorkshopEnt param) {
		workshopEntMapper.updateWorkshopEnt(param);
		return new ResultObject();
	}
		
	// 新建
	@Override
	public Object addWorkshopEnt(WorkshopEnt ent, LoginUserTest user) {
		// ent.setYhzh("宝华镇");
		ent.setYhzh(Constants.YHZH_BAOHUA);
		ent.setCreateTime(new Date());
		ent.setIsdeleted("0");
		ent.setCreateId(user.getLoginId());
		workshopEntMapper.addWorkshopEnt(ent);
		return new ResultObject();
	}
		
	// 删除
	@Override
	public Object deleteWorkshopEnt(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		workshopEntMapper.deleteWorkshopEnt(id);
		return new ResultObject();
	}
	
	// 厂区概况
	// 查询
	@Override
	public Object getWorkshopAdmList(WorkshopParam param) {
		// 查询总数
		int total = workshopAdmMapper.selectAdmTotal(param);
		List<WorkshopAdm> list = new ArrayList<WorkshopAdm>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = workshopAdmMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
			
	// 查询详情
	@Override
	public WorkshopAdm getWorkshopAdm(String id) {
		// 根据id去查询通知公告信息
		WorkshopAdm workshopAdm = workshopAdmMapper.getWorkshopAdm(id);
		return workshopAdm;
	}
			
	// 修改
	@Override
	public Object updateWorkshopAdm(WorkshopAdm param) {
		workshopAdmMapper.updateWorkshopAdm(param);
		return new ResultObject();
	}
			
	// 新建
	@Override
	public Object addWorkshopAdm(WorkshopAdm adm, LoginUserTest user) {
		// adm.setYhzh("宝华镇");
		adm.setYhzh(Constants.YHZH_BAOHUA);
		adm.setCreateTime(new Date());
		adm.setIsdeleted("0");
		adm.setCreateId(user.getLoginId());
		workshopAdmMapper.addWorkshopAdm(adm);
		return new ResultObject();
	}
			
	// 删除
	@Override
	public Object deleteWorkshopAdm(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		workshopAdmMapper.deleteWorkshopAdm(id);
		return new ResultObject();
	}
		
	@Override
	public Object getAdmGis() {
		List<WorkshopAdm> list = workshopAdmMapper.selectInfoWeb();
		PageResult response = new PageResult();
		if (list != null && list.size() > 0) {
			response.setOk(true);
			response.setTotal(list.size());
			response.setRows(list);
		} else {
			response.setOk(false);
			response.setTotal(0);
		}
		return response;
	}

	// 器材管理
	// 查询
	@Override
	public Object getWorkshopEquList(WorkshopParam param) {
		// 查询总数
		int total = workshopEquMapper.selectEquTotal(param);
		List<WorkshopEqu> list = new ArrayList<WorkshopEqu>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = workshopEquMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
				
	// 查询详情
	@Override
	public WorkshopEqu getWorkshopEqu(String id) {
		// 根据id去查询通知公告信息
		WorkshopEqu workshopEqu = workshopEquMapper.getWorkshopEqu(id);
		return workshopEqu;
	}
				
	// 修改
	@Override
	public Object updateWorkshopEqu(WorkshopEqu param) {
		workshopEquMapper.updateWorkshopEqu(param);
		return new ResultObject();
	}
				
	// 新建
	@Override
	public Object addWorkshopEqu(WorkshopEqu equ, LoginUserTest user) {
		// equ.setYhzh("宝华镇");
		equ.setYhzh(Constants.YHZH_BAOHUA);
		equ.setCreateTime(new Date());
		equ.setIsdeleted("0");
		equ.setCreateId(user.getLoginId());
		workshopEquMapper.addWorkshopEqu(equ);
		return new ResultObject();
	}
				
	// 删除
	@Override
	public Object deleteWorkshopEqu(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		workshopEquMapper.deleteWorkshopEqu(id);
		return new ResultObject();
	}

	@Override
	public Object countAdmAllCountryside() {
		ResultObject res = new ResultObject();
		res.setObj(workshopAdmMapper.countAdmAllCountryside());
		return res;
	}
}
