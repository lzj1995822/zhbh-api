package com.jtzh.service;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public abstract interface NetGridMemberService
{
  @Transactional
  public abstract boolean addNetGridMember(MultipartFile paramMultipartFile, String paramString);
  
  public abstract boolean updateNetGridMember(MultipartFile paramMultipartFile, String paramString);
  
  @Transactional
  public abstract boolean deleteNetGridMember(Long paramLong);
  
  public abstract List<Map<String, String>> getNetGridMemberForOrg(Long paramLong);

  public abstract Map getNetGridMemberByNetGridID(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\NetGridMemberService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */