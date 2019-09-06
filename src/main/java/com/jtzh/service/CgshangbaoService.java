package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jtzh.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.AB;
import com.jtzh.entity.Cgshangbao;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Yhzhshangbao;
import com.jtzh.mapper.CgshangbaoMapper;

@Service
public class CgshangbaoService {
    @Resource
    public CgshangbaoMapper cgshangbaoMapper;

    public CgshangbaoMapper getCgshangbaoMapper() {
        return cgshangbaoMapper;
    }


    public void setCgshangbaoMapper(CgshangbaoMapper cgshangbaoMapper) {
        this.cgshangbaoMapper = cgshangbaoMapper;
    }

    Map<String, Long> map = new HashMap<String, Long>();

    public int insertSelective(Cgshangbao param, LoginUserTest user) {
    	param.setSubmittime(new Date());
    	param.setYhzh(Constants.YHZH_BAOHUA);
    	param.setCreateId(user.getLoginId());
    	param.setCreateTime(new Date());
    	param.setDelflag("A");
        return cgshangbaoMapper.insertCgshangbao(param);
    }

    public int yilian(Cgshangbao param) {
    	param.setLiantime(new Date());
        return cgshangbaoMapper.yilian(param);
    }

    public int paifa(Cgshangbao param) {
    	param.setPaifatime(new Date());
        return cgshangbaoMapper.paifa(param);
    }

    public int chuli(Cgshangbao param) {
        return cgshangbaoMapper.chuli(param);
    }

    public int huitui(Cgshangbao param) {
        return cgshangbaoMapper.huitui(param);
    }

    public int yishenghe(Cgshangbao param) {
        return cgshangbaoMapper.yishenghe(param);
    }

    public int yuqi(Cgshangbao cgshangbao) {
        return cgshangbaoMapper.yuqi(cgshangbao);
    }

    public List<Cgshangbao> mohusousuo(String arg0, String arg1) {
        return cgshangbaoMapper.mohusousuo(arg0, arg1);
    }

    public List<Cgshangbao> gaojisousuo(@Param("Categories") String Categories, @Param("smallcategories") String smallcategories,
                                        @Param("isdeleted") String isdeleted, @Param("submittime") String submittime, @Param("endtime") String endtime) {
        return cgshangbaoMapper.gaojisousuo(Categories, smallcategories, isdeleted, submittime, endtime);
    }

    public List<Cgshangbao> findbypaifaren(String paifaren) {
        return cgshangbaoMapper.findbypaifaren(paifaren);
    }

    public Object findbyisdeleted(String isdeleted) {
        return cgshangbaoMapper.findbyisdeleted(isdeleted);
    }

    public Long selectcount1() {
        return cgshangbaoMapper.selectcount1();
    }

    public Long selectcount2() {
        return cgshangbaoMapper.selectcount2();
    }

    public  int deleteByPrimaryKey(Integer id){
        return cgshangbaoMapper.deleteByPrimaryKey(id);
    }
    public  int deletecgchuli(Integer id){
        return cgshangbaoMapper.deletecgchuli(id);
    }
    public     List<AB> tongjizhuangtai(){
        return cgshangbaoMapper.tongjizhuangtai();
    }
    public Long selectcount3(){
        return cgshangbaoMapper.selectcount3();
    }
    public  List <Cgshangbao> findall(@Param("lianren")String lianren){
        return cgshangbaoMapper.findall(lianren);
    }
    public Long selectcount4(Long isdeleted){
        return cgshangbaoMapper.selectcount4(isdeleted);
    }
    public Long selectcount8(Yhzhshangbao yhzhshangbao){
        return cgshangbaoMapper.selectcount8(yhzhshangbao);
    }
    public Long selectcount9(Yhzhshangbao yhzhshangbao){
        return cgshangbaoMapper.selectcount9(yhzhshangbao);
    }
    public int addCgshangbao(Cgshangbao param, LoginUserTest user) {
    	param.setSubmittime(new Date());
    	param.setYhzh(Constants.YHZH_BAOHUA);
    	param.setCreateId(user.getLoginId());
    	param.setCreateTime(new Date());
    	param.setDelflag("A");
        return cgshangbaoMapper.insertCgshangbao(param);
    }
    public int updateCgshangbao(Cgshangbao param) {
        return cgshangbaoMapper.updateByPrimaryKeySelective(param);
    }
    public int deleteCgshangbao(String id) {
        return cgshangbaoMapper.deleteCgshangbao(id);
    }
    public int ApplyCgshangbao(Cgshangbao param, LoginUserTest user) {
    	param.setSubmittime(new Date());
    	param.setYhzh(Constants.YHZH_BAOHUA);
    	param.setCreateId(user.getLoginId());
    	param.setCreateTime(new Date());
    	param.setDelflag("A");
        return cgshangbaoMapper.applyCgshangbao(param);
    }
    public List<Cgshangbao> getCgshangbaoList(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.getCgshangbaoList(yhzhshangbao);
    }
    public List<Cgshangbao> findshangbao(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.findshangbao(yhzhshangbao);
    }
    public List<Cgshangbao> findshangbao1(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.findshangbao1(yhzhshangbao);
    }
    public List<Cgshangbao> findzhuangtai(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.findzhuangtai(yhzhshangbao);
    }
    public Long getCountList1(Cgshangbao param) {
        return cgshangbaoMapper.getCountList1(param);
    }
    public Long getCountList2(Cgshangbao param) {
        return cgshangbaoMapper.getCountList2(param);
    }
    public Long getCountList3(Cgshangbao param) {
        return cgshangbaoMapper.getCountList3(param);
    }
    public Long getCountList4(Cgshangbao param) {
        return cgshangbaoMapper.getCountList4(param);
    }
    public Long getCountList5(Cgshangbao param) {
        return cgshangbaoMapper.getCountList5(param);
    }
    public List <CountIsdeleted> getCountList6(Cgshangbao param) {
        return cgshangbaoMapper.getCount();
    }


    public Long getCountListfeiqi() {
        return cgshangbaoMapper.getCountListfeiqi();
    }
    public Long getCountListshangbao() {
        return cgshangbaoMapper.getCountListshangbao();
    }
    public Long getCountListlian() {
        return cgshangbaoMapper.getCountListlian();
    }
    public Long getCountListpaifa() {
        return cgshangbaoMapper.getCountListpaifa();
    }
    public Long getCountListchuli() {
        return cgshangbaoMapper.getCountListchuli();
    }
    public Long getCountListdaishenhe() {
        return cgshangbaoMapper.getCountListdaishenhe();
    }
    public Long getCountListshenhe() {
        return cgshangbaoMapper.getCountListshenhe();
    }
    /*public Object getCountListjidu(String year) {
        return cgshangbaoMapper.getCountListjidu(year);
    }*/
	public Object getCountListjidu(String year) {
		ResultObject res = new ResultObject();
		List<CountQuarter>  countQuarters= cgshangbaoMapper.countProblemByYear(year);
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
    public List<Cgshangbao> getStateshangbaorenList(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.getStateshangbaorenList(yhzhshangbao);
    }
    public List<Cgshangbao> getStatepaifarenList(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.getStatepaifarenList(yhzhshangbao);
    }
    public List<Cgshangbao> getStatePeopleList(Yhzhshangbao yhzhshangbao) {
        return cgshangbaoMapper.getStatePeopleList(yhzhshangbao);
    }
    public Object cgfindbyId(String id) {
        return cgshangbaoMapper.cgfindbyId(id);
    }
    public Object cgfindallbyId(String id) {
        return cgshangbaoMapper.cgfindallbyId(id);
    }
    public   List <Cgshangbao> findcgbyisdeleted(String isdeleted){
        return cgshangbaoMapper.findcgbyisdeleted(isdeleted);
    }
    public int updatezhuangtai(Cgshangbao param) {
        return cgshangbaoMapper.updatezhuangtai(param);
    }
    public List <CountCountryside> getCountrysideList(Cgshangbao param) {
        return cgshangbaoMapper.getCountrysideList();
    }
    public List <CountSource> getCountSource(Cgshangbao param) {
        return cgshangbaoMapper.getCountSource();
    }

    public List <CountSmallcategories> getCgCountSmallcategories() {
        return cgshangbaoMapper.getCgCountSmallcategories();
    }

}