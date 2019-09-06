package com.jtzh.mapper;

import com.jtzh.vo.app.EventDealingPictureVO;
import com.jtzh.entity.Picture;

import java.util.List;

public abstract interface PictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(Picture paramPicture);
  
  public abstract Picture selectByPrimaryKey(Long paramLong);
  
  public abstract List<Picture> selectAll();
  
  public abstract int updateByPrimaryKey(Picture paramPicture);
  
  public abstract List<Picture> selectByDisputeEventID(Long paramLong);
  
  public abstract List<Picture> selectByServedRecordID(Long paramLong);
  
  public abstract List<Picture> selectByEnterpriseUSCode(String paramString);
  
  public abstract List<Picture> selectByTrafficAccidentID(Long paramLong);
  
  public abstract List<Picture> selectBySSEventID(Long paramLong);
  
  public abstract List<Picture> selectByDutyPointID(Long paramLong);
  
  public abstract List<Picture> selectBySPEventID(Long paramLong);
  
  public abstract List<Picture> selectByNetGridEventID(Long paramLong);
  
  public abstract List<Picture> selectSPEventDealingPictureBySPEventID(Long paramLong);
  
  public abstract List<Picture> selectSSEventDealingPictureBySSEventID(Long paramLong);
  
  public abstract List<Picture> selectNetGridEventDealingPictureByEventID(Long paramLong);
  
  public abstract List<Picture> selectTrafficAccidentDealingPictureByEventID(Long paramLong);
  
  public abstract List<Picture> selectDisputeEventDealingPictureByEventID(Long paramLong);
  
  public abstract List<Picture> selectKeyVehiclesPictureByKeyVehiclesID(Long paramLong);
  
  public abstract List<Picture> selectKeyDriverPictureByKeyDriverID(Long paramLong);
  
  public abstract List<EventDealingPictureVO> selectSPEventDealingPictureForAPP(Long paramLong);
  
  public abstract List<EventDealingPictureVO> selectSSEventDealingPictureForAPP(Long paramLong);
  
  public abstract List<EventDealingPictureVO> selectTrafficAccidentDealingPictureForAPP(Long paramLong);
  
  public abstract List<EventDealingPictureVO> selectDisputeEventDealingPictureForAPP(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\PictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */