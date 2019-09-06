package com.jtzh.mapper;

import com.jtzh.vo.gis.ServedPersonCountVO;
import com.jtzh.vo.served.ServedPersonBasicCountVO;
import com.jtzh.vo.served.ServedPersonBasicDetailVO;
import com.jtzh.vo.served.SpecialPersonPieVO;
import com.jtzh.entity.ServedPersonBasic;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ServedPersonBasicMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(ServedPersonBasic paramServedPersonBasic);
  
  public abstract ServedPersonBasic selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedPersonBasic> selectAll();
  
  public abstract int updateByPrimaryKey(ServedPersonBasic paramServedPersonBasic);
  
  public abstract int changeSpecialStatus(@Param("certifID") String paramString);
  
  public abstract List<com.jtzh.vo.served.ServedPersonBasicVO> queryBasic(@Param("name") String paramString1, @Param("servedPersonTypeValue") String paramString2, @Param("certifID") String paramString3, @Param("netGridID") Integer paramInteger1, @Param("isSpecialPopulation") Integer paramInteger2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract List<ServedPersonBasic> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<ServedPersonBasic> selectByNameAndCertifID(@Param("name") String paramString1, @Param("certifID") String paramString2);
  public abstract int selectByNameAndCertifIDGhTotal(@Param("name") String paramString1, @Param("certifID") String paramString2);
  public abstract List<ServedPersonBasic> selectByNameAndCertifIDGh(@Param("name") String paramString1, @Param("certifID") String paramString2,@Param("start") int start,@Param("pageSize") int pageSize);
  
  public abstract List<ServedPersonCountVO> getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<ServedPersonCountVO> getCountByNetGrid(@Param("servedPersonTypeValue") String paramString1, @Param("netGridID") String paramString2);
  
  public abstract int getQueryCount(@Param("name") String paramString1, @Param("servedPersonTypeValue") String paramString2, @Param("certifID") String paramString3, @Param("netGridID") Integer paramInteger1, @Param("isSpecialPopulation") Integer paramInteger2);
  
  public abstract List<com.jtzh.vo.gis.ServedPersonBasicVO> getServedPersonBasic(@Param("servedPersonTypeValue") String paramString);
  
  public abstract List<com.jtzh.vo.gis.ServedPersonBasicVO> getServedPersonBasicByNetGrid(@Param("servedPersonTypeValue") String paramString1, @Param("netGridID") String paramString2);
  
  public abstract Long getPrimaryKeyByName(@Param("name") String paramString1, @Param("certifID") String paramString2);
  
  public abstract Long getPrimaryKeyByCertifID(@Param("certifID") String paramString);
  
  public abstract List<ServedPersonBasicDetailVO> getServedPersonBasicDetail(@Param("certifID") String paramString);
  
  public abstract List<SpecialPersonPieVO> getServedHistogramCount(@Param("type") String paramString);
  
  public abstract List<ServedPersonBasicCountVO> getServedPersonCount();
  
  void updateBasic(ServedPersonBasic basic);
  
  public abstract int deleteBasic(Long ServedPersonID);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedPersonBasicMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */