package com.jtzh.mapper;

import com.jtzh.vo.gis.SocietySecurityEventVO;
import com.jtzh.vo.ss.SSCountVO;
import com.jtzh.vo.ss.SSVO;
import com.jtzh.entity.SocietySecurityEvent;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface SocietySecurityEventMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SocietySecurityEvent paramSocietySecurityEvent);
  
  public abstract SocietySecurityEvent selectByPrimaryKey(Long paramLong);
  
  public abstract List<SocietySecurityEvent> selectAll();
  
  public abstract int updateByPrimaryKey(SocietySecurityEvent paramSocietySecurityEvent);
  
  public abstract int updateSSEventStatus(@Param("type") String paramString, @Param("id") Long paramLong);
  
  public abstract int getCommonCount(@Param("netGridID") Long paramLong);
  
  public abstract int getImportantCount(@Param("netGridID") Long paramLong);
  
  public abstract List<SocietySecurityEventVO> getSSEventByType(@Param("netGridID") Integer paramInteger1, @Param("type") Integer paramInteger2);
  
  public abstract List<SocietySecurityEventVO> getSSEventQuery(@Param("kind") Integer paramInteger1, @Param("name") String paramString, @Param("netGridID") Integer paramInteger2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventQueryCount(@Param("kind") Integer paramInteger1, @Param("name") String paramString, @Param("netGridID") Integer paramInteger2);
  
  public abstract SSVO getSSEventDetail(@Param("id") Long paramLong);
  
  public abstract List<SSCountVO> getSSEventCount();
  
  public abstract List<SocietySecurityEventVO> getSSEventReporterQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventReporterQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SocietySecurityEventVO> getSSEventDespatcherQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventDespatcherQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SocietySecurityEventVO> getSSEventDeptDespatcherQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventDeptDespatcherQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SocietySecurityEventVO> getSSEventHandlerQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventHandlerQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SocietySecurityEventVO> getSSEventAuditorQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventAuditorQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SocietySecurityEventVO> getSSEventAPPQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventAPPQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SocietySecurityEventVO> getSSEventForNetGrid(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSSEventForNetGridCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List getSSEventCountForCheck(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getSSEventByStatus(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getSSEventCountByNetGrid();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SocietySecurityEventMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */