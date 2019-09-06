package com.jtzh.service;

import com.jtzh.vo.school.SchoolQueryVO;
import com.jtzh.vo.school.SchoolVO;
import com.jtzh.vo.school.SchoolVideoQuery;
import com.jtzh.vo.school.SchoolVideoVO;
import com.jtzh.vo.video.CheckVideoVO;
import com.jtzh.entity.School;
import com.jtzh.entity.SchoolVideo;

import java.util.List;
import java.util.Map;

public abstract interface SchoolService
{
  public abstract Map getSchoolCode();
  
  public abstract boolean addSchool(School paramSchool);
  
  public abstract boolean addSchoolVideo(SchoolVideo paramSchoolVideo);
  
  public abstract boolean deleteSchool(Long paramLong);
  
  public abstract boolean updateSchool(School paramSchool);
  
  public abstract boolean deleteSchoolVideo(Long paramLong);
  
  public abstract SchoolVO getSchoolDetail(Long paramLong);
  
  public abstract boolean updateSchoolVideo(SchoolVideo paramSchoolVideo);
  
  public abstract SchoolVideoVO getSchoolVideoDetail(Long paramLong);
  
  public abstract School getSchoolDetailToUpdate(Long paramLong);
  
  public abstract SchoolQueryVO getSchoolQuery(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SchoolVideoQuery getSchoolVideoQuery(String paramString, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SchoolVideo getSchoolVideoDetailToUpdate(Long paramLong);
  
  public abstract List<CheckVideoVO> getVideoForTree(Long paramLong);
  
  public abstract List<CheckVideoVO> getSchoolForTree();





  public abstract List getServedSchoolCount();






}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\SchoolService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */