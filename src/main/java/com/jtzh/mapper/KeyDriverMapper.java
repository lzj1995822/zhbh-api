package com.jtzh.mapper;

import com.jtzh.vo.key.KeyDriverInfoVO;
import com.jtzh.entity.KeyDriver;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface KeyDriverMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(KeyDriver paramKeyDriver);
  
  public abstract KeyDriver selectByPrimaryKey(Long paramLong);
  
  public abstract KeyDriverInfoVO getDetailByKey(Long paramLong);
  
  public abstract List<KeyDriver> selectAll();
  
  public abstract List<KeyDriverInfoVO> getKeyDriverInfo(@Param("name") String paramString1, @Param("certID") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getKeyDriverInfoCount(@Param("name") String paramString1, @Param("certID") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract int updateByPrimaryKey(KeyDriver paramKeyDriver);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\KeyDriverMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */