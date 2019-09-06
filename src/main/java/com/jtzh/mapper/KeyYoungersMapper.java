package com.jtzh.mapper;

import com.jtzh.vo.gis.PieCountVO;
import com.jtzh.entity.KeyYoungers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface KeyYoungersMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(KeyYoungers paramKeyYoungers);
  
  public abstract KeyYoungers selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<KeyYoungers> selectAll();
  
  public abstract List<com.jtzh.vo.gis.KeyYoungersVO> selectWithLocation(@Param("netGridID") Integer paramInteger);
  
  public abstract List<com.jtzh.vo.keyYoungers.KeyYoungersVO> getKeyYoungersQuery(@Param("netGridID") Integer paramInteger, @Param("name") String paramString1, @Param("certifID") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getKeyYoungersQueryCount(@Param("netGridID") Integer paramInteger, @Param("name") String paramString1, @Param("certifID") String paramString2);
  
  public abstract List<KeyYoungers> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<PieCountVO> getKeyYoungersCountForGIS(@Param("netGridID") Long paramLong);
  
  public abstract List<PieCountVO> getKeyYoungerHistogramCount();
  
  public abstract int updateByPrimaryKey(KeyYoungers paramKeyYoungers);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\KeyYoungersMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */