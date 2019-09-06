package com.jtzh.mapper;

import com.jtzh.vo.skynet.SPTrailVO;
import com.jtzh.entity.SPTrail;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SPTrailMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SPTrail paramSPTrail);
  
  public abstract SPTrail selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPTrail> selectAll();
  
  public abstract List<SPTrailVO> getSPTrailQuery(@Param("name") String paramString1, @Param("startTime") String paramString2, @Param("endTime") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSPTrailQueryCount(@Param("name") String paramString1, @Param("startTime") String paramString2, @Param("endTime") String paramString3);
  
  public abstract int updateByPrimaryKey(SPTrail paramSPTrail);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SPTrailMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */