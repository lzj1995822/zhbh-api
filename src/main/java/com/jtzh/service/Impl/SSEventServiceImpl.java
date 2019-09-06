/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.app.EventDealingPictureVO;
import com.jtzh.vo.app.EventDealingVideoVO;
/*     */ import com.jtzh.vo.gis.SocietySecurityEventVO;
/*     */ import com.jtzh.vo.ss.FileUpdateVO;
/*     */ import com.jtzh.vo.ss.SSQueryVO;
import com.jtzh.entity.Picture;
import com.jtzh.entity.SSEventDealing;
import com.jtzh.entity.SSEventDealingPicture;
import com.jtzh.entity.SSEventInvolvedPersons;
import com.jtzh.entity.SecurityEventPicture;
import com.jtzh.entity.SecurityEventVideoFile;
import com.jtzh.entity.TEFile;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.SSEventInvolvedPersonsMapper;
import com.jtzh.mapper.SocietySecurityEventMapper;
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
/*     */ public class SSEventServiceImpl implements com.jtzh.service.SSEventService
/*     */ {
/*     */   @Autowired
/*     */   private SocietySecurityEventMapper societySecurityEventMapper;
/*     */   @Autowired
/*     */   private SSEventInvolvedPersonsMapper ssEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SecurityEventPictureMapper securityEventPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SecurityEventVideoFileMapper securityEventVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODESSEventStatusTypeMapper codessEventStatusTypeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODESSEventTypeMapper codessEventTypeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SSEventDistributeMapper ssEventDistributeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SSEventDealingMapper ssEventDealingMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SSEventDealingPictureMapper ssEventDealingPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SSEventDealingVideoFileMapper ssEventDealingVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SSEventCheckedMapper ssEventCheckedMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private TEFileMapper teFileMapper;
/*     */   private static final String SSEVENTPICTURE_PATH = "/SocietySecurityEvent/picture/";
/*     */   private static final String SSEVENTVIDEO_PATH = "/SocietySecurityEvent/video/";
/*     */   private static final String SSEVENTDEALINGPICTURE_PATH = "/SocietySecurityEvent/DealingPicture/";
/*     */   private static final String SSEVENTDEALINGVIDEO_PATH = "/SocietySecurityEvent/DealingVideo/";
/*     */   
/*     */   public Map getSSEventCode()
/*     */   {
/*  66 */     Map map = new HashMap();
/*  67 */     map.put("EventStatusType", this.codessEventStatusTypeMapper.selectAll());
/*  68 */     map.put("EventType", this.codessEventTypeMapper.selectAll());
/*  69 */     return map;
/*     */   }
/*     */   
/*     */   public Long addSSEventBasic(com.jtzh.entity.SocietySecurityEvent event)
/*     */   {
/*  74 */     this.societySecurityEventMapper.insert(event);
/*  75 */     return event.getSsEventID();
/*     */   }
/*     */   
/*     */   public boolean addSSEventInvolvedPersons(SSEventInvolvedPersons persons)
/*     */   {
/*  80 */     return this.ssEventInvolvedPersonsMapper.insert(persons) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateSSEventInvolvedPersons(SSEventInvolvedPersons persons)
/*     */   {
/*  85 */     return this.ssEventInvolvedPersonsMapper.updateByPrimaryKey(persons) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteSSEventInvolvedPersons(Long id)
/*     */   {
/*  90 */     return this.ssEventInvolvedPersonsMapper.deleteByPrimaryKey(id) != 0;
/*     */   }
/*     */   
/*     */   public boolean insertSSEventDistribute(com.jtzh.entity.SSEventDistribute distribute)
/*     */   {
/*  95 */     return this.ssEventDistributeMapper.insert(distribute) != 0;
/*     */   }
/*     */   
/*     */   public Long insertSSEventDealingBasic(SSEventDealing dealing)
/*     */   {
/* 100 */     boolean flag = this.ssEventDealingMapper.insert(dealing) != 0;
/* 101 */     if (flag)
/* 102 */       return dealing.getEventDealingID();
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public boolean insertSSEventChecked(com.jtzh.entity.SSEventChecked checked)
/*     */   {
/* 108 */     return this.ssEventCheckedMapper.insert(checked) != 0;
/*     */   }
/*     */   
/*     */   public List<com.jtzh.vo.ss.SSCountVO> getSSCountVO()
/*     */   {
/* 113 */     return this.societySecurityEventMapper.getSSEventCount();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteSSEvent(Long id)
/*     */   {
/* 119 */     boolean flag = deleteSSEventMedia(id);
/* 120 */     if (flag) {
/* 121 */       flag = this.societySecurityEventMapper.deleteByPrimaryKey(id) != 0;
/*     */     }
/* 123 */     if (flag)
/* 124 */       flag = this.ssEventInvolvedPersonsMapper.deleteBySSEventID(id) != 0;
/* 125 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean addSSEventPictures(MultipartFile file, Long ID)
/*     */   {
/* 130 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 131 */     if ((file != null) && (!file.isEmpty())) {
/* 132 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 134 */       String originFileName = file.getOriginalFilename();
/* 135 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 138 */       File outPath = new File(root_path + "/SocietySecurityEvent/picture/");
/* 139 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 140 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 144 */       File outFile = new File(root_path + "/SocietySecurityEvent/picture/" + filename + extension);
/*     */       try
/*     */       {
/* 147 */         file.transferTo(outFile);
/*     */         
/* 149 */         Picture p = new Picture();
/* 150 */         p.setPictureName(filename);
/* 151 */         p.setPictureSuffix(extension);
/* 152 */         p.setPicturePath("/SocietySecurityEvent/picture/");
/* 153 */         this.pictureMapper.insert(p);
/* 154 */         Long pictureID = p.getPictureID();
/* 155 */         SecurityEventPicture picture = new SecurityEventPicture();
/* 156 */         picture.setSSEventID(ID);
/* 157 */         picture.setPictureID(pictureID);
/* 158 */         return this.securityEventPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 160 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addSSEventVideo(MultipartFile file, Long ID)
/*     */   {
/* 169 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 170 */     if ((file != null) && (!file.isEmpty())) {
/* 171 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 173 */       String originFileName = file.getOriginalFilename();
/* 174 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 177 */       File outPath = new File(root_path + "/SocietySecurityEvent/video/");
/* 178 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 179 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 183 */       File outFile = new File(root_path + "/SocietySecurityEvent/video/" + filename + extension);
/*     */       try
/*     */       {
/* 186 */         file.transferTo(outFile);
/*     */         
/* 188 */         TEFile f = new TEFile();
/* 189 */         f.setFileName(filename);
/* 190 */         f.setFilePath("/SocietySecurityEvent/video/");
/* 191 */         f.setFileSuffix(extension);
/* 192 */         this.teFileMapper.insert(f);
/* 193 */         Long fileID = f.getFileID();
/* 194 */         SecurityEventVideoFile videoFile = new SecurityEventVideoFile();
/* 195 */         videoFile.setSSEventID(ID);
/* 196 */         videoFile.setFileID(fileID);
/* 197 */         return this.securityEventVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 199 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 202 */     return false;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 207 */     int start = 0;
/* 208 */     if (page > 1)
/* 209 */       start = (page - 1) * pageSize;
/* 210 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventDespatcherQuery(id, kind, name, netGridID, status, start, pageSize);
/* 211 */     int count = this.societySecurityEventMapper.getSSEventDespatcherQueryCount(id, kind, name, netGridID, status);
/* 212 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 213 */     SSQueryVO s = new SSQueryVO();
/* 214 */     s.setVos(vos);
/* 215 */     s.setPage(p);
/* 216 */     return s;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventDeptDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 221 */     int start = 0;
/* 222 */     if (page > 1)
/* 223 */       start = (page - 1) * pageSize;
/* 224 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventDeptDespatcherQuery(id, kind, name, netGridID, status, start, pageSize);
/* 225 */     int count = this.societySecurityEventMapper.getSSEventDeptDespatcherQueryCount(id, kind, name, netGridID, status);
/* 226 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 227 */     SSQueryVO s = new SSQueryVO();
/* 228 */     s.setVos(vos);
/* 229 */     s.setPage(p);
/* 230 */     return s;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventHandlerQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 235 */     int start = 0;
/* 236 */     if (page > 1)
/* 237 */       start = (page - 1) * pageSize;
/* 238 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventHandlerQuery(id, kind, name, netGridID, status, start, pageSize);
/* 239 */     int count = this.societySecurityEventMapper.getSSEventHandlerQueryCount(id, kind, name, netGridID, status);
/* 240 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 241 */     SSQueryVO s = new SSQueryVO();
/* 242 */     s.setVos(vos);
/* 243 */     s.setPage(p);
/* 244 */     return s;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventAuditorQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 249 */     int start = 0;
/* 250 */     if (page > 1)
/* 251 */       start = (page - 1) * pageSize;
/* 252 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventAuditorQuery(id, kind, name, netGridID, status, start, pageSize);
/* 253 */     int count = this.societySecurityEventMapper.getSSEventAuditorQueryCount(id, kind, name, netGridID, status);
/* 254 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 255 */     SSQueryVO s = new SSQueryVO();
/* 256 */     s.setVos(vos);
/* 257 */     s.setPage(p);
/* 258 */     return s;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventReporterQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 263 */     int start = 0;
/* 264 */     if (page > 1)
/* 265 */       start = (page - 1) * pageSize;
/* 266 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventReporterQuery(id, kind, name, netGridID, status, start, pageSize);
/* 267 */     int count = this.societySecurityEventMapper.getSSEventReporterQueryCount(id, kind, name, netGridID, status);
/* 268 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 269 */     SSQueryVO s = new SSQueryVO();
/* 270 */     s.setVos(vos);
/* 271 */     s.setPage(p);
/* 272 */     return s;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventAPPQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 277 */     int start = 0;
/* 278 */     if (page > 1)
/* 279 */       start = (page - 1) * pageSize;
/* 280 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventAPPQuery(id, kind, name, netGridID, status, start, pageSize);
/* 281 */     int count = this.societySecurityEventMapper.getSSEventAPPQueryCount(id, kind, name, netGridID, status);
/* 282 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 283 */     SSQueryVO s = new SSQueryVO();
/* 284 */     s.setVos(vos);
/* 285 */     s.setPage(p);
/* 286 */     return s;
/*     */   }
/*     */   
/*     */   public SSQueryVO getSSEventForNetGrid(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 291 */     int start = 0;
/* 292 */     if (page > 1)
/* 293 */       start = (page - 1) * pageSize;
/* 294 */     List<SocietySecurityEventVO> vos = this.societySecurityEventMapper.getSSEventForNetGrid(id, kind, name, netGridID, status, start, pageSize);
/* 295 */     int count = this.societySecurityEventMapper.getSSEventForNetGridCount(id, kind, name, netGridID, status);
/* 296 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 297 */     SSQueryVO s = new SSQueryVO();
/* 298 */     s.setVos(vos);
/* 299 */     s.setPage(p);
/* 300 */     return s;
/*     */   }
/*     */   
/*     */   public boolean updateSSEventStatus(String type, Long id)
/*     */   {
/* 305 */     return this.societySecurityEventMapper.updateSSEventStatus(type, id) != 0;
/*     */   }
/*     */   
/*     */   public Map getSSDetail(Long id)
/*     */   {
/* 310 */     com.jtzh.vo.ss.SSVO ssvo = this.societySecurityEventMapper.getSSEventDetail(id);
/* 311 */     List<SSEventInvolvedPersons> involvedPersons = this.ssEventInvolvedPersonsMapper.selectBySSEventID(id);
/* 312 */     List<com.jtzh.vo.ss.SSDistributeVO> distributes = this.ssEventDistributeMapper.selectByEventID(id);
/* 313 */     List<com.jtzh.vo.ss.SSDealingVO> dealings = this.ssEventDealingMapper.selectByEventID(id);
/* 314 */     List<com.jtzh.vo.ss.SSCheckedVO> checkeds = this.ssEventCheckedMapper.selectByEventID(id);
/* 315 */     Map map = new HashMap();
/* 316 */     map.put("SSEventBasic", ssvo);
/* 317 */     map.put("involvedPersons", involvedPersons);
/* 318 */     map.put("SSEventMedia", getSSEventMedia(id));
/* 319 */     map.put("distributes", distributes);
/* 320 */     map.put("dealings", dealings);
/* 321 */     map.put("dealingsMedia", getSSEventDealingMedia(id));
/* 322 */     map.put("checkeds", checkeds);
/* 323 */     return map;
/*     */   }
/*     */   
/*     */   public Map getSSDetailForAPP(Long id)
/*     */   {
/* 328 */     com.jtzh.vo.ss.SSVO ssvo = this.societySecurityEventMapper.getSSEventDetail(id);
/* 329 */     List<SSEventInvolvedPersons> involvedPersons = this.ssEventInvolvedPersonsMapper.selectBySSEventID(id);
/* 330 */     List<com.jtzh.vo.ss.SSDistributeVO> distributes = this.ssEventDistributeMapper.selectByEventID(id);
/* 331 */     List<com.jtzh.vo.ss.SSDealingVO> dealings = this.ssEventDealingMapper.selectByEventID(id);
/* 332 */     List<com.jtzh.vo.ss.SSCheckedVO> checkeds = this.ssEventCheckedMapper.selectByEventID(id);
/* 333 */     Map map = new HashMap();
/* 334 */     map.put("SSEventBasic", ssvo);
/* 335 */     map.put("involvedPersons", involvedPersons);
/* 336 */     map.put("SSEventMedia", getSSEventMedia(id));
/* 337 */     map.put("distributes", distributes);
/* 338 */     map.put("dealings", dealings);
/* 339 */     map.put("dealingsMedia", getSSEventDealingMediaForAPP(id));
/* 340 */     map.put("checkeds", checkeds);
/* 341 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateSSEvent(com.jtzh.entity.SocietySecurityEvent societySecurityEvent)
/*     */   {
/* 347 */     return this.societySecurityEventMapper.updateByPrimaryKey(societySecurityEvent) != 0;
/*     */   }
/*     */   
/*     */   public Map getDetailToUpdate(Long SSEventID)
/*     */   {
/* 352 */     com.jtzh.entity.SocietySecurityEvent societySecurityEvent = this.societySecurityEventMapper.selectByPrimaryKey(SSEventID);
/* 353 */     List<SSEventInvolvedPersons> involvedPersons = this.ssEventInvolvedPersonsMapper.selectBySSEventID(SSEventID);
/* 354 */     Map map = new HashMap();
/* 355 */     map.put("basic", societySecurityEvent);
/* 356 */     map.put("involvedPersons", involvedPersons);
/* 357 */     map.put("media", getSSEventMedia(SSEventID));
/* 358 */     return map;
/*     */   }
/*     */   
/*     */   private Map getSSEventMedia(Long id) {
/* 362 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 363 */     List<Picture> pictures = this.pictureMapper.selectBySSEventID(id);
/* 364 */     List picturePaths = new ArrayList();
/* 365 */     List videoPaths = new ArrayList();
/* 366 */     if (pictures.size() > 0) {
/* 367 */       for (Picture p : pictures) {
/* 368 */         FileUpdateVO vo = new FileUpdateVO();
/* 369 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 370 */         vo.setId(p.getPictureID());
/* 371 */         vo.setUrl(path);
/* 372 */         picturePaths.add(vo);
/*     */       }
/*     */     }
/* 375 */     TEFile file = this.teFileMapper.selectBySSEventID(id);
/* 376 */     String videoPath = null;
/* 377 */     if (file != null) {
/* 378 */       videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 379 */       FileUpdateVO vo = new FileUpdateVO();
/* 380 */       vo.setId(file.getFileID());
/* 381 */       vo.setUrl(videoPath);
/* 382 */       videoPaths.add(vo);
/*     */     }
/* 384 */     Map map = new HashMap();
/* 385 */     map.put("pictures", picturePaths);
/* 386 */     map.put("video", videoPaths);
/* 387 */     return map;
/*     */   }
/*     */   
/*     */   private Map getSSEventDealingMedia(Long id) {
/* 391 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 392 */     List<Picture> pictures = this.pictureMapper.selectSSEventDealingPictureBySSEventID(id);
/* 393 */     List picturePaths = new ArrayList();
/* 394 */     List videoPaths = new ArrayList();
Picture p;
/* 395 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 396 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (Picture)localIterator.next();
/* 397 */         FileUpdateVO vo = new FileUpdateVO();
/* 398 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 399 */         vo.setId(p.getPictureID());
/* 400 */         vo.setUrl(path);
/* 401 */         picturePaths.add(vo);
/*     */       }
/*     */     
/* 404 */     List<TEFile> files = this.teFileMapper.selectSSEventDealingFileBySSEventID(id);
/* 405 */     if (files.size() > 0) {
/* 406 */       for (TEFile file : files) {
/* 407 */         String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 408 */         FileUpdateVO vo = new FileUpdateVO();
/* 409 */         vo.setId(file.getFileID());
/* 410 */         vo.setUrl(videoPath);
/* 411 */         videoPaths.add(vo);
/*     */       }
/*     */     }
/* 414 */     Map map = new HashMap();
/* 415 */     map.put("pictures", picturePaths);
/* 416 */     map.put("video", videoPaths);
/* 417 */     return map;
/*     */   }
/*     */   
/*     */   private Map getSSEventDealingMediaForAPP(Long id)
/*     */   {
/* 422 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 423 */     List<EventDealingPictureVO> pictures = this.pictureMapper.selectSSEventDealingPictureForAPP(id);
/* 424 */     List picturePaths = new ArrayList();
/* 425 */     List videoPaths = new ArrayList();
/*     */     EventDealingPictureVO p;
/* 426 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 427 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (EventDealingPictureVO)localIterator.next();
/* 428 */         FileUpdateVO vo = new FileUpdateVO();
/* 429 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 430 */         vo.setId(p.getEventDealingID());
/* 431 */         vo.setUrl(path);
/* 432 */         picturePaths.add(vo);
/*     */       }
/* 435 */     List<EventDealingVideoVO> files = this.teFileMapper.selectSSEventDealingFileForAPP(id);
/* 436 */     if (files.size() > 0) {
/* 437 */       for (com.jtzh.vo.app.EventDealingVideoVO file : files) {
/* 438 */         String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 439 */         FileUpdateVO vo = new FileUpdateVO();
/* 440 */         vo.setId(file.getEventDealingID());
/* 441 */         vo.setUrl(videoPath);
/* 442 */         videoPaths.add(vo);
/*     */       }
/*     */     }
/* 445 */     Map map = new HashMap();
/* 446 */     map.put("pictures", picturePaths);
/* 447 */     map.put("video", videoPaths);
/* 448 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean deleteSSEventMedia(Long id)
/*     */   {
/* 460 */     boolean flag = false;
/* 461 */     String rootPath = CommonUtils.getRootPath("msmis.file");
/* 462 */     List<SecurityEventPicture> sep = this.securityEventPictureMapper.selectBySSEventID(id);
/* 463 */     if (sep.size() > 0) {
/* 464 */       for (SecurityEventPicture image : sep) {
/* 465 */         Picture p = this.pictureMapper.selectByPrimaryKey(image.getPictureID());
/* 466 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 467 */         if (CommonUtils.deleteFile(path)) {
/* 468 */           flag = this.securityEventPictureMapper.deleteByPictureID(image.getPictureID()) != 0;
/*     */         } else {
/* 470 */           flag = false;
/* 471 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/* 475 */       flag = true;
/*     */     }
/* 477 */     if (flag) {
/*     */       SecurityEventVideoFile videoFile;
/* 479 */       if ((videoFile = this.securityEventVideoFileMapper.selectBySSEventID(id)) != null) {
/* 480 */         TEFile f = this.teFileMapper.selectByPrimaryKey(videoFile.getFileID());
/* 481 */         String file = rootPath + f.getFilePath() + f.getFileName() + f.getFileSuffix();
/* 482 */         if (CommonUtils.deleteFile(file)) {
/* 483 */           flag = this.securityEventVideoFileMapper.deleteByFileID(videoFile.getFileID()) != 0;
/*     */         } else {
/* 485 */           flag = false;
/*     */         }
/*     */       } else {
/* 488 */         flag = true;
/*     */       }
/*     */     }
/* 491 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addSSEventDealingPictures(MultipartFile file, Long ID)
/*     */   {
/* 497 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 498 */     boolean flag = false;
/* 499 */     if ((file != null) && (!file.isEmpty())) {
/* 500 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 502 */       String originFileName = file.getOriginalFilename();
/* 503 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 506 */       File outPath = new File(root_path + "/SocietySecurityEvent/DealingPicture/");
/* 507 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 508 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 512 */       File outFile = new File(root_path + "/SocietySecurityEvent/DealingPicture/" + filename + extension);
/*     */       try
/*     */       {
/* 515 */         file.transferTo(outFile);
/*     */         
/* 517 */         Picture p = new Picture();
/* 518 */         p.setPictureName(filename);
/* 519 */         p.setPictureSuffix(extension);
/* 520 */         p.setPicturePath("/SocietySecurityEvent/DealingPicture/");
/* 521 */         flag = this.pictureMapper.insert(p) != 0;
/* 522 */         Long pictureID = p.getPictureID();
/* 523 */         SSEventDealingPicture picture = new SSEventDealingPicture();
/* 524 */         picture.setEventDealingID(ID);
/* 525 */         picture.setPictureID(pictureID);
/* 526 */         flag = this.ssEventDealingPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 528 */         e.printStackTrace();
/*     */       }
/*     */     } else {
/* 531 */       flag = true;
/*     */     }
/* 533 */     return flag;
/*     */   }
/*     */   
/*     */   private boolean addSSEventDealingPictures(MultipartFile[] file, Long ID)
/*     */   {
/* 538 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 539 */     boolean flag = false;
/* 540 */     if (file.length > 0) {
/* 541 */       for (int i = 0; i < file.length; i++) {
/* 542 */         if ((file[i] != null) && (!file[i].isEmpty())) {
/* 543 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 545 */           String originFileName = file[i].getOriginalFilename();
/* 546 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 549 */           File outPath = new File(root_path + "/SocietySecurityEvent/DealingPicture/");
/* 550 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 551 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 555 */           File outFile = new File(root_path + "/SocietySecurityEvent/DealingPicture/" + filename + extension);
/*     */           try
/*     */           {
/* 558 */             file[i].transferTo(outFile);
/*     */             
/* 560 */             Picture p = new Picture();
/* 561 */             p.setPictureName(filename);
/* 562 */             p.setPictureSuffix(extension);
/* 563 */             p.setPicturePath("/SocietySecurityEvent/DealingPicture/");
/* 564 */             flag = this.pictureMapper.insert(p) != 0;
/* 565 */             Long pictureID = p.getPictureID();
/* 566 */             SSEventDealingPicture picture = new SSEventDealingPicture();
/* 567 */             picture.setEventDealingID(ID);
/* 568 */             picture.setPictureID(pictureID);
/* 569 */             flag = this.ssEventDealingPictureMapper.insert(picture) != 0;
/*     */           } catch (IOException e) {
/* 571 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 576 */       flag = true;
/*     */     }
/* 578 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean addSSEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 583 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 584 */     if ((file != null) && (!file.isEmpty())) {
/* 585 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 587 */       String originFileName = file.getOriginalFilename();
/* 588 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 591 */       File outPath = new File(root_path + "/SocietySecurityEvent/DealingVideo/");
/* 592 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 593 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 597 */       File outFile = new File(root_path + "/SocietySecurityEvent/DealingVideo/" + filename + extension);
/*     */       try
/*     */       {
/* 600 */         file.transferTo(outFile);
/*     */         
/* 602 */         TEFile f = new TEFile();
/* 603 */         f.setFileName(filename);
/* 604 */         f.setFilePath("/SocietySecurityEvent/DealingVideo/");
/* 605 */         f.setFileSuffix(extension);
/* 606 */         this.teFileMapper.insert(f);
/* 607 */         Long fileID = f.getFileID();
/* 608 */         com.jtzh.entity.SSEventDealingVideoFile videoFile = new com.jtzh.entity.SSEventDealingVideoFile();
/* 609 */         videoFile.setEventDealingID(ID);
/* 610 */         videoFile.setFileID(fileID);
/* 611 */         return this.ssEventDealingVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 613 */         e.printStackTrace();
/*     */       }
/*     */     } else {
/* 616 */       return true;
/*     */     }
/* 618 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @org.springframework.transaction.annotation.Transactional
/*     */   public boolean addSSEventDealingFromAPP(String eventID, String dealingUserID, String dealingTime, String dealingInf, String remark, MultipartFile[] pictures, MultipartFile video)
/*     */   {
/* 626 */     SSEventDealing dealing = new SSEventDealing();
/* 627 */     dealing.setEventID(Long.valueOf(eventID));
/* 628 */     dealing.setDealingUserID(Long.valueOf(dealingUserID));
/*     */     try {
/* 630 */       dealing.setDealingTime(com.jtzh.util.DateUtil.strToDateTime(dealingTime));
/*     */     } catch (java.text.ParseException e) {
/* 632 */       e.printStackTrace();
/*     */     }
/* 634 */     dealing.setDealingInf(dealingInf);
/* 635 */     dealing.setRemark(remark);
/* 636 */     boolean flag = this.ssEventDealingMapper.insert(dealing) != 0;
/* 637 */     if (flag) {
/* 638 */       Long ID = dealing.getEventDealingID();
/* 639 */       flag = addSSEventDealingPictures(pictures, ID);
/* 640 */       if (flag) {
/* 641 */         flag = addSSEventDealingVideo(video, ID);
/*     */       }
/*     */     }
/* 644 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean isDistribute(Long id)
/*     */   {
/* 649 */     List<com.jtzh.vo.ss.SSDistributeVO> vos = this.ssEventDistributeMapper.selectByEventID(id);
/* 650 */     return vos.size() > 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\SSEventServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */