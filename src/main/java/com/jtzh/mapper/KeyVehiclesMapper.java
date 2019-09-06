package com.jtzh.mapper;

import com.jtzh.vo.key.KeyVehiclesInfoVO;
import com.jtzh.entity.KeyVehicles;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface KeyVehiclesMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(KeyVehicles paramKeyVehicles);
  
  public abstract KeyVehicles selectByPrimaryKey(Long paramLong);
  
  public abstract KeyVehiclesInfoVO getDetailByID(@Param("id") Long paramLong);
  
  public abstract List<KeyVehicles> selectAll();
  
  public abstract int updateByPrimaryKey(KeyVehicles paramKeyVehicles);
  
  public abstract List<KeyVehiclesInfoVO> getKeyVehiclesInfo(@Param("name") String paramString1, @Param("certID") String paramString2, @Param("number") String paramString3, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getKeyVehiclesInfoCount(@Param("name") String paramString1, @Param("certID") String paramString2, @Param("number") String paramString3, @Param("netGridID") Integer paramInteger);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\KeyVehiclesMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */