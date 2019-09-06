package com.jtzh.service;

import com.jtzh.vo.key.InspectRecordQueryVO;
import com.jtzh.vo.key.KeyDriverQueryVO;
import com.jtzh.vo.key.KeyVehiclesQueryVO;
import com.jtzh.entity.CODEDrivingLicenseType;
import com.jtzh.entity.CODEVechiclesType;
import com.jtzh.entity.InspectRecord;
import com.jtzh.entity.KeyDriver;
import com.jtzh.entity.KeyVehicles;
import com.jtzh.entity.NonPublicEconomyOrg;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public abstract interface KeyService
{
  public abstract List<CODEVechiclesType> getVechiclesCode();
  
  public abstract KeyVehiclesQueryVO getVehiclesInfo(String paramString1, String paramString2, String paramString3, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Long addKeyVehicles(KeyVehicles paramKeyVehicles);
  
  public abstract boolean uploadKeyVehiclesPictures(MultipartFile[] paramArrayOfMultipartFile, Long paramLong);
  
  public abstract boolean updateKeyVehicles(KeyVehicles paramKeyVehicles);
  
  public abstract boolean deleteKeyVehicles(Long paramLong);
  
  public abstract Map getDetailByID(Long paramLong);
  
  public abstract List<CODEDrivingLicenseType> getDrivingLicenseCode();
  
  public abstract KeyDriverQueryVO getKeyDriverInfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Long addKeyDriver(KeyDriver paramKeyDriver);
  
  @Transactional
  public abstract boolean uploadKeyDriverPictures(MultipartFile[] paramArrayOfMultipartFile, Long paramLong);
  
  public abstract boolean updateKeyDriver(KeyDriver paramKeyDriver);
  
  public abstract boolean deleteKeyDriver(Long paramLong);
  
  public abstract Map getDetaileByDriverID(Long paramLong);
  
  public abstract KeyDriver getDetailToUpdateDriver(Long paramLong);
  
  public abstract List<NonPublicEconomyOrg> getKeyEnterpriseUSCcode();
  
  public abstract InspectRecord getInspectRecDetail(Long paramLong);
  
  public abstract InspectRecordQueryVO getInspectRecInfo(@Param("name") String paramString1, @Param("date") String paramString2, @Param("code") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract boolean addInspectRecord(InspectRecord paramInspectRecord);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\KeyService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */