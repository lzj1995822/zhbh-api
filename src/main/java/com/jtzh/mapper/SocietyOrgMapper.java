package com.jtzh.mapper;

import com.jtzh.vo.nonpublic.NonpublicHistogramVO;
import com.jtzh.vo.nonpublic.SocietyOrgDetailVO;
import com.jtzh.vo.nonpublic.SocietyOrgInfoVO;
import com.jtzh.entity.SocietyOrg;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SocietyOrgMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(SocietyOrg paramSocietyOrg);
  
  public abstract SocietyOrg selectByPrimaryKey(String paramString);
  
  public abstract List<SocietyOrg> selectAll(@Param("netGridID") Long paramLong);
  
  public abstract int updateByPrimaryKey(SocietyOrg paramSocietyOrg);
  
  public abstract List<SocietyOrgInfoVO> getSocietyOrgInfo(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSocietyOrgInfoCount(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<SocietyOrgDetailVO> getSocietyOrgDetailByCode(@Param("code") String paramString);
  
  public abstract List<NonpublicHistogramVO> getSocietyOrgHistogram();
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SocietyOrgMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */