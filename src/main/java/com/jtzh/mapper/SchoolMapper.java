package com.jtzh.mapper;

import com.jtzh.vo.school.SchoolCodeVO;
import com.jtzh.vo.school.SchoolCountVO;
import com.jtzh.vo.school.SchoolVO;
import com.jtzh.vo.served.SpecialPersonPieVO;
import com.jtzh.vo.video.CheckVideoVO;
import com.jtzh.entity.School;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SchoolMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(School paramSchool);
  
  public abstract School selectByPrimaryKey(Long paramLong);
  
  public abstract List<School> selectAll();
  
  public abstract int updateByPrimaryKey(School paramSchool);
  
  public abstract SchoolVO getSchoolDetailByID(@Param("id") Long paramLong);
  
  public abstract List<SchoolCodeVO> getAllSchoolCode();
  
  public abstract List<SchoolVO> getSchoolQuery(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getSchoolQueryCount(@Param("name") String paramString1, @Param("type") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<CheckVideoVO> getSchoolForTree();

  public abstract List<SchoolCountVO> getServedSchoolCount();

}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SchoolMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */