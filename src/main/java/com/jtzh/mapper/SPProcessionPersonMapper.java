package com.jtzh.mapper;

import com.jtzh.vo.skynet.ProcessionPersonVO;
import com.jtzh.entity.SPProcessionPerson;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SPProcessionPersonMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SPProcessionPerson paramSPProcessionPerson);
  
  public abstract SPProcessionPerson selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPProcessionPerson> selectAll();
  
  public abstract List<ProcessionPersonVO> getProcessionPersonQuery(@Param("name") String paramString, @Param("processionID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getProcessionPersonQueryCount(@Param("name") String paramString, @Param("processionID") Integer paramInteger);
  
  public abstract ProcessionPersonVO getProcessionPersonDetail(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(SPProcessionPerson paramSPProcessionPerson);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SPProcessionPersonMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */