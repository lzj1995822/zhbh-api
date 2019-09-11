package com.jtzh.service.Impl;

import java.security.Timestamp;
import java.util.*;

import javax.annotation.Resource;

import com.jtzh.entity.*;
import com.jtzh.mapper.*;
import com.jtzh.model.VolunteerResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.TestTime;
import com.jtzh.pojo.KeyParam;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.PioneerVolunteerService;
import org.springframework.transaction.annotation.Transactional;

@Service("pioneerVolunteerService")
public class PioneerVolunteerServiceImpl implements PioneerVolunteerService {
	
	@Resource
	private PioneerVolunteerMapper pioneerVolunteerMapper;
	@Resource
	private PioneerVolunteerPxMapper pioneerVolunteerPxMapper;
	@Resource
	private PioneerVolunteerService pioneerVolunteerService;
	
	@Resource
	private PioneerVolunteerServiceMapper pioneerVolunteerServiceMapper;
	
	@Resource
	private PioneerServiceEnrollMapper pioneerServiceEnrollMapper;
	@Resource
	private PioneerServiceResultMapper pioneerServiceResultMapper;

	@Resource
	private UserinformationMapper userinformationMapper;
	@Override 
	public Object addZyz(PioneerVolunteer pioneerVolunteer) {
		ResultObject obj = new ResultObject();
		obj.setResult(false);
		int num = pioneerVolunteerMapper.getZyzInfoBySjh(pioneerVolunteer.getSfz());
		if(num>0) {
			obj.setMessage("身份证重复！");
			return obj;
		}
		pioneerVolunteer.setShzt("0");
		pioneerVolunteer.setCreateTime(new Date());
		pioneerVolunteer.setDelflag("A");
		pioneerVolunteerMapper.insert(pioneerVolunteer);
		List<PioneerVolunteerPx> list = pioneerVolunteer.getPx();
		if(list != null  &&  list.size()>0) {
			for(PioneerVolunteerPx px : list) {
				px.setDelflag("A");
				px.setVolunteerId(pioneerVolunteer.getId());
				pioneerVolunteerPxMapper.insert(px);
			}
		}
		if(StringUtils.isNotBlank(pioneerVolunteer.getId()+"")) {
			obj.setResult(true);
		}
		return obj;
	}

    @Override
    public Object getZyzBmInfo() {
        KeyParam keyParam = new KeyParam();
        TestTime t = new TestTime();
        Map<String,String> map = t.getTimes();
        keyParam.setStartTime(map.get("CurrentTimeStart"));
        keyParam.setEndTime(map.get("currentTimeEnd"));
        int day = pioneerVolunteerMapper.getZyzTotal(keyParam);
        keyParam.setStartTime(map.get("firstday"));
        keyParam.setEndTime(map.get("lastday"));
        int mouth = pioneerVolunteerMapper.getZyzTotal(keyParam);
        keyParam.setStartTime(map.get("yearStart"));
        keyParam.setEndTime(map.get("yearEnd"));
        int year = pioneerVolunteerMapper.getZyzTotal(keyParam);
        Map<String,Integer> m = new HashMap<String, Integer>();
        m.put("day",day);
        m.put("mouth",mouth);
        m.put("year",year);
        ResultObject res = new ResultObject();
        res.setObj(m);
        return res;
    }

