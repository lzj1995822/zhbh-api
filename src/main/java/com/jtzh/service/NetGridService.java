package com.jtzh.service;

import com.jtzh.entity.*;
import com.jtzh.vo.netGrid.NetGridEventQueryVO;
import com.jtzh.vo.netGrid.NetGridMemberQueryVO;
import com.jtzh.vo.netGrid.NetGridQueryVO;
import com.jtzh.vo.ss.SSCountVO;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface NetGridService
{
  public abstract boolean insertNetGridMember(NetGridMember paramNetGridMember);
  
  public abstract boolean updateNetGridMember(NetGridMember paramNetGridMember);
  
  public abstract Map getNetGridEventCode();
  
  public abstract boolean updateNetGridEventStatus(String paramString, Long paramLong);
  
  public abstract NetGridMemberQueryVO getNetGridMemberQuery(Integer paramInteger1, String paramString1, String paramString2, Integer paramInteger2, int paramInt1, int paramInt2);
  
  public abstract Map getNetGridMemberDetail(Long paramLong);
  
  public abstract Map getNetGridMemberDetailToUpdate(Long paramLong);
  
  public abstract List getNetGridMemberHistogram();
  
  public abstract Long insertNetGridEventBasic(NetGridEvent paramNetGridEvent);
  
  public abstract boolean addNetGridEventPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addNetGridEventVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addNetGridEventInvolvedPersons(NetGridEventInvolvedPersons paramNetGridEventInvolvedPersons);
  
  public abstract boolean addNetGridEventDistribute(NetGridEventDistribute paramNetGridEventDistribute);
  public abstract boolean deleteNetGridEventDistribute(Tenetgrideventreturn tenetgrideventreturn);
  public abstract Long addNetGridEventDealingBasic(NetGridEventDealing paramNetGridEventDealing);
  
  public abstract boolean addNetGridEventDealingPictures(MultipartFile[] paramArrayOfMultipartFile, Long paramLong);
  
  public abstract boolean addNetGridEventDealingVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addNetGridEventChecked(NetGridEventChecked paramNetGridEventChecked);
  
  public abstract NetGridEventQueryVO getNetGridEventDespatcherQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGridEventQueryVO getNetGridEventDeptDespatcherQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGridEventQueryVO getNetGridEventHandlerQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGridEventQueryVO getNetGridEventReporterQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGridEventQueryVO getNetGridEventAuditorQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGridEventQueryVO getNetGridEventAPPQuery(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGridEventQueryVO getNetGridEventForNetGrid(Long paramLong, Integer paramInteger1, String paramString1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract Map getNetGridEventDetail(Long paramLong);
  
  public abstract NetGridQueryVO getNetGridQuery(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract NetGrid getNetGridDetail(Long paramLong);
  
  public abstract boolean addNetGrid(NetGrid paramNetGrid);
  
  public abstract boolean updateNetGrid(NetGrid paramNetGrid);
  
  public abstract boolean deleteNetGrid(Long paramLong);
  
  public abstract List<SSCountVO> getNetGridEventCount();
  
  public abstract boolean isDistribute(Long paramLong);
  
  public abstract Map getNetGridMemberInfo(Long paramLong);
  
  public abstract List<NetGridMemberT> getNetGridMemberByFatherID(Long paramLong);
  
  public abstract List<Map<String, String>> getNetGridByFaterID(Long paramLong);
  
  public abstract List<Map<String, String>> getAllNetGrid();
  
  public abstract boolean addNetGridEventDealingFromAPP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\NetGridService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */