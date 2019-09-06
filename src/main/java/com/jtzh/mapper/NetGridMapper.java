package com.jtzh.mapper;

import com.jtzh.vo.netGrid.NetGridFatherAndChildVO;
import com.jtzh.vo.netGrid.NetGridVO;
import com.jtzh.vo.video.CheckVideoVO;
import com.jtzh.entity.NetGrid;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public  interface NetGridMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public  int insert(NetGrid paramNetGrid);
  
  public abstract NetGrid selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGrid> selectAll();

  public abstract NetGridFatherAndChildVO getNetGridFaterAndChildName(@Param("netGridID") Long paramLong);
  public abstract NetGrid getNetGridFaterIdAndChildName(@Param("fatherNetGridID") Long fatherNetGridID,@Param("netGridName") String paramString2);
  public abstract List<NetGridVO> getNetGridQuery(@Param("netGridName") String paramString1, @Param("netGridLeaderName") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  public abstract NetGridVO getNetGirdNumber(@Param("fatherNetGridID") Long fatherNetGridID);
  public abstract int getNetGridQueryCount(@Param("netGridName") String paramString1, @Param("netGridLeaderName") String paramString2);
  
  public abstract List<CheckVideoVO> getNetGridForTree();
  
  public abstract int updateByPrimaryKey(NetGrid paramNetGrid);
  
  public abstract List<Map<String, String>> getNetGridByFaterID(@Param("netGridID") Long paramLong);
  
  public abstract List<Map<String, String>> getAllNetGrid();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */