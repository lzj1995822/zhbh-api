package com.jtzh.mapper;

import com.jtzh.vo.gis.PieCountVO;
import com.jtzh.vo.video.CheckVideoVO;
import com.jtzh.vo.video.VideoInfoVO;
import com.jtzh.entity.Video;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface VideoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(Video paramVideo);
  
  public abstract Video selectByPrimaryKey(Long paramLong);
  
  public abstract VideoInfoVO getByPrimaryKey(Long paramLong);
  
  public abstract List<Video> selectAll();
  
  public abstract List<CheckVideoVO> getVideoForTree(@Param("id") Long paramLong);
  
  public abstract List<PieCountVO> getVideoPieCount();
  
  public abstract List<VideoInfoVO> getVideoByNetGridID(@Param("netGridID") Integer paramInteger);
  
  public abstract int updateByPrimaryKey(Video paramVideo);
  
  public abstract List<VideoInfoVO> getVideoInfo(@Param("name") String paramString, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getVideoInfoCount(@Param("name") String paramString, @Param("netGridID") Integer paramInteger);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\VideoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */