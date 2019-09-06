package com.jtzh.service;

import com.jtzh.vo.orgMember.OrgBasicInfQueryVO;
import com.jtzh.vo.orgMember.OrgBasicInfVO;
import com.jtzh.vo.orgMember.OrgMemberQueryRequestVO;
import com.jtzh.vo.orgMember.OrgMemberQueryResponseVO;
import com.jtzh.vo.orgMember.OrgMemberQueryVO;
import com.jtzh.vo.orgMember.OrgMemberServedPersonRecoedQueryResponseVO;
import com.jtzh.vo.orgMember.OrgMemberServedPersonRecordQueryVO;
import com.jtzh.vo.orgMember.OrgMemberTypesVO;
import com.jtzh.vo.orgMember.OrgMemberVO;
import com.jtzh.entity.OrgBasicInf;
import com.jtzh.entity.OrgMember;

import java.util.List;
import java.util.Map;

public abstract interface OrgMemberService
{
  public abstract OrgMemberVO getByOrgMemberId(long paramLong);
  
  public abstract OrgMemberQueryResponseVO query(OrgMemberQueryRequestVO paramOrgMemberQueryRequestVO);
  
  public abstract boolean updateStatus(long paramLong, int paramInt);
  
  public abstract boolean update(OrgMember paramOrgMember);
  
  public abstract OrgMemberTypesVO getSpecs();
  
  public abstract boolean add(OrgMemberVO paramOrgMemberVO);
  
  public abstract OrgMemberServedPersonRecoedQueryResponseVO getServiceRecord(OrgMemberServedPersonRecordQueryVO paramOrgMemberServedPersonRecordQueryVO);
  
  public abstract List<OrgMemberQueryVO> getOrgMemberByNameAndCertID(String paramString1, String paramString2);
  
  public abstract Long getPrimaryKeyByName(String paramString1, String paramString2);
  
  public abstract List getServedRecordCount();
  
  public abstract Map getServedRecordDetail(Long paramLong);
  
  public abstract OrgBasicInfQueryVO getOrgBasicInf(String paramString1, String paramString2, Integer paramInteger, String paramString3, int paramInt1, int paramInt2);
  
  public abstract OrgBasicInfVO getOrgBasicInfDetail(Long paramLong);
  
  public abstract OrgBasicInf getOrgBasicInfDetailToUpdate(Long paramLong);
  
  public abstract boolean addOrgBasicInfo(OrgBasicInf paramOrgBasicInf);
  
  public abstract boolean updateOrgBasicInfo(OrgBasicInf paramOrgBasicInf);
  
  public abstract boolean deleteOrgBasicInfo(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\OrgMemberService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */