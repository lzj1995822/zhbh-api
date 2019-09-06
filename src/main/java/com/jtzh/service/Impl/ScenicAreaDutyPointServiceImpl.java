/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.dutyPoint.DutyPointQueryVO;
/*     */ import com.jtzh.vo.dutyPoint.DutyPointVO;
import com.jtzh.entity.Picture;
import com.jtzh.entity.ScenicAreaDutyPoint;
import com.jtzh.entity.ScenicAreaDutyPointPicture;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.ScenicAreaDutyPointMapper;
import com.jtzh.mapper.ScenicAreaDutyPointPictureMapper;
import com.jtzh.service.ScenicAreaDutyPointService;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ScenicAreaDutyPointServiceImpl
/*     */   implements ScenicAreaDutyPointService
/*     */ {
/*     */   @Resource
/*     */   private ScenicAreaDutyPointPictureMapper scenicAreaDutyPointPictureMapper;
/*     */   @Resource
/*     */   private ScenicAreaDutyPointMapper scenicAreaDutyPointMapper;
/*     */   @Resource
/*     */   private PictureMapper pictureMapper;
/*     */   private static final String POINTPICTURE_PATH = "/ScenicAreaDutyPoint/picture";
/*     */   
/*     */   public Integer addScenicAreaDutyPoint(ScenicAreaDutyPoint point)
/*     */   {
/*  42 */     this.scenicAreaDutyPointMapper.insert(point);
/*  43 */     return point.getScenicAreaDutyPointID();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addScenicAreaDutyPointPicture(MultipartFile file, Long ID)
/*     */   {
/*  49 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  50 */     if ((file != null) && (!file.isEmpty())) {
/*  51 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/*  53 */       String originFileName = file.getOriginalFilename();
/*  54 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/*  57 */       File outPath = new File(root_path + "/ScenicAreaDutyPoint/picture");
/*  58 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  59 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/*  63 */       File outFile = new File(root_path + "/ScenicAreaDutyPoint/picture" + filename + extension);
/*     */       try
/*     */       {
/*  66 */         file.transferTo(outFile);
/*     */         
/*  68 */         Picture p = new Picture();
/*  69 */         p.setPictureName(filename);
/*  70 */         p.setPictureSuffix(extension);
/*  71 */         p.setPicturePath("/ScenicAreaDutyPoint/picture");
/*  72 */         this.pictureMapper.insert(p);
/*  73 */         Long pictureID = p.getPictureID();
/*  74 */         ScenicAreaDutyPointPicture picture = new ScenicAreaDutyPointPicture();
/*  75 */         picture.setScenicAreaDutyPointID(ID);
/*     */         
/*  77 */         picture.setPictureID(pictureID);
/*  78 */         return this.scenicAreaDutyPointPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/*  80 */         e.printStackTrace();
/*     */       }
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public DutyPointQueryVO getDutyPointQuery(Integer netGridID, String name, int page, int pageSize)
/*     */   {
/*  88 */     int start = 0;
/*  89 */     if (page > 1)
/*  90 */       start = (page - 1) * pageSize;
/*  91 */     List<DutyPointVO> pointVOS = this.scenicAreaDutyPointMapper.getDutyPoint(netGridID, name, start, pageSize);
/*  92 */     int count = this.scenicAreaDutyPointMapper.getDutyPointCount(netGridID, name);
/*  93 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  94 */     DutyPointQueryVO vo = new DutyPointQueryVO();
/*  95 */     vo.setVos(pointVOS);
/*  96 */     vo.setPage(p);
/*  97 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map getDutyPointDetail(Long id)
/*     */   {
/* 103 */     List<Picture> pictures = getPictures(id);
/* 104 */     DutyPointVO vo = this.scenicAreaDutyPointMapper.getDutyPointDetailByID(Integer.valueOf(id.intValue()));
/* 105 */     Map map = new HashMap();
/* 106 */     map.put("detail", vo);
/* 107 */     map.put("pictures", pictures);
/* 108 */     return map;
/*     */   }
/*     */   
/*     */   public ScenicAreaDutyPoint getDutyDetailToUpdate(Integer scenicAreaDutyPointID)
/*     */   {
/* 113 */     return this.scenicAreaDutyPointMapper.selectByPrimaryKey(scenicAreaDutyPointID);
/*     */   }
/*     */   
/*     */   public boolean updateDutyPoint(ScenicAreaDutyPoint scenicAreaDutyPoint)
/*     */   {
/* 118 */     return this.scenicAreaDutyPointMapper.updateByPrimaryKey(scenicAreaDutyPoint) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteDutyPoint(Integer scenicAreaDutyPointID)
/*     */   {
/* 123 */     return this.scenicAreaDutyPointMapper.deleteByPrimaryKey(scenicAreaDutyPointID) != 0;
/*     */   }
/*     */   
/*     */   private List getPictures(Long id)
/*     */   {
/* 128 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 129 */     List<Picture> pictures = this.pictureMapper.selectByDutyPointID(id);
/* 130 */     List<String> picturePaths = new ArrayList();
/* 131 */     if (pictures.size() > 0) {
/* 132 */       for (Picture p : pictures) {
/* 133 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 134 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 137 */     return picturePaths;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\ScenicAreaDutyPointServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */