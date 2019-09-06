package com.jtzh.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.entity.Menuconfiguration;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.UseMapper;
import com.jtzh.service.UseService;
/**
 * 用户权限的查询
 * @author JTZH
 *
 */
@Service("useServiceImpl")
public class UseServiceImpl implements UseService{
	@Resource
	private UseMapper useMapper;
	@Override
	public Object getlist(Userinformation user) {
		return useMapper.getlist(user);
	}
}
