package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jtzh.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.detail.pojo.KeyCoordinateRes;
import com.jtzh.detail.pojo.KeyProblemChuliDetail;
import com.jtzh.detail.pojo.KeySolveResDetail;
import com.jtzh.detail.pojo.KeySolveResponse;
import com.jtzh.detail.pojo.KeyproProblemAppointmans;
import com.jtzh.detail.pojo.KeyproProblemDetail;
import com.jtzh.detail.pojo.KeyproProblemDetailVo;
import com.jtzh.entity.CountrysideList;
import com.jtzh.entity.KeyproInformation;
import com.jtzh.entity.KeyproProblem;
import com.jtzh.entity.KeyproProblemChuli;
import com.jtzh.entity.KeyproSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.jpush.JpushUtils;
import com.jtzh.mapper.CountrysideListMapper;
import com.jtzh.mapper.KeyproInformationMapper;
import com.jtzh.mapper.KeyproProblemChuliMapper;
import com.jtzh.mapper.KeyproProblemMapper;
import com.jtzh.mapper.KeyproSourceMapper;
import com.jtzh.service.KeyproProblemService;

@Service("keyproProblemService")
public class KeyproProblemServiceImpl implements KeyproProblemService {
	@Resource
	private KeyproProblemMapper problemMapper;
	@Resource
	private KeyproSourceMapper sourceMapper;
	@Resource
	private KeyproProblemChuliMapper chuliMapper;
	@Resource
	private KeyproInformationMapper informationMapper;
	@Resource
	private CountrysideListMapper countrysideListMapper;
	@Resource
	private JpushUtils jpushUtils;

	@Override
	public Object getProblemList(ProblemPagination param, LoginUserTest user) {
		// 查询总数
		List<KeyproProblem> list = new ArrayList<KeyproProblem>();
		int total = problemMapper.selectCount(param, user.getUserName());
		PageResult response = new PageResult();
		if (total > 0) {
			list = problemMapper.selectInfo(param, user.getUserName());
		}
		response.setOk(true);
		response.setTotal(total);
		response.setRows(list);
		return response;
	}

	@Override
	public Object getProblemListApp(ProblemPagination param, LoginUserTest user) {
		// 查询总数
		List<KeyproProblem> list = new ArrayList<KeyproProblem>();
		int total = problemMapper.selectCountApp(param, user.getUserName());
		PageResult response = new PageResult();
		if (total > 0) {
			list = problemMapper.selectInfoApp(param, user.getUserName());
		}
		response.setOk(true);
		response.setTotal(total);
		response.setRows(list);
		return response;
	}

	@Override
	public Object getProblemListWeb(ProblemPagination param) {
		// 查询总数
		List<KeyproProblem> list = new ArrayList<KeyproProblem>();
		int total = problemMapper.selectCountWeb(param);
		PageResult response = new PageResult();
		if (total > 0) {
			list = problemMapper.selectInfoWeb(param);
		}
		response.setOk(true);
		response.setTotal(total);
		response.setRows(list);
		return response;
	}

	@Override
	public Object getProblemList1(ProblemPagination param, LoginUserTest user) {
		// 查询总数
		List<KeyproProblem> list = new ArrayList<KeyproProblem>();
		int count = problemMapper.selectCount1(param, user.getUserName());
		PageResult response = new PageResult();
		if (count > 0) {
			list = problemMapper.selectInfo1(param, user.getUserName());
		}
		response.setOk(true);
		response.setTotal(count);
		response.setRows(list);
		return response;
	}

	@Override
	public Object getProblem(String id) {
		// Constants.ATTACHSOURCE_PROBLEM即"02"代表问题资源在KeyproSource表中对应的attachsource
		KeyproProblemDetailVo problemDetail = new KeyproProblemDetailVo();
		KeyproProblemVo problemVo = problemMapper.selectProblemVo(id);
		problemDetail.setProblemVo(problemVo);
		problemDetail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_PROBLEM, id));
		ResultObject obj = new ResultObject();
		obj.setObj(problemDetail);
		return obj;
	}

	@Override
	public Object getProblemChuli(String id) {
		// Constants.ATTACHSOURCE_PROBLEM即"02"代表问题资源在KeyproSource表中对应的attachsource
		KeyProblemChuliDetail chuliDetail = new KeyProblemChuliDetail();
		KeyproProblemChuli keyproProblemChuli = chuliMapper.selectProblemChuli(id);
		chuliDetail.setKeyproProblemChuli(keyproProblemChuli);
		chuliDetail.setChuliSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_PROBLEM_SOLVE, id));
		ResultObject obj = new ResultObject();
		obj.setObj(chuliDetail);
		return obj;
	}

	@Override
	public Object removeProblem(String id) {
		// 删除问题---a).删除问题表记录; b)删除问题对应的资源表记录.
		problemMapper.deleteProblem(id);
		List<KeyproSource> sourceList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_PROBLEM, id);
		if (sourceList != null && sourceList.size() > 0) {
			for (KeyproSource source : sourceList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object addProblem(KeyproProblemDetail detail, LoginUserTest user) {
		// 1.add问题资源
		KeyproProblem problem = detail.getProblem();
		problem.setCreateTime(new Date());
		problem.setDelflag(Constants.DELFLAG_FALSE);
		problem.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM);
		problem.setYhzh(Constants.YHZH_BAOHUA);
		problem.setProcessState(Constants.REPORT_PROCESS);
		problem.setCreateId(user.getLoginId());
		problemMapper.insertProblem(problem);
		// 2.add图片资源
		List<KeyproSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (KeyproSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM);
				source.setSourceId(problem.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object modifyProblem(KeyproProblemDetail detail) {
		KeyproProblem problem = detail.getProblem();
		problem.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM);
		problem.setDelflag(Constants.DELFLAG_FALSE);
		problemMapper.updateByPrimaryKey(problem);
		List<KeyproSource> workList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_PROBLEM, problem.getId());
		if (workList != null && workList.size() > 0) {
			for (KeyproSource source : workList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<KeyproSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (KeyproSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM);
				source.setSourceId(problem.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public int desert(String id) {
		return problemMapper.updateStatus(id, Constants.DESERT_PROCESS);
	}

	@Override
	public int recovery(String id) {
		return problemMapper.updateStatus(id, Constants.REPORT_PROCESS);
	}

	@Override
	public int chuli(String id) {
		return problemMapper.updateStatus(id, Constants.CHULI_PROCESS);
	}

	@Override
	public int finish(KeyproProblemReq param) {
		problemMapper.updateStatus(param.getShangbaoid(), Constants.APPOINT_PROCESS);
		param.setShehetime(new Date());
		param.setChulitime(new Date());
		chuliMapper.huitui(param);
		return chuliMapper.shenghe(param);
	}

	@Override
	public Object keyGetAllSolve(String shangbaoid) {
		List<KeySolveResDetail> keySolveResDetails = new ArrayList<>();
		List<KeySolveResponse> res = chuliMapper.selectAllBySid(shangbaoid);
		for (KeySolveResponse keySolveResponse : res) {
			KeySolveResDetail detail = new KeySolveResDetail();
			List<KeyproSource> solveSource;
			solveSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_PROBLEM_SOLVE, keySolveResponse.getId());
			detail.setKeySolveResponse(keySolveResponse);
			detail.setSolveSource(solveSource);
			keySolveResDetails.add(detail);
		}
		return keySolveResDetails;
	}

	@Override
	public int huitui(String id) {
		return problemMapper.updateStatus(id, Constants.HUITUI_PROCESS);
	}

	@Override
	public int yishenghe(String id) {
		return problemMapper.updateStatus(id, Constants.YISHENHE_PROCESS);
	}

	@Override
	public int yilian(KeyproProblem param) {
		param.setLiantime(new Date());
		problemMapper.updateStatus(param.getId(), Constants.LIAN_PROCESS);
		return problemMapper.yilian(param);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object paifa(KeyproProblemAppointmans param) {
		String appointMans[] = param.getAppointMans();
		for(String appointMan : appointMans){
			String alias = Constants.JPUSH_KEY_DEPNAME + appointMan;
	    	jpushUtils.sendMsgToAndroid(Constants.JPUSH_DEFAULT_MSG, alias);
			KeyproProblemChuli problemChuli = param.getKeyproProblemChuli();
			problemChuli.setDelflag(Constants.DELFLAG_FALSE);
			problemChuli.setAppointTime(new Date());
			problemChuli.setAppointMan(appointMan);
			problemChuli.setIsSolve(Constants.SOLVE_WAIT);
			problemChuli.setIsCheck(Constants.EXAMINE_WAIT);
			problemChuli.setCreateTime(new Date());
			chuliMapper.insertChuli(problemChuli);
		}
		problemMapper.updateStatus(param.getKeyproProblemChuli().getShangbaoid(), Constants.APPOINT_PROCESS);
		return new ResultObject();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object solve(KeyProblemChuliDetail param) {
		KeyproProblemChuli chuli = param.getKeyproProblemChuli();
		/*KeySolveResponse solve = chuliMapper.selectBySolveId(chuli.getId());
		if (null != solve) {
			chuliMapper.deleteSolve(solve.getId());
		}*/
		chuli.setChulitime(new Date());
		chuli.setDelflag(Constants.DELFLAG_FALSE);
		chuli.setIsSolve(Constants.SOLVE_HAS);
		chuli.setIsCheck(Constants.EXAMINE_WAIT);
		chuli.setHuituiren(null);
		chuli.setSheheren(null);
		chuli.setShehemiaoshu(null);
		chuli.setShehetime(null);
		chuliMapper.chuli(chuli);
		//删除原来的处理图片
		List<KeyproSource> workList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_PROBLEM_SOLVE, chuli.getId());
		if (workList != null && workList.size() > 0) {
			for (KeyproSource source : workList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		// 2.add图片资源
		List<KeyproSource> list = param.getChuliSource();
		if (list != null && list.size() > 0) {
			for (KeyproSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM_SOLVE);
				source.setSourceId(chuli.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		//判断 所有派发的是不是都被处理了  再更新主表状态
		if(chuliMapper.countAppoints(chuli.getShangbaoid())==chuliMapper.countHasSolved(chuli.getShangbaoid()))
		problemMapper.updateStatus(chuli.getShangbaoid(), Constants.VERIFY_PROCESS);
		return new ResultObject();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object shenghe(KeyproProblemReq param) {
		param.setIsCheck(Constants.EXAMINE_HAS);
		if (Constants.EXAMINE_YES.equalsIgnoreCase(param.getExaminePassOrNot())) {
			param.setShehetime(new Date());
			param.setHuituiren(Constants.EXAMINE_YES);
			chuliMapper.shenghe(param);
			//判断 所有派发的是不是都被审核通过了  再更新主表状态
			//System.out.println(chuliMapper.countAppoints(param.getShangbaoid()));
			//System.out.println(chuliMapper.countCheckedYes(param.getShangbaoid()));
			if(chuliMapper.countAppoints(param.getShangbaoid())==chuliMapper.countCheckedYes(param.getShangbaoid()))
			problemMapper.updateStatus(param.getShangbaoid(), Constants.FINISH_PROCESS);
		}
		if (Constants.EXAMINE_NO.equalsIgnoreCase(param.getExaminePassOrNot())) {
			param.setShehetime(new Date());
			param.setHuituiren(Constants.EXAMINE_NO);
			chuliMapper.shenghe(param);
			param.setIsSolve("0");
			param.setIsSolve(Constants.SOLVE_WAIT);
			chuliMapper.returnSolve(param);
			//chuliMapper.deleteSolve(param.getId());
			//判断 所有派发的是不是都被审核失败了  再更新主表状态
			//if(chuliMapper.countAppoints(param.getShangbaoid())==chuliMapper.countCheckedNo(param.getShangbaoid()))
			problemMapper.updateStatus(param.getShangbaoid(), Constants.APPOINT_PROCESS);
		}
		return new ResultObject();
	}

	@Override
	public Object countProblemState() {
		List<CountState> count = problemMapper.countProblemState();
		ResultObject res = new ResultObject();
		res.setObj(count);
		return res;
	}

	@Override
	public int yuqi() {
		return problemMapper.yuqi(Constants.YUQI_PROCESS);
	}

	@Override
	public Object findAllByState(String state) {
		List<KeyproProblemResponse> response = problemMapper.findAllByState(state);
		ResultObject res = new ResultObject();
		res.setObj(response);
		return res;
	}

	@Override
	public Object findByStateRelax(String id) {
		List<KeyproProblemResponse> response = problemMapper.findByStateRelax(id);
		ResultObject res = new ResultObject();
		res.setObj(response);
		return res;
	}

	@Override
	public Object getKeyCoordinate() {
		List<KeyCoordinateRes> keyCoordinateRes = problemMapper.getKeyCoordinate();
		ResultObject res = new ResultObject();
		res.setObj(keyCoordinateRes);
		return res;
	}

	@Override
	public Object getFivePeople(String proId) {
		List<KeyproInformation> inf = informationMapper.selectFive(proId);
		ResultObject res = new ResultObject();
		res.setObj(inf);
		return res;
	}

	@Override
	public Object selectProblemAndProName(ProblemPagination param, LoginUserTest user) {
		// 查询总数
		List<KeyproProblemVo> list = new ArrayList<KeyproProblemVo>();
		int total = problemMapper.selectCount(param, user.getUserName());
		PageResult response = new PageResult();
		if (total > 0) {
			list = problemMapper.selectProblemAndProName(param, user.getUserName());
		}
		response.setOk(true);
		response.setTotal(total);
		response.setRows(list);
		return response;
	}

	@Override
	public Object countProblemAllCountryside() {
		ResultObject res = new ResultObject();
		List<CountrysideList> allCountryside = countrysideListMapper.getAllCountryside();
		List<CountKeypro> decade = problemMapper.countProblemAllCountryside();
		Map<String,Integer> responseMap = new HashMap<>();
		Map <Integer,String> countryMap = new HashMap<>();
		for(CountrysideList country : allCountryside){
			int index = 0;
			int count = 0;
			countryMap.put(index, country.getCountrysideName());
			for(CountKeypro param: decade){
				if(param.getType().equals(countryMap.get(index)))
				count += param.getCount();
			}
			responseMap.put(country.getCountrysideName(), count);
			index++;
		}
		res.setObj(responseMap);
		return res;
	}

	@Override
	public Object countProblemStateAll() {
		Map <String,Integer> stateMap = new LinkedHashMap<>();
		List<CountState> countStates = problemMapper.countProblemState();
		Map <Integer,String> handleMap = new HashMap<>();
		handleMap.put(0, Constants.KEY_PROBLEM_STATE_0);
		handleMap.put(1, Constants.KEY_PROBLEM_STATE_1);
		handleMap.put(2, Constants.KEY_PROBLEM_STATE_2);
		handleMap.put(3, Constants.KEY_PROBLEM_STATE_3);
		handleMap.put(4, Constants.KEY_PROBLEM_STATE_4);
		int allCount = 0;
		int index = 0;
		for(CountState countState:countStates){
			stateMap.put(handleMap.get(index), Integer.valueOf(countState.getCount()));
			index++;
			allCount+=Integer.valueOf(countState.getCount());
		}
		stateMap.put(Constants.KEY_PROBLEM_STATE_ALL, allCount);
		return stateMap;
	}

	@Override
	public Object countProblemByYear(String year) {
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

	@Override
	public Object countProblemType() {
		List<CountType> count = problemMapper.countProblemType();
		ResultObject res = new ResultObject();
		res.setObj(count);
		return res;
	}

	public 	int updateZt(@Param("id") int id, @Param("processState") String processState){
		return problemMapper.updateZt(id, processState);
	}




}