    @Override
	public Object getZyz(KeyParam keyParam) {
		TestTime t = new TestTime();
		Map<String,String> map = t.getTimes();
		if("1".equals(keyParam.getKeyword())) {//当日
			keyParam.setStartTime(map.get("CurrentTimeStart"));
			keyParam.setEndTime(map.get("currentTimeEnd"));
		}
		if("2".equals(keyParam.getKeyword())) {//当月
			keyParam.setStartTime(map.get("firstday"));
			keyParam.setEndTime(map.get("lastday"));
		}
		if("3".equals(keyParam.getKeyword())) {//当年
			keyParam.setStartTime(map.get("yearStart"));
			keyParam.setEndTime(map.get("yearEnd"));
		}
        keyParam.setKeyword(keyParam.getKey());
		PageResult page = new PageResult();
		int total = pioneerVolunteerMapper.getZyzTotal(keyParam);
		if(total > 0) {
			page.setTotal(total);
			List<PioneerVolunteer> list = pioneerVolunteerMapper.getZyz(keyParam);
			page.setOk(true);
			page.setRows(list);
			return page;
		}
		return page;
	}
	@Override
	public Object getZyzInfo(String id) {
		PioneerVolunteer p = pioneerVolunteerMapper.selectByPrimaryKey(id);
		List<PioneerVolunteerPx> l = pioneerVolunteerPxMapper.selectByZyzId(id);
		p.setPx(l);
		return p;
	}
	@Override
	public Object updateZyz(PioneerVolunteer pioneerVolunteer) {
		
		pioneerVolunteerMapper.updateById(pioneerVolunteer.getId().toString());
		pioneerVolunteerPxMapper.updateById(pioneerVolunteer.getId().toString());
		pioneerVolunteerService.addZyz(pioneerVolunteer);
		ResultObject obj = new ResultObject();
		return obj;
	}
	@Override
	public Object addZyzhd(PioneerVolunteerServiceE r) {
		r.setCreateTime(new Date());
		r.setDelflag("A");
		r.setSfjs("0");
		return pioneerVolunteerServiceMapper.insert(r);
	}
	
	
	@Override
	public Object updateZyzHd() {
		return null;
	}


    @Override
    public Object getZyzHdByTime() {
        TestTime t = new TestTime();
        Map<String,String> map = t.getTimes();
        KeyParam keyParam = new KeyParam();
        keyParam.setStartTime(map.get("CurrentTimeStart"));
        keyParam.setEndTime(map.get("currentTimeEnd"));
        int day = pioneerVolunteerServiceMapper.getZyzHdTotal(keyParam);

        keyParam.setStartTime(map.get("firstday"));
        keyParam.setEndTime(map.get("lastday"));
        int mouth = pioneerVolunteerServiceMapper.getZyzHdTotal(keyParam);

        keyParam.setStartTime(map.get("yearStart"));
        keyParam.setEndTime(map.get("yearEnd"));
        int year = pioneerVolunteerServiceMapper.getZyzHdTotal(keyParam);
        Map<String,Integer> m = new HashMap<String, Integer>();
        m.put("day",day);
        m.put("mouth",mouth);
        m.put("year",year);
        ResultObject res = new ResultObject();
        res.setObj(m);
        return res;
    }

    @Override
	public Object getZyzhd(KeyParam keyParam) {
		TestTime t = new TestTime();
		Map<String,String> map = t.getTimes();
		if("1".equals(keyParam.getKeyword())) {//当日
			keyParam.setStartTime(map.get("CurrentTimeStart"));
			keyParam.setEndTime(map.get("currentTimeEnd"));
		}
		if("2".equals(keyParam.getKeyword())) {//当月
			keyParam.setStartTime(map.get("firstday"));
			keyParam.setEndTime(map.get("lastday"));
		}
		if("3".equals(keyParam.getKeyword())) {//当年
			keyParam.setStartTime(map.get("yearStart"));
			keyParam.setEndTime(map.get("yearEnd"));
		}
		keyParam.setKeyword(keyParam.getKey());
		PageResult page = new PageResult();
		int total = pioneerVolunteerServiceMapper.getZyzHdTotal(keyParam);
		page.setOk(true);
		page.setTotal(total);

		if(total > 0) {
			page.setTotal(total);
			List<PioneerVolunteerServiceE> list = pioneerVolunteerServiceMapper.getZyzHd(keyParam);
			page.setRows(list);
			return page;
		}
		return page;
	}
	@Override
    @Transactional
	public Object updateZyzZt(String id, String zt) {
		int num = pioneerVolunteerMapper.updateZyzZt(id, zt);
        PioneerVolunteer p = pioneerVolunteerMapper.selectByPrimaryKey(id);
		if (num > 0  && p.getLxdh() != null) {
            Userinformation user = new Userinformation();
            user.setCreateon(new Date());
            user.setUisubordinatedepartment("志愿者");
            user.setUiloginname(p.getLxdh());
            user.setUicode(p.getLxdh().substring(p.getLxdh().length()-6,p.getLxdh().length()));
            user.setUirealname(p.getXm());
            userinformationMapper.insert(user);
		}
		ResultObject obj = new ResultObject();
		if(num > 0) {
			obj.setResult(true);
			return obj;
		}
		obj.setResult(false);
		return obj;
	}
	@Override
	public Object getZyzhdApp(KeyParam keyParam) {
		
		PageResult page = new PageResult();
		int total = pioneerVolunteerServiceMapper.getZyzHdTotalApp(keyParam);
		if(total > 0) {
			page.setTotal(total);
			List<PioneerVolunteerServiceE> list = pioneerVolunteerServiceMapper.getZyzHdApp(keyParam);
			page.setOk(true);
			page.setRows(list);
			return page;
		}
		return page;
	}
	
	@Override
	public Object getZyzhdAppYjs(KeyParam keyParam) {
		
		PageResult page = new PageResult();
		int total = pioneerVolunteerServiceMapper.getZyzHdTotalAppYjs(keyParam);
		if(total > 0) {
			page.setTotal(total);
			List<PioneerVolunteerServiceE> list = pioneerVolunteerServiceMapper.getZyzHdAppYjs(keyParam);
			page.setOk(true);
			page.setRows(list);
			return page;
		}
		return page;
	}
	@Override
	public Object getZyzhdBm(String hdid, String zyzzh) {
		ResultObject obj = new ResultObject();
		int num = pioneerServiceEnrollMapper.getZyzBm(hdid, zyzzh);
		if(num > 0) {
			obj.setResult(false);
			return obj;
		}
		obj.setResult(true);
		return obj;
	}


    @Override
    public Object getZyzhdBmInfo(KeyParam keyParam) {
        PageResult page = new PageResult();
        int num = pioneerServiceEnrollMapper.getZyzBmInfoTotal(keyParam);
        page.setOk(true);
        if(num > 0) {
            page.setTotal(num);
            List<PioneerVolunteer> list = pioneerServiceEnrollMapper.getZyzBmInfo(keyParam);
            page.setRows(list);
        }
        return page;
    }

    @Override
	public Object addBmInfo(String hdid, String zyzzh) {
		PioneerServiceEnroll p = new PioneerServiceEnroll();
		ResultObject obj = new ResultObject();
		p.setCreateTime(new Date());
		p.setDelflag("A");
		p.setHdid(Long.valueOf(hdid));
		p.setZyzzh(zyzzh);
		Integer zyzid = pioneerVolunteerMapper.getIdByPhoneNumber(zyzzh);
		if (zyzid == null) {
			obj.setResult(false);
			obj.setMessage("此手机号暂未绑定支志愿者");
			return obj;
		}
		p.setZyzid(Long.valueOf(zyzid));
		int num =  pioneerServiceEnrollMapper.insert(p);
		if(num > 0) {
			obj.setResult(true);
			return obj;
		}
		obj.setResult(false);
		return obj;
	}
	@Override
    @Transactional
	public Object addHdJg(PioneerServiceResult pioneerServiceResult) {
		ResultObject obj = new ResultObject();
		pioneerServiceResult.setCreateTime(new Date());
		pioneerServiceResult.setDelflag("A");
		pioneerServiceResultMapper.insert(pioneerServiceResult);
        pioneerVolunteerServiceMapper.updateYjs(String.valueOf(pioneerServiceResult.getHdid()));
		return obj;
	}
	@Override
	public Object getHdJg(String id) {
		ResultObject obj = new ResultObject();
		PioneerServiceResult  p = pioneerServiceResultMapper.selectByPrimaryKey(id);
		obj.setObj(p);
		return obj;
	}
	@Override
	public Object removeZyzHd(String id) {
		pioneerVolunteerServiceMapper.deleteByPrimaryKey(Long.valueOf(id));
		ResultObject obj = new ResultObject();
		return obj;
	}
	@Override
	public Object updateZyzHd(PioneerVolunteerServiceE pioneerServiceResult) {
		pioneerVolunteerServiceMapper.updateByPrimaryKey(pioneerServiceResult);
		ResultObject obj = new ResultObject();
		return obj;
	}

	@Override
	public List<VolunteerResultModel> countByMonthAndType() {
		return pioneerVolunteerMapper.countByMonthAndType();
	}

}
