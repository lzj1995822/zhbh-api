package com.jtzh.service;

import com.jtzh.vo.skynet.ProcessionPersonQueryVO;
import com.jtzh.vo.skynet.SPProcessionDetailVO;
import com.jtzh.vo.skynet.SPProcessionQueryVO;
import com.jtzh.vo.skynet.SPQueryVO;
import com.jtzh.vo.skynet.SPTrailQueryVO;
import com.jtzh.vo.skynet.UserVO;
import com.jtzh.vo.ss.SSCountVO;
import com.jtzh.entity.SPProcession;
import com.jtzh.entity.SPProcessionPerson;
import com.jtzh.entity.SPRegion;
import com.jtzh.entity.SkynetPatrolEvent;
import com.jtzh.entity.SkynetPatrolEventChecked;
import com.jtzh.entity.SkynetPatrolEventDealing;
import com.jtzh.entity.SkynetPatrolEventDistribute;
import com.jtzh.entity.SkynetPatrolEventInvolvedPersons;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface SkynetService
{
  public abstract Long insertSPEvent(SkynetPatrolEvent paramSkynetPatrolEvent);
  
  public abstract boolean updateSPEvent(SkynetPatrolEvent paramSkynetPatrolEvent);
  
  public abstract Map getSPEventCode();
  
  public abstract boolean deleteSPEvent(Long paramLong);
  
  public abstract boolean changeSPEventStatus(String paramString, Long paramLong);
  
  public abstract boolean insertSPEventInvolvedPersons(SkynetPatrolEventInvolvedPersons paramSkynetPatrolEventInvolvedPersons);
  
  public abstract boolean updateSPEventInvolvedPersons(SkynetPatrolEventInvolvedPersons paramSkynetPatrolEventInvolvedPersons);
  
  public abstract boolean deleteSPEventInvolvedPersons(Long paramLong);
  
  public abstract List<UserVO> getUserInfoByKey(String paramString);

  public abstract List<UserVO> getUserInfoByKeyDept(String paramString);
  
  public abstract boolean insertSPEventChecked(SkynetPatrolEventChecked paramSkynetPatrolEventChecked);
  
  public abstract SPQueryVO getSPEventReporterQuery(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SPQueryVO getSPEventDespatcherQuery(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SPQueryVO getSPEventDeptDespatcherQuery(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SPQueryVO getSPEventHandlerQuery(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SPQueryVO getSPEventAuditorQuery(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SPQueryVO getSPEventAPPQuery(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract SPQueryVO getSPEventForNetGrid(Long paramLong, String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract Map getSPEventDetail(Long paramLong);
  
  public abstract Map getSPEventDetailForAPP(Long paramLong);
  
  public abstract Map getSPEventDetailToUpdate(Long paramLong);
  
  public abstract boolean addSPEventPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addSPEventVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract Long insertSPEventDealing(SkynetPatrolEventDealing paramSkynetPatrolEventDealing);
  
  public abstract boolean updateSPEventDealing(SkynetPatrolEventDealing paramSkynetPatrolEventDealing);
  
  public abstract boolean addSPEventDealingPictures(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addSPEventDealingVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean insertSPEventDistribute(SkynetPatrolEventDistribute paramSkynetPatrolEventDistribute);
  
  public abstract List<SSCountVO> getSPEventCount();
  
  public abstract boolean isDistribute(Long paramLong);
  
  public abstract SPProcessionQueryVO getSPProcessionQuery(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract boolean addProcession(SPProcession paramSPProcession);
  
  public abstract List<SPProcession> getAllProcession();
  
  public abstract boolean updateProcession(SPProcession paramSPProcession);
  
  public abstract SPProcessionDetailVO getProcessionDetailByID(Long paramLong);
  
  public abstract List<SPProcessionDetailVO> getProcessionDetailByInspectionArea(Long paramLong);
  
  public abstract SPProcession getProcessionDetailToUpdate(Long paramLong);
  
  public abstract boolean deleteProcession(Long paramLong);
  
  public abstract boolean addSPRegion(SPRegion paramSPRegion);
  
  public abstract boolean updateSPRegion(SPRegion paramSPRegion);
  
  public abstract boolean deleteSPRegion(Long paramLong);
  
  public abstract List<SPRegion> selectByRegionName(String paramString);
  
  public abstract List<SPRegion> selectAllRegion();
  
  public abstract boolean addProcessionPerson(SPProcessionPerson paramSPProcessionPerson, Long paramLong);
  
  public abstract Long uploadProcessionPersonPhoto(MultipartFile paramMultipartFile);
  
  public abstract boolean updateProcessionPersonPhoto(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract ProcessionPersonQueryVO getProcessionPersonQuery(String paramString, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Map getProcessionPersonDetail(Long paramLong);
  
  public abstract Map getProcessionPersonDetailToUpdate(Long paramLong);
  
  public abstract boolean deleteSPProcessionPerson(Long paramLong);
  
  public abstract boolean updateSPProcessionPerson(SPProcessionPerson paramSPProcessionPerson);
  
  public abstract SPTrailQueryVO getSPTrailQuery(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract boolean addSPEventDealingFromAPP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\SkynetService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */