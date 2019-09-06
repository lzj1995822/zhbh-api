package com.jtzh.mapper;

import com.jtzh.vo.nonpublic.NonPublicEconomyOrgDetailVO;
import com.jtzh.vo.nonpublic.NonPublicEconomyOrgInfoVO;
import com.jtzh.vo.nonpublic.NonpublicHistogramVO;
import com.jtzh.entity.NonPublicEconomyOrg;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface NonPublicEconomyOrgMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(NonPublicEconomyOrg paramNonPublicEconomyOrg);
  
  public abstract NonPublicEconomyOrg selectByPrimaryKey(String paramString);
  
  public abstract List<NonPublicEconomyOrg> selectAll(@Param("netGridID") Long paramLong);
  
  public abstract List<NonPublicEconomyOrg> getKeyEnterpriseUSCcode();
  
  public abstract int updateByPrimaryKey(NonPublicEconomyOrg paramNonPublicEconomyOrg);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<NonpublicHistogramVO> getHistogram();
  
  public abstract List<NonPublicEconomyOrgDetailVO> getNonPublicEconomyOrgDetailByCode(@Param("code") String paramString);
  
  public abstract List<NonPublicEconomyOrgDetailVO> getNonPublicEconomyOrgDetailForGIS(@Param("netGridID") Integer paramInteger1, @Param("isLogisticsEnterprise") Integer paramInteger2, @Param("isKeyEnterprise") Integer paramInteger3);
  
  public abstract List<NonPublicEconomyOrgInfoVO> getNonPublicEconomyOrgInfo(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Long paramLong, @Param("isLogisticsEnterprise") Integer paramInteger1, @Param("isKeyEnterprise") Integer paramInteger2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNonPublicEconomyOrgInfoCount(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Long paramLong, @Param("isLogisticsEnterprise") Integer paramInteger1, @Param("isKeyEnterprise") Integer paramInteger2);
  
  public abstract int getKeyEnterpriseCount();
  
  public abstract int getLogisticsEnterpriseCount();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NonPublicEconomyOrgMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */