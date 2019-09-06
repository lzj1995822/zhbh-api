/*    */ package com.jtzh.service.Impl;
import com.jtzh.entity.SPTrail;
import com.jtzh.mapper.SPTrailMapper;
import com.jtzh.service.SPTrailService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class SPTrailServiceImpl implements SPTrailService
/*    */ {
/*    */   @Autowired
/*    */   private SPTrailMapper trailMapper;
/*    */   
/*    */   public boolean addTrail(SPTrail trail)
/*    */   {
/* 17 */     return this.trailMapper.insert(trail) != 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\SPTrailServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */