package com.jtzh.mapper;

import com.jtzh.vo.KeyPetitioners.KeyPetitionersForGISVO;
import com.jtzh.vo.KeyPetitioners.KeyPetitionersVO;
import com.jtzh.vo.gis.PieCountVO;
import com.jtzh.entity.KeyPetitioners;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface KeyPetitionersMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(KeyPetitioners paramKeyPetitioners);
  
  public abstract KeyPetitioners selectByPrimaryKey(Long paramLong);
  
  public abstract KeyPetitioners selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<KeyPetitioners> selectAll();
  
  public abstract int updateByPrimaryKey(KeyPetitioners paramKeyPetitioners);
  
  public abstract List<KeyPetitionersVO> getKeyPetitionersQuery(@Param("netGridID") Integer paramInteger, @Param("name") String paramString1, @Param("certifID") String paramString2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getKeyPetitionersQueryCount(@Param("netGridID") Integer paramInteger, @Param("name") String paramString1, @Param("certifID") String paramString2);
  
  public abstract List<PieCountVO> getKeyPetitionersPieCount();
  
  public abstract List<KeyPetitionersForGISVO> selectWithLocation(@Param("netGridID") Integer paramInteger);
  
  public abstract int getCountForGIS(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\KeyPetitionersMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */