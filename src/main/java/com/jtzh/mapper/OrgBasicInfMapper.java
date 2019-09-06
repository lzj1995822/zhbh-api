package com.jtzh.mapper;

import com.jtzh.vo.orgMember.OrgBasicInfExVO;
import com.jtzh.vo.orgMember.OrgBasicInfVO;
import com.jtzh.entity.OrgBasicInf;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface OrgBasicInfMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(OrgBasicInf paramOrgBasicInf);
  
  public abstract OrgBasicInf selectByPrimaryKey(Long paramLong);
  
  public abstract List<OrgBasicInf> selectAll();
  
  public abstract List<OrgBasicInfExVO> getOrgInfQuery(@Param("orgName") String paramString1, @Param("orgType") String paramString2, @Param("netGridID") Integer paramInteger, @Param("levelType") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getOrgInfQueryCount(@Param("orgName") String paramString1, @Param("orgType") String paramString2, @Param("netGridID") Integer paramInteger, @Param("levelType") String paramString3);
  
  public abstract OrgBasicInfVO getOrgInfDetailByOrgID(Long paramLong);
  
  public abstract int updateByPrimaryKey(OrgBasicInf paramOrgBasicInf);
  
  public abstract int getCount();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\OrgBasicInfMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */