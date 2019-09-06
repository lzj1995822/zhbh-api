package com.jtzh.mapper;

import com.jtzh.vo.dispute.DisputeEventCountVO;
import com.jtzh.vo.dispute.DisputeEventDetailVO;
import com.jtzh.vo.dispute.DisputeEventVO;
import com.jtzh.entity.DisputeEvent;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface DisputeEventMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeEvent paramDisputeEvent);
  
  public abstract int updateEventStatus(@Param("status") String paramString, @Param("id") Long paramLong);
  
  public abstract DisputeEventDetailVO selectByPrimaryKey(Long paramLong);
  
  public abstract DisputeEvent selectByDisputeEventID(Long paramLong);
  
  public abstract List<DisputeEventVO> getDisputeEventReporterQuery(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventReporterQueryCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<DisputeEventVO> getDisputeEventDespatcherQuery(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventDespatcherQueryCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<DisputeEventVO> getDisputeEventDeptDespatcherQuery(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventDeptDespatcherQueryCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<DisputeEventVO> getDisputeEventHandlerQuery(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventHandlerQueryCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<DisputeEventVO> getDisputeEventAuditorQuery(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventAuditorQueryCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<DisputeEventVO> getDisputeEventAPPQuery(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventAPPQueryCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<DisputeEvent> getAll();
  
  public abstract List<DisputeEvent> selectForGIS(@Param("key") String paramString);
  
  public abstract List<DisputeEvent> getSolveEvent(@Param("netGridID") Long paramLong);
  
  public abstract List<DisputeEvent> getUnSolveEvent(@Param("netGridID") Long paramLong);
  
  public abstract int getUnSovleCount(@Param("netGridID") Long paramLong);
  
  public abstract int getSovleCount(@Param("netGridID") Long paramLong);
  
  public abstract List<DisputeEventCountVO> getDisputeEventCount(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract int updateByPrimaryKey(DisputeEvent paramDisputeEvent);
  
  public abstract int getSSEventCountForCheck(@Param("isFinish") Integer paramInteger);
  
  public abstract List<DisputeEventVO> getDisputeEventForNetGrid(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDisputeEventForNetGridCount(@Param("id") Long paramLong, @Param("eventName") String paramString1, @Param("eventTypeValue") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract Map getDisputeEventByStatus(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getDisputeEventCountByNetGrid();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */