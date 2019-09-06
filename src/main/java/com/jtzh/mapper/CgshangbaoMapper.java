package com.jtzh.mapper;

import java.util.List;
import java.util.Map;

import com.jtzh.pojo.*;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.AB;
import com.jtzh.entity.Cgshangbao;
import com.jtzh.entity.CgshangbaoExample;
import com.jtzh.entity.Yhzhshangbao;

public interface CgshangbaoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int countByExample(CgshangbaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int deleteByExample(CgshangbaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int deleteByPrimaryKey(Integer id);


    int deleteByPrimaryResouce(@Param("sourceId") String id,@Param("source") String source);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int insert(Cgshangbao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int insertSelective(Cgshangbao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    List<Cgshangbao> selectByExample(CgshangbaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    Cgshangbao selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int updateByExampleSelective(@Param("record") Cgshangbao record, @Param("example") CgshangbaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int updateByExample(@Param("record") Cgshangbao record, @Param("example") CgshangbaoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int updateByPrimaryKeySelective(Cgshangbao record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cgshangbao
     *
     * @mbggenerated Wed Jul 18 10:32:41 CST 2018
     */
    int updateByPrimaryKey(Cgshangbao record);
    int yilian(Cgshangbao param);
    int paifa(Cgshangbao param);
    int chuli(Cgshangbao param);
    int huitui(Cgshangbao param);
    int yishenghe(Cgshangbao param);
    List <Cgshangbao> findshangbao1(Map<String, Long> map);
    int yuqi(Cgshangbao cgshangbao);
    List <Cgshangbao> mohusousuo(String arg0,String arg1);
    List <Cgshangbao> gaojisousuo(@Param("Categories")String Categories,@Param("smallcategories")String smallcategories,
                                  @Param("isdeleted")String isdeleted,@Param("submittime")String submittime,@Param("endtime")String endtime);
    List <Cgshangbao> findbypaifaren(String paifaren);
    List <CgshangbaoFind> findbyisdeleted(String isdeleted);
    Long selectcount4(Long isdeleted);
    Long selectcount8(@Param("page") Yhzhshangbao yhzhshangbao);
    Long selectcount9(@Param("page") Yhzhshangbao yhzhshangbao);
    Long selectcount1();
    Long selectcount2();
    int deletecgchuli(Integer id);
    List<AB> tongjizhuangtai();
    Long selectcount3();
    List <Cgshangbao> findall(@Param("lianren")String lianren);
    int insertCgshangbao(Cgshangbao param);
    int updateCgshangbao(Cgshangbao param);
    int deleteCgshangbao(@Param("id") String id);
    int applyCgshangbao(Cgshangbao param);
    List <Cgshangbao> getCgshangbaoList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Cgshangbao> findshangbao(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Cgshangbao> findshangbao1(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Cgshangbao> findzhuangtai(@Param("page") Yhzhshangbao yhzhshangbao);
    Long getCountList1(Cgshangbao param);
    Long getCountList2(Cgshangbao param);
    Long getCountList3(Cgshangbao param);
    Long getCountList4(Cgshangbao param);
    Long getCountList5(Cgshangbao param);
    Long getCountList6(Cgshangbao param);
    Long[] getCountList7(Cgshangbao param);
    List<CountIsdeleted> getCount();

    Long getCountListfeiqi();
    Long getCountListshangbao();
    Long getCountListlian();
    Long getCountListpaifa();
    Long getCountListchuli();
    Long getCountListdaishenhe();
    Long getCountListshenhe();
    List<CountIsdeleted> getCountListjidu(@Param("col")String year);
    List <Cgshangbao> getStateshangbaorenList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Cgshangbao> getStatepaifarenList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Cgshangbao> getStatePeopleList(@Param("page") Yhzhshangbao yhzhshangbao);
    List <Cgshangbao> cgfindbyId(String id);
    List <CgshangbaoFind> cgfindallbyId(String id);
    List <Cgshangbao> findcgbyisdeleted(String isdeleted);
    int updatezhuangtai(Cgshangbao param);
    List<CountCountryside> getCountrysideList();
    List<CountSource> getCountSource();
    List<CountQuarter> countProblemByYear(@Param("year")String year);
    List <CountSmallcategories> getCgCountSmallcategories();

}