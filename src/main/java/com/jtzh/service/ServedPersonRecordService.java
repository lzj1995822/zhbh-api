package com.jtzh.service;

import org.springframework.web.multipart.MultipartFile;

public abstract interface ServedPersonRecordService
{
  public abstract Long addServiceRecord(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract boolean addRecordPicture(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addRecordVideo(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean updateRecord(Long paramLong, String paramString1, String paramString2);
  
  public abstract boolean deleteRecord(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\ServedPersonRecordService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */