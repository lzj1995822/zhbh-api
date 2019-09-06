/*    */ package com.jtzh.service.Impl;
import com.jtzh.mapper.OrgBasicInfMapper;
import com.jtzh.mapper.OrgMemberMapper;
import com.jtzh.mapper.OrgMemberServedPersonRecordMapper;
import com.jtzh.service.ZZService;

/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class ZZServiceImpl
/*    */   implements ZZService
/*    */ {
/*    */   @Autowired
/*    */   private OrgBasicInfMapper orgBasicInfMapper;
/*    */   @Autowired
/*    */   private OrgMemberMapper orgMemberMapper;
/*    */   @Autowired
/*    */   private OrgMemberServedPersonRecordMapper orgMemberServedPersonRecordMapper;
/*    */   
/*    */   public Map getZZHomePageCount()
/*    */   {
/* 26 */     Map map = new HashMap();
/* 27 */     map.put("orgBasicInf", Integer.valueOf(this.orgBasicInfMapper.getCount()));
/* 28 */     map.put("orgMember", Integer.valueOf(this.orgMemberMapper.getQueryCount(null, null, null)));
/* 29 */     map.put("everyMonthPersonCount", Integer.valueOf(this.orgMemberServedPersonRecordMapper.getEveryMonthPersonCount()));
/* 30 */     map.put("servedTotalCount", Integer.valueOf(this.orgMemberServedPersonRecordMapper.getQueryCount(null, null, null)));
/* 31 */     map.put("servedTotalTimes", Integer.valueOf(this.orgMemberServedPersonRecordMapper.getServedCount()));
/* 32 */     map.put("currentMonthCount", this.orgMemberServedPersonRecordMapper.getCurrentMonthCount());
/* 33 */     return map;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\ZZServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */