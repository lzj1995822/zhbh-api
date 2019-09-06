package com.jtzh.mapper;

import com.jtzh.vo.school.SchoolVideoVO;
import com.jtzh.vo.video.CheckVideoVO;
import com.jtzh.entity.SchoolVideo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SchoolVideoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SchoolVideo paramSchoolVideo);
  
  public abstract SchoolVideo selectByPrimaryKey(Long paramLong);
  
  public abstract SchoolVideoVO getSchoolVideoDetailByID(@Param("id") Long paramLong);
  
  public abstract List<SchoolVideo> selectAll();
  
  public abstract List<SchoolVideoVO> getSchoolVideoQuery(@Param("schoolName") String paramString, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSchoolVideoQueryCount(@Param("schoolName") String paramString, @Param("netGridID") Integer paramInteger);
  
  public abstract List<CheckVideoVO> getVideoForTree(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(SchoolVideo paramSchoolVideo);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SchoolVideoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */