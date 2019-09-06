package com.jtzh.service;

import com.jtzh.vo.video.CheckVideoVO;
import com.jtzh.vo.video.VideoInfoVO;
import com.jtzh.vo.video.VideoQueryVO;
import com.jtzh.entity.CODEVideoType;
import com.jtzh.entity.NetGrid;
import com.jtzh.entity.Video;

import java.util.List;

public abstract interface VideoService
{
  public abstract List<CODEVideoType> getVideoCode();
  
  public abstract List<NetGrid> getAllNetGrid();
  
  public abstract VideoQueryVO getVideoInfo(String paramString, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract VideoInfoVO getDetailByID(Long paramLong);
  
  public abstract Video getToUpdateVideoInfo(Long paramLong);
  
  public abstract boolean addVideo(Video paramVideo);
  
  public abstract boolean updateVideo(Video paramVideo);
  
  public abstract boolean deleteVideo(Long paramLong);
  
  public abstract List<CheckVideoVO> getNetGridForTree();
  
  public abstract List<CheckVideoVO> getVideoForTree(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\VideoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */