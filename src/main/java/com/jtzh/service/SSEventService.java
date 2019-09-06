package com.jtzh.service;

import com.jtzh.vo.ss.SSCountVO;
import com.jtzh.vo.ss.SSQueryVO;
import com.jtzh.entity.SSEventChecked;
import com.jtzh.entity.SSEventDealing;
import com.jtzh.entity.SSEventDistribute;
import com.jtzh.entity.SSEventInvolvedPersons;
import com.jtzh.entity.SocietySecurityEvent;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface SSEventService
{
  public abstract Long addSSEventBasic(SocietySecurityEvent paramSocietySecurityEvent);
  
  public abstract Map getSSEventCode();
  
  public abstract boolean addSSEventInvolvedPersons(SSEventInvolvedPersons paramSSEventInvolvedPersons);
  
  public abstract boolean updateSSEventInvolvedPersons(SSEventInvolvedPersons paramSSEventInvolvedPersons);
  
  public abstract boolean deleteSSEventInvolvedPersons(Long paramLong);
  
  public abstract boolean insertSSEventDistribute(SSEventDistribute paramSSEventDistribute);
  
  public abstract Long insertSSEventDealingBasic(SSEventDealing paramSSEventDealing);
  
  public abstract boolean insertSSEventChecked(SSEventChecked paramSSEventChecked);
  
  public abstract List<SSCountVO> getSSCountVO();
  
  public abstract boolean deleteSSEvent(Long paramLong);
  
  public abstract boolean addSSEventPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addSSEventVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract SSQueryVO getSSEventDespatcherQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SSQueryVO getSSEventDeptDespatcherQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SSQueryVO getSSEventHandlerQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SSQueryVO getSSEventAuditorQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SSQueryVO getSSEventReporterQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SSQueryVO getSSEventAPPQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SSQueryVO getSSEventForNetGrid(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract boolean updateSSEventStatus(String paramString, Long paramLong);
  
  public abstract Map getSSDetail(Long paramLong);
  
  public abstract Map getSSDetailForAPP(Long paramLong);
  
  public abstract boolean updateSSEvent(SocietySecurityEvent paramSocietySecurityEvent);
  
  public abstract Map getDetailToUpdate(Long paramLong);
  
  public abstract boolean addSSEventDealingPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addSSEventDealingVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addSSEventDealingFromAPP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile);
  
  public abstract boolean isDistribute(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\SSEventService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */