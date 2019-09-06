package com.jtzh.mapper;

import com.jtzh.vo.app.SpecialPopulationForTypeAndNetGrid;
import com.jtzh.vo.served.SpecialPersonCountByTypeVO;
import com.jtzh.vo.served.SpecialPersonCountVO;
import com.jtzh.vo.served.SpecialPersonPieVO;
import com.jtzh.entity.SpecialServedPerson;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SpecialServedPersonMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SpecialServedPerson paramSpecialServedPerson);
  
  public abstract SpecialServedPerson selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<SpecialServedPerson> selectAll();
  
  public abstract int updateByPrimaryKey(SpecialServedPerson paramSpecialServedPerson);
  
  public abstract List<SpecialServedPerson> query(@Param("servedPersonID") long paramLong, @Param("specialTypeValue") String paramString);
  
  public abstract List<SpecialPopulationForTypeAndNetGrid> select(@Param("specialPopulationTypeValue") String paramString1, @Param("netGridName") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract List<SpecialPersonCountVO> getSpecialPersonCount();
  
  public abstract List<SpecialPersonCountByTypeVO> getSpecialPersonCountByType();
  
  public abstract List<SpecialPersonPieVO> getSpecialPersonPieCount(@Param("type") String paramString);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SpecialServedPersonMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */