package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.GovmgtLog;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.GovmgtLogMapper;
import com.jtzh.pojo.GovmgtLogParam;
import com.jtzh.pojo.PageResult;

@Service("govmgtLogService")
public class GovmgtLogServiceImpl implements GovmgtLogService{
	@Resource
	private GovmgtLogMapper govmgtLogMapper;
	
	// 查询
		@Override
		public Object getGovmgtLogList(GovmgtLogParam param) {
			// 查询总数
			int total = govmgtLogMapper.selectTotal(param);
			List<GovmgtLog> list = new ArrayList<GovmgtLog>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = govmgtLogMapper.selectInfo(param);
			}
			res.setRows(list);
			return res;
		}
			
		// 查询详情
		@Override
		public GovmgtLog getGovmgtLogInfo(String id) {
			// 根据id去查询通知公告信息
			GovmgtLog param = govmgtLogMapper.getGovmgtLogInfo(id);
			return param;
		}
			
		// 修改
		@Override
		public Object updateGovmgtLog(GovmgtLog param) {
			govmgtLogMapper.updateGovmgtLog(param);
			return new ResultObject();
		}
			
		// 新建
		@Override
		public Object addGovmgtLog(GovmgtLog param, LoginUserTest user) {
			param.setYhzh(Constants.YHZH_BAOHUA);
			param.setCreateId(user.getLoginId());
			param.setCreateTime(new Date());
			param.setDelflag("A");
			govmgtLogMapper.addGovmgtLog(param);
			return new ResultObject();
		}
			
		// 删除
		@Override
		public Object deleteGovmgtLog(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			govmgtLogMapper.deleteGovmgtLog(id);
			return new ResultObject();
		}

}
