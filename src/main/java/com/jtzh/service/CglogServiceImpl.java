package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.Cglog;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CglogMapper;
import com.jtzh.pojo.CglogParam;
import com.jtzh.pojo.PageResult;

@Service("cglogService")
public class CglogServiceImpl implements CglogService {
	@Resource
	private CglogMapper cglogMapper;
	
	// 查询
		@Override
		public Object getCglogList(CglogParam param) {
			// 查询总数
			int total = cglogMapper.selectCglTotal(param);
			List<Cglog> list = new ArrayList<Cglog>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = cglogMapper.selectInfo(param);
			}
			res.setRows(list);
			return res;
		}
				
		// 查询详情
		@Override
		public Cglog getCglogInfo(String id) {
			// 根据id去查询通知公告信息
			Cglog cglog = cglogMapper.getCglogInfo(id);
			return cglog;
		}
				
		// 新建
		@Override
		public Object addCglog(Cglog cglog, LoginUserTest user) {
			cglog.setSubmittime(new Date());
			cglog.setYhzh(Constants.YHZH_BAOHUA);
			cglog.setCreateId(user.getLoginId());
			cglog.setCreateTime(new Date());
			cglog.setDelflag("A");
			cglogMapper.addCglog(cglog);
			return new ResultObject();
		}
				
		// 删除
		@Override
		public Object deleteCglog(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			cglogMapper.deleteCglog(id);
			return new ResultObject();
		}
			
		// 修改
		@Override
		public Object updateCglog(Cglog param) {
			cglogMapper.updateCglog(param);
			return new ResultObject();
		}

}
