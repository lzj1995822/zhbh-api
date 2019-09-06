package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CountrysideBuild;
import com.jtzh.entity.CountrysideSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CountrysideMapper;
import com.jtzh.mapper.CountrysideSourceMapper;
import com.jtzh.pojo.CountrysideBuildCount;
import com.jtzh.pojo.CountrysideDetail;
import com.jtzh.pojo.CountrysideParam;
import com.jtzh.pojo.PageResult;

@Service("CountrysideService")
public class CountrysideServiceImpl implements CountrysideService{
	@Resource
	private CountrysideMapper countrysideMapper;

	@Resource
	private CountrysideSourceMapper countrysideSourceMapper;
	
	@Override
	public Object getCountrysideList(CountrysideParam param) {
		// 查询总数
		int total = countrysideMapper.selectCouTotal(param);
		List<CountrysideBuild> list = new ArrayList<CountrysideBuild>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = countrysideMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public CountrysideDetail getCountrysideInfo(String id) {
		// 根据id去查询信息和图片资源信息
		CountrysideDetail countrysideDetail = new CountrysideDetail();
		CountrysideBuild countryside = countrysideMapper.getCountrysideInfo(id);
		countrysideDetail.setCountrysideBuild(countryside);
		// 01
		countrysideDetail.setSource(countrysideSourceMapper.getSourceInfo("01", id));
		return countrysideDetail;
	}
	
	@Override
	public Object addCountryside(CountrysideDetail countrysideDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		CountrysideBuild countryside = countrysideDetail.getCountrysideBuild();
		// 01
		countryside.setState("01");
		countryside.setEndState("01");
		countryside.setCommit("01");
		countryside.setAttachmentSource("01");
		countryside.setYhzh(Constants.YHZH_BAOHUA);
		countryside.setCreateId(user.getLoginId());
		countryside.setCreateTime(new Date());
		countryside.setDelflag("A");
		countrysideMapper.insertCountryside(countryside);
		List<CountrysideSource> couList = countrysideDetail.getSource();
		// 如果图片存在
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				source.setAttachmentSource("01");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setDelflag("A");
				source.setSourceId(countryside.getId());
				countrysideSourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object deleteCountryside(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		countrysideMapper.deleteCountryside(id);
		List<CountrysideSource> couList = countrysideSourceMapper.getSourceInfo(sourceType, id);
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				Integer a = source.getId();
				countrysideSourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}
	// 修改
	@Override
	public Object updateCountryside(CountrysideBuild param) {
		countrysideMapper.updateCountryside(param);
		return new ResultObject();
	}
	
	// 申请审核
	@Override
	public Object testCountryside(CountrysideBuild param) {
		countrysideMapper.testCountryside(param);
		return new ResultObject();
	}
	
	@Override
	public Object getAllxyList(CountrysideParam param) {
		// 查询总数
		int total = countrysideMapper.selectCouTotal(param);
		List<CountrysideBuild> list = new ArrayList<CountrysideBuild>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = countrysideMapper.selectInfoAllxy(param);
		}
		res.setRows(list);
		return res;
	}
	
	// 验收
	@Override
	public Object commitCountryside(CountrysideBuild param) {
		countrysideMapper.commitCountryside(param);
		return new ResultObject();
	}
		
	// 验收
	@Override
	public Object shenheCountryside(CountrysideBuild param) {
		countrysideMapper.shenheCountryside(param);
		return new ResultObject();
	}
	
	@Override
	public Object getCountrysideYanshouList(CountrysideParam param) {
		// 查询总数
		int total = countrysideMapper.selectCouTotal1(param);
		List<CountrysideBuild> list = new ArrayList<CountrysideBuild>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = countrysideMapper.selectInfo1(param);
		}
		res.setRows(list);
		return res;
	}
	
	public Long getCountList1(CountrysideBuild param) {
        return countrysideMapper.getCountList1(param);
    }
	
	public Long getCountList2(CountrysideBuild param) {
        return countrysideMapper.getCountList2(param);
    }
	
	public Long getCountList3(CountrysideBuild param) {
        return countrysideMapper.getCountList3(param);
    }
	
	public List<CountrysideBuildCount> getapplyList(CountrysideBuild param){
		return countrysideMapper.getapplyList();
	}
	
	public List<CountrysideBuildCount> getexamineList(CountrysideBuild param){
		return countrysideMapper.getexamineList();
	}

}
