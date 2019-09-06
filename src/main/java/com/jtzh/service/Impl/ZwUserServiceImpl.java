package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.NumberUtil;
import com.jtzh.entity.GovmgtUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.GovmgtOrgStructureMapper;
import com.jtzh.mapper.GovmgtUserMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.TreeParam;
import com.jtzh.pojo.UserPagination;
import com.jtzh.service.ZwUserService;

@Service("userService")
public class ZwUserServiceImpl implements ZwUserService {
	@Resource
	private GovmgtUserMapper govmgtuserMapper;
	@Resource
	private GovmgtOrgStructureMapper orgMapper;

	@Override
	public Object getUserList(UserPagination param) {
		// 查询总数
		int total = govmgtuserMapper.selectTotal(param);
		List<GovmgtUser> list = new ArrayList<GovmgtUser>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = govmgtuserMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getUser(String id) {
		GovmgtUser user = govmgtuserMapper.selectUser(id);
		ResultObject obj = new ResultObject();
		obj.setObj(user);
		return obj;
	}

	@Override
	public Object removeUser(String id) {
		govmgtuserMapper.deleteUser(id);
		return new ResultObject();
	}

	@Override
	public Object insertUser(GovmgtUser user, LoginUserTest loginUser) {
		user.setDelflag(Constants.DELFLAG_FALSE);
		user.setCreateTime(new Date());
		user.setPassword(Constants.DEFAULT_USER_PASSWORD);
		user.setUserNumber("ZWU" + NumberUtil.getNumber());
		user.setYhzh(Constants.YHZH_BAOHUA);
		user.setCreateId(loginUser.getLoginId());
		govmgtuserMapper.insert(user);
		return new ResultObject();
	}

	@Override
	public Object updateUser(GovmgtUser user) {
		user.setDelflag(Constants.DELFLAG_FALSE);
		govmgtuserMapper.updateByPrimaryKey(user);
		return new ResultObject();
	}

	@Override
	public Object getTree() {
		List<TreeParam> t111 = orgMapper.selectBySId("0");
		TreeParam t1 = t111.get(0);
		List<TreeParam> t2 = orgMapper.selectBySId(t1.getId());
		List<TreeParam> tree2 = new ArrayList<TreeParam>();
		for (TreeParam t : t2) {
			List<TreeParam> t3 = orgMapper.selectBySId(t.getId());
			List<TreeParam> tree3 = new ArrayList<TreeParam>();
			for (TreeParam tt : t3) {
				List<TreeParam> t4 = orgMapper.selectBySId(tt.getId());
				tt.setChildren(t4);
				tree3.add(tt);
			}
			t.setChildren(tree3);
			tree2.add(t);
		}
		t1.setChildren(tree2);
		return t1;
	}

	@Override
	public Object getUserTree() {
		List<TreeParam> t111 = govmgtuserMapper.selectBySId("0");
		TreeParam t1 = t111.get(0);
		List<TreeParam> t2 = govmgtuserMapper.selectBySId(t1.getId());
		List<TreeParam> tree2 = new ArrayList<TreeParam>();
		for (TreeParam t : t2) {
			List<TreeParam> t3 = govmgtuserMapper.selectBySId(t.getId());
			List<TreeParam> tree3 = new ArrayList<TreeParam>();
			for (TreeParam tt : t3) {
				List<TreeParam> t4 = govmgtuserMapper.selectBySId(tt.getId());
				tt.setChildren(t4);
				tree3.add(tt);
			}
			t.setChildren(tree3);
			tree2.add(t);
		}
		t1.setChildren(tree2);
		return t1;
	}
	
	@Override
	public Object getAllUserList(GovmgtUser param) {
		// 查询总数
		int total = govmgtuserMapper.selectAllTotal(param);
		List<GovmgtUser> list = new ArrayList<GovmgtUser>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = govmgtuserMapper.selectAllInfo(param);
		}
		response.setRows(list);
		return response;
	}

}
