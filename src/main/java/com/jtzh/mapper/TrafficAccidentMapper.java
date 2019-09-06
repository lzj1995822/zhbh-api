package com.jtzh.mapper;

import com.jtzh.vo.gis.PieCountVO;
import com.jtzh.vo.served.SpecialPersonPieVO;
import com.jtzh.vo.trafficAccident.TrafficAccidentExVO;
import com.jtzh.entity.TrafficAccident;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface TrafficAccidentMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int updateTrafficAccidentStatus(@Param("type") String paramString, @Param("id") Long paramLong);
  
  public abstract int insert(TrafficAccident paramTrafficAccident);
  
  public abstract TrafficAccident selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccident> selectAll();
  
  public abstract List<com.jtzh.vo.trafficAccident.TrafficAccidentVO> getTrafficAccidentQuery(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract List<com.jtzh.vo.trafficAccident.TrafficAccidentVO> getTrafficAccidentDetail(@Param("id") Long paramLong);
  
  public abstract int getUnSovleCount(@Param("netGridID") Long paramLong);
  
  public abstract int getSovleCount(@Param("netGridID") Long paramLong);
  
  public abstract int getTrafficAccidentQueryCount(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<com.jtzh.vo.gis.TrafficAccidentVO> getTrafficAccidentByStatus(@Param("type") String paramString, @Param("netGridID") Integer paramInteger);
  
  public abstract List<PieCountVO> getTrafficAccidentPieCount(@Param("netGridID") Long paramLong);
  
  public abstract int updateByPrimaryKey(TrafficAccident paramTrafficAccident);
  
  public abstract List<SpecialPersonPieVO> getTrafficAccidentHistogramCount();
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentReporterQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentReporterQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentDespatcherQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentDespatcherQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentDeptDespatcherQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentDeptDespatcherQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentHandlerQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentHandlerQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentAuditorQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentAuditorQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentAPPQuery(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentAPPQueryCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List<TrafficAccidentExVO> getTrafficAccidentForNetGrid(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getTrafficAccidentForNetGridCount(@Param("id") Long paramLong, @Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("status") String paramString3);
  
  public abstract List getTrafficEventCountForCheck(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getTrafficEventByStatus(@Param("start") Date paramDate1, @Param("end") Date paramDate2);
  
  public abstract Map getTrafficEventCountByNetGrid();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */