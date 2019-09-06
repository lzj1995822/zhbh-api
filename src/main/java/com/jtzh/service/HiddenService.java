package com.jtzh.service;

import com.jtzh.vo.hidden.HiddenTypeVO;
import org.springframework.web.bind.annotation.PathVariable;

import com.jtzh.entity.HiddenDanger;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.HiddenDetail;
import com.jtzh.pojo.HiddenParam;

import java.util.List;

public interface HiddenService {
	
	public Object getHiddenList(HiddenParam param); // 查询

	public HiddenDetail getHiddenInfo(String id); // 查看详情

	public Object addHidden(HiddenDetail HiddenDetail, LoginUserTest user); // 新建

	public Object deleteHidden(String id, String sourceType); // 删除
	
	Object updateHidden(HiddenDanger param); // 修改
	
	Object moveHidden(HiddenDanger param); // 移交
	
	Object sendHidden(HiddenDanger param); // 指派
	
	Object solveHidden(HiddenDetail HiddenDetail); // 整改
	
	public Object getHiddenCoordinate();

	public Object countHiddenState();

	public Object getHiddenGis(HiddenParam param); // 查询
	
	public Object countHiddenByYear(String year);
	
	public Object countHiddenByState(String state);
	
	public Object countHiddenStateNoParam();
	
	public Object countHiddenByMonth(String year);
	
	public Object countHiddenByDay(String year);
	
	public Object countHiddenAllCountryside();
	
	public Object countHiddenByType();
	
	public Object countHiddenByPeople();

	public abstract List<HiddenTypeVO> getHiddenType();

	public Object getHiddenCountByType();


}
