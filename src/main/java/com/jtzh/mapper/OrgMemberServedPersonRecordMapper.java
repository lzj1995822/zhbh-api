package com.jtzh.mapper;

import com.jtzh.vo.gis.ServedRecordVO;
import com.jtzh.vo.orgMember.OrgMemberServedPersonRecordQueryVO;
import com.jtzh.vo.orgMember.ServedRecordCountVO;
import com.jtzh.vo.orgMember.ServedRecordDetailVO;
import com.jtzh.entity.OrgMemberServedPersonRecord;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface OrgMemberServedPersonRecordMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(OrgMemberServedPersonRecord paramOrgMemberServedPersonRecord);
  
  public abstract OrgMemberServedPersonRecord selectByPrimaryKey(Long paramLong);
  
  public abstract ServedRecordDetailVO getDetailByID(@Param("orgMServedPID") Long paramLong);
  
  public abstract List<OrgMemberServedPersonRecord> selectAll();
  
  public abstract int updateByPrimaryKey(OrgMemberServedPersonRecord paramOrgMemberServedPersonRecord);
  
  public abstract int updateRecord(@Param("id") Long paramLong, @Param("content") String paramString, @Param("date") Date paramDate);
  
  public abstract int getEveryMonthPersonCount();
  
  public abstract int getServedCount();
  
  public abstract List<OrgMemberServedPersonRecordQueryVO> select(@Param("orgMemberName") String paramString1, @Param("servedPersonName") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getQueryCount(@Param("orgMemberName") String paramString1, @Param("servedPersonName") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<ServedRecordCountVO> getServedRecordCount();
  
  public abstract List<ServedRecordCountVO> getCurrentMonthCount();
  
  public abstract List<ServedRecordVO> getServedRecordForGIS(@Param("netGridID") Integer paramInteger);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\OrgMemberServedPersonRecordMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */