package com.jtzh.mapper;

import com.jtzh.vo.house.HouseDetailVO;
import com.jtzh.vo.house.HouseExVO;
import com.jtzh.entity.House;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface HouseMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(House paramHouse);
  
  public abstract House selectByPrimaryKey(Long paramLong);
  
  public abstract List<HouseExVO> getHouseQuery(@Param("name") String paramString1, @Param("address") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getHouseQueryCount(@Param("name") String paramString1, @Param("address") String paramString2);
  
  public abstract HouseDetailVO getHouseDetailByHouseID(@Param("id") Long paramLong);
  
  public abstract List<HouseDetailVO> getHouseDetailForGIS();
  
  public abstract List<House> selectAll();
  
  public abstract int updateByPrimaryKey(House paramHouse);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\HouseMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */