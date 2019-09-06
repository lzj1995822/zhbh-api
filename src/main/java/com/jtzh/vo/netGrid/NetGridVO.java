/*    */ package com.jtzh.vo.netGrid;
/*    */ 
/*    */ 
/*    */ public class NetGridVO
/*    */ {
/*    */   private Long netGridID;
/*    */   
/*    */   private String netGridName;
/*    */   
/*    */   private String netGridLeaderName;
/*    */   
/*    */   private Integer netGridMemberNumber;
/*    */   
/*    */   private Integer netGridNumber;
/*    */   
/*    */   private Integer netGridArea;

           private String netureGrid;
           private String exclusiveGrid;

           private Long fatherNetGridID;
/*    */   private String fatherNetGridName;
/*    */   
/*    */   public Long getNetGridID()
/*    */   {
/* 21 */     return this.netGridID;
/*    */   }
/*    */   
/*    */   public void setNetGridID(Long netGridID) {
/* 25 */     this.netGridID = netGridID;
/*    */   }
/*    */   
/*    */   public String getNetGridName() {
/* 29 */     return this.netGridName;
/*    */   }
/*    */   
/*    */   public void setNetGridName(String netGridName) {
/* 33 */     this.netGridName = netGridName;
/*    */   }
/*    */   
/*    */   public String getNetGridLeaderName() {
/* 37 */     return this.netGridLeaderName;
/*    */   }
/*    */   
/*    */   public void setNetGridLeaderName(String netGridLeaderName) {
/* 41 */     this.netGridLeaderName = netGridLeaderName;
/*    */   }
/*    */   
/*    */   public Integer getNetGridMemberNumber() {
/* 45 */     return this.netGridMemberNumber;
/*    */   }
/*    */   
/*    */   public void setNetGridMemberNumber(Integer netGridMemberNumber) {
/* 49 */     this.netGridMemberNumber = netGridMemberNumber;
/*    */   }
/*    */   
/*    */   public Integer getNetGridNumber() {
/* 53 */     return this.netGridNumber;
/*    */   }
/*    */   
/*    */   public void setNetGridNumber(Integer netGridNumber) {
/* 57 */     this.netGridNumber = netGridNumber;
/*    */   }
/*    */   
/*    */   public Integer getNetGridArea() {
/* 61 */     return this.netGridArea;
/*    */   }
/*    */   
/*    */   public void setNetGridArea(Integer netGridArea) {
/* 65 */     this.netGridArea = netGridArea;
/*    */   }
/*    */   
/*    */   public String getFatherNetGridName() {
/* 69 */     return this.fatherNetGridName;
/*    */   }
/*    */   
/*    */   public void setFatherNetGridName(String fatherNetGridName) {
/* 73 */     this.fatherNetGridName = fatherNetGridName;
/*    */   }

    public String getNetureGrid() {
        return netureGrid;
    }

    public void setNetureGrid(String netureGrid) {
        this.netureGrid = netureGrid;
    }

    public String getExclusiveGrid() {
        return exclusiveGrid;
    }

    public void setExclusiveGrid(String exclusiveGrid) {
        this.exclusiveGrid = exclusiveGrid;
    }

    public Long getFatherNetGridID() {
        return fatherNetGridID;
    }

    public void setFatherNetGridID(Long fatherNetGridID) {
        this.fatherNetGridID = fatherNetGridID;
    }
    /*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\netGrid\NetGridVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */