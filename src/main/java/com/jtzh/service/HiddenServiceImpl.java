package com.jtzh.service;

import java.util.*;

import javax.annotation.Resource;

import com.jtzh.vo.hidden.HiddenTypeVO;
import com.jtzh.vo.school.SchoolCountVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.detail.pojo.HiddenCoordinate;
import com.jtzh.detail.pojo.HiddenResponse;
import com.jtzh.entity.HiddenDanger;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.SecuritySource;
import com.jtzh.mapper.HiddenMapper;
import com.jtzh.mapper.SecuritySourceMapper;
import com.jtzh.pojo.CountDay;
import com.jtzh.pojo.CountHiddenAndInspection;
import com.jtzh.pojo.CountMonth;
import com.jtzh.pojo.CountQuarter;
import com.jtzh.pojo.CountState;
import com.jtzh.pojo.CountWisdomTalent;
import com.jtzh.pojo.HiddenDetail;
import com.jtzh.pojo.HiddenParam;
import com.jtzh.pojo.PageResult;
import com.jtzh.responsevo.CountHiddenType;

@Service("hiddenService")
public class HiddenServiceImpl implements HiddenService{
	@Resource
	private HiddenMapper hiddenMapper;

	@Resource
	private SecuritySourceMapper securitySourceMapper;
	
	@Override
	public Object getHiddenList(HiddenParam param) {
		List<HiddenDanger> list = new ArrayList<HiddenDanger>();
		PageResult response = new PageResult();
		int total = hiddenMapper.selectHidTotal(param);
		if (total > 0) {
			list = hiddenMapper.selectInfo(param);
		}
		response.setOk(true);
		response.setTotal(total);
		response.setRows(list);
		return response;
	}
	
	@Override
	public HiddenDetail getHiddenInfo(String id) {
		// 根据id去查询信息和图片资源信息
		HiddenResponse response = new HiddenResponse();
		HiddenDanger hidden = hiddenMapper.getHiddenInfo(id);
		response.setHiddenDanger(hidden);
		// 02
		response.setSource(securitySourceMapper.getSourceInfo(Constants.ATTACHSOURCE_BEFORE, id));
		// 03
		response.setAfterSource(securitySourceMapper.getSourceInfo(Constants.ATTACHSOURCE_AFTER, id));
		return response;
	}
	
	@Override
	public Object addHidden(HiddenDetail hiddenDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		HiddenDanger hidden = hiddenDetail.getHiddenDanger();
		// 02
		hidden.setPeople(hiddenDetail.getHiddenDanger().getPeople());
		hidden.setState(Constants.DESCRIPTION_BEFORE);
		hidden.setAttachmentSource("02");
		hidden.setYhzh(Constants.YHZH_BAOHUA);
		hidden.setCreateTime(new Date());
		hidden.setIsdeleted("0");
		hidden.setCreateId(user.getLoginId());
		hiddenMapper.insertHidden(hidden);
		List<SecuritySource> hidList = hiddenDetail.getSource();
		// 如果图片存在
		if (hidList != null && hidList.size() > 0) {
			for (SecuritySource source : hidList) {
				source.setAttachmentSource("02");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setIsdeleted("0");
				source.setSourceId(hidden.getId());
				securitySourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object deleteHidden(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		hiddenMapper.deleteHidden(id);
		List<SecuritySource> hidList = securitySourceMapper.getSourceInfo(sourceType, id);
		if (hidList != null && hidList.size() > 0) {
			for (SecuritySource source : hidList) {
				Integer a = source.getId();
				securitySourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	// 修改
	@Override
	public Object updateHidden(HiddenDanger param) {
		hiddenMapper.updateHidden(param);
		return new ResultObject();
	}

	// 移交
	@Override
	public Object moveHidden(HiddenDanger param) {
		param.setState("02");
		hiddenMapper.moveHidden(param);
		return new ResultObject();
	}

	// 指派
	@Override
	public Object sendHidden(HiddenDanger param) {
		param.setState("03");
		hiddenMapper.sendHidden(param);
		return new ResultObject();
	}
	
	// 整改
	@Override
	public Object solveHidden(HiddenDetail hiddenDetail) {
		HiddenDanger hidden = hiddenDetail.getHiddenDanger();
		hidden.setState(Constants.DESCRIPTION_AFTER);
		hiddenMapper.solveHidden(hidden);
		List<SecuritySource> hidList = hiddenDetail.getSource();
		// 如果图片存在
		if (hidList != null && hidList.size() > 0) {
			for (SecuritySource source : hidList) {
				source.setAttachmentSource(Constants.ATTACHSOURCE_AFTER);
				source.setType("02");
				source.setCreateTime(new Date());
				source.setIsdeleted("0");
				source.setSourceId(hidden.getId());
				securitySourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object getHiddenCoordinate() {
		List<HiddenCoordinate> hiddenCoordinate = hiddenMapper.getHiddenCoordinate();
		ResultObject res = new ResultObject();
		res.setObj(hiddenCoordinate);
		return res;
	}

	@Override
	public Object countHiddenState() {
		List<CountHiddenAndInspection> list = hiddenMapper.countHiddenState();
		ResultObject res = new ResultObject();
		res.setObj(list);
		return res;
	}

	@Override
	public Object getHiddenGis(HiddenParam param) {
		List<HiddenDanger> list = hiddenMapper.selectInfoWeb(param);
		PageResult response = new PageResult();
		if (list != null && list.size() > 0) {
			response.setOk(true);
			response.setTotal(list.size());
			response.setRows(list);
		} else {
			response.setOk(false);
			response.setTotal(0);
		}
		return response;
	}

	@Override
	public Object countHiddenByYear(String year) {
		ResultObject res = new ResultObject();
		List<CountQuarter>  countQuarters= hiddenMapper.countHiddenByYear(year);
		Map<String,Integer> targetQuarter = new HashMap<>();
		Map <Integer,String> quarterMap = new HashMap<>();
		Integer startQuarter = Constants.DEFAULT_QUARTER;
		List<CountQuarter> list = new ArrayList<>();
		for(int i = 0;i < 4;i++){
			int count = 0;
			quarterMap.put(i, (startQuarter).toString());
			for(CountQuarter param: countQuarters){
				if(param.getQuarter().equals(quarterMap.get(i)))
				count += Integer.valueOf(param.getCount());
			}
			CountQuarter cq = new CountQuarter();
			cq.setCount(String.valueOf(count));
			cq.setQuarter(String.valueOf(startQuarter));
			list.add(cq);
			startQuarter ++;
		}
		res.setObj(list);
		return res;
	}

	@Override
	public Object countHiddenByState(String state) {
		return hiddenMapper.countHiddenByState(state);
	}

	@Override
	public Object countHiddenStateNoParam() {
		List<CountState> list = hiddenMapper.countHiddenStateNoParam();
		ResultObject res = new ResultObject();
		res.setObj(list);
		return res;
	}

	@Override
	public Object countHiddenByMonth(String year) {
		List<CountMonth>  countMonthes= hiddenMapper.countHiddenByMonth(year);
		ResultObject res = new ResultObject();
		res.setObj(countMonthes);
		return res;
	}

	@Override
	public Object countHiddenByDay(String year) {
		List<CountDay>  countDays= hiddenMapper.countHiddenByDay(year);
		ResultObject res = new ResultObject();
		res.setObj(countDays);
		return res;
	}

	@Override
	public Object countHiddenAllCountryside() {
		ResultObject res = new ResultObject();
		res.setObj(hiddenMapper.countHiddenAllCountryside());
		return res;
	}

	@Override
	public Object countHiddenByType() {
		List list = new ArrayList<>();
		String solveBefore = "01";
		String solveAfter = "02";
		List<CountHiddenType> before = hiddenMapper.countHiddenByType(solveBefore);
		int size = before.size();
		String [] type = new String[size];
		int [] beforeCount = new int[size];
		int [] afterCount = new int[size];
		int index=0;
		int index1 =0;
		for(CountHiddenType countBefore:before){
			type[index] = countBefore.getType();
			beforeCount[index] = countBefore.getCount();
			index++;
		}
		List<CountHiddenType> after = hiddenMapper.countHiddenByType(solveAfter);
		for(CountHiddenType countAfter:after){
			afterCount[index1] = countAfter.getCount();
			index1++;
		}
		list.add(type);
		list.add(beforeCount);
		list.add(afterCount);
		Map map = new LinkedHashMap<>();
		map.put("隐患类型", type);
		map.put("未处理数目", beforeCount);
		map.put("已处理数目", afterCount);
		return map;
	}

	@Override
	public Object countHiddenByPeople() {
		List list = new ArrayList<>();
		String solveBefore = "01";
		String solveAfter = "02";
		List<CountHiddenType> before = hiddenMapper.countHiddenByPeople(solveBefore);
		List<CountHiddenType> after = hiddenMapper.countHiddenByPeople(solveAfter);
		int size = before.size();
		String [] type = new String[size];
		int [] beforeCount = new int[size];
		int [] afterCount = new int[size];
		int index=0;
		int index1 =0;
		for(CountHiddenType countBefore:before){
			type[index] = countBefore.getType();
			beforeCount[index] = countBefore.getCount();
			index++;
		}
		for(CountHiddenType countAfter:after){
			afterCount[index1] = countAfter.getCount();
			index1++;
		}
		list.add(type);
		list.add(beforeCount);
		list.add(afterCount);
		Map map = new LinkedHashMap<>();
		map.put("人员姓名", type);
		map.put("未处理数目", beforeCount);
		map.put("已处理数目", afterCount);
		return map;
	}


	@Override
	public List<HiddenTypeVO> getHiddenType()
	{
		List<HiddenTypeVO> list= new ArrayList<HiddenTypeVO>();
		List l = new ArrayList();
		int len = 24;
		String[] desc =
				{	"生产经营单位资质证照类隐患",
                        "安全生产管理机构及人员类隐患",
                        "安全生产责任制类隐患",
                        "安全生产管理制度类隐患",
                        "安全操作规程类隐患",
                        "教育培训类隐患",
                        "安全生产管理档案类隐患",
                        "安全生产投入类隐患",
                        "应急管理类隐患",
                        "特种设备基础管理类隐患",
                        "职业卫生基础管理类隐患",
                        "相关方基础管理类隐患",
                        "其他基础管理类隐患",
                        "特种设备现场管理类隐患",
                        "生产设备设施及工艺类隐患",
                        "场所环境类隐患",
                        "从业人员操作行为类隐患",
                        "消防安全类隐患",
                        "用电安全类隐患",
                        "职业卫生现场安全类隐患",
                        "有限空间现场安全类隐患",
                        "辅助动力系统类隐患",
                        "相关方现场管理类隐患",
                        "其他现场管理类隐患"
				};
		int[] num =
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		l.add(desc);
		l.add(num);
		for (int i = 0; i < len; i++) {
			HiddenTypeVO v =new HiddenTypeVO();
			v.setDesc(desc[i] );
			v.setNum( num[i]);
			list.add(v);
		}
		return list ;
	}

    @Override
    public Object getHiddenCountByType() {
		List List = new ArrayList<>();
		String solveBefore = "01";
		String solveAfter = "02";
		List<CountHiddenType> before = hiddenMapper.getHiddenCountByType(solveBefore);
		List<CountHiddenType> after = hiddenMapper.getHiddenCountByType(solveAfter);
		int size = before.size();
		String [] type = new String[size];
		int [] beforeCount = new int[size];
		int [] afterCount = new int[size];
		int index=0;
		int index1 =0;
		for(CountHiddenType countBefore:before){
			type[index] = countBefore.getType();
			beforeCount[index] = countBefore.getCount();
			index++;
		}
		for(CountHiddenType countAfter:after){
			afterCount[index1] = countAfter.getCount();
			index1++;
		}
		List.add(type);
		List.add(beforeCount);
		List.add(afterCount);
		Map map = new LinkedHashMap<>();
		map.put("隐患类型", type);
		map.put("未处理数目", beforeCount);
		map.put("已处理数目", afterCount);
		return map;

    }

}
