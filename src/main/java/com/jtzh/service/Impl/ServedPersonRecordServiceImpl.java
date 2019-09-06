/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
import com.jtzh.entity.OrgMemberServedPersonRecord;
import com.jtzh.entity.Picture;
import com.jtzh.entity.ServedRecordPicture;
import com.jtzh.entity.ServedRecordVideoFile;
import com.jtzh.entity.TEFile;
import com.jtzh.mapper.NetGridMemberMapper;
import com.jtzh.mapper.OrgMemberMapper;
import com.jtzh.mapper.OrgMemberServedPersonRecordMapper;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.ServedPersonBasicMapper;
import com.jtzh.mapper.ServedPersonForeignerMapper;
import com.jtzh.mapper.ServedRecordPictureMapper;
import com.jtzh.mapper.ServedRecordVideoFileMapper;
import com.jtzh.mapper.TEFileMapper;
import com.jtzh.service.ServedPersonRecordService;

/*     */ import java.io.File;
/*     */ import java.text.ParseException;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class ServedPersonRecordServiceImpl implements ServedPersonRecordService
/*     */ {
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private OrgMemberMapper orgMemberMapper;
/*     */   @Autowired
/*     */   private ServedPersonForeignerMapper servedPersonForeignerMapper;
/*     */   @Autowired
/*     */   private ServedPersonBasicMapper servedPersonBasicMapper;
/*     */   @Autowired
/*     */   private OrgMemberServedPersonRecordMapper orgMemberServedPersonRecordMapper;
/*     */   @Autowired
/*     */   private ServedRecordPictureMapper servedRecordPictureMapper;
/*     */   @Autowired
/*     */   private TEFileMapper teFileMapper;
/*     */   @Autowired
/*     */   private ServedRecordVideoFileMapper servedRecordVideoFileMapper;
/*     */   @Autowired
/*     */   private NetGridMemberMapper netGridMemberMapper;
/*     */   private static final String SERVEDRECORD_PICTURE_PATH = "/ServedRecord/picture";
/*     */   private static final String SERVEDRECORD_VIDEO_PATH = "/ServedRecord/video";
/*     */   
/*     */   public Long addServiceRecord(String orgMemberName, String orgMemberCertID, String servedPersonName, String servedPersonCertID, String servedPersonType, String serverInf, String serverDate)
/*     */   {
/*  51 */     long orgID = this.netGridMemberMapper.getNetGridMemberIDByNameAndCertID(orgMemberName, orgMemberCertID);
/*  52 */     long servedID;  if ("1".equals(servedPersonType)) {
/*  53 */       servedID = this.servedPersonForeignerMapper.getServedPersonIDByName(servedPersonName, servedPersonCertID).longValue();
/*     */     } else
/*  55 */       servedID = this.servedPersonBasicMapper.getPrimaryKeyByName(servedPersonName, servedPersonCertID).longValue();
/*  56 */     OrgMemberServedPersonRecord o = new OrgMemberServedPersonRecord();
/*  57 */     o.setOrgMemberID(Long.valueOf(orgID));
/*  58 */     o.setServedPersonID(Long.valueOf(servedID));
/*  59 */     o.setServerInf(serverInf);
/*     */     try {
/*  61 */       o.setServerDate(com.jtzh.util.DateUtil.strToDate(serverDate));
/*     */     }
/*     */     catch (ParseException e) {
/*  64 */       e.printStackTrace();
/*     */     }
/*  66 */     this.orgMemberServedPersonRecordMapper.insert(o);
/*  67 */     Long ID = o.getOrgMServedPID();
/*  68 */     return ID;
/*     */   }
/*     */   
/*     */   public boolean addRecordPicture(MultipartFile file, Long ID)
/*     */   {
/*  73 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  74 */     if ((file != null) && (!file.isEmpty())) {
/*  75 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/*  77 */       String originFileName = file.getOriginalFilename();
/*  78 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/*  81 */       File outPath = new File(root_path + "/ServedRecord/picture");
/*  82 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  83 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/*  87 */       File outFile = new File(root_path + "/ServedRecord/picture" + filename + extension);
/*     */       try
/*     */       {
/*  90 */         file.transferTo(outFile);
/*     */         
/*  92 */         Picture p = new Picture();
/*  93 */         p.setPictureName(filename);
/*  94 */         p.setPicturePath("/ServedRecord/picture");
/*  95 */         p.setPictureSuffix(extension);
/*  96 */         this.pictureMapper.insert(p);
/*  97 */         Long pictureID = p.getPictureID();
/*  98 */         ServedRecordPicture s = new ServedRecordPicture();
/*  99 */         s.setServedRecordID(ID);
/* 100 */         s.setPictureID(pictureID);
/* 101 */         return this.servedRecordPictureMapper.insert(s) != 0;
/*     */       } catch (Exception ex) {
/* 103 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addRecordVideo(MultipartFile file, Long ID)
/*     */   {
/* 111 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 112 */     if ((file != null) && (!file.isEmpty())) {
/* 113 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 115 */       String originFileName = file.getOriginalFilename();
/* 116 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 119 */       File outPath = new File(root_path + "/ServedRecord/video");
/* 120 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 121 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 125 */       File outFile = new File(root_path + "/ServedRecord/video" + filename + extension);
/*     */       try
/*     */       {
/* 128 */         file.transferTo(outFile);
/*     */         
/* 130 */         TEFile f = new TEFile();
/* 131 */         f.setFileName(filename);
/* 132 */         f.setFilePath("/ServedRecord/video");
/* 133 */         f.setFileSuffix(extension);
/* 134 */         this.teFileMapper.insert(f);
/* 135 */         Long fileID = f.getFileID();
/* 136 */         ServedRecordVideoFile videoFile = new ServedRecordVideoFile();
/*     */         
/* 138 */         videoFile.setServedRecordID(ID);
/* 139 */         videoFile.setFileID(fileID);
/* 140 */         return this.servedRecordVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (Exception ex) {
/* 142 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public boolean updateRecord(Long id, String content, String date)
/*     */   {
/* 150 */     return this.orgMemberServedPersonRecordMapper.updateRecord(id, content, java.sql.Date.valueOf(date)) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteRecord(Long id)
/*     */   {
/* 155 */     if (deleteServedRecordMedia(id)) {
/* 156 */       return this.orgMemberServedPersonRecordMapper.deleteByPrimaryKey(id) != 0;
/*     */     }
/* 158 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean deleteServedRecordMedia(Long id)
/*     */   {
/* 171 */     boolean flag = false;
/* 172 */     String rootPath = CommonUtils.getRootPath("msmis.file");
/* 173 */     List<ServedRecordPicture> srp = this.servedRecordPictureMapper.selectByRecordID(id);
/* 174 */     if (srp.size() > 0) {
/* 175 */       for (ServedRecordPicture image : srp) {
/* 176 */         Picture p = this.pictureMapper.selectByPrimaryKey(image.getPictureID());
/* 177 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 178 */         if (CommonUtils.deleteFile(path)) {
/* 179 */           flag = this.servedRecordPictureMapper.deleteByPictureID(image.getPictureID()) != 0;
/*     */         } else {
/* 181 */           flag = false;
/* 182 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/* 186 */       flag = true;
/*     */     }
/* 188 */     if (flag) {
/*     */       ServedRecordVideoFile videoFile;
/* 190 */       if ((videoFile = this.servedRecordVideoFileMapper.selectByRecordID(id)) != null) {
/* 191 */         TEFile f = this.teFileMapper.selectByPrimaryKey(videoFile.getFileID());
/* 192 */         String file = rootPath + f.getFilePath() + f.getFileName() + f.getFileSuffix();
/* 193 */         if (CommonUtils.deleteFile(file)) {
/* 194 */           flag = this.servedRecordVideoFileMapper.deleteByFileID(videoFile.getFileID()) != 0;
/*     */         } else {
/* 196 */           flag = false;
/*     */         }
/*     */       } else {
/* 199 */         flag = true;
/*     */       }
/*     */     }
/* 202 */     return flag;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\ServedPersonRecordServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */