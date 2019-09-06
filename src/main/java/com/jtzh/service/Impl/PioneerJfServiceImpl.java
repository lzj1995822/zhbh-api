package com.jtzh.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.PioneerDues;
import com.jtzh.entity.PioneerJf;
import com.jtzh.entity.PioneerLddy;
import com.jtzh.entity.PioneerSjxm;
import com.jtzh.entity.PioneerSjxmHb;
import com.jtzh.mapper.PioneerDuesMapper;
import com.jtzh.mapper.PioneerJfMapper;
import com.jtzh.mapper.PioneerLddyMapper;
import com.jtzh.mapper.PioneerSjxmHbMapper;
import com.jtzh.mapper.PioneerSjxmMapper;
import com.jtzh.pojo.KeyParam;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.PioneerJfService;
@Service("pioneerJfService")
public class PioneerJfServiceImpl implements PioneerJfService {
	
	@Resource
	private PioneerJfMapper pioneerJfMapper;
	@Resource
	private PioneerLddyMapper pioneerLddyMapper;

	@Resource
	private PioneerSjxmMapper pioneerSjxmMapper;
	
	@Resource
	private PioneerSjxmHbMapper pioneerSjxmHbMapper;
	@Resource
	private PioneerDuesMapper pioneerDuesMapper;
	@Override
	public Object getDyjf(PioneerJf jf) {
		PageResult page = new PageResult();
		int total = pioneerJfMapper.getDyjfTotal(jf);
		if(total > 0) {
			List<PioneerJf> list = pioneerJfMapper.getDyjf(jf);
			page.setOk(true);
			page.setTotal(total);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public Object addDyjf(PioneerJf jf) {
		ResultObject obj = new ResultObject();
		jf.setCreateTime(new Date());
		jf.setDelflag("A");
		try {
			jf.setZf(jf.getFz1()+jf.getFz2()+jf.getFz3()+jf.getFz4()+jf.getFz5()+jf.getFz6()+jf.getFz7()+jf.getFz8());
		} catch (Exception e) {
			obj.setResult(false);
			return obj;
		}
		int num = pioneerJfMapper.insert(jf);
		if(num > 0) {
			obj.setResult(true);
			return obj;
		}
		obj.setResult(false);
		return obj;
	}

	@Override
	public Object addLddy(PioneerLddy lddy) {
		ResultObject obj = new ResultObject();
		lddy.setDelflag("A");
		lddy.setCreateTime(new Date());
		int num = pioneerLddyMapper.insert(lddy);
		if(num > 0) {
			obj.setResult(true);
			return obj;
		}
		obj.setResult(false);
		return obj;
	}

	@Override
	public Object updateLddy(PioneerLddy lddy) {
		ResultObject obj = new ResultObject();
		pioneerLddyMapper.updateByPrimaryKey(lddy);
		return obj;
	}

	@Override
	public Object getLddy(KeyParam param) {
		PageResult page = new PageResult();
		int total = pioneerLddyMapper.getLddyTotal(param);
		if(total > 0) {
			
			List<PioneerLddy> list = pioneerLddyMapper.getLddy(param);
			page.setTotal(total);
			page.setOk(true);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public Object getLddys() {
		List<PioneerLddy> list = pioneerLddyMapper.getLddys();
		return list;
	}
	@Override
	public Object addSjxm(PioneerSjxm sjxm) {
		
		sjxm.setCreateTime(new Date());
		sjxm.setDelflag("A");
		sjxm.setZt("0");
		//TODO 插入新建人员的所属市、镇、村
		int num = pioneerSjxmMapper.insert(sjxm);
		ResultObject obj = new ResultObject();
		obj.setResult(false);
		if(num > 0) {
			obj.setResult(true);
		}
		return obj;
	}

	@Override
	public Object getAllSjxm(KeyParam param) {
		List<PioneerSjxm> list = pioneerSjxmMapper.getAllSjxm(param);
		ResultObject obj = new ResultObject();
		obj.setResult(true);
		obj.setObj(list);
		return obj;
	}

	@Override
	public Object getSjxm(KeyParam param) {
		//TODO 带账号所属的市、镇、村进行查询
		PageResult page = new PageResult();
		int total = pioneerSjxmMapper.getSjxmTotal(param);
		if(total > 0 ) {
			List<PioneerSjxm> list = pioneerSjxmMapper.getSjxm(param);
			page.setTotal(total);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public Object updateSjxm(PioneerSjxm sjxm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object addDf(PioneerDues dues) {
		dues.setCreateTime(new Date());
		dues.setDelflag("A");
		int num = pioneerDuesMapper.insert(dues);
		ResultObject obj = new ResultObject();
		obj.setResult(false);
		if(num > 0) {
			obj.setResult(true);
		}
		return obj;
	}

	@Override
	public Object getDfs(KeyParam keyParam) {
		
		PageResult page = new PageResult();
		int total = pioneerDuesMapper.getDfTotal(keyParam);
		if(total > 0 ) {
			List<PioneerDues> list = pioneerDuesMapper.getDf(keyParam);
			page.setTotal(total);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public Object removeDf(String id) {
		pioneerDuesMapper.deleteByPrimaryKey(Long.valueOf(id));
		ResultObject obj = new ResultObject();
		return obj;
	}

	@Override
	public Object updateDf(PioneerDues dues) {
		pioneerDuesMapper.updateByPrimaryKey(dues);
		ResultObject obj = new ResultObject();
		return obj;
	}

	@Override
	public Object removeLddy(String id) {
		ResultObject obj = new ResultObject();
		int num = pioneerLddyMapper.deleteByPrimaryKey(Long.valueOf(id));
		if(num > 0) {
			obj.setResult(true);
		}
		return obj;
	}

	@Override
	public Object updateSjxmZt(String id, String zt) {
		PioneerSjxm sjxm = new PioneerSjxm();
		sjxm.setId(Long.valueOf(id));
		sjxm.setZt(zt);
		int num = pioneerSjxmMapper.updateSjxmZt(sjxm);
		ResultObject obj = new ResultObject();
		if(num > 0) {
			obj.setResult(true);
		}
		return obj;
	}

	@Override
	public Object addJdhb(PioneerSjxmHb hb) {
		int num = pioneerSjxmHbMapper.insert(hb);
		ResultObject obj = new ResultObject();
		if(num > 0) {
			obj.setResult(true);
		}
		return obj;
	}

	@Override
	public Object getJdhb(String id) {
		PioneerSjxmHb num = pioneerSjxmHbMapper.selectByXmid(Long.valueOf(id));
		ResultObject obj = new ResultObject();
		if(num != null) {
			obj.setObj(num);
		}
		return obj;
	}

	@Override
	public Object removeSjxm(String id) {
		pioneerSjxmMapper.deleteByPrimaryKey(Long.valueOf(id));
		ResultObject obj = new ResultObject();
		return obj;
	}

	@Override
	public Object modifySjxm(PioneerSjxm sjxm) {
		pioneerSjxmMapper.updateByPrimaryKey(sjxm);
		ResultObject obj = new ResultObject();
		return obj;
	}
	
}
