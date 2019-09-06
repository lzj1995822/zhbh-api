package com.jtzh.mapper;

import com.jtzh.vo.dutyPoint.DutyPointVO;
import com.jtzh.vo.gis.ScenicAreaDutyPointVO;
import com.jtzh.entity.ScenicAreaDutyPoint;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ScenicAreaDutyPointMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(ScenicAreaDutyPoint paramScenicAreaDutyPoint);
  
  public abstract ScenicAreaDutyPoint selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<ScenicAreaDutyPoint> selectAll();
  
  public abstract int updateByPrimaryKey(ScenicAreaDutyPoint paramScenicAreaDutyPoint);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<ScenicAreaDutyPointVO> getScenicAreaDutyPointDetail(@Param("netGridID") Integer paramInteger);
  
  public abstract List<DutyPointVO> getDutyPoint(@Param("netGridID") Integer paramInteger, @Param("name") String paramString, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDutyPointCount(@Param("netGridID") Integer paramInteger, @Param("name") String paramString);
  
  public abstract DutyPointVO getDutyPointDetailByID(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ScenicAreaDutyPointMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */