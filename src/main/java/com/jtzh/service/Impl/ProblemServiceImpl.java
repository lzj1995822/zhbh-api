package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.GovmgtProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.GovmgtProblemMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.ProblemPagination;
import com.jtzh.service.ProblemService;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
	@Resource
	private GovmgtProblemMapper problemMapper;

	@Override
	public Object getProblemList(ProblemPagination param) {
		// 查询总数
		int total = problemMapper.selectTotal(param);
		List<GovmgtProblem> list = new ArrayList<GovmgtProblem>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

	// 查询详情
	@Override
	public GovmgtProblem getProblem(String id) {
		// 根据id去查询
		GovmgtProblem problem = problemMapper.selectProblem(id);
		return problem;
	}
	
	// 删除
	@Override
	public Object removeProblem(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		problemMapper.deleteProblem(id);
		return new ResultObject();
	}

	@Override
	public Object addProblem(GovmgtProblem param, LoginUserTest user) {
		param.setCreateTime(new Date());
		param.setDelflag(Constants.DELFLAG_FALSE);
		param.setYhzh(Constants.YHZH_BAOHUA);
		param.setCreateId(user.getLoginId());
		problemMapper.insertProblem(param);
		return new ResultObject();
	}

	
	// 修改
		@Override
		public Object modifyProblem(GovmgtProblem param) {
			problemMapper.updateByPrimaryKey(param);
			return new ResultObject();
		}

}
