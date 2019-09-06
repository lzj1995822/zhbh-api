/*    */ package com.jtzh.service.Impl;
/*    */ import com.jtzh.vo.served.SpecialPersonPieVO;
import com.jtzh.mapper.ServedPersonBasicMapper;
import com.jtzh.service.PopulationService;

/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class PopulationServiceImpl
/*    */   implements PopulationService
/*    */ {
/*    */   @Autowired
/*    */   private ServedPersonBasicMapper servedPersonBasicMapper;
/*    */   
/*    */   public List getServedHistogramCount(String type)
/*    */   {
/* 21 */     List<SpecialPersonPieVO> list = this.servedPersonBasicMapper.getServedHistogramCount(type);
/* 22 */     List l = new ArrayList();
/* 23 */     int len = list.size();
/* 24 */     String[] name = new String[len];
/* 25 */     int[] value = new int[len];
/* 26 */     for (int i = 0; i < len; i++) {
/* 27 */       SpecialPersonPieVO v = (SpecialPersonPieVO)list.get(i);
/* 28 */       name[i] = v.getName();
/* 29 */       value[i] = v.getValue();
/*    */     }
/* 31 */     l.add(name);
/* 32 */     l.add(value);
/* 33 */     return l;
/*    */   }

			public int getServedHistogramScreenCount(String type)
/*    */   {
			int count=0;
/* 21 */     List<SpecialPersonPieVO> list = this.servedPersonBasicMapper.getServedHistogramCount(type);
/* 22 */     List l = new ArrayList();
/* 23 */     int len = list.size();
/* 24 */     String[] name = new String[len];
/* 25 */     int[] value = new int[len];
/* 26 */     for (int i = 0; i < len; i++) {
/* 27 */       SpecialPersonPieVO v = (SpecialPersonPieVO)list.get(i);
/* 28 */       name[i] = v.getName();
/* 29 */       value[i] = v.getValue();
				count+=value[i];
/*    */     }
/* 31 */     l.add(name);
/* 32 */     l.add(value);
/* 33 */     return count;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\PopulationServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */