package com.jtzh.mapper;

import com.jtzh.vo.orgMember.OrgMemberQueryVO;
import com.jtzh.entity.OrgMember;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface OrgMemberMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(OrgMember paramOrgMember);
  
  public abstract OrgMember selectByPrimaryKey(Long paramLong);
  
  public abstract List<OrgMember> selectAll();
  
  public abstract int updateByPrimaryKey(OrgMember paramOrgMember);
  
  public abstract Long getPrimaryKeyByName(@Param("name") String paramString1, @Param("certID") String paramString2);
  
  public abstract List<OrgMemberQueryVO> select(@Param("name") String paramString1, @Param("positionTypeValue") String paramString2, @Param("status") Integer paramInteger, @Param("page") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract List<OrgMemberQueryVO> getOrgMemberByNameAndCertID(@Param("name") String paramString1, @Param("id") String paramString2);
  
  public abstract int getQueryCount(@Param("name") String paramString1, @Param("positionTypeValue") String paramString2, @Param("status") Integer paramInteger);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\OrgMemberMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */