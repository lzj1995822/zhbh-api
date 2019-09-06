/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
/*    */ import com.jtzh.vo.dispute.DisputeEventQueryResponseVO;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.PerformanceService;

/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.WebDataBinder;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.InitBinder;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.context.request.WebRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/performance"})
/*    */ public class PerformanceController
/*    */ {
/*    */   @Autowired
/*    */   private PerformanceService performanceService;
/*    */   
/*    */   @InitBinder
/*    */   protected void init(WebDataBinder binder, WebRequest request)
/*    */   {
/* 34 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 35 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getEventDataForCheck"})
/*    */   @ResponseBody
/*    */   public ExtResponse<DisputeEventQueryResponseVO> getEventDataForCheck(Date start, Date end)
/*    */   {
/* 42 */     return ResponseUtil.success(this.performanceService.getEventDataForCheck(start, end));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getEventDataByNetGrid"})
/*    */   @ResponseBody
/*    */   public ExtResponse<DisputeEventQueryResponseVO> getEventDataByNetGrid(Date start, Date end) {
/* 48 */     return ResponseUtil.success(this.performanceService.getEventDataByNetGrid(start, end));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getEventCountByStatus"})
/*    */   @ResponseBody
/*    */   public ExtResponse<DisputeEventQueryResponseVO> getEventCountByStatus(Date start, Date end) {
/* 54 */     return ResponseUtil.success(this.performanceService.getEventCountByStatus(start, end));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\PerformanceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */