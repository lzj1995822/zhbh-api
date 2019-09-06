package com.jtzh.service;

import com.jtzh.vo.dispute.DisputeEventQueryResponseVO;
import com.jtzh.entity.DisputeEvent;
import com.jtzh.entity.DisputeEventChecked;
import com.jtzh.entity.DisputeEventDealing;
import com.jtzh.entity.DisputeEventDistribute;
import com.jtzh.entity.DisputeEventInvolvedPersons;

import java.util.HashMap;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public abstract interface DisputeEventService
{
  public abstract DisputeEventQueryResponseVO getDisputeEventReporterQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract DisputeEventQueryResponseVO getDisputeEventDespatcherQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract DisputeEventQueryResponseVO getDisputeEventDeptDespatcherQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract DisputeEventQueryResponseVO getDisputeEventHandlerQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract DisputeEventQueryResponseVO getDisputeEventAPPQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract DisputeEventQueryResponseVO getDisputeEventAuditorQuery(Long paramLong, String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract DisputeEventQueryResponseVO getDisputeEventForNetGrid(Long paramLong, String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract HashMap getDisputeEventDetail(Long paramLong);
  
  public abstract HashMap getDisputeEventDetailForAPP(Long paramLong);
  
  public abstract Long insertDisputeEvent(DisputeEvent paramDisputeEvent);
  
  public abstract boolean updateDisputeEvent(DisputeEvent paramDisputeEvent);
  
  public abstract boolean deleteDisputeEvent(Long paramLong);
  
  public abstract List getDisputeEventCount();
  
  public abstract DisputeEvent getDisputeBasicDetailToUpdate(Long paramLong);
  
  public abstract boolean addDisputeEventPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addDisputeEventVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addDisputeEventInvolvedPersons(DisputeEventInvolvedPersons paramDisputeEventInvolvedPersons);
  
  public abstract Long addDisputeEventDealing(DisputeEventDealing paramDisputeEventDealing);
  
  public abstract boolean addDisputeEventChecked(DisputeEventChecked paramDisputeEventChecked);
  
  public abstract boolean addDisputeEventDistribute(DisputeEventDistribute paramDisputeEventDistribute);
  
  public abstract boolean addDisputeEventDealingPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addDisputeEventDealingVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean uploadDisputeEventDealingMedia(MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean updateDisputeEventStatus(String paramString, Long paramLong);
  
  public abstract boolean isDistribute(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\DisputeEventService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */