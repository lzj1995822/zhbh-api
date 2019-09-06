/*    */ package com.jtzh.service.Impl;
/*    */ import com.jtzh.util.Page;
/*    */ import com.jtzh.util.PageUtil;
/*    */ import com.jtzh.vo.house.HouseDetailVO;
/*    */ import com.jtzh.vo.house.HouseExVO;
/*    */ import com.jtzh.vo.house.HouseQueryVO;
import com.jtzh.entity.House;
import com.jtzh.mapper.CODEBuildingPurposeTypeMapper;
import com.jtzh.mapper.CODEHiddenTroubleTypeMapper;
import com.jtzh.mapper.CODERentalPurposeTypeMapper;
import com.jtzh.mapper.HouseMapper;
import com.jtzh.service.HouseService;

/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class HouseServiceImpl
/*    */   implements HouseService
/*    */ {
/*    */   @Autowired
/*    */   private HouseMapper houseMapper;
/*    */   @Autowired
/*    */   private CODEBuildingPurposeTypeMapper codeBuildingPurposeTypeMapper;
/*    */   @Autowired
/*    */   private CODERentalPurposeTypeMapper codeRentalPurposeTypeMapper;
/*    */   @Autowired
/*    */   private CODEHiddenTroubleTypeMapper codeHiddenTroubleTypeMapper;
/*    */   
/*    */   public boolean addHouse(House house)
/*    */   {
/* 35 */     return this.houseMapper.insert(house) != 0;
/*    */   }
/*    */   
/*    */   public boolean updateHouse(House house)
/*    */   {
/* 40 */     return this.houseMapper.updateByPrimaryKey(house) != 0;
/*    */   }
/*    */   
/*    */   public boolean deleteHouse(Long id)
/*    */   {
/* 45 */     return this.houseMapper.deleteByPrimaryKey(id) != 0;
/*    */   }
/*    */   
/*    */   public HouseQueryVO getHouseQuery(String name, String address, int page, int pageSize)
/*    */   {
/* 50 */     int start = 0;
/* 51 */     if (page > 1)
/* 52 */       start = (page - 1) * pageSize;
/* 53 */     List<HouseExVO> vos = this.houseMapper.getHouseQuery(name, address, start, pageSize);
/* 54 */     int count = this.houseMapper.getHouseQueryCount(name, address);
/* 55 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 56 */     HouseQueryVO vo = new HouseQueryVO();
/* 57 */     vo.setVos(vos);
/* 58 */     vo.setPage(p);
/* 59 */     return vo;
/*    */   }
/*    */   
/*    */   public HouseDetailVO getHouseDetail(Long id)
/*    */   {
/* 64 */     return this.houseMapper.getHouseDetailByHouseID(id);
/*    */   }
/*    */   
/*    */   public House getHouseDetailToUpdate(Long id)
/*    */   {
/* 69 */     return this.houseMapper.selectByPrimaryKey(id);
/*    */   }
/*    */   
/*    */   public Map getHouseCode()
/*    */   {
/* 74 */     Map map = new HashMap();
/* 75 */     map.put("BuildingPurposeType", this.codeBuildingPurposeTypeMapper.selectAll());
/* 76 */     map.put("RentalPurposeType", this.codeRentalPurposeTypeMapper.selectAll());
/* 77 */     map.put("HiddenTroubleType", this.codeHiddenTroubleTypeMapper.selectAll());
/* 78 */     return map;
/*    */   }
/*    */   
/*    */   public List<HouseDetailVO> getHouseDetailForGIS()
/*    */   {
/* 83 */     return this.houseMapper.getHouseDetailForGIS();
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\HouseServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */