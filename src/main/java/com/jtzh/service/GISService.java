package com.jtzh.service;

import com.jtzh.vo.KeyPetitioners.KeyPetitionersForGISVO;
import com.jtzh.vo.gis.*;
import com.jtzh.vo.video.VideoInfoVO;
import com.jtzh.entity.DisputeEvent;
import com.jtzh.entity.NonPublicEconomyOrg;
import com.jtzh.entity.SocietyOrg;

import java.util.List;
import java.util.Map;

public abstract interface GISService
{
  public abstract List<ServedPersonCountVO> getCount(Long paramLong);
  
  public abstract List<ServedPersonCountVO> getCountByNetGrid(String paramString1, String paramString2);
  
  public abstract List<ServedPersonBasicVO> getServedPersonBasic(String paramString);
  
  public abstract List<ServedPersonBasicVO> getServedPersonBasicByNetGrid(String paramString1, String paramString2);
  
  public abstract List<SpecialPopulationCountVO> getSpecialPopulationCount(Long paramLong);
  
  public abstract List<AIDSdiseaseVO> getAIDSdiseaseWithLocation(Long paramLong);
  
  public abstract List<CommunityCorrectionerVO> getCommunityCorrectionerWithLocation(Long paramLong);
  
  public abstract List<EmancipistVO> getEmancipistWithLocation(Long paramLong);
  
  public abstract List<DrugAddictsVO> getDrugAddictsWithLocation(Long paramLong);
  
  public abstract List<SeverePsychoticVO> getSeverePsychoticWithLocation(Long paramLong);
  
  public abstract List<KeyPetitionersForGISVO> getKeyPetitionersWithLocation(Integer paramInteger);
  
  public abstract List<NonPublicEconomyOrg> getAllNonPublicEconomyOrg(Long paramLong);
  
  public abstract List<SocietyOrg> getAllSocietyOrg(Long paramLong);
  
  public abstract List<SpecialPopulationCountVO> getOrgCount(Long paramLong);
  
  public abstract List<DisputeEvent> getAllDisputeEvent();
  
  public abstract List<SpecialPopulationCountVO> getDisputeEventCount(Long paramLong);
  
  public abstract List<DisputeEvent> getSolveEvent(Long paramLong);
  
  public abstract List<DisputeEvent> getUnSolveEvent(Long paramLong);
  
  public abstract List<PieCountVO> getVideoPieCount();
  
  public abstract List<VideoInfoVO> getVideoByNetGridID(Integer paramInteger);
  
  public abstract List<ServedRecordVO> getServedRecordForGIS(Integer paramInteger);
  
  public abstract List<SpecialPopulationCountVO> getTrafficAccidentCount(Long paramLong);
  
  public abstract List<TrafficAccidentVO> getTrafficAccidentByStatus(String paramString, Integer paramInteger);
  
  public abstract List<PieCountVO> getTrafficAccidentPieCount(Long paramLong);
  
  public abstract List<SpecialPopulationCountVO> getSSEventCount(Long paramLong);
  
  public abstract List<SocietySecurityEventVO> getSSEventByType(Integer paramInteger1, Integer paramInteger2);
  
  public abstract Map getSSEventMedia(Long paramLong);
  
  public abstract List<ScenicAreaDutyPointVO> getDutyPoint(Integer paramInteger);
  
  public abstract Map getDutyPointMedia(Long paramLong);
  
  public abstract List<DisputeEvent> selectForGIS(String paramString);
  
  public abstract List<KeyYoungersVO> getKeyYoungersWithLocation(Integer paramInteger);
  
  public abstract List<PieCountVO> getKeyYoungersCountForGIS(Long paramLong);

  public abstract List<RealTimeLocationVO> getRealTimeLocation(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\GISService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */