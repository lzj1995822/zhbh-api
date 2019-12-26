package com.jtzh.mapper;

import com.jtzh.vo.gis.PieCountVO;
import com.jtzh.vo.netGrid.NetGridMemberVO;
import com.jtzh.entity.NetGridMember;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public abstract interface NetGridMemberMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridMember paramNetGridMember);
  
  public abstract NetGridMember selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridMember> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridMember paramNetGridMember);
  
  public abstract List<NetGridMemberVO> getNetGridMemberQuery(@Param("netGridID") Integer paramInteger1, @Param("name") String paramString1, @Param("certID") String paramString2, @Param("isServicePerson") Integer paramInteger2, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getNetGridMemberQueryCount(@Param("netGridID") Integer paramInteger1, @Param("name") String paramString1, @Param("certID") String paramString2, @Param("isServicePerson") Integer paramInteger2);
  
  public abstract NetGridMemberVO getNetGridMemberDetail(@Param("id") Long paramLong);
  
  public abstract List<PieCountVO> getNetGridMemberCount();
  
  public abstract List<Map<String, String>> getNetGridMemberForOrg(@Param("id") Long paramLong);
  
  public abstract long getNetGridMemberIDByNameAndCertID(@Param("name") String paramString1, @Param("certID") String paramString2);
  public abstract NetGridMemberVO getNetGridMemberByNetGridID(@Param("id") Long paramLong);


  public abstract Map reporter();

  /**
   * 网格员巡查数量排名
   * @return
   */
  public  abstract  List<NetGridMemberVO> reporterRank();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridMemberMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */