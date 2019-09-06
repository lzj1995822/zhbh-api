package com.jtzh.mapper;

import com.jtzh.vo.skynet.SPExVO;
import com.jtzh.vo.skynet.SPVO;
import com.jtzh.vo.ss.SSCountVO;
import com.jtzh.entity.SkynetPatrolEvent;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface SkynetPatrolEventMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SkynetPatrolEvent paramSkynetPatrolEvent);
  
  public abstract SkynetPatrolEvent selectByPrimaryKey(Long paramLong);
  
  public abstract SPVO selectBySPEventID(@Param("id") Long paramLong);
  
  public abstract List<SkynetPatrolEvent> selectAll();
  
  public abstract List<SPVO> getSPEventQuery(@Param("name") String paramString, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventQueryCount(@Param("name") String paramString, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2);
  
  public abstract List<SPExVO> getSPEventReporterQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventReporterQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SPExVO> getSPEventDespatcherQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventDespatcherQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SPExVO> getSPEventDeptDespatcherQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventDeptDespatcherQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SPExVO> getSPEventHandlerQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventHandlerQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SPExVO> getSPEventAuditorQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventAuditorQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SPExVO> getSPEventAPPQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventAPPQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SPExVO> getSPEventForNetGrid(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPEventForNetGridCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") Integer paramInteger1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<SSCountVO> getSPEventCount();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEvent paramSkynetPatrolEvent);
  
  public abstract int updateSPEventStatus(@Param("type") String paramString, @Param("id") Long paramLong);
  
  public abstract List getSPEventCountForCheck(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getSPEventByStatus(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getSPEventCountByNetGrid();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */