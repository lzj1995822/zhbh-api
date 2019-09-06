package com.jtzh.service;

import com.jtzh.vo.house.HouseDetailVO;
import com.jtzh.vo.house.HouseQueryVO;
import com.jtzh.entity.House;

import java.util.List;
import java.util.Map;

public abstract interface HouseService
{
  public abstract boolean addHouse(House paramHouse);
  
  public abstract boolean updateHouse(House paramHouse);
  
  public abstract boolean deleteHouse(Long paramLong);
  
  public abstract HouseQueryVO getHouseQuery(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract HouseDetailVO getHouseDetail(Long paramLong);
  
  public abstract House getHouseDetailToUpdate(Long paramLong);
  
  public abstract Map getHouseCode();
  
  public abstract List<HouseDetailVO> getHouseDetailForGIS();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\HouseService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */