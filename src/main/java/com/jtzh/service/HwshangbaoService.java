package com.jtzh.service;

import java.util.*;

import javax.annotation.Resource;

import com.jtzh.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.AB;
import com.jtzh.entity.Hwshangbao;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Yhzhshangbao;
import com.jtzh.mapper.HwshangbaoMapper;

@Service
public class HwshangbaoService {
	@Resource
    public HwshangbaoMapper hwshangbaoMapper;

    public HwshangbaoMapper getHwshangbaoMapper() {
        return hwshangbaoMapper;
    }
    
    public void setHwshangbaoMapper(HwshangbaoMapper hwshangbaoMapper) {
        this.hwshangbaoMapper = hwshangbaoMapper;
    }

    Map<String, Long> map = new HashMap<String, Long>();

    public int insertSelective(Hwshangbao param, LoginUserTest user) {
    	param.setSubmittime(new Date());
    	param.setYhzh(Constants.YHZH_BAOHUA);
    	param.setCreateId(user.getLoginId());
    	param.setCreateTime(new Date());
    	param.setDelflag("A");
        return hwshangbaoMapper.insertHwshangbao(param);
    }

    public int yilian(Hwshangbao param) {
    	param.setLiantime(new Date());
        return hwshangbaoMapper.yilian(param);
    }

    public int paifa(Hwshangbao param) {
    	param.setPaifatime(new Date());
        return hwshangbaoMapper.paifa(param);
    }

    public int chuli(Hwshangbao param) {
        return hwshangbaoMapper.chuli(param);
    }

    public int huitui(Hwshangbao param) {
        return hwshangbaoMapper.huitui(param);
    }

    public int yishenghe(Hwshangbao param) {
        return hwshangbaoMapper.yishenghe(param);
    }

    public int yuqi(Hwshangbao hwshangbao) {
        return hwshangbaoMapper.yuqi(hwshangbao);
    }

    public List<Hwshangbao> mohusousuo(String arg0, String arg1) {
        return hwshangbaoMapper.mohusousuo(arg0, arg1);
    }

    public List<Hwshangbao> gaojisousuo(@Param("Categories") String Categories, @Param("smallcategories") String smallcategories,
                                        @Param("isdeleted") String isdeleted, @Param("submittime") String submittime, @Param("endtime") String endtime) {
        return hwshangbaoMapper.gaojisousuo(Categories, smallcategories, isdeleted, submittime, endtime);
    }

    public List<Hwshangbao> findbypaifaren(String paifaren) {
        return hwshangbaoMapper.findbypaifaren(paifaren);
    }
    
    public Object findbyisdeleted(String isdeleted) {
        return hwshangbaoMapper.findbyisdeleted(isdeleted);
    }

    public Long selectcount1() {
        return hwshangbaoMapper.selectcount1();
    }

    public Long selectcount2() {
        return hwshangbaoMapper.selectcount2();
    }

    public  int deleteByPrimaryKey(Integer id){
        return hwshangbaoMapper.deleteByPrimaryKey(id);
    }
    public  int deletehwchuli(Integer id){
        return hwshangbaoMapper.deletehwchuli(id);
    }
    public     List<AB> tongjizhuangtai(){
        return hwshangbaoMapper.tongjizhuangtai();
    }
    public Long selectcount3(){
        return hwshangbaoMapper.selectcount3();
    }
    public  List <Hwshangbao> findall(@Param("lianren")String lianren){
        return hwshangbaoMapper.findall(lianren);
    }
    public Long selectcount4(Long isdeleted){
        return hwshangbaoMapper.selectcount4(isdeleted);
    }
    public Long selectcount8(Yhzhshangbao yhzhshangbao){
        return hwshangbaoMapper.selectcount8(yhzhshangbao);
    }
    public Long selectcount9(Yhzhshangbao yhzhshangbao){
        return hwshangbaoMapper.selectcount9(yhzhshangbao);
    }
    public List<Hwshangbao> getHwshangbaoList(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.getHwshangbaoList(yhzhshangbao);
    }
    public int addHwshangbao(Hwshangbao param, LoginUserTest user) {
    	param.setSubmittime(new Date());
    	param.setYhzh(Constants.YHZH_BAOHUA);
    	param.setCreateId(user.getLoginId());
    	param.setCreateTime(new Date());
    	param.setDelflag("A");
        return hwshangbaoMapper.insertHwshangbao(param);
    }
    public int updateHwshangbao(Hwshangbao param) {
        return hwshangbaoMapper.updateHwshangbao(param);
    }
    public int deleteHwshangbao(String id) {
        return hwshangbaoMapper.deleteHwshangbao(id);
    }
    public int ApplyHwshangbao(Hwshangbao param, LoginUserTest user) {
    	param.setSubmittime(new Date());
    	param.setYhzh(Constants.YHZH_BAOHUA);
    	param.setCreateId(user.getLoginId());
    	param.setCreateTime(new Date());
    	param.setDelflag("A");
        return hwshangbaoMapper.applyHwshangbao(param);
    }
    public List<Hwshangbao> findshangbao(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.findshangbao(yhzhshangbao);
    }
    public List<Hwshangbao> findshangbao1(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.findshangbao1(yhzhshangbao);
    }
    public List<Hwshangbao> findzhuangtai(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.findzhuangtai(yhzhshangbao);
    }
    public Long hwgetCountList1(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCountList1(param);
    }
    public Long hwgetCountList2(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCountList2(param);
    }
    public Long hwgetCountList3(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCountList3(param);
    }
    public Long hwgetCountList4(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCountList4(param);
    }
    public Long hwgetCountList5(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCountList5(param);
    }
    public List <CountIsdeleted> hwgetCountList6(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCount();
    }
    public Long hwgetCountListfeiqi() {
        return hwshangbaoMapper.hwgetCountListfeiqi();
    }
    public Long hwgetCountListshangbao() {
        return hwshangbaoMapper.hwgetCountListshangbao();
    }
    public Long hwgetCountListlian() {
        return hwshangbaoMapper.hwgetCountListlian();
    }
    public Long hwgetCountListpaifa() {
        return hwshangbaoMapper.hwgetCountListpaifa();
    }
    public Long hwgetCountListchuli() {
        return hwshangbaoMapper.hwgetCountListchuli();
    }
    public Long hwgetCountListdaishenhe() {
        return hwshangbaoMapper.hwgetCountListdaishenhe();
    }
    public Long hwgetCountListshenhe() {
        return hwshangbaoMapper.hwgetCountListshenhe();
    }
    /*public Object hwgetCountListjidu(String year) {
        return hwshangbaoMapper.hwgetCountListjidu(year);
    }*/
    public Object hwgetCountListjidu(String year) {
    	ResultObject res = new ResultObject();
		List<CountQuarter>  countQuarters= hwshangbaoMapper.countProblemByYear(year);
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
    public List<Hwshangbao> hwgetStateshangbaorenList(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.hwgetStateshangbaorenList(yhzhshangbao);
    }
    public List<Hwshangbao> hwgetStatepaifarenList(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.hwgetStatepaifarenList(yhzhshangbao);
    }
    public List<Hwshangbao> hwgetStatePeopleList(Yhzhshangbao yhzhshangbao) {
        return hwshangbaoMapper.hwgetStatePeopleList(yhzhshangbao);
    }
    public Object hwfindbyId(String id) {
        return hwshangbaoMapper.hwfindbyId(id);
    }
    public Object hwfindallbyId(String id) {
        return hwshangbaoMapper.hwfindallbyId(id);
    }
    public  List <Hwshangbao> findhwbyisdeleted(String isdeleted){
        return hwshangbaoMapper.findhwbyisdeleted(isdeleted);
    }
    public  int updateByPrimaryKeySelective(Hwshangbao record){
        return hwshangbaoMapper.updateByPrimaryKeySelective(record);
    }
    public List <CountCountryside> getCountrysideList(Hwshangbao param) {
        return hwshangbaoMapper.getCountrysideList();
    }
    public List <CountSource> hwgetCountSource(Hwshangbao param) {
        return hwshangbaoMapper.hwgetCountSource();
    }

    public List <CountSmallcategories> getHwCountSmallcategories() {
        return hwshangbaoMapper.getHwCountSmallcategories();
    }

    /**
     * 根据案件来源分类统计
     * @return {案件来源：数量}
     */
    public List<Map> calBySource(String calDay) {
        return hwshangbaoMapper.calBySource(calDay);
    }

    public Map<String, Integer> todaySituation() {
        Map<String, Integer> map = new HashMap<>();
        map.put("todayAdd",  hwshangbaoMapper.todayAdd());
        map.put("todayPassed",  hwshangbaoMapper.todayPassed());
        map.put("todayResolved",  hwshangbaoMapper.todayResolved());
        return map;


    }

    public int getHwIncreare() {
      int  todayRes=  hwshangbaoMapper.getHwIncreare();
      int  yesRes=  hwshangbaoMapper.getHwIncreare2();

      int res=0;
      if(yesRes==0){
          res=1;
      }else {
          res = (todayRes - yesRes) / yesRes;
      }

      return res;
    }



    public List<Map> calByPeople(String date) {
        List<Map> list = hwshangbaoMapper.calByPeople(date);
        list.sort(Comparator.comparing(o -> o.get("value").toString()));
        return list;
    }

    public List gethwCountSmallcategories(String calDay) {
        return hwshangbaoMapper.gethwCountSmallcategories(calDay);
    }
}
