package com.jtzh.service;

import com.jtzh.entity.RealTimeLocation;
import com.jtzh.vo.app.SpecialPopulationForTypeAndNetGrid;
import com.jtzh.vo.app.UserVO;
import com.jtzh.vo.dispute.DisputeEventAPPUploadVO;
import com.jtzh.vo.netGrid.NetGridEventAPPUploadVO;
import com.jtzh.vo.skynet.SPEventAPPUploadVO;
import com.jtzh.vo.ss.SSEventAPPUploadVO;
import com.jtzh.vo.trafficAccident.TrafficAccidentAPPUploadVO;
import com.jtzh.entity.APPVersion;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public abstract interface APPService
{
  public abstract List<SpecialPopulationForTypeAndNetGrid> getByTypeAndGrid(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean addServiceRecord(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, @RequestParam("serverInf") String paramString6, String paramString7, MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile);
  
  public abstract Long addDisputeEvent(DisputeEventAPPUploadVO paramDisputeEventAPPUploadVO);
  
  public abstract Long addTrafficAccident(TrafficAccidentAPPUploadVO paramTrafficAccidentAPPUploadVO);
  
  @Transactional
  public abstract Long addSSEvent(SSEventAPPUploadVO paramSSEventAPPUploadVO);
  
  public abstract boolean uploadTrafficAccidentMedia(MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile, Long paramLong);
  
  @Transactional
  public abstract boolean uploadSSEventMedia(MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract Long addNetGridEvent(NetGridEventAPPUploadVO paramNetGridEventAPPUploadVO);
  
  public abstract boolean addNetGridEventMedia(MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract Long addSPEvent(SPEventAPPUploadVO paramSPEventAPPUploadVO);
  
  public abstract boolean addSPEventMedia(MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract int insertData();
  
  public abstract boolean uploadDisputeEventMedia(MultipartFile[] paramArrayOfMultipartFile, MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract UserVO APPLogin(String paramString1, String paramString2);
  
  public abstract APPVersion getAPPVersionInfo();

  public abstract boolean addRealTimeLocation(RealTimeLocation paramRealTimeLocation);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\APPService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */