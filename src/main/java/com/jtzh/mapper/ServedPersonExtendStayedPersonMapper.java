package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedPersonExtendStayedPerson;

public abstract interface ServedPersonExtendStayedPersonMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int deleteByCertifID(@Param("id") String paramString);
  
  public abstract int insert(ServedPersonExtendStayedPerson paramServedPersonExtendStayedPerson);
  
  public abstract ServedPersonExtendStayedPerson selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<ServedPersonExtendStayedPerson> selectAll();
  
  public abstract int updateByPrimaryKey(ServedPersonExtendStayedPerson paramServedPersonExtendStayedPerson);
  
  public abstract List<ServedPersonExtendStayedPerson> queryByCerfitID(@Param("certifID") String paramString);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedPersonExtendStayedPersonMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */