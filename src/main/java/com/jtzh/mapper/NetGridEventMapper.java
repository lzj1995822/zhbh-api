package com.jtzh.mapper;

import com.jtzh.vo.netGrid.NetGridEventDetailVO;
import com.jtzh.vo.netGrid.NetGridEventVO;
import com.jtzh.vo.ss.SSCountVO;
import com.jtzh.entity.NetGridEvent;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface NetGridEventMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEvent paramNetGridEvent);
  
  public abstract NetGridEvent selectByPrimaryKey(Long paramLong);
  
  public abstract NetGridEventDetailVO getNetGridEventDetail(@Param("id") Long paramLong);
  
  public abstract List<NetGridEvent> selectAll();
  
  public abstract List<NetGridEventVO> getNetGridEventReporterQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventReporterQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<NetGridEventVO> getNetGridEventDespatcherQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventDespatcherQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<NetGridEventVO> getNetGridEventDeptDespatcherQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventDeptDespatcherQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<NetGridEventVO> getNetGridEventHandlerQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventHandlerQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<NetGridEventVO> getNetGridEventAuditorQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventAuditorQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<NetGridEventVO> getNetGridEventAPPQuery(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventAPPQueryCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract List<NetGridEventVO> getNetGridEventForNetGrid(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridEventForNetGridCount(@Param("id") Long paramLong, @Param("kind") Integer paramInteger1, @Param("name") String paramString1, @Param("netGridID") Integer paramInteger2, @Param("status") String paramString2);
  
  public abstract int updateByPrimaryKey(NetGridEvent paramNetGridEvent);
  
  public abstract int updateNetGridEventStatus(@Param("type") String paramString, @Param("id") Long paramLong);
  
  public abstract List<SSCountVO> getNetGridEventCount();
  
  public abstract List getNetGridEventCountForCheck(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getNetGridEventByStatus(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */