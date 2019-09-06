package com.jtzh.mapper;

import com.jtzh.vo.skynet.SPProcessionDetailVO;
import com.jtzh.entity.SPProcession;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SPProcessionMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SPProcession paramSPProcession);
  
  public abstract SPProcession selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPProcession> selectAll();
  
  public abstract List<SPProcessionDetailVO> getProcessionQuery(@Param("processionName") String paramString1, @Param("processionLeaderName") String paramString2, @Param("area") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getProcessionQueryCount(@Param("processionName") String paramString1, @Param("processionLeaderName") String paramString2, @Param("area") Integer paramInteger);
  
  public abstract SPProcessionDetailVO getProcessionDetailByID(@Param("id") Long paramLong);
  
  public abstract List<SPProcessionDetailVO> getProcessionDetailByInspectionArea(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(SPProcession paramSPProcession);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SPProcessionMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */