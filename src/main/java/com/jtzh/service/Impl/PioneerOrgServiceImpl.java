package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.NumberUtil;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerOrg;
import com.jtzh.mapper.PioneerOrgMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.PioneerOrgCount;
import com.jtzh.pojo.PioneerOrgPagination;
import com.jtzh.pojo.PioneerOrgTree;
import com.jtzh.service.PioneerOrgService;

@Service("pioneerOrgService")
public class PioneerOrgServiceImpl implements PioneerOrgService {
	@Resource
	private PioneerOrgMapper orgMapper;

	@Override
	public Object getPioneerOrgList(PioneerOrgPagination param) {
		// 查询总数
		int total = orgMapper.selectTotal(param);
		List<PioneerOrg> list = new ArrayList<PioneerOrg>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = orgMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getPioneerOrg(String id) {
		PioneerOrg org = orgMapper.selectOrg(id);
		ResultObject obj = new ResultObject();
		obj.setObj(org);
		return obj;
	}

	@Override
	public Object removePioneerOrg(String id) {
		orgMapper.deleteOrg(id);
		return new ResultObject();
	}

	@Override
	public Object insertPioneerOrg(PioneerOrg org, LoginUserTest user) {
		org.setDelflag(Constants.DELFLAG_FALSE);
		org.setCreateTime(new Date());
		org.setOrgNumber("XFO" + NumberUtil.getNumber());
		org.setYhzh(Constants.YHZH_BAOHUA);
		org.setCreateId(user.getLoginId());
		orgMapper.insert(org);
		return new ResultObject();
	}

	@Override
	public Object updatePioneerOrg(PioneerOrg org) {
		org.setDelflag(Constants.DELFLAG_FALSE);
		orgMapper.updateByPrimaryKey(org);
		return new ResultObject();
	}

	@Override
	public Object getPioneerOrgTree() {
		List<PioneerOrgTree> t111 = orgMapper.selectBySId("0");
		List<PioneerOrgTree> treef = new ArrayList<PioneerOrgTree>();
		for (PioneerOrgTree t0 : t111) {
			List<PioneerOrgTree> t2 = orgMapper.selectBySId(t0.getId());
			List<PioneerOrgTree> tree2 = new ArrayList<PioneerOrgTree>();
			for (PioneerOrgTree t : t2) {
				List<PioneerOrgTree> t3 = orgMapper.selectBySId(t.getId());
				List<PioneerOrgTree> tree3 = new ArrayList<PioneerOrgTree>();
				for (PioneerOrgTree tt : t3) {
					List<PioneerOrgTree> t4 = orgMapper.selectBySId(tt.getId());
					tt.setChildren(t4);
					tree3.add(tt);
				}
				t.setChildren(tree3);
				tree2.add(t);
			}
			t0.setChildren(tree2);
			treef.add(t0);
		}
		return treef;
	}
	
	public Long getCountList() {
        return orgMapper.getCountList();
    }
	
	public Object getCountOrgList(){
		List<PioneerOrgCount> t111 = orgMapper.selectBySId2("0");
		List<PioneerOrgCount> treef = new ArrayList<PioneerOrgCount>();
		for (PioneerOrgCount t0 : t111) {
			List<PioneerOrgCount> t2 = orgMapper.selectBySId2(t0.getId());
			List<PioneerOrgCount> tree2 = new ArrayList<PioneerOrgCount>();
			for (PioneerOrgCount t : t2) {
				t.setCount(orgMapper.getCountOrgList(t.getId()).toString());
			}
			t0.setCount((orgMapper.getCountOrgList(t0.getId())).toString());
			treef.add(t0);
		}
		return treef;
	}

}
