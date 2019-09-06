package com.jtzh.service;

import com.jtzh.vo.trafficAccident.TrafficAccidentQueryVO;
import com.jtzh.entity.TrafficAccident;
import com.jtzh.entity.TrafficAccidentChecked;
import com.jtzh.entity.TrafficAccidentDealing;
import com.jtzh.entity.TrafficAccidentDistribute;
import com.jtzh.entity.TrafficAccidentInvolvedPersons;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public abstract interface TrafficAccidentService
{
  public abstract Map getTrafficCodes();
  
  public abstract boolean updateAccidentInvolvedPersons(TrafficAccidentInvolvedPersons paramTrafficAccidentInvolvedPersons);
  
  public abstract boolean deleteAccidentInvolvedPersons(Long paramLong);
  
  public abstract boolean updateTrafficAccident(TrafficAccident paramTrafficAccident);
  
  public abstract Map getTrafficAccidentDetailToUpdate(Long paramLong);
  
  public abstract boolean deleteTrafficAccident(Long paramLong);
  
  public abstract boolean addTrafficAccidentPicture(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addTrafficAccidentVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract Long addTrafficAccidentBasic(TrafficAccident paramTrafficAccident);
  
  public abstract boolean addTrafficAccidentInvolvedPersons(TrafficAccidentInvolvedPersons paramTrafficAccidentInvolvedPersons);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentDespatcherQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentDeptDespatcherQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentHandlerQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentReporterQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentAuditorQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentAPPQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract TrafficAccidentQueryVO getTrafficAccidentForNetGrid(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Map getTrafficAccidentDetail(Long paramLong);
  
  public abstract Map getTrafficAccidentDetailForAPP(Long paramLong);
  
  public abstract List getTrafficAccidentHistogramCount();
  
  public abstract boolean addTrafficAccidentDistribute(TrafficAccidentDistribute paramTrafficAccidentDistribute);
  
  public abstract Long addTrafficAccidetDealingBasic(TrafficAccidentDealing paramTrafficAccidentDealing);
  
  @Transactional
  public abstract boolean addTrafficAccidetDealingFromAPP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile);
  
  public abstract boolean addTrafficAccidentDealingPicture(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addTrafficAccidentDealingVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addTrafficAccidentChecked(TrafficAccidentChecked paramTrafficAccidentChecked);
  
  public abstract boolean updateTrafficAccidentStatus(String paramString, Long paramLong);
  
  public abstract boolean isDistribute(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\TrafficAccidentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */