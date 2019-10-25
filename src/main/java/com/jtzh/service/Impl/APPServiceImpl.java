/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.common.Constants;
import com.jtzh.entity.*;
import com.jtzh.mapper.*;
import com.jtzh.util.DateUtil;
/*     */ import com.jtzh.vo.dispute.DisputeEventAPPUploadVO;
/*     */ import com.jtzh.vo.netGrid.NetGridEventAPPUploadVO;
/*     */ import com.jtzh.vo.skynet.SPEventAPPUploadVO;
/*     */ import com.jtzh.vo.ss.SSEventAPPUploadVO;
/*     */ import com.jtzh.vo.trafficAccident.TrafficAccidentAPPUploadVO;

/*     */ import java.io.File;
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/*     */
/*     */ @org.springframework.stereotype.Service
/*     */ public class APPServiceImpl implements com.jtzh.service.APPService
/*     */ {
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SpecialServedPersonMapper specialServedPersonMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.OrgMemberMapper orgMemberMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.ServedPersonForeignerMapper servedPersonForeignerMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.ServedPersonBasicMapper servedPersonBasicMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.OrgMemberServedPersonRecordMapper orgMemberServedPersonRecordMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventMapper disputeEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventPictureMapper disputeEventPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventVideoFileMapper disputeEventVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventInvolvedPersonsMapper disputeEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private TEFileMapper teFileMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.PersonHouseMapper personHouseMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.HouseMapper houseMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.UserMapper userMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.ServedRecordPictureMapper servedRecordPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.ServedRecordVideoFileMapper servedRecordVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentMapper trafficAccidentMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentPictureMapper trafficAccidentPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentVideoFileMapper trafficAccidentVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentInvolvedPersonsMapper trafficAccidentInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.APPVersionMapper appVersionMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SocietySecurityEventMapper societySecurityEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SSEventInvolvedPersonsMapper ssEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SecurityEventPictureMapper securityEventPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SecurityEventVideoFileMapper securityEventVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.NetGridEventMapper netGridEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.NetGridEventInvolvedPersonsMapper netGridEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.NetGridEventPictureMapper netGridEventPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.NetGridEventVideoFileMapper netGridEventVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SkynetPatrolEventMapper skynetPatrolEventMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SkynetPatrolEventInvolvedPersonsMapper skynetPatrolEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SkynetPatrolEventPictureMapper skynetPatrolEventPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SkynetPatrolEventVideoFileMapper skynetPatrolEventVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.NetGridMemberMapper netGridMemberMapper;
            @Autowired
            private NetGridMapper netGridMapper;
            @Autowired
            private UserinformationMapper userinformationMapper;

@Resource
private RealTimeLocationMapper realTimeLocationMapper;
/*     */   private static final String DISPUTEEVENT_PATH = "/DisputeEvent/";
/*     */   private static final String SERVEDRECORD_PATH = "/ServedRecord/";
/*     */   private static final String TRAFFIC_PATH = "/Traffic/";
/*     */   private static final String SSEVENT_PATH = "/SocietySecurityEvent/";
/*     */   private static final String NETGRIDEVENT_PATH = "/NetGrid/Event/";
/*     */   private static final String SPEVENT_PATH = "/SkynetPatrolEvent/";
/*     */   
/*     */   public List<com.jtzh.vo.app.SpecialPopulationForTypeAndNetGrid> getByTypeAndGrid(String type, String netGrid, int page)
/*     */   {
/* 114 */     int pageSize = 10;
/* 115 */     int start = 0;
/* 116 */     if (page > 1)
/* 117 */       start = page * pageSize;
/* 118 */     List<com.jtzh.vo.app.SpecialPopulationForTypeAndNetGrid> lists = this.specialServedPersonMapper.select(type, netGrid, start, pageSize);
/*     */     
/* 120 */     return lists;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addServiceRecord(String orgMemberName, String orgMemberCertID, String servedPersonName, String servedPersonCertID, String servedPersonType, String serverInf, String serverDate, MultipartFile[] pictures, MultipartFile video)
/*     */   {
/* 130 */     long orgID = this.netGridMemberMapper.getNetGridMemberIDByNameAndCertID(orgMemberName, orgMemberCertID);
/* 131 */     long servedID; long servedID1; if ("1".equals(servedPersonType)) {
/* 132 */       servedID1 = this.servedPersonForeignerMapper.getServedPersonIDByName(servedPersonName, servedPersonCertID).longValue();
/*     */     } else
/* 134 */       servedID1 = this.servedPersonBasicMapper.getPrimaryKeyByName(servedPersonName, servedPersonCertID).longValue();
/* 135 */     OrgMemberServedPersonRecord o = new OrgMemberServedPersonRecord();
/* 136 */     o.setOrgMemberID(Long.valueOf(orgID));
/* 137 */     o.setServedPersonID(Long.valueOf(servedID1));
/* 138 */     o.setServerInf(serverInf);
/*     */     try {
/* 140 */       o.setServerDate(DateUtil.strToDate(serverDate));
/*     */     }
/*     */     catch (ParseException e) {
/* 143 */       e.printStackTrace();
/*     */     }
/* 145 */     int flag = this.orgMemberServedPersonRecordMapper.insert(o);
/* 146 */     long ID = o.getOrgMServedPID().longValue();
/* 147 */     String root_path = getRootPath();
/* 148 */     if (pictures.length > 0) {
/* 149 */       for (int i = 0; i < pictures.length; i++) {
/* 150 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 151 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 153 */           String originFileName = pictures[i].getOriginalFilename();
/* 154 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 157 */           File outPath = new File(root_path + "/ServedRecord/");
/* 158 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 159 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 163 */           File outFile = new File(root_path + "/ServedRecord/" + filename + extension);
/*     */           try
/*     */           {
/* 166 */             pictures[i].transferTo(outFile);
/*     */             
/* 168 */             Picture p = new Picture();
/* 169 */             p.setPictureName(filename);
/* 170 */             p.setPicturePath("/ServedRecord/");
/* 171 */             p.setPictureSuffix(extension);
/* 172 */             flag = this.pictureMapper.insert(p);
/* 173 */             Long pictureID = p.getPictureID();
/* 174 */             ServedRecordPicture s = new ServedRecordPicture();
/* 175 */             s.setServedRecordID(Long.valueOf(ID));
/* 176 */             s.setPictureID(pictureID);
/* 177 */             flag = this.servedRecordPictureMapper.insert(s);
/*     */           } catch (Exception ex) {
/* 179 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 184 */     if ((video != null) && (!video.isEmpty())) {
/* 185 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 187 */       String originFileName = video.getOriginalFilename();
/* 188 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 191 */       File outPath = new File(root_path + "/ServedRecord/");
/* 192 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 193 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 197 */       File outFile = new File(root_path + "/ServedRecord/" + filename + extension);
/*     */       try
/*     */       {
/* 200 */         video.transferTo(outFile);
/*     */         
/* 202 */         TEFile f = new TEFile();
/* 203 */         f.setFileName(filename);
/* 204 */         f.setFilePath("/ServedRecord/");
/* 205 */         f.setFileSuffix(extension);
/* 206 */         flag = this.teFileMapper.insert(f);
/* 207 */         Long fileID = f.getFileID();
/* 208 */         ServedRecordVideoFile videoFile = new ServedRecordVideoFile();
/*     */         
/* 210 */         videoFile.setServedRecordID(Long.valueOf(ID));
/* 211 */         videoFile.setFileID(fileID);
/* 212 */         flag = this.servedRecordVideoFileMapper.insert(videoFile);
/*     */       } catch (Exception ex) {
/* 214 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 217 */     return flag != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public Long addDisputeEvent(DisputeEventAPPUploadVO uploadVO)
/*     */   {
/* 224 */     int flag = 0;
/* 225 */     DisputeEvent e = new DisputeEvent();
/* 226 */     e.setEventName(uploadVO.getEventName());
/*     */     try {
/* 228 */       e.setEventDate(DateUtil.strToDate(uploadVO.getEventDate()));
/*     */     }
/*     */     catch (ParseException e1) {
/* 231 */       e1.printStackTrace();
/*     */     }
/* 233 */     e.setEventPlace(uploadVO.getEventPlace());
/* 234 */     e.setEvenScaleTypeValue(uploadVO.getEvenScaleTypeValue());
/* 235 */     e.setEventTypeValue(uploadVO.getEventTypeValue());
/* 236 */     e.setNumberofJoinning(uploadVO.getNumberofJoinning());
/* 237 */     e.setEventIntroduction(uploadVO.getEventIntroduction());
/* 238 */     e.setRelatedOrg(uploadVO.getRelatedOrg());
/* 239 */     e.setLongitude(uploadVO.getLongitude());
/* 240 */     e.setLatitude(uploadVO.getLatitude());
/* 241 */     e.setNetGridID(uploadVO.getNetGridID());
/* 242 */     e.setSolvingByPersonName(uploadVO.getSolvingByPersonName());
/* 243 */     e.setEventStatus(uploadVO.getEventStatus());
/* 244 */     flag = this.disputeEventMapper.insert(e);
/* 245 */     Long disputeEventID = e.getDisputeEventID();
/* 246 */     List<com.jtzh.entity.DisputeEventInvolvedPersons> involvedPersons = uploadVO.getInvolvedPersons();
/* 247 */     for (com.jtzh.entity.DisputeEventInvolvedPersons person : involvedPersons) {
/* 248 */       person.setEventID(disputeEventID);
/* 249 */       flag = this.disputeEventInvolvedPersonsMapper.insert(person);
/*     */     }
/* 251 */     boolean result = flag != 0;
/* 252 */     if (result)
/* 253 */       return disputeEventID;
/* 254 */     return null;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean uploadDisputeEventMedia(MultipartFile[] pictures, MultipartFile video, Long id)
/*     */   {
/* 260 */     String root_path = getRootPath();
/* 261 */     int flag = 0;
/* 262 */     if (pictures.length > 0) {
/* 263 */       for (int i = 0; i < pictures.length; i++) {
/* 264 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 265 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 267 */           String originFileName = pictures[i].getOriginalFilename();
/* 268 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 271 */           File outPath = new File(root_path + "/DisputeEvent/");
/* 272 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 273 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 277 */           File outFile = new File(root_path + "/DisputeEvent/" + filename + extension);
/*     */           try
/*     */           {
/* 280 */             pictures[i].transferTo(outFile);
/*     */             
/* 282 */             Picture p = new Picture();
/* 283 */             p.setPictureName(filename);
/* 284 */             p.setPicturePath("/DisputeEvent/");
/* 285 */             p.setPictureSuffix(extension);
/* 286 */             flag = this.pictureMapper.insert(p);
/* 287 */             Long pictureID = p.getPictureID();
/* 288 */             com.jtzh.entity.DisputeEventPicture d = new com.jtzh.entity.DisputeEventPicture();
/* 289 */             d.setDisputeEventID(id);
/* 290 */             d.setPictureID(pictureID);
/* 291 */             flag = this.disputeEventPictureMapper.insert(d);
/*     */           } catch (Exception ex) {
/* 293 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 298 */     if ((video != null) && (!video.isEmpty())) {
/* 299 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 301 */       String originFileName = video.getOriginalFilename();
/* 302 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 305 */       File outPath = new File(root_path + "/DisputeEvent/");
/* 306 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 307 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 311 */       File outFile = new File(root_path + "/DisputeEvent/" + filename + extension);
/*     */       try
/*     */       {
/* 314 */         video.transferTo(outFile);
/*     */         
/* 316 */         TEFile f = new TEFile();
/* 317 */         f.setFileName(filename);
/* 318 */         f.setFilePath("/DisputeEvent/");
/* 319 */         f.setFileSuffix(extension);
/* 320 */         flag = this.teFileMapper.insert(f);
/* 321 */         Long fileID = f.getFileID();
/* 322 */         com.jtzh.entity.DisputeEventVideoFile videoFile = new com.jtzh.entity.DisputeEventVideoFile();
/* 323 */         videoFile.setDisputeEventID(id);
/* 324 */         videoFile.setFileID(fileID);
/* 325 */         flag = this.disputeEventVideoFileMapper.insert(videoFile);
/*     */       } catch (Exception ex) {
/* 327 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 330 */     return flag != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public Long addTrafficAccident(TrafficAccidentAPPUploadVO uploadVO)
/*     */   {
/* 337 */     boolean flag = false;
/* 338 */     TrafficAccident accident = new TrafficAccident();
/* 339 */     accident.setTrafficAccidentName(uploadVO.getTrafficAccidentName());
/* 340 */     accident.setTrafficAccidentKind(uploadVO.getTrafficAccidentKind());
/* 341 */     accident.setTrafficAccidentTypeValue(uploadVO.getTrafficAccidentTypeValue());
/* 342 */     accident.setTrafficAccidentContent(uploadVO.getTrafficAccidentContent());
/*     */     try {
/* 344 */       accident.setTrafficAccidentStartDateTime(DateUtil.strToDateTime(uploadVO.getTrafficAccidentStartDateTime()));
/*     */     } catch (ParseException e) {
/* 346 */       e.printStackTrace();
/*     */     }
/* 348 */     accident.setTrafficAccidentHappenLongitude(uploadVO.getTrafficAccidentHappenLongitude());
/* 349 */     accident.setTrafficAccidentHappenLatitude(uploadVO.getTrafficAccidentHappenLatitude());
/* 350 */     accident.setCurrentRemarks(uploadVO.getCurrentRemarks());
/* 351 */     accident.setCurrentResponsiblePersonCertID(uploadVO.getCurrentResponsiblePersonCertID());
/* 352 */     accident.setTrafficAccidentStatusTypeValue("01");
/* 353 */     accident.setNetGridID(uploadVO.getNetGridID());
/* 354 */     flag = this.trafficAccidentMapper.insert(accident) != 0;
/* 355 */     Long trafficAccidentID = accident.getTrafficAccidentID();
/* 356 */     List<com.jtzh.entity.TrafficAccidentInvolvedPersons> involvedPersons = uploadVO.getInvolvedPersons();
/* 357 */     for (com.jtzh.entity.TrafficAccidentInvolvedPersons person : involvedPersons) {
/* 358 */       person.setTrafficAccidentID(trafficAccidentID);
/* 359 */       flag = this.trafficAccidentInvolvedPersonsMapper.insert(person) != 0;
/*     */     }
/* 361 */     if (flag)
/* 362 */       return trafficAccidentID;
/* 363 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public boolean uploadTrafficAccidentMedia(MultipartFile[] pictures, MultipartFile video, Long id)
/*     */   {
/* 370 */     boolean flag = false;
/* 371 */     String root_path = getRootPath();
/* 372 */     if (pictures.length > 0) {
/* 373 */       for (int i = 0; i < pictures.length; i++) {
/* 374 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 375 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 377 */           String originFileName = pictures[i].getOriginalFilename();
/* 378 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 381 */           File outPath = new File(root_path + "/Traffic/");
/* 382 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 383 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 387 */           File outFile = new File(root_path + "/Traffic/" + filename + extension);
/*     */           try
/*     */           {
/* 390 */             pictures[i].transferTo(outFile);
/*     */             
/* 392 */             Picture p = new Picture();
/* 393 */             p.setPictureName(filename);
/* 394 */             p.setPicturePath("/Traffic/");
/* 395 */             p.setPictureSuffix(extension);
/* 396 */             flag = this.pictureMapper.insert(p) != 0;
/* 397 */             Long pictureID = p.getPictureID();
/* 398 */             TrafficAccidentPicture tPicture = new TrafficAccidentPicture();
/* 399 */             tPicture.setTrafficAccidentID(id);
/* 400 */             tPicture.setPictureID(pictureID);
/* 401 */             flag = this.trafficAccidentPictureMapper.insert(tPicture) != 0;
/*     */           } catch (Exception ex) {
/* 403 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 408 */     if ((video != null) && (!video.isEmpty())) {
/* 409 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 411 */       String originFileName = video.getOriginalFilename();
/* 412 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 415 */       File outPath = new File(root_path + "/Traffic/");
/* 416 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 417 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 421 */       File outFile = new File(root_path + "/Traffic/" + filename + extension);
/*     */       try
/*     */       {
/* 424 */         video.transferTo(outFile);
/*     */         
/* 426 */         TEFile f = new TEFile();
/* 427 */         f.setFileName(filename);
/* 428 */         f.setFilePath("/Traffic/");
/* 429 */         f.setFileSuffix(extension);
/* 430 */         flag = this.teFileMapper.insert(f) != 0;
/* 431 */         Long fileID = f.getFileID();
/* 432 */         com.jtzh.entity.TrafficAccidentVideoFile videoFile = new com.jtzh.entity.TrafficAccidentVideoFile();
/* 433 */         videoFile.setTrafficAccidentID(id);
/* 434 */         videoFile.setFileID(fileID);
/* 435 */         flag = this.trafficAccidentVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (Exception ex) {
/* 437 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 440 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public Long addSSEvent(SSEventAPPUploadVO uploadVO)
/*     */   {
/* 447 */     SocietySecurityEvent event = new SocietySecurityEvent();
/* 448 */     event.setSsEventName(uploadVO.getSsEventName());
/* 449 */     event.setSsEventKind(uploadVO.getSsEventKind());
/* 450 */     event.setSsEventTypeValue(uploadVO.getSsEventTypeValue());
/* 451 */     event.setSsEventContent(uploadVO.getSsEventContent());
/*     */     try {
/* 453 */       event.setSsEventStartDateTime(DateUtil.strToDateTime(uploadVO.getSsEventStartDateTime()));
/*     */     } catch (ParseException e) {
/* 455 */       e.printStackTrace();
/*     */     }
/* 457 */     event.setSsEventHappenLongitude(uploadVO.getSsEventHappenLongitude());
/* 458 */     event.setSsEventHappenLatitude(uploadVO.getSsEventHappenLatitude());
/* 459 */     event.setSsEventStatusTypeValue(uploadVO.getSsEventStatusTypeValue());
/* 460 */     event.setCurrentRemarks(uploadVO.getCurrentRemarks());
/* 461 */     event.setCurrentResponsiblePersonCertID(uploadVO.getCurrentResponsiblePersonCertID());
/* 462 */     event.setNetGridID(uploadVO.getNetGridID());
/* 463 */     boolean flag = this.societySecurityEventMapper.insert(event) != 0;
/* 464 */     if (flag) {
/* 465 */       Long ID = event.getSsEventID();
/* 466 */       List<com.jtzh.entity.SSEventInvolvedPersons> involvedPersons = uploadVO.getInvolvedPersons();
/* 467 */       for (com.jtzh.entity.SSEventInvolvedPersons persons : involvedPersons) {
/* 468 */         persons.setSsEventID(ID);
/* 469 */         flag = this.ssEventInvolvedPersonsMapper.insert(persons) != 0;
/* 470 */         if (!flag)
/*     */           break;
/*     */       }
/* 473 */       if (flag)
/* 474 */         return ID;
/* 475 */       return null;
/*     */     }
/* 477 */     return null;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean uploadSSEventMedia(MultipartFile[] pictures, MultipartFile video, Long id)
/*     */   {
/* 483 */     boolean flag = false;
/* 484 */     String root_path = getRootPath();
/* 485 */     if (pictures.length > 0) {
/* 486 */       for (int i = 0; i < pictures.length; i++) {
/* 487 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 488 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 490 */           String originFileName = pictures[i].getOriginalFilename();
/* 491 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 494 */           File outPath = new File(root_path + "/SocietySecurityEvent/" + "picture/");
/* 495 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 496 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 500 */           File outFile = new File(root_path + "/SocietySecurityEvent/" + "picture/" + filename + extension);
/*     */           try
/*     */           {
/* 503 */             pictures[i].transferTo(outFile);
/*     */             
/* 505 */             Picture p = new Picture();
/* 506 */             p.setPictureName(filename);
/* 507 */             p.setPicturePath("/SocietySecurityEvent/picture/");
/* 508 */             p.setPictureSuffix(extension);
/* 509 */             flag = this.pictureMapper.insert(p) != 0;
/* 510 */             Long pictureID = p.getPictureID();
/* 511 */             com.jtzh.entity.SecurityEventPicture picture = new com.jtzh.entity.SecurityEventPicture();
/* 512 */             picture.setSSEventID(id);
/* 513 */             picture.setPictureID(pictureID);
/* 514 */             flag = this.securityEventPictureMapper.insert(picture) != 0;
/*     */           } catch (Exception ex) {
/* 516 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 521 */       flag = true;
/*     */     }
/* 523 */     if ((video != null) && (!video.isEmpty())) {
/* 524 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 526 */       String originFileName = video.getOriginalFilename();
/* 527 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 530 */       File outPath = new File(root_path + "/SocietySecurityEvent/" + "video/");
/* 531 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 532 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 536 */       File outFile = new File(root_path + "/SocietySecurityEvent/" + "video/" + filename + extension);
/*     */       try
/*     */       {
/* 539 */         video.transferTo(outFile);
/*     */         
/* 541 */         TEFile f = new TEFile();
/* 542 */         f.setFileName(filename);
/* 543 */         f.setFilePath("/SocietySecurityEvent/video/");
/* 544 */         f.setFileSuffix(extension);
/* 545 */         flag = this.teFileMapper.insert(f) != 0;
/* 546 */         Long fileID = f.getFileID();
/* 547 */         SecurityEventVideoFile videoFile = new SecurityEventVideoFile();
/* 548 */         videoFile.setSSEventID(id);
/* 549 */         videoFile.setFileID(fileID);
/* 550 */         flag = this.securityEventVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (Exception ex) {
/* 552 */         ex.printStackTrace();
/*     */       }
/*     */     } else {
/* 555 */       flag = true;
/*     */     }
/* 557 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public Long addNetGridEvent(NetGridEventAPPUploadVO uploadVO)
/*     */   {
/* 564 */     NetGridEvent event = new NetGridEvent();
/* 565 */     event.setEventName(uploadVO.getEventName());
/* 566 */     event.setEventKind(uploadVO.getEventKind());
/* 567 */     event.setEventTypeValue(uploadVO.getEventTypeValue());
/* 568 */     event.setEventContent(uploadVO.getEventContent());
/*     */     try {
/* 570 */       event.setEventStartDateTime(DateUtil.strToDateTime(uploadVO.getEventStartDateTime()));
/*     */     } catch (ParseException e) {
/* 572 */       e.printStackTrace();
/*     */     }
/* 574 */     event.setEventHappenLongitude(uploadVO.getEventHappenLongitude());
/* 575 */     event.setEventHappenLatitude(uploadVO.getEventHappenLatitude());
/* 576 */     event.setEventStatusTypeValue(uploadVO.getEventStatusTypeValue());
/* 577 */     event.setCurrentRemarks(uploadVO.getCurrentRemarks());
/* 578 */     event.setCurrentResponsiblePersonCertID(uploadVO.getCurrentResponsiblePersonCertID());
/* 579 */     event.setNetGridID(uploadVO.getNetGridID());
/* 580 */     boolean flag = this.netGridEventMapper.insert(event) != 0;
/* 581 */     if (flag) {
/* 582 */       Long ID = event.getEventID();
/* 583 */       List<com.jtzh.entity.NetGridEventInvolvedPersons> persons = uploadVO.getInvolvedPersons();
/* 584 */       for (com.jtzh.entity.NetGridEventInvolvedPersons person : persons) {
/* 585 */         person.setEventID(ID);
/* 586 */         flag = this.netGridEventInvolvedPersonsMapper.insert(person) != 0;
/* 587 */         if (!flag)
/*     */           break;
/*     */       }
/* 590 */       if (flag)
/* 591 */         return ID;
/* 592 */       return null;
/*     */     }
/* 594 */     return null;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean addNetGridEventMedia(MultipartFile[] pictures, MultipartFile video, Long id)
/*     */   {
/* 600 */     boolean flag = false;
/* 601 */     String root_path = getRootPath();
/* 602 */     if (pictures.length > 0) {
/* 603 */       for (int i = 0; i < pictures.length; i++) {
/* 604 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 605 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 607 */           String originFileName = pictures[i].getOriginalFilename();
/* 608 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 611 */           File outPath = new File(root_path + "/NetGrid/Event/" + "Picture/");
/* 612 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 613 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 617 */           File outFile = new File(root_path + "/NetGrid/Event/" + "Picture/" + filename + extension);
/*     */           try
/*     */           {
/* 620 */             pictures[i].transferTo(outFile);
/*     */             
/* 622 */             Picture p = new Picture();
/* 623 */             p.setPictureName(filename);
/* 624 */             p.setPicturePath("/NetGrid/Event/Picture/");
/* 625 */             p.setPictureSuffix(extension);
/* 626 */             flag = this.pictureMapper.insert(p) != 0;
/* 627 */             Long pictureID = p.getPictureID();
/* 628 */             NetGridEventPicture picture = new NetGridEventPicture();
/* 629 */             picture.setEventID(id);
/* 630 */             picture.setPictureID(pictureID);
/* 631 */             flag = this.netGridEventPictureMapper.insert(picture) != 0;
/*     */           } catch (Exception ex) {
/* 633 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 638 */       flag = true;
/*     */     }
/* 640 */     if ((video != null) && (!video.isEmpty())) {
/* 641 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 643 */       String originFileName = video.getOriginalFilename();
/* 644 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 647 */       File outPath = new File(root_path + "/NetGrid/Event/" + "Video/");
/* 648 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 649 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 653 */       File outFile = new File(root_path + "/NetGrid/Event/" + "Video/" + filename + extension);
/*     */       try
/*     */       {
/* 656 */         video.transferTo(outFile);
/*     */         
/* 658 */         TEFile f = new TEFile();
/* 659 */         f.setFileName(filename);
/* 660 */         f.setFilePath("/NetGrid/Event/Video/");
/* 661 */         f.setFileSuffix(extension);
/* 662 */         flag = this.teFileMapper.insert(f) != 0;
/* 663 */         Long fileID = f.getFileID();
/* 664 */         NetGridEventVideoFile videoFile = new NetGridEventVideoFile();
/* 665 */         videoFile.setEventID(id);
/* 666 */         videoFile.setFileID(fileID);
/* 667 */         flag = this.netGridEventVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (Exception ex) {
/* 669 */         ex.printStackTrace();
/*     */       }
/*     */     } else {
/* 672 */       flag = true;
/*     */     }
/* 674 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public Long addSPEvent(SPEventAPPUploadVO uploadVO)
/*     */   {
/* 681 */     SkynetPatrolEvent event = new SkynetPatrolEvent();
/* 682 */     event.setSpEventName(uploadVO.getSpEventName());
/* 683 */     event.setSpEventKind(uploadVO.getSpEventKind());
/* 684 */     event.setSpEventTypeValue(uploadVO.getSpEventTypeValue());
/* 685 */     event.setSpEventContent(uploadVO.getSpEventContent());
/*     */     try {
/* 687 */       event.setSpEventStartDateTime(DateUtil.strToDateTime(uploadVO.getSpEventStartDateTime()));
/*     */     } catch (ParseException e) {
/* 689 */       e.printStackTrace();
/*     */     }
/* 691 */     event.setSpEventHappenLongitude(uploadVO.getSpEventHappenLongitude());
/* 692 */     event.setSpEventHappenLatitude(uploadVO.getSpEventHappenLatitude());
/* 693 */     event.setSpEventStatusTypeValue(uploadVO.getSpEventStatusTypeValue());
/* 694 */     event.setCurrentRemarks(uploadVO.getCurrentRemarks());
/* 695 */     event.setCurrentResponsiblePersonCertID(uploadVO.getCurrentResponsiblePersonCertID());
/* 696 */     event.setNetGridID(uploadVO.getNetGridID());
/* 697 */     boolean flag = this.skynetPatrolEventMapper.insert(event) != 0;
/* 698 */     if (flag) {
/* 699 */       Long ID = event.getSpEventID();
/* 700 */       List<com.jtzh.entity.SkynetPatrolEventInvolvedPersons> persons = uploadVO.getInvolvedPersons();
/* 701 */       for (com.jtzh.entity.SkynetPatrolEventInvolvedPersons person : persons) {
/* 702 */         person.setSpEventID(ID);
/* 703 */         flag = this.skynetPatrolEventInvolvedPersonsMapper.insert(person) != 0;
/* 704 */         if (!flag)
/*     */           break;
/*     */       }
/* 707 */       if (flag)
/* 708 */         return ID;
/* 709 */       return null;
/*     */     }
/* 711 */     return null;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean addSPEventMedia(MultipartFile[] pictures, MultipartFile video, Long id)
/*     */   {
/* 717 */     boolean flag = false;
/* 718 */     String root_path = getRootPath();
/* 719 */     if (pictures.length > 0) {
/* 720 */       for (int i = 0; i < pictures.length; i++) {
/* 721 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 722 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 724 */           String originFileName = pictures[i].getOriginalFilename();
/* 725 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 728 */           File outPath = new File(root_path + "/SkynetPatrolEvent/" + "picture/");
/* 729 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 730 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 734 */           File outFile = new File(root_path + "/SkynetPatrolEvent/" + "picture/" + filename + extension);
/*     */           try
/*     */           {
/* 737 */             pictures[i].transferTo(outFile);
/*     */             
/* 739 */             Picture p = new Picture();
/* 740 */             p.setPictureName(filename);
/* 741 */             p.setPicturePath("/SkynetPatrolEvent/picture/");
/* 742 */             p.setPictureSuffix(extension);
/* 743 */             flag = this.pictureMapper.insert(p) != 0;
/* 744 */             Long pictureID = p.getPictureID();
/* 745 */             com.jtzh.entity.SkynetPatrolEventPicture picture = new com.jtzh.entity.SkynetPatrolEventPicture();
/* 746 */             picture.setSPEventID(id);
/* 747 */             picture.setPictureID(pictureID);
/* 748 */             flag = this.skynetPatrolEventPictureMapper.insert(picture) != 0;
/*     */           } catch (Exception ex) {
/* 750 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 755 */       flag = true;
/*     */     }
/* 757 */     if ((video != null) && (!video.isEmpty())) {
/* 758 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 760 */       String originFileName = video.getOriginalFilename();
/* 761 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 764 */       File outPath = new File(root_path + "/SkynetPatrolEvent/" + "video/");
/* 765 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 766 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 770 */       File outFile = new File(root_path + "/SkynetPatrolEvent/" + "video/" + filename + extension);
/*     */       try
/*     */       {
/* 773 */         video.transferTo(outFile);
/*     */         
/* 775 */         TEFile f = new TEFile();
/* 776 */         f.setFileName(filename);
/* 777 */         f.setFilePath("/SkynetPatrolEvent/video/");
/* 778 */         f.setFileSuffix(extension);
/* 779 */         flag = this.teFileMapper.insert(f) != 0;
/* 780 */         Long fileID = f.getFileID();
/* 781 */         com.jtzh.entity.SkynetPatrolEventVideoFile videoFile = new com.jtzh.entity.SkynetPatrolEventVideoFile();
/* 782 */         videoFile.setSPEventID(id);
/* 783 */         videoFile.setFileID(fileID);
/* 784 */         flag = this.skynetPatrolEventVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (Exception ex) {
/* 786 */         ex.printStackTrace();
/*     */       }
/*     */     } else {
/* 789 */       flag = true;
/*     */     }
/* 791 */     return flag;
/*     */   }
/*     */   
/*     */   private String getRootPath() {
/* 795 */     Properties prop = new Properties();
///* 796 */     java.io.InputStream in = getClass().getResourceAsStream("/common.properties");
///*     */     try {
///* 798 */       prop.load(in);
///*     */     } catch (java.io.IOException e) {
///* 800 */       e.printStackTrace();
///*     */     }
///* 802 */     String root_path = prop.getProperty("msmis.file");
/* 803 */     return Constants.ROOT_PATH;
/*     */   }
/*     */   
/*        public int insertData()
        {
 808      int result = 0;
 809      int[] a = com.jtzh.test.RandomValue.randomCommon(1, 1410, 1409);
 810      int[] b = com.gbt.test.RandomValue.randomCommon(1, 1410, 1409);
 811      for (int i = 0; i < b.length; i++) {
 812        PersonHouse p = new PersonHouse();
 813        p.setHouseID(Long.valueOf(b[i]));
 814        p.setServedPersonID(Long.valueOf(a[i]));
 815        result = this.personHouseMapper.insert(p);
          }
 817      return result;
        }*/
/*     */   
/*     */ 
/*     */   public com.jtzh.vo.app.UserVO APPLogin(String usename, String password)
/*     */   {
/* 823 */     return this.userMapper.checkLogin(usename);
/*     */   }
/*     */   
/*     */ 
/*     */   public com.jtzh.entity.APPVersion getAPPVersionInfo()
/*     */   {
/* 829 */     return this.appVersionMapper.getAPPVersion();
/*     */   }
/*     */
@Override
public int insertData() {
	// TODO Auto-generated method stub
	return 0;
}

	@Transactional
	public boolean addRealTimeLocation(RealTimeLocation location)
	{

        User user = userMapper.selectByPrimaryKey(location.getUserID());
        if (user != null){
            String netGirdName = replaceChar(user.getRealName());
            Long netGirdId = user.getNetGridID();
            NetGrid netGrid = netGridMapper.getNetGridFaterIdAndChildName(netGirdId,netGirdName);
            location.setUserID(netGrid.getNetGridID());
            RealTimeLocation realTimeLocation = realTimeLocationMapper.selectByPrimaryKey(location.getUserID(),"");
            location.setMoment(new Date());
            if (realTimeLocation != null){
                location.setID(realTimeLocation.getID());
                boolean flag = this.realTimeLocationMapper.updateByPrimaryKey(location) != 0;
                return flag;
            }
            boolean flag = this.realTimeLocationMapper.addRealTimeLocation(location) != 0;
            return flag;
        }else {
            Userinformation userinformation = userinformationMapper.selectByPrimaryKey(Integer.valueOf(location.getUserID().toString()));
            location.setUserID(Long.valueOf(userinformation.getId()));
            location.setType("1");
            location.setMoment(new Date());
            location.setType("1");
            RealTimeLocation realTimeLocation = realTimeLocationMapper.selectByPrimaryKey(location.getUserID(),"1");
            if (realTimeLocation != null){
                location.setID(realTimeLocation.getID());
                boolean flag = this.realTimeLocationMapper.updateByPrimaryKey(location) != 0;
                return flag;
            }

            boolean flag = this.realTimeLocationMapper.addRealTimeLocation(location) != 0;
            return flag;
        }
	}

	private String replaceChar(String str){
        str.replace("一","1");
        str.replace("二","2");
        str.replace("三","3");
        str.replace("四","4");
        str.replace("五","5");
        str.replace("六","6");
        str.replace("七","7");
        str.replace("八","8");
        str.replace("九","9");
        str.replace("十","0");
        return str;
    }
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\APPServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */