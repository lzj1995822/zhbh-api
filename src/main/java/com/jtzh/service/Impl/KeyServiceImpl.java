/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.key.InspectRecordQueryVO;
/*     */ import com.jtzh.vo.key.KeyDriverQueryVO;
/*     */ import com.jtzh.vo.key.KeyVehiclesQueryVO;
import com.jtzh.entity.InspectRecord;
import com.jtzh.entity.KeyDriver;
import com.jtzh.entity.KeyDriverPicture;
import com.jtzh.entity.KeyVehicles;
import com.jtzh.entity.KeyVehiclesPicture;
import com.jtzh.entity.Picture;
import com.jtzh.mapper.CODEDrivingLicenseTypeMapper;
import com.jtzh.mapper.InspectRecordMapper;
import com.jtzh.mapper.KeyDriverMapper;
import com.jtzh.mapper.KeyDriverPictureMapper;
import com.jtzh.mapper.KeyVehiclesMapper;
import com.jtzh.mapper.NonPublicEconomyOrgMapper;
import com.jtzh.mapper.PictureMapper;

/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class KeyServiceImpl implements com.jtzh.service.KeyService
/*     */ {
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODEVechiclesTypeMapper codeVechiclesTypeMapper;
/*     */   @Autowired
/*     */   private KeyVehiclesMapper keyVehiclesMapper;
/*     */   @Autowired
/*     */   private KeyDriverMapper keyDriverMapper;
/*     */   @Autowired
/*     */   private CODEDrivingLicenseTypeMapper codeDrivingLicenseTypeMapper;
/*     */   @Autowired
/*     */   private NonPublicEconomyOrgMapper nonPublicEconomyOrgMapper;
/*     */   @Autowired
/*     */   private InspectRecordMapper inspectRecordMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.KeyVehiclesPictureMapper keyVehiclesPictureMapper;
/*     */   @Autowired
/*     */   private KeyDriverPictureMapper keyDriverPictureMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   private static final String KEYVECHIOCLES_PATH = "/key/KeyVehicles/Pictures/";
/*     */   private static final String KEYDRIVER_PATH = "/key/KeyDriver/Pictures/";
/*     */   
/*     */   public List<com.jtzh.entity.CODEVechiclesType> getVechiclesCode()
/*     */   {
/*  57 */     return this.codeVechiclesTypeMapper.selectAll();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public KeyVehiclesQueryVO getVehiclesInfo(String name, String certID, String number, Integer netGridID, int page, int pageSize)
/*     */   {
/*  64 */     int start = 0;
/*  65 */     if (page > 1)
/*  66 */       start = (page - 1) * pageSize;
/*  67 */     List<com.jtzh.vo.key.KeyVehiclesInfoVO> list = this.keyVehiclesMapper.getKeyVehiclesInfo(name, certID, number, netGridID, start, pageSize);
/*     */     
/*  69 */     int count = this.keyVehiclesMapper.getKeyVehiclesInfoCount(name, certID, number, netGridID);
/*  70 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  71 */     KeyVehiclesQueryVO vo = new KeyVehiclesQueryVO();
/*  72 */     vo.setPage(p);
/*  73 */     vo.setVos(list);
/*  74 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public Long addKeyVehicles(KeyVehicles vehicles)
/*     */   {
/*  80 */     boolean flag = this.keyVehiclesMapper.insert(vehicles) != 0;
/*  81 */     if (flag)
/*  82 */       return vehicles.getKeyVehiclesID();
/*  83 */     return null;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean uploadKeyVehiclesPictures(MultipartFile[] pictures, Long id)
/*     */   {
/*  89 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  90 */     boolean flag = false;
/*  91 */     if (pictures.length > 0) {
/*  92 */       for (int i = 0; i < pictures.length; i++) {
/*  93 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/*  94 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/*  96 */           String originFileName = pictures[i].getOriginalFilename();
/*  97 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 100 */           File outPath = new File(root_path + "/key/KeyVehicles/Pictures/");
/* 101 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 102 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 106 */           File outFile = new File(root_path + "/key/KeyVehicles/Pictures/" + filename + extension);
/*     */           try
/*     */           {
/* 109 */             pictures[i].transferTo(outFile);
/*     */             
/* 111 */             Picture p = new Picture();
/* 112 */             p.setPictureName(filename);
/* 113 */             p.setPicturePath("/key/KeyVehicles/Pictures/");
/* 114 */             p.setPictureSuffix(extension);
/* 115 */             flag = this.pictureMapper.insert(p) != 0;
/* 116 */             Long pictureID = p.getPictureID();
/* 117 */             KeyVehiclesPicture vehiclesPicture = new KeyVehiclesPicture();
/* 118 */             vehiclesPicture.setKeyVehiclesID(id);
/* 119 */             vehiclesPicture.setPictureID(pictureID);
/* 120 */             flag = this.keyVehiclesPictureMapper.insert(vehiclesPicture) != 0;
/*     */           } catch (Exception ex) {
/* 122 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 127 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateKeyVehicles(KeyVehicles vehicles)
/*     */   {
/* 133 */     return this.keyVehiclesMapper.updateByPrimaryKey(vehicles) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteKeyVehicles(Long id)
/*     */   {
/* 139 */     return this.keyVehiclesMapper.deleteByPrimaryKey(id) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map getDetailByID(Long id)
/*     */   {
/* 145 */     Map map = new HashMap();
/* 146 */     map.put("detail", this.keyVehiclesMapper.getDetailByID(id));
/* 147 */     map.put("pictures", getKeyVehiclesPictures(id));
/* 148 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.entity.CODEDrivingLicenseType> getDrivingLicenseCode()
/*     */   {
/* 154 */     return this.codeDrivingLicenseTypeMapper.selectAll();
/*     */   }
/*     */   
/*     */ 
/*     */   public KeyDriverQueryVO getKeyDriverInfo(String name, String certID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 160 */     int start = 0;
/* 161 */     if (page > 1)
/* 162 */       start = (page - 1) * pageSize;
/* 163 */     List<com.jtzh.vo.key.KeyDriverInfoVO> list = this.keyDriverMapper.getKeyDriverInfo(name, certID, netGridID, start, pageSize);
/* 164 */     int count = this.keyDriverMapper.getKeyDriverInfoCount(name, certID, netGridID);
/* 165 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 166 */     KeyDriverQueryVO vo = new KeyDriverQueryVO();
/* 167 */     vo.setVos(list);
/* 168 */     vo.setPage(p);
/* 169 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public Long addKeyDriver(KeyDriver driver)
/*     */   {
/* 175 */     boolean flag = this.keyDriverMapper.insert(driver) != 0;
/* 176 */     if (flag)
/* 177 */       return driver.getKeyDriverID();
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean uploadKeyDriverPictures(MultipartFile[] pictures, Long id)
/*     */   {
/* 184 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 185 */     boolean flag = false;
/* 186 */     if (pictures.length > 0) {
/* 187 */       for (int i = 0; i < pictures.length; i++) {
/* 188 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 189 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 191 */           String originFileName = pictures[i].getOriginalFilename();
/* 192 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 195 */           File outPath = new File(root_path + "/key/KeyDriver/Pictures/");
/* 196 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 197 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 201 */           File outFile = new File(root_path + "/key/KeyDriver/Pictures/" + filename + extension);
/*     */           try
/*     */           {
/* 204 */             pictures[i].transferTo(outFile);
/*     */             
/* 206 */             Picture p = new Picture();
/* 207 */             p.setPictureName(filename);
/* 208 */             p.setPicturePath("/key/KeyDriver/Pictures/");
/* 209 */             p.setPictureSuffix(extension);
/* 210 */             flag = this.pictureMapper.insert(p) != 0;
/* 211 */             Long pictureID = p.getPictureID();
/* 212 */             KeyDriverPicture driverPicture = new KeyDriverPicture();
/* 213 */             driverPicture.setKeyDriverID(id);
/* 214 */             driverPicture.setPictureID(pictureID);
/* 215 */             flag = this.keyDriverPictureMapper.insert(driverPicture) != 0;
/*     */           } catch (Exception ex) {
/* 217 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 222 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateKeyDriver(KeyDriver driver)
/*     */   {
/* 228 */     return this.keyDriverMapper.updateByPrimaryKey(driver) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteKeyDriver(Long id)
/*     */   {
/* 234 */     return this.keyDriverMapper.deleteByPrimaryKey(id) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map getDetaileByDriverID(Long id)
/*     */   {
/* 240 */     Map map = new HashMap();
/* 241 */     map.put("detail", this.keyDriverMapper.getDetailByKey(id));
/* 242 */     map.put("pictures", getKeyDriverPictures(id));
/* 243 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public KeyDriver getDetailToUpdateDriver(Long id)
/*     */   {
/* 249 */     return this.keyDriverMapper.selectByPrimaryKey(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.entity.NonPublicEconomyOrg> getKeyEnterpriseUSCcode()
/*     */   {
/* 255 */     return this.nonPublicEconomyOrgMapper.getKeyEnterpriseUSCcode();
/*     */   }
/*     */   
/*     */ 
/*     */   public InspectRecord getInspectRecDetail(Long id)
/*     */   {
/* 261 */     return this.inspectRecordMapper.getInspectRecDetail(id);
/*     */   }
/*     */   
/*     */ 
/*     */   public InspectRecordQueryVO getInspectRecInfo(String name, String date, String code, int page, int pageSize)
/*     */   {
/* 267 */     int start = 0;
/* 268 */     if (page > 1)
/* 269 */       start = (page - 1) * pageSize;
/* 270 */     List<InspectRecord> records = this.inspectRecordMapper.getInspectRecInfo(name, date, code, start, pageSize);
/* 271 */     int count = this.inspectRecordMapper.getInspectRecInfoCount(name, date, code);
/* 272 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 273 */     InspectRecordQueryVO vo = new InspectRecordQueryVO();
/* 274 */     vo.setRecords(records);
/* 275 */     vo.setPage(p);
/* 276 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addInspectRecord(InspectRecord record)
/*     */   {
/* 282 */     return this.inspectRecordMapper.insert(record) != 0;
/*     */   }
/*     */   
/*     */   private List getKeyVehiclesPictures(Long id) {
/* 286 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 287 */     List<Picture> pictures = this.pictureMapper.selectKeyVehiclesPictureByKeyVehiclesID(id);
/* 288 */     List picturePaths = new ArrayList();
/* 289 */     if (pictures.size() > 0) {
/* 290 */       for (Picture p : pictures) {
/* 291 */         String path =  p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 292 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 295 */     return picturePaths;
/*     */   }
/*     */   
/*     */   private List getKeyDriverPictures(Long id) {
/* 299 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 300 */     List<Picture> pictures = this.pictureMapper.selectKeyDriverPictureByKeyDriverID(id);
/* 301 */     List picturePaths = new ArrayList();
/* 302 */     if (pictures.size() > 0) {
/* 303 */       for (Picture p : pictures) {
/* 304 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 305 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 308 */     return picturePaths;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\KeyServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */