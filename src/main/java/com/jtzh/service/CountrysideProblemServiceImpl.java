package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CountrysideProblem;
import com.jtzh.entity.CountrysideSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CountrysideProblemMapper;
import com.jtzh.mapper.CountrysideSourceMapper;
import com.jtzh.pojo.CountIsdeleted;
import com.jtzh.pojo.CountQuarter;
import com.jtzh.pojo.CountrysideFind;
import com.jtzh.pojo.CountrysideProblemDetail;
import com.jtzh.pojo.CountrysideProblemParam;
import com.jtzh.pojo.PageResult;

@Service("countrysideProblemService")
public class CountrysideProblemServiceImpl implements CountrysideProblemService{
	@Resource
	private CountrysideProblemMapper problemMapper;

	@Resource
	private CountrysideSourceMapper sourceMapper;
	
	@Override
	public Object getCountrysideProblemList(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectCoPTotal(param);
		List<CountrysideProblem> list = new ArrayList<CountrysideProblem>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public CountrysideProblemDetail getCountrysideProblemInfo(String id) {
		// 根据id去查询信息和图片资源信息
		CountrysideProblemDetail problemDetail = new CountrysideProblemDetail();
		CountrysideProblem problem = problemMapper.getCountrysideProblemInfo(id);
		problemDetail.setCountrysideProblem(problem);
		// 03
		problemDetail.setSource(sourceMapper.getSourceInfo("03", id));
		return problemDetail;
	}
	
	@Override
	public Object deleteCountrysideProblem(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		problemMapper.deleteCountrysideProblem(id);
		List<CountrysideSource> couList = sourceMapper.getSourceInfo(sourceType, id);
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				Integer a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	// 修改
	@Override
	public Object updateCountrysideProblem(CountrysideProblem param) {
		problemMapper.updateCountrysideProblem(param);
		return new ResultObject();
	}
	
	@Override
	public Object addCountrysideProblem(CountrysideProblemDetail countrysideDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		CountrysideProblem problem = countrysideDetail.getCountrysideProblem();
		// 03
		problem.setIsdeleted("1");
		problem.setShangbaotime(new Date());
		problem.setAttachmentSource("03");
		problem.setYhzh(Constants.YHZH_BAOHUA);
		problem.setCreateId(user.getLoginId());
		problem.setCreateTime(new Date());
		problem.setDelflag("A");
		problemMapper.insertCountrysideProblem(problem);
		List<CountrysideSource> couList = countrysideDetail.getSource();
		// 如果图片存在
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				source.setAttachmentSource("03");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setDelflag("A");
				source.setSourceId(problem.getId());
				sourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	// 立案
	@Override
	public Object Problemlian(CountrysideProblem param) {
		param.setLiantime(new Date());
		problemMapper.Problemlian(param);
		return new ResultObject();
	}
		
	// 派发
	@Override
	public Object Problempaifa(CountrysideProblem param) {
		param.setPaifatime(new Date());
		problemMapper.Problempaifa(param);
		return new ResultObject();
	}
	
	@Override
	public Object findbystate(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectCocTotal(param);
		List<CountrysideFind> list = new ArrayList<CountrysideFind>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfo1(param);
		}
		res.setRows(list);
		return res;
	}
	
	public Object findbyId(String id) {
        return problemMapper.findbyId(id);
    }
	
	@Override
	public Object getshangbaorenProblemList(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectSbrTotal(param);
		List<CountrysideProblem> list = new ArrayList<CountrysideProblem>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfoSbr(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public Object getpaifarenProblemList(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectPfrTotal(param);
		List<CountrysideProblem> list = new ArrayList<CountrysideProblem>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfoPfr(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public Object getPeopleProblemList(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectPeoTotal(param);
		List<CountrysideProblem> list = new ArrayList<CountrysideProblem>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfoPeo(param);
		}
		res.setRows(list);
		return res;
	}
	
	// 派发
	@Override
	public Object updateIsdeleted(CountrysideProblem param) {
		problemMapper.updateIsdeleted(param);
		return new ResultObject();
	}
	
	@Override
	public CountrysideProblem getxyInfo(String id) {
		// 根据id去查询
		CountrysideProblem  xy = problemMapper.getxyInfo(id);
		return xy;
	}
	
	@Override
	public Object getxyList(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectCoPTotal(param);
		List<CountrysideProblem> list = new ArrayList<CountrysideProblem>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfoxy(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public Object getAllxyList(CountrysideProblemParam param) {
		// 查询总数
		int total = problemMapper.selectCoPTotal(param);
		List<CountrysideProblem> list = new ArrayList<CountrysideProblem>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = problemMapper.selectInfoAllxy(param);
		}
		res.setRows(list);
		return res;
	}
	
	public Long getCountListfeiqi() {
        return problemMapper.getCountListfeiqi();
    }
    public Long getCountListdaipaifa() {
        return problemMapper.getCountListdaipaifa();
    }
    public Long getCountListchulizhong() {
        return problemMapper.getCountListchulizhong();
    }
    public Long getCountListdaishenhe() {
        return problemMapper.getCountListdaishenhe();
    }
    public Long getCountListyijiean() {
        return problemMapper.getCountListyijiean();
    }
    /*public Object getCountListjidu(String year) {
        return problemMapper.getCountListjidu(year);
    }*/
    public Object getCountListjidu(String year) {
    	ResultObject res = new ResultObject();
		List<CountQuarter>  countQuarters= problemMapper.countProblemByYear(year);
		Map<String,Integer> targetQuarter = new HashMap<>();
		Map <Integer,String> quarterMap = new HashMap<>();
		Integer startQuarter = Constants.DEFAULT_QUARTER;
		List<CountQuarter> resQuarters = new ArrayList<>();
		Integer index=0;
		for(int i = 0;i < 4;i++){
			CountQuarter countQuarter = new CountQuarter();
			int count = 0;
			quarterMap.put(i, (startQuarter).toString());
			for(CountQuarter param: countQuarters){
				if(param.getQuarter().equals(quarterMap.get(i)))
				count += Integer.valueOf(param.getCount());
			}
			targetQuarter.put(startQuarter.toString(), count);
			startQuarter ++;
			index=Integer.valueOf(i+1);
			countQuarter.setCount(String.valueOf(count));
			countQuarter.setQuarter(index.toString());
			resQuarters.add(countQuarter);
		}
		res.setObj(resQuarters);
		return res;
	}
    public List <CountIsdeleted> getAllCountList(CountrysideProblem param) {
        return problemMapper.getCount();
    }
    public Long getCountList(CountrysideProblem param) {
        return problemMapper.getCountList(param);
    }

}
