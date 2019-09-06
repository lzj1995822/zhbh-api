/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.app.EventDealingPictureVO;
import com.jtzh.vo.app.EventDealingVideoVO;
/*     */ import com.jtzh.vo.dispute.DisputeEventCountVO;
/*     */ import com.jtzh.vo.dispute.DisputeEventQueryResponseVO;
/*     */ import com.jtzh.vo.dispute.DisputeEventVO;
/*     */ import com.jtzh.vo.ss.FileUpdateVO;
import com.jtzh.entity.DisputeDealingPicture;
import com.jtzh.entity.DisputeEventDealingVideoFile;
import com.jtzh.entity.DisputeEventPicture;
import com.jtzh.entity.Picture;
import com.jtzh.entity.TEFile;
import com.jtzh.mapper.DisputeEventMapper;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.TEFileMapper;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class DisputeEventServiceImpl implements com.jtzh.service.DisputeEventService
/*     */ {
/*     */   @Autowired
/*     */   private DisputeEventMapper disputeEventMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private TEFileMapper teFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventPictureMapper disputeEventPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventVideoFileMapper disputeEventVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventInvolvedPersonsMapper disputeEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventDealingMapper disputeEventDealingMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventDistributeMapper disputeEventDistributeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventCheckedMapper disputeEventCheckedMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeDealingPictureMapper disputeDealingPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.DisputeEventDealingVideoFileMapper disputeEventDealingVideoFileMapper;
/*     */   private static final String DISPUTEEVENTPICTURE_PATH = "/DisputeEvent/picture/";
/*     */   private static final String DISPUTEEVENTVIDEO_PATH = "/DisputeEvent/video/";
/*     */   private static final String DISPUTEEVENTDEALINGPICTURE_PATH = "/DisputeEvent/DealingPicture/";
/*     */   private static final String DISPUTEEVENTDEALINGVIDEO_PATH = "/DisputeEvent/DealingVideo/";
/*     */   
/*     */   public DisputeEventQueryResponseVO getDisputeEventReporterQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/*  60 */     int start = 0;
/*  61 */     if (page > 1)
/*  62 */       start = (page - 1) * pageSize;
/*  63 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventReporterQuery(id, eventName, eventTypeValue, netGridID, status, start, pageSize);
/*     */     
/*  65 */     int count = this.disputeEventMapper.getDisputeEventReporterQueryCount(id, eventName, eventTypeValue, netGridID, status);
/*  66 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  67 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/*  68 */     vo.setDisputeEvents(disputeEvents);
/*  69 */     vo.setPage(p);
/*  70 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DisputeEventQueryResponseVO getDisputeEventDespatcherQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/*  77 */     int start = 0;
/*  78 */     if (page > 1)
/*  79 */       start = (page - 1) * pageSize;
/*  80 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventDespatcherQuery(id, eventName, eventTypeValue, netGridID, start, pageSize);
/*     */     
/*  82 */     int count = this.disputeEventMapper.getDisputeEventDespatcherQueryCount(id, eventName, eventTypeValue, netGridID);
/*  83 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  84 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/*  85 */     vo.setDisputeEvents(disputeEvents);
/*  86 */     vo.setPage(p);
/*  87 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DisputeEventQueryResponseVO getDisputeEventDeptDespatcherQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/*  94 */     int start = 0;
/*  95 */     if (page > 1)
/*  96 */       start = (page - 1) * pageSize;
/*  97 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventDeptDespatcherQuery(id, eventName, eventTypeValue, netGridID, start, pageSize);
/*     */     
/*  99 */     int count = this.disputeEventMapper.getDisputeEventDeptDespatcherQueryCount(id, eventName, eventTypeValue, netGridID);
/* 100 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 101 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/* 102 */     vo.setDisputeEvents(disputeEvents);
/* 103 */     vo.setPage(p);
/* 104 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DisputeEventQueryResponseVO getDisputeEventHandlerQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 111 */     int start = 0;
/* 112 */     if (page > 1)
/* 113 */       start = (page - 1) * pageSize;
/* 114 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventHandlerQuery(id, eventName, eventTypeValue, netGridID, start, pageSize);
/*     */     
/* 116 */     int count = this.disputeEventMapper.getDisputeEventHandlerQueryCount(id, eventName, eventTypeValue, netGridID);
/* 117 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 118 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/* 119 */     vo.setDisputeEvents(disputeEvents);
/* 120 */     vo.setPage(p);
/* 121 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public DisputeEventQueryResponseVO getDisputeEventAPPQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 127 */     int start = 0;
/* 128 */     if (page > 1)
/* 129 */       start = (page - 1) * pageSize;
/* 130 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventAPPQuery(id, eventName, eventTypeValue, netGridID, start, pageSize);
/*     */     
/* 132 */     int count = this.disputeEventMapper.getDisputeEventAPPQueryCount(id, eventName, eventTypeValue, netGridID);
/* 133 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 134 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/* 135 */     vo.setDisputeEvents(disputeEvents);
/* 136 */     vo.setPage(p);
/* 137 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DisputeEventQueryResponseVO getDisputeEventAuditorQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 144 */     int start = 0;
/* 145 */     if (page > 1)
/* 146 */       start = (page - 1) * pageSize;
/* 147 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventAuditorQuery(id, eventName, eventTypeValue, netGridID, start, pageSize);
/*     */     
/* 149 */     int count = this.disputeEventMapper.getDisputeEventAuditorQueryCount(id, eventName, eventTypeValue, netGridID);
/* 150 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 151 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/* 152 */     vo.setDisputeEvents(disputeEvents);
/* 153 */     vo.setPage(p);
/* 154 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public DisputeEventQueryResponseVO getDisputeEventForNetGrid(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 161 */     int start = 0;
/* 162 */     if (page > 1)
/* 163 */       start = (page - 1) * pageSize;
/* 164 */     List<DisputeEventVO> disputeEvents = this.disputeEventMapper.getDisputeEventForNetGrid(id, eventName, eventTypeValue, netGridID, start, pageSize);
/*     */     
/* 166 */     int count = this.disputeEventMapper.getDisputeEventForNetGridCount(id, eventName, eventTypeValue, netGridID);
/* 167 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 168 */     DisputeEventQueryResponseVO vo = new DisputeEventQueryResponseVO();
/* 169 */     vo.setDisputeEvents(disputeEvents);
/* 170 */     vo.setPage(p);
/* 171 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public HashMap getDisputeEventDetail(Long disputeEventID)
/*     */   {
/* 177 */     com.jtzh.vo.dispute.DisputeEventDetailVO disputeEventBasic = this.disputeEventMapper.selectByPrimaryKey(disputeEventID);
/* 178 */     List<com.jtzh.entity.DisputeEventInvolvedPersons> involvedPersons = this.disputeEventInvolvedPersonsMapper.selectByEventID(disputeEventID);
/* 179 */     List<com.jtzh.vo.dispute.DisputeEventDistributeVO> distributeVOS = this.disputeEventDistributeMapper.selectByEventID(disputeEventID);
/* 180 */     List<com.jtzh.vo.dispute.DisputeEventDealingVO> dealingVOS = this.disputeEventDealingMapper.selectByEventID(disputeEventID);
/* 181 */     List<com.jtzh.vo.dispute.DisputeEventCheckedVO> checkedVOS = this.disputeEventCheckedMapper.selectByEventID(disputeEventID);
/* 182 */     HashMap map = new HashMap();
/* 183 */     map.put("disputeEventsBasic", disputeEventBasic);
/* 184 */     map.put("disputeEventsMedia", getDisputeEventMedia(disputeEventID));
/* 185 */     map.put("involvedPersons", involvedPersons);
/* 186 */     map.put("distributeBasic", distributeVOS);
/* 187 */     map.put("dealingBasic", dealingVOS);
/* 188 */     map.put("dealingMedia", getDisputeEventDealingMedia(disputeEventID));
/* 189 */     map.put("checked", checkedVOS);
/* 190 */     return map;
/*     */   }
/*     */   
/*     */   public HashMap getDisputeEventDetailForAPP(Long disputeEventID)
/*     */   {
/* 195 */     com.jtzh.vo.dispute.DisputeEventDetailVO disputeEventBasic = this.disputeEventMapper.selectByPrimaryKey(disputeEventID);
/* 196 */     List<com.jtzh.entity.DisputeEventInvolvedPersons> involvedPersons = this.disputeEventInvolvedPersonsMapper.selectByEventID(disputeEventID);
/* 197 */     List<com.jtzh.vo.dispute.DisputeEventDistributeVO> distributeVOS = this.disputeEventDistributeMapper.selectByEventID(disputeEventID);
/* 198 */     List<com.jtzh.vo.dispute.DisputeEventDealingVO> dealingVOS = this.disputeEventDealingMapper.selectByEventID(disputeEventID);
/* 199 */     List<com.jtzh.vo.dispute.DisputeEventCheckedVO> checkedVOS = this.disputeEventCheckedMapper.selectByEventID(disputeEventID);
/* 200 */     HashMap map = new HashMap();
/* 201 */     map.put("disputeEventsBasic", disputeEventBasic);
/* 202 */     map.put("disputeEventsMedia", getDisputeEventMedia(disputeEventID));
/* 203 */     map.put("involvedPersons", involvedPersons);
/* 204 */     map.put("distributeBasic", distributeVOS);
/* 205 */     map.put("dealingBasic", dealingVOS);
/* 206 */     map.put("dealingMedia", getDisputeEventDealingMediaForAPP(disputeEventID));
/* 207 */     map.put("checked", checkedVOS);
/* 208 */     return map;
/*     */   }
/*     */   
/*     */   public Long insertDisputeEvent(com.jtzh.entity.DisputeEvent disputeEvent)
/*     */   {
/* 213 */     boolean flag = this.disputeEventMapper.insert(disputeEvent) != 0;
/* 214 */     if (flag)
/* 215 */       return disputeEvent.getDisputeEventID();
/* 216 */     return null;
/*     */   }
/*     */   
/*     */   public boolean updateDisputeEvent(com.jtzh.entity.DisputeEvent disputeEvent)
/*     */   {
/* 221 */     return this.disputeEventMapper.updateByPrimaryKey(disputeEvent) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteDisputeEvent(Long id)
/*     */   {
/* 226 */     if (deleteDisputeEventMedia(id)) {
/* 227 */       return this.disputeEventMapper.deleteByPrimaryKey(id) != 0;
/*     */     }
/* 229 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public List getDisputeEventCount()
/*     */   {
/* 235 */     List<DisputeEventCountVO> list = this.disputeEventMapper.getDisputeEventCount(null, null);
/* 236 */     List l = new ArrayList();
/* 237 */     int len = list.size();
/* 238 */     String[] names = new String[len];
/* 239 */     int[] solved = new int[len];
/* 240 */     int[] unsolved = new int[len];
/* 241 */     for (int i = 0; i < len; i++) {
/* 242 */       names[i] = ((DisputeEventCountVO)list.get(i)).getName();
/* 243 */       solved[i] = ((DisputeEventCountVO)list.get(i)).getSolved();
/* 244 */       unsolved[i] = ((DisputeEventCountVO)list.get(i)).getUnsolved();
/*     */     }
/* 246 */     l.add(names);
/* 247 */     l.add(solved);
/* 248 */     l.add(unsolved);
/* 249 */     return l;
/*     */   }
/*     */   
/*     */   public com.jtzh.entity.DisputeEvent getDisputeBasicDetailToUpdate(Long id)
/*     */   {
/* 254 */     return this.disputeEventMapper.selectByDisputeEventID(id);
/*     */   }
/*     */   
/*     */   public boolean addDisputeEventPictures(MultipartFile file, Long ID)
/*     */   {
/* 259 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 260 */     if ((file != null) && (!file.isEmpty())) {
/* 261 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 263 */       String originFileName = file.getOriginalFilename();
/* 264 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 267 */       File outPath = new File(root_path + "/DisputeEvent/picture/");
/* 268 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 269 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 273 */       File outFile = new File(root_path + "/DisputeEvent/picture/" + filename + extension);
/*     */       try
/*     */       {
/* 276 */         file.transferTo(outFile);
/*     */         
/* 278 */         Picture p = new Picture();
/* 279 */         p.setPictureName(filename);
/* 280 */         p.setPictureSuffix(extension);
/* 281 */         p.setPicturePath("/DisputeEvent/picture/");
/* 282 */         this.pictureMapper.insert(p);
/* 283 */         Long pictureID = p.getPictureID();
/* 284 */         DisputeEventPicture picture = new DisputeEventPicture();
/* 285 */         picture.setDisputeEventID(ID);
/* 286 */         picture.setPictureID(pictureID);
/* 287 */         return this.disputeEventPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 289 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 292 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addDisputeEventVideo(MultipartFile file, Long ID)
/*     */   {
/* 297 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 298 */     if ((file != null) && (!file.isEmpty())) {
/* 299 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 301 */       String originFileName = file.getOriginalFilename();
/* 302 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 305 */       File outPath = new File(root_path + "/DisputeEvent/video/");
/* 306 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 307 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 311 */       File outFile = new File(root_path + "/DisputeEvent/video/" + filename + extension);
/*     */       try
/*     */       {
/* 314 */         file.transferTo(outFile);
/*     */         
/* 316 */         TEFile f = new TEFile();
/* 317 */         f.setFileName(filename);
/* 318 */         f.setFilePath("/DisputeEvent/video/");
/* 319 */         f.setFileSuffix(extension);
/* 320 */         this.teFileMapper.insert(f);
/* 321 */         Long fileID = f.getFileID();
/* 322 */         com.jtzh.entity.DisputeEventVideoFile videoFile = new com.jtzh.entity.DisputeEventVideoFile();
/* 323 */         videoFile.setDisputeEventID(ID);
/* 324 */         videoFile.setFileID(fileID);
/* 325 */         return this.disputeEventVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 327 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 330 */     return false;
/*     */   }
/*     */   
/*     */   private Map getDisputeEventMedia(Long id) {
/* 334 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 335 */     List<Picture> pictures = this.pictureMapper.selectByDisputeEventID(id);
/* 336 */     List picturePaths = new ArrayList();
/* 337 */     List videoPaths = new ArrayList();
/* 338 */     if (pictures.size() > 0) {
/* 339 */       for (Picture p : pictures) {
/* 340 */         FileUpdateVO vo = new FileUpdateVO();
/* 341 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 342 */         vo.setId(p.getPictureID());
/* 343 */         vo.setUrl(path);
/* 344 */         picturePaths.add(vo);
/*     */       }
/*     */     }
/* 347 */     TEFile file = this.teFileMapper.selectByDisputeEventID(id);
/* 348 */     String videoPath = null;
/* 349 */     if (file != null) {
/* 350 */       videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 351 */       FileUpdateVO vo = new FileUpdateVO();
/* 352 */       vo.setId(file.getFileID());
/* 353 */       vo.setUrl(videoPath);
/* 354 */       videoPaths.add(vo);
/*     */     }
/* 356 */     Map map = new HashMap();
/* 357 */     map.put("pictures", picturePaths);
/* 358 */     map.put("video", videoPaths);
/* 359 */     return map;
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
/*     */   private boolean deleteDisputeEventMedia(Long id)
/*     */   {
/* 372 */     boolean flag = false;
/* 373 */     String rootPath = CommonUtils.getRootPath("msmis.file");
/* 374 */     List<DisputeEventPicture> dep = this.disputeEventPictureMapper.selectByDisputeEventID(id);
/* 375 */     if (dep.size() > 0) {
/* 376 */       for (DisputeEventPicture image : dep) {
/* 377 */         Picture p = this.pictureMapper.selectByPrimaryKey(image.getPictureID());
/* 378 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 379 */         if (CommonUtils.deleteFile(path)) {
/* 380 */           flag = this.disputeEventPictureMapper.deleteByPictureID(image.getPictureID()) != 0;
/*     */         } else {
/* 382 */           flag = false;
/* 383 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/* 387 */       flag = true;
/*     */     }
/* 389 */     if (flag) {
/*     */       com.jtzh.entity.DisputeEventVideoFile videoFile;
/* 391 */       if ((videoFile = this.disputeEventVideoFileMapper.selectByDisputeEventID(id)) != null) {
/* 392 */         TEFile f = this.teFileMapper.selectByPrimaryKey(videoFile.getFileID());
/* 393 */         String file = rootPath + f.getFilePath() + f.getFileName() + f.getFileSuffix();
/* 394 */         if (CommonUtils.deleteFile(file)) {
/* 395 */           flag = this.disputeEventVideoFileMapper.deleteByFileID(videoFile.getFileID()) != 0;
/*     */         } else {
/* 397 */           flag = false;
/*     */         }
/*     */       } else {
/* 400 */         flag = true;
/*     */       }
/*     */     }
/* 403 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addDisputeEventInvolvedPersons(com.jtzh.entity.DisputeEventInvolvedPersons persons)
/*     */   {
/* 409 */     return this.disputeEventInvolvedPersonsMapper.insert(persons) != 0;
/*     */   }
/*     */   
/*     */   public Long addDisputeEventDealing(com.jtzh.entity.DisputeEventDealing dealing)
/*     */   {
/* 414 */     boolean flag = this.disputeEventDealingMapper.insert(dealing) != 0;
/* 415 */     if (flag)
/* 416 */       return dealing.getEventDealingID();
/* 417 */     return null;
/*     */   }
/*     */   
/*     */   public boolean addDisputeEventChecked(com.jtzh.entity.DisputeEventChecked checked)
/*     */   {
/* 422 */     return this.disputeEventCheckedMapper.insert(checked) != 0;
/*     */   }
/*     */   
/*     */   public boolean addDisputeEventDistribute(com.jtzh.entity.DisputeEventDistribute distribute)
/*     */   {
/* 427 */     return this.disputeEventDistributeMapper.insert(distribute) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addDisputeEventDealingPictures(MultipartFile file, Long ID)
/*     */   {
/* 433 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 434 */     if ((file != null) && (!file.isEmpty())) {
/* 435 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 437 */       String originFileName = file.getOriginalFilename();
/* 438 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 441 */       File outPath = new File(root_path + "/DisputeEvent/DealingPicture/");
/* 442 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 443 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 447 */       File outFile = new File(root_path + "/DisputeEvent/DealingPicture/" + filename + extension);
/*     */       try
/*     */       {
/* 450 */         file.transferTo(outFile);
/*     */         
/* 452 */         Picture p = new Picture();
/* 453 */         p.setPictureName(filename);
/* 454 */         p.setPictureSuffix(extension);
/* 455 */         p.setPicturePath("/DisputeEvent/DealingPicture/");
/* 456 */         this.pictureMapper.insert(p);
/* 457 */         Long pictureID = p.getPictureID();
/* 458 */         DisputeDealingPicture picture = new DisputeDealingPicture();
/* 459 */         picture.setEventDealingID(ID);
/* 460 */         picture.setPictureID(pictureID);
/* 461 */         return this.disputeDealingPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 463 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 466 */     return false;
/*     */   }
/*     */   
/*     */   private boolean addDisputeEventDealingPictures(MultipartFile[] file, Long ID)
/*     */   {
/* 471 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 472 */     if (file.length > 0) {
/* 473 */       for (int i = 0; i < file.length; i++) {
/* 474 */         if ((file[i] != null) && (!file[i].isEmpty())) {
/* 475 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 477 */           String originFileName = file[i].getOriginalFilename();
/* 478 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 481 */           File outPath = new File(root_path + "/DisputeEvent/DealingPicture/");
/* 482 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 483 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 487 */           File outFile = new File(root_path + "/DisputeEvent/DealingPicture/" + filename + extension);
/*     */           try
/*     */           {
/* 490 */             file[i].transferTo(outFile);
/*     */             
/* 492 */             Picture p = new Picture();
/* 493 */             p.setPictureName(filename);
/* 494 */             p.setPictureSuffix(extension);
/* 495 */             p.setPicturePath("/DisputeEvent/DealingPicture/");
/* 496 */             this.pictureMapper.insert(p);
/* 497 */             Long pictureID = p.getPictureID();
/* 498 */             DisputeDealingPicture picture = new DisputeDealingPicture();
/* 499 */             picture.setEventDealingID(ID);
/* 500 */             picture.setPictureID(pictureID);
/* 501 */             return this.disputeDealingPictureMapper.insert(picture) != 0;
/*     */           } catch (IOException e) {
/* 503 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 508 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addDisputeEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 513 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 514 */     if ((file != null) && (!file.isEmpty())) {
/* 515 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 517 */       String originFileName = file.getOriginalFilename();
/* 518 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 521 */       File outPath = new File(root_path + "/DisputeEvent/DealingVideo/");
/* 522 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 523 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 527 */       File outFile = new File(root_path + "/DisputeEvent/DealingVideo/" + filename + extension);
/*     */       try
/*     */       {
/* 530 */         file.transferTo(outFile);
/*     */         
/* 532 */         TEFile f = new TEFile();
/* 533 */         f.setFileName(filename);
/* 534 */         f.setFilePath("/DisputeEvent/DealingVideo/");
/* 535 */         f.setFileSuffix(extension);
/* 536 */         this.teFileMapper.insert(f);
/* 537 */         Long fileID = f.getFileID();
/* 538 */         DisputeEventDealingVideoFile videoFile = new DisputeEventDealingVideoFile();
/* 539 */         videoFile.setEventDealingID(ID);
/* 540 */         videoFile.setFileID(fileID);
/* 541 */         return this.disputeEventDealingVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 543 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 546 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean uploadDisputeEventDealingMedia(MultipartFile[] pictures, MultipartFile video, Long id)
/*     */   {
/* 552 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 553 */     int flag = 0;
/* 554 */     if (pictures.length > 0) {
/* 555 */       for (int i = 0; i < pictures.length; i++) {
/* 556 */         if ((pictures[i] != null) && (!pictures[i].isEmpty())) {
/* 557 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 559 */           String originFileName = pictures[i].getOriginalFilename();
/* 560 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 563 */           File outPath = new File(root_path + "/DisputeEvent/DealingPicture/");
/* 564 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 565 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 569 */           File outFile = new File(root_path + "/DisputeEvent/DealingPicture/" + filename + extension);
/*     */           try
/*     */           {
/* 572 */             pictures[i].transferTo(outFile);
/*     */             
/* 574 */             Picture p = new Picture();
/* 575 */             p.setPictureName(filename);
/* 576 */             p.setPicturePath("/DisputeEvent/DealingPicture/");
/* 577 */             p.setPictureSuffix(extension);
/* 578 */             flag = this.pictureMapper.insert(p);
/* 579 */             Long pictureID = p.getPictureID();
/* 580 */             DisputeDealingPicture picture = new DisputeDealingPicture();
/* 581 */             picture.setEventDealingID(id);
/* 582 */             picture.setPictureID(pictureID);
/* 583 */             flag = this.disputeDealingPictureMapper.insert(picture);
/*     */           } catch (Exception ex) {
/* 585 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 590 */     if ((video != null) && (!video.isEmpty())) {
/* 591 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 593 */       String originFileName = video.getOriginalFilename();
/* 594 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 597 */       File outPath = new File(root_path + "/DisputeEvent/DealingVideo/");
/* 598 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 599 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 603 */       File outFile = new File(root_path + "/DisputeEvent/DealingVideo/" + filename + extension);
/*     */       try
/*     */       {
/* 606 */         video.transferTo(outFile);
/*     */         
/* 608 */         TEFile f = new TEFile();
/* 609 */         f.setFileName(filename);
/* 610 */         f.setFilePath("/DisputeEvent/DealingVideo/");
/* 611 */         f.setFileSuffix(extension);
/* 612 */         flag = this.teFileMapper.insert(f);
/* 613 */         Long fileID = f.getFileID();
/* 614 */         DisputeEventDealingVideoFile videoFile = new DisputeEventDealingVideoFile();
/* 615 */         videoFile.setEventDealingID(id);
/* 616 */         videoFile.setFileID(fileID);
/* 617 */         flag = this.disputeEventDealingVideoFileMapper.insert(videoFile);
/*     */       } catch (Exception ex) {
/* 619 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 622 */     return flag != 0;
/*     */   }
/*     */   
/*     */   private Map getDisputeEventDealingMedia(Long id)
/*     */   {
/* 627 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 628 */     List<Picture> pictures = this.pictureMapper.selectDisputeEventDealingPictureByEventID(id);
/* 629 */     List picturePaths = new ArrayList();
/* 630 */     List videoPaths = new ArrayList();
				Picture p = new Picture();
/* 631 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 632 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (Picture)localIterator.next();
/* 633 */         FileUpdateVO vo = new FileUpdateVO();
/* 634 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 635 */         vo.setId(p.getPictureID());
/* 636 */         vo.setUrl(path);
/* 637 */         picturePaths.add(vo);
/*     */       }
/*     */     
/* 640 */     List<TEFile> files = this.teFileMapper.selectDisputeEventDealingFileByEventID(id);
/* 641 */     if (files.size() > 0) {
/* 642 */       for (TEFile file : files) {
/* 643 */         String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 644 */         FileUpdateVO vo = new FileUpdateVO();
/* 645 */         vo.setId(file.getFileID());
/* 646 */         vo.setUrl(videoPath);
/* 647 */         videoPaths.add(vo);
/*     */       }
/*     */     }
/* 650 */     Map map = new HashMap();
/* 651 */     map.put("pictures", picturePaths);
/* 652 */     map.put("video", videoPaths);
/* 653 */     return map;
/*     */   }
/*     */   
/*     */   private Map getDisputeEventDealingMediaForAPP(Long id) {
/* 657 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 658 */     List<EventDealingPictureVO> pictures = this.pictureMapper.selectDisputeEventDealingPictureForAPP(id);
/* 659 */     List picturePaths = new ArrayList();
/* 660 */     List videoPaths = new ArrayList();
			  EventDealingPictureVO p = new EventDealingPictureVO();
/* 661 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 662 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (EventDealingPictureVO)localIterator.next();
/* 663 */         FileUpdateVO vo = new FileUpdateVO();
/* 664 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 665 */         vo.setId(p.getEventDealingID());
/* 666 */         vo.setUrl(path);
/* 667 */         picturePaths.add(vo);
/*     */       }
/* 670 */     List<EventDealingVideoVO> files = this.teFileMapper.selectDisputeEventDealingFileForAPP(id);
/* 671 */     if (files.size() > 0) {
/* 672 */       for (com.jtzh.vo.app.EventDealingVideoVO file : files) {
/* 673 */         String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 674 */         FileUpdateVO vo = new FileUpdateVO();
/* 675 */         vo.setId(file.getEventDealingID());
/* 676 */         vo.setUrl(videoPath);
/* 677 */         videoPaths.add(vo);
/*     */       }
/*     */     }
/* 680 */     Map map = new HashMap();
/* 681 */     map.put("pictures", picturePaths);
/* 682 */     map.put("video", videoPaths);
/* 683 */     return map;
/*     */   }
/*     */   
/*     */   public boolean updateDisputeEventStatus(String status, Long id)
/*     */   {
/* 688 */     return this.disputeEventMapper.updateEventStatus(status, id) != 0;
/*     */   }
/*     */   
/*     */   public boolean isDistribute(Long id)
/*     */   {
/* 693 */     List<com.jtzh.vo.dispute.DisputeEventDistributeVO> vos = this.disputeEventDistributeMapper.selectByEventID(id);
/* 694 */     return vos.size() > 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\DisputeEventServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */