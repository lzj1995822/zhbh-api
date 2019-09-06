package com.jtzh.service;

import com.jtzh.vo.dutyPoint.DutyPointQueryVO;
import com.jtzh.entity.ScenicAreaDutyPoint;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface ScenicAreaDutyPointService
{
  public abstract Integer addScenicAreaDutyPoint(ScenicAreaDutyPoint paramScenicAreaDutyPoint);
  
  public abstract boolean addScenicAreaDutyPointPicture(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract DutyPointQueryVO getDutyPointQuery(Integer paramInteger, String paramString, int paramInt1, int paramInt2);
  
  public abstract Map getDutyPointDetail(Long paramLong);
  
  public abstract ScenicAreaDutyPoint getDutyDetailToUpdate(Integer paramInteger);
  
  public abstract boolean updateDutyPoint(ScenicAreaDutyPoint paramScenicAreaDutyPoint);
  
  public abstract boolean deleteDutyPoint(Integer paramInteger);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\ScenicAreaDutyPointService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */