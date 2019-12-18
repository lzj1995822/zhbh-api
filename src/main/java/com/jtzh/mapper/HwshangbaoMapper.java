package com.jtzh.mapper;

import java.util.List;
import java.util.Map;

import com.jtzh.pojo.*;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.AB;
import com.jtzh.entity.Hwshangbao;
import com.jtzh.entity.HwshangbaoExample;
import com.jtzh.entity.Yhzhshangbao;

public interface HwshangbaoMapper {
	
    int countByExample(HwshangbaoExample example);

    int deleteByExample(HwshangbaoExample example);

    int deleteByPrimaryKey(Integer id);
    int deleteBySourceId(@Param("sourceId") String sourceId,@Param("source") String source);
    int insert(Hwshangbao record);

    int insertSelective(Hwshangbao record);

    List<Hwshangbao> selectByExample(HwshangbaoExample example);

    Hwshangbao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hwshangbao record, @Param("example") HwshangbaoExample example);

    int updateByExample(@Param("record") Hwshangbao record, @Param("example") HwshangbaoExample example);

    int updateByPrimaryKeySelective(Hwshangbao record);

    int updateByPrimaryKey(Hwshangbao record);
    int yilian(Hwshangbao hwshangbao);
    int paifa(Hwshangbao hwshangbao);
    int chuli(Hwshangbao hwshangbao);
    int huitui(Hwshangbao hwshangbao);
    int yishenghe(Hwshangbao hwshangbao);
    int yuqi(Hwshangbao hwshangbao);
    List <Hwshangbao> mohusousuo(String arg0,String arg1);
    List <Hwshangbao> gaojisousuo(@Param("Categories")String Categories,@Param("smallcategories")String smallcategories,
                                  @Param("isdeleted")String isdeleted,@Param("submittime")String submittime,@Param("endtime")String endtime);
    List <Hwshangbao> findbypaifaren(String paifaren);
    List <HwshangbaoFind> findbyisdeleted(String isdeleted);
    Long selectcount4(Long isdeleted);
    Long selectcount8(@Param("page") Yhzhshangbao yhzhshangbao);
    Long selectcount9(@Param("page") Yhzhshangbao yhzhshangbao);
    Long selectcount1();
    Long selectcount2();
    int deletehwchuli(Integer id);
    List<AB> tongjizhuangtai();
    Long selectcount3();
    List <Hwshangbao> findall(@Param("lianren")String lianren);
    List <Hwshangbao> getHwshangbaoList(@Param("page") Yhzhshangbao yhzhshangbao);
    int insertHwshangbao(Hwshangbao param);
    int updateHwshangbao(Hwshangbao param);
    int deleteHwshangbao(@Param("id") String id);
    int applyHwshangbao(Hwshangbao param);
    List <Hwshangbao> findshangbao(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Hwshangbao> findshangbao1(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Hwshangbao> findzhuangtai(@Param("page") Yhzhshangbao yhzhshangbao);
    Long hwgetCountList1(Hwshangbao param);
    Long hwgetCountList2(Hwshangbao param);
    Long hwgetCountList3(Hwshangbao param);
    Long hwgetCountList4(Hwshangbao param);
    Long hwgetCountList5(Hwshangbao param);
    Long hwgetCountList6(Hwshangbao param);
    List<CountIsdeleted> hwgetCount();
    Long hwgetCountListfeiqi();
    Long hwgetCountListshangbao();
    Long hwgetCountListlian();
    Long hwgetCountListpaifa();
    Long hwgetCountListchuli();
    Long hwgetCountListdaishenhe();
    Long hwgetCountListshenhe();
    List<CountIsdeleted> hwgetCountListjidu(@Param("col")String year);
    List <Hwshangbao> hwgetStateshangbaorenList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Hwshangbao> hwgetStatepaifarenList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Hwshangbao> hwgetStatePeopleList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Hwshangbao> hwfindbyId(String id);
    List <HwshangbaoFind> hwfindallbyId(String id);
    List <Hwshangbao> findhwbyisdeleted(String isdeleted);
    List<CountCountryside> getCountrysideList();
    List<CountSource> hwgetCountSource();
    List<CountQuarter> countProblemByYear(@Param("year")String year);

    List <CountSmallcategories> getHwCountSmallcategories();




    /**
     * 根据案件来源分类统计
     * @param calDay 统计日期
     * @return {案件来源：数量}
     */
    List<Map> calhwBySource(@Param(value = "calDay") String calDay);
    Integer todayAdd();

    Integer todayPassed();


    Integer todayResolved();

    Integer getHwIncreare();

    //查询昨天审核通过比率
    Integer getHwIncreare2();


    List<Map> calByPeople(String date);

    List <CountSmallcategories> gethwCountSmallcategories(@Param(value = "calDay") String calDay);
}
