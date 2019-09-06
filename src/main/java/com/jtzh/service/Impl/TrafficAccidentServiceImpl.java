/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.app.EventDealingPictureVO;
import com.jtzh.vo.app.EventDealingVideoVO;
/*     */ import com.jtzh.vo.ss.FileUpdateVO;
/*     */ import com.jtzh.vo.trafficAccident.TrafficAccidentExVO;
/*     */ import com.jtzh.vo.trafficAccident.TrafficAccidentQueryVO;
import com.jtzh.entity.Picture;
import com.jtzh.entity.TEFile;
import com.jtzh.entity.TrafficAccidentDealing;
import com.jtzh.entity.TrafficAccidentDealingPicture;
import com.jtzh.entity.TrafficAccidentPicture;
import com.jtzh.entity.TrafficAccidentVideoFile;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.TEFileMapper;
import com.jtzh.mapper.TrafficAccidentInvolvedPersonsMapper;
import com.jtzh.mapper.TrafficAccidentMapper;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class TrafficAccidentServiceImpl implements com.jtzh.service.TrafficAccidentService
/*     */ {
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODETrafficAccidentKindMapper codeTrafficAccidentKindMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODETrafficAccidentTypeMapper codeTrafficAccidentTypeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODETrafficAccidentStatusTypeMapper codeTrafficAccidentStatusTypeMapper;
/*     */   @Autowired
/*     */   private TrafficAccidentInvolvedPersonsMapper trafficAccidentInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private TrafficAccidentMapper trafficAccidentMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private TEFileMapper teFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentPictureMapper trafficAccidentPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentVideoFileMapper trafficAccidentVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentCheckedMapper trafficAccidentCheckedMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentDealingMapper trafficAccidentDealingMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentDealingPictureMapper trafficAccidentDealingPictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentDealingVideoFileMapper trafficAccidentDealingVideoFileMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TrafficAccidentDistributeMapper trafficAccidentDistributeMapper;
/*     */   private static final String TRAFFICPICTURE_PATH = "/TrafficAccident/picture/";
/*     */   private static final String TRAFFICVIDEO_PATH = "/TrafficAccident/video/";
/*     */   private static final String TRAFFICDEALINGPICTURE_PATH = "/TrafficAccident/DealingPicture/";
/*     */   private static final String TRAFFICDEALINGVIDEO_PATH = "/TrafficAccident/DealingVideo/";
/*     */



/*     */   public Map getTrafficCodes()
/*     */   {
/*  66 */     Map map = new java.util.HashMap();
/*  67 */     map.put("AccidentKind", this.codeTrafficAccidentKindMapper.selectAll());
/*  68 */     map.put("AccidentType", this.codeTrafficAccidentTypeMapper.selectAll());
/*  69 */     map.put("AccidentStatusType", this.codeTrafficAccidentStatusTypeMapper.selectAll());
/*  70 */     return map;
/*     */   }
/*     */   
/*     */   public Long addTrafficAccidentBasic(com.jtzh.entity.TrafficAccident t)
/*     */   {
/*  75 */     this.trafficAccidentMapper.insert(t);
/*  76 */     return t.getTrafficAccidentID();
/*     */   }
/*     */   
/*     */   public boolean addTrafficAccidentInvolvedPersons(com.jtzh.entity.TrafficAccidentInvolvedPersons persons)
/*     */   {
/*  81 */     return this.trafficAccidentInvolvedPersonsMapper.insert(persons) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateAccidentInvolvedPersons(com.jtzh.entity.TrafficAccidentInvolvedPersons persons)
/*     */   {
/*  86 */     return this.trafficAccidentInvolvedPersonsMapper.updateByPrimaryKey(persons) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteAccidentInvolvedPersons(Long id)
/*     */   {
/*  91 */     return this.trafficAccidentInvolvedPersonsMapper.deleteByPrimaryKey(id) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateTrafficAccident(com.jtzh.entity.TrafficAccident trafficAccident)
/*     */   {
/*  96 */     return this.trafficAccidentMapper.updateByPrimaryKey(trafficAccident) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map getTrafficAccidentDetailToUpdate(Long id)
/*     */   {
/* 102 */     Map map = new java.util.HashMap();
/* 103 */     map.put("basic", this.trafficAccidentMapper.selectByPrimaryKey(id));
/* 104 */     map.put("involvedPersons", this.trafficAccidentInvolvedPersonsMapper.selectByTrafficAccidentID(id));
/* 105 */     return map;
/*     */   }
/*     */   
/*     */   public boolean deleteTrafficAccident(Long id)
/*     */   {
/* 110 */     if (deleteTrafficAccidentMedia(id)) {
/* 111 */       return this.trafficAccidentMapper.deleteByPrimaryKey(id) != 0;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addTrafficAccidentPicture(MultipartFile file, Long ID)
/*     */   {
/* 125 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 126 */     boolean flag = false;
/* 127 */     if ((file != null) && (!file.isEmpty())) {
/* 128 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 130 */       String originFileName = file.getOriginalFilename();
/* 131 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 134 */       File outPath = new File(root_path + "/TrafficAccident/picture/");
/* 135 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 136 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 140 */       File outFile = new File(root_path + "/TrafficAccident/picture/" + filename + extension);
/*     */       try
/*     */       {
/* 143 */         file.transferTo(outFile);
/*     */         
/* 145 */         Picture p = new Picture();
/* 146 */         p.setPictureName(filename);
/* 147 */         p.setPictureSuffix(extension);
/* 148 */         p.setPicturePath("/TrafficAccident/picture/");
/* 149 */         flag = this.pictureMapper.insert(p) != 0;
/* 150 */         Long pictureID = p.getPictureID();
/* 151 */         TrafficAccidentPicture picture = new TrafficAccidentPicture();
/* 152 */         picture.setTrafficAccidentID(ID);
/* 153 */         picture.setPictureID(pictureID);
/* 154 */         flag = this.trafficAccidentPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 156 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 159 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addTrafficAccidentVideo(MultipartFile file, Long ID)
/*     */   {
/* 171 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 172 */     if ((file != null) && (!file.isEmpty())) {
/* 173 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 175 */       String originFileName = file.getOriginalFilename();
/* 176 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 179 */       File outPath = new File(root_path + "/TrafficAccident/video/");
/* 180 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 181 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 185 */       File outFile = new File(root_path + "/TrafficAccident/video/" + filename + extension);
/*     */       try
/*     */       {
/* 188 */         file.transferTo(outFile);
/*     */         
/* 190 */         TEFile f = new TEFile();
/* 191 */         f.setFileName(filename);
/* 192 */         f.setFilePath("/TrafficAccident/video/");
/* 193 */         f.setFileSuffix(extension);
/* 194 */         this.teFileMapper.insert(f);
/* 195 */         Long fileID = f.getFileID();
/* 196 */         TrafficAccidentVideoFile videoFile = new TrafficAccidentVideoFile();
/* 197 */         videoFile.setTrafficAccidentID(ID);
/* 198 */         videoFile.setFileID(fileID);
/* 199 */         return this.trafficAccidentVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 201 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 204 */     return false;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentReporterQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 209 */     int start = 0;
/* 210 */     if (page > 1)
/* 211 */       start = (page - 1) * pageSize;
/* 212 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentReporterQuery(id, name, type, netGridID, status, start, pageSize);
/* 213 */     int count = this.trafficAccidentMapper.getTrafficAccidentReporterQueryCount(id, name, type, netGridID, status);
/* 214 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 215 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 216 */     vo.setVos(vos);
/* 217 */     vo.setPage(p);
/* 218 */     return vo;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentDespatcherQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 223 */     int start = 0;
/* 224 */     if (page > 1)
/* 225 */       start = (page - 1) * pageSize;
/* 226 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentDespatcherQuery(id, name, type, netGridID, status, start, pageSize);
/* 227 */     int count = this.trafficAccidentMapper.getTrafficAccidentDespatcherQueryCount(id, name, type, netGridID, status);
/* 228 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 229 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 230 */     vo.setVos(vos);
/* 231 */     vo.setPage(p);
/* 232 */     return vo;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentDeptDespatcherQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 237 */     int start = 0;
/* 238 */     if (page > 1)
/* 239 */       start = (page - 1) * pageSize;
/* 240 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentDeptDespatcherQuery(id, name, type, netGridID, status, start, pageSize);
/* 241 */     int count = this.trafficAccidentMapper.getTrafficAccidentDeptDespatcherQueryCount(id, name, type, netGridID, status);
/* 242 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 243 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 244 */     vo.setVos(vos);
/* 245 */     vo.setPage(p);
/* 246 */     return vo;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentHandlerQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 251 */     int start = 0;
/* 252 */     if (page > 1)
/* 253 */       start = (page - 1) * pageSize;
/* 254 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentHandlerQuery(id, name, type, netGridID, status, start, pageSize);
/* 255 */     int count = this.trafficAccidentMapper.getTrafficAccidentHandlerQueryCount(id, name, type, netGridID, status);
/* 256 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 257 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 258 */     vo.setVos(vos);
/* 259 */     vo.setPage(p);
/* 260 */     return vo;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentAuditorQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 265 */     int start = 0;
/* 266 */     if (page > 1)
/* 267 */       start = (page - 1) * pageSize;
/* 268 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentAuditorQuery(id, name, type, netGridID, status, start, pageSize);
/* 269 */     int count = this.trafficAccidentMapper.getTrafficAccidentAuditorQueryCount(id, name, type, netGridID, status);
/* 270 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 271 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 272 */     vo.setVos(vos);
/* 273 */     vo.setPage(p);
/* 274 */     return vo;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentAPPQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 279 */     int start = 0;
/* 280 */     if (page > 1)
/* 281 */       start = (page - 1) * pageSize;
/* 282 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentAPPQuery(id, name, type, netGridID, status, start, pageSize);
/* 283 */     int count = this.trafficAccidentMapper.getTrafficAccidentAPPQueryCount(id, name, type, netGridID, status);
/* 284 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 285 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 286 */     vo.setVos(vos);
/* 287 */     vo.setPage(p);
/* 288 */     return vo;
/*     */   }
/*     */   
/*     */   public TrafficAccidentQueryVO getTrafficAccidentForNetGrid(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 293 */     int start = 0;
/* 294 */     if (page > 1)
/* 295 */       start = (page - 1) * pageSize;
/* 296 */     List<TrafficAccidentExVO> vos = this.trafficAccidentMapper.getTrafficAccidentForNetGrid(id, name, type, netGridID, status, start, pageSize);
/* 297 */     int count = this.trafficAccidentMapper.getTrafficAccidentForNetGridCount(id, name, type, netGridID, status);
/* 298 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 299 */     TrafficAccidentQueryVO vo = new TrafficAccidentQueryVO();
/* 300 */     vo.setVos(vos);
/* 301 */     vo.setPage(p);
/* 302 */     return vo;
/*     */   }
/*     */   
/*     */   public Map getTrafficAccidentDetail(Long id)
/*     */   {
/* 307 */     Map map = getTrafficAccidentMedia(id);
/* 308 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentVO> vos = this.trafficAccidentMapper.getTrafficAccidentDetail(id);
/* 309 */     List<com.jtzh.entity.TrafficAccidentInvolvedPersons> involvedPersons = this.trafficAccidentInvolvedPersonsMapper.selectByTrafficAccidentID(id);
/* 310 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentDealingVO> dealingVOS = this.trafficAccidentDealingMapper.selectByEventID(id);
/* 311 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentDistributeVO> distributeVOS = this.trafficAccidentDistributeMapper.selectByEventID(id);
/* 312 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentCheckedVO> checkedVOS = this.trafficAccidentCheckedMapper.selectByEventID(id);
/* 313 */     map.put("trafficAccidentBasic", vos);
/* 314 */     map.put("involvedPersons", involvedPersons);
/* 315 */     map.put("trafficAccidentMedia", getTrafficAccidentMedia(id));
/* 316 */     map.put("distribute", distributeVOS);
/* 317 */     map.put("trafficAccidentDealingBasic", dealingVOS);
/* 318 */     map.put("trafficAccidentDealingMedia", getTrafficAccidentDealingMedia(id));
/* 319 */     map.put("checked", checkedVOS);
/* 320 */     return map;
/*     */   }
/*     */   
/*     */   public Map getTrafficAccidentDetailForAPP(Long id)
/*     */   {
/* 325 */     Map map = getTrafficAccidentMedia(id);
/* 326 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentVO> vos = this.trafficAccidentMapper.getTrafficAccidentDetail(id);
/* 327 */     List<com.jtzh.entity.TrafficAccidentInvolvedPersons> involvedPersons = this.trafficAccidentInvolvedPersonsMapper.selectByTrafficAccidentID(id);
/* 328 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentDealingVO> dealingVOS = this.trafficAccidentDealingMapper.selectByEventID(id);
/* 329 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentDistributeVO> distributeVOS = this.trafficAccidentDistributeMapper.selectByEventID(id);
/* 330 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentCheckedVO> checkedVOS = this.trafficAccidentCheckedMapper.selectByEventID(id);
/* 331 */     map.put("trafficAccidentBasic", vos);
/* 332 */     map.put("involvedPersons", involvedPersons);
/* 333 */     map.put("trafficAccidentMedia", getTrafficAccidentMedia(id));
/* 334 */     map.put("distribute", distributeVOS);
/* 335 */     map.put("trafficAccidentDealingBasic", dealingVOS);
/* 336 */     map.put("trafficAccidentDealingMedia", getTrafficAccidentDealingMediaForAPP(id));
/* 337 */     map.put("checked", checkedVOS);
/* 338 */     return map;
/*     */   }
/*     */   
/*     */   public List getTrafficAccidentHistogramCount()
/*     */   {
/* 343 */     List<com.jtzh.vo.served.SpecialPersonPieVO> list = this.trafficAccidentMapper.getTrafficAccidentHistogramCount();
/* 344 */     List l = new ArrayList();
/* 345 */     int len = list.size();
/* 346 */     String[] name = new String[len];
/* 347 */     int[] value = new int[len];
/* 348 */     for (int i = 0; i < len; i++) {
/* 349 */       com.jtzh.vo.served.SpecialPersonPieVO v = (com.jtzh.vo.served.SpecialPersonPieVO)list.get(i);
/* 350 */       name[i] = v.getName();
/* 351 */       value[i] = v.getValue();
/*     */     }
/* 353 */     l.add(name);
/* 354 */     l.add(value);
/* 355 */     return l;
/*     */   }
/*     */   
/*     */   private Map getTrafficAccidentMedia(Long id) {
/* 359 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 360 */     List<Picture> pictures = this.pictureMapper.selectByTrafficAccidentID(id);
/* 361 */     List picturePaths = new ArrayList();
/* 362 */     List videoPaths = new ArrayList();
/* 363 */     if (pictures.size() > 0) {
/* 364 */       for (Picture p : pictures) {
/* 365 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 366 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 369 */     TEFile file = this.teFileMapper.selectByTrafficAccidentID(id);
/*     */     
/* 371 */     if (file != null) {
/* 372 */       String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 373 */       videoPaths.add(videoPath);
/*     */     }
/* 375 */     Map map = new java.util.HashMap();
/* 376 */     map.put("pictures", picturePaths);
/* 377 */     map.put("video", videoPaths);
/* 378 */     return map;
/*     */   }
/*     */   
/*     */   private Map getTrafficAccidentDealingMedia(Long id) {
/* 382 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 383 */     List<Picture> pictures = this.pictureMapper.selectTrafficAccidentDealingPictureByEventID(id);
/* 384 */     List picturePaths = new ArrayList();
/* 385 */     List videoPaths = new ArrayList();
/*     */     Picture p;
/* 386 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 387 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (Picture)localIterator.next();
/* 388 */         FileUpdateVO vo = new FileUpdateVO();
/* 389 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 390 */         vo.setId(p.getPictureID());
/* 391 */         vo.setUrl(path);
/* 392 */         picturePaths.add(vo);
/*     */       }
/* 395 */     Object files = this.teFileMapper.selectTrafficAccidentDealingFileByEventID(id);
/* 396 */     if (((List)files).size() > 0) {
///* 397 */       for (TEFile file : (List)files) {
///* 398 */         String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
///* 399 */         FileUpdateVO vo = new FileUpdateVO();
///* 400 */         vo.setId(file.getFileID());
///* 401 */         vo.setUrl(videoPath);
///* 402 */         videoPaths.add(vo);
///*     */       }
/*     */     }
/* 405 */     Map map = new java.util.HashMap();
/* 406 */     map.put("pictures", picturePaths);
/* 407 */     map.put("video", videoPaths);
/* 408 */     return map;
/*     */   }
/*     */   
/*     */   private Map getTrafficAccidentDealingMediaForAPP(Long id)
/*     */   {
/* 413 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 414 */     List<EventDealingPictureVO> pictures = this.pictureMapper.selectTrafficAccidentDealingPictureForAPP(id);
/* 415 */     List picturePaths = new ArrayList();
/* 416 */     List videoPaths = new ArrayList();
/*     */     EventDealingPictureVO p;
/* 417 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 418 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (EventDealingPictureVO)localIterator.next();
/* 419 */         FileUpdateVO vo = new FileUpdateVO();
/* 420 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 421 */         vo.setId(p.getEventDealingID());
/* 422 */         vo.setUrl(path);
/* 423 */         picturePaths.add(vo);
/*     */       }

/* 426 */     List<EventDealingVideoVO> files = this.teFileMapper.selectTrafficAccidentDealingFileForAPP(id);
/* 427 */     if (((List)files).size() > 0) {
/* 428 */       for (com.jtzh.vo.app.EventDealingVideoVO file : files) {
/* 429 */         String videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 430 */         FileUpdateVO vo = new FileUpdateVO();
/* 431 */         vo.setId(file.getEventDealingID());
/* 432 */         vo.setUrl(videoPath);
/* 433 */         videoPaths.add(vo);
/*     */       }
/*     */     }
/* 436 */     Map map = new java.util.HashMap();
/* 437 */     map.put("pictures", picturePaths);
/* 438 */     map.put("video", videoPaths);
/* 439 */     return map;
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
/*     */   private boolean deleteTrafficAccidentMedia(Long id)
/*     */   {
/* 452 */     boolean flag = false;
/* 453 */     String rootPath = CommonUtils.getRootPath("msmis.file");
/* 454 */     List<TrafficAccidentPicture> tap = this.trafficAccidentPictureMapper.selectByTrafficAccidentID(id);
/* 455 */     if (tap.size() > 0) {
/* 456 */       for (TrafficAccidentPicture image : tap) {
/* 457 */         Picture p = this.pictureMapper.selectByPrimaryKey(image.getPictureID());
/* 458 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 459 */         if (CommonUtils.deleteFile(path)) {
/* 460 */           flag = this.trafficAccidentPictureMapper.deleteByPictureID(image.getPictureID()) != 0;
/*     */         } else {
/* 462 */           flag = false;
/* 463 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/* 467 */       flag = true;
/*     */     }
/* 469 */     if (flag) {
/*     */       TrafficAccidentVideoFile videoFile;
/* 471 */       if ((videoFile = this.trafficAccidentVideoFileMapper.selectByTrafficAccidentID(id)) != null) {
/* 472 */         TEFile f = this.teFileMapper.selectByPrimaryKey(videoFile.getFileID());
/* 473 */         String file = rootPath + f.getFilePath() + f.getFileName() + f.getFileSuffix();
/* 474 */         if (CommonUtils.deleteFile(file)) {
/* 475 */           flag = this.trafficAccidentVideoFileMapper.deleteByFileID(videoFile.getFileID()) != 0;
/*     */         } else {
/* 477 */           flag = false;
/*     */         }
/*     */       } else {
/* 480 */         flag = true;
/*     */       }
/*     */     }
/* 483 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean addTrafficAccidentDistribute(com.jtzh.entity.TrafficAccidentDistribute distribute)
/*     */   {
/* 488 */     return this.trafficAccidentDistributeMapper.insert(distribute) != 0;
/*     */   }
/*     */   
/*     */   public Long addTrafficAccidetDealingBasic(TrafficAccidentDealing dealing)
/*     */   {
/* 493 */     boolean flag = this.trafficAccidentDealingMapper.insert(dealing) != 0;
/* 494 */     if (flag)
/* 495 */       return dealing.getEventDealingID();
/* 496 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   @org.springframework.transaction.annotation.Transactional
/*     */   public boolean addTrafficAccidetDealingFromAPP(String eventID, String dealingUserID, String dealingTime, String dealingInf, String remark, MultipartFile[] pictures, MultipartFile video)
/*     */   {
/* 503 */     TrafficAccidentDealing dealing = new TrafficAccidentDealing();
/* 504 */     dealing.setEventID(Long.valueOf(eventID));
/* 505 */     dealing.setDealingUserID(Long.valueOf(dealingUserID));
/*     */     try {
/* 507 */       dealing.setDealingTime(com.jtzh.util.DateUtil.strToDateTime(dealingTime));
/*     */     } catch (java.text.ParseException e) {
/* 509 */       e.printStackTrace();
/*     */     }
/* 511 */     dealing.setDealingInf(dealingInf);
/* 512 */     dealing.setRemark(remark);
/* 513 */     boolean flag = this.trafficAccidentDealingMapper.insert(dealing) != 0;
/* 514 */     if (flag) {
/* 515 */       Long ID = dealing.getEventDealingID();
/* 516 */       flag = addTrafficAccidentDealingPicture(pictures, ID);
/* 517 */       if (flag) {
/* 518 */         flag = addTrafficAccidentDealingVideo(video, ID);
/*     */       }
/*     */     }
/* 521 */     return flag;
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
/*     */   public boolean addTrafficAccidentDealingPicture(MultipartFile file, Long ID)
/*     */   {
/* 534 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 535 */     boolean flag = false;
/* 536 */     if ((file != null) && (!file.isEmpty())) {
/* 537 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 539 */       String originFileName = file.getOriginalFilename();
/* 540 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 543 */       File outPath = new File(root_path + "/TrafficAccident/DealingPicture/");
/* 544 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 545 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 549 */       File outFile = new File(root_path + "/TrafficAccident/DealingPicture/" + filename + extension);
/*     */       try
/*     */       {
/* 552 */         file.transferTo(outFile);
/*     */         
/* 554 */         Picture p = new Picture();
/* 555 */         p.setPictureName(filename);
/* 556 */         p.setPictureSuffix(extension);
/* 557 */         p.setPicturePath("/TrafficAccident/DealingPicture/");
/* 558 */         flag = this.pictureMapper.insert(p) != 0;
/* 559 */         Long pictureID = p.getPictureID();
/* 560 */         TrafficAccidentDealingPicture picture = new TrafficAccidentDealingPicture();
/* 561 */         picture.setEventDealingID(ID);
/* 562 */         picture.setPictureID(pictureID);
/* 563 */         flag = this.trafficAccidentDealingPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 565 */         e.printStackTrace();
/*     */       }
/*     */     } else {
/* 568 */       flag = true;
/*     */     }
/* 570 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean addTrafficAccidentDealingPicture(MultipartFile[] file, Long ID)
/*     */   {
/* 582 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 583 */     boolean flag = false;
/* 584 */     if (file.length > 0) {
/* 585 */       for (int i = 0; i < file.length; i++) {
/* 586 */         if ((file[i] != null) && (!file[i].isEmpty())) {
/* 587 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 589 */           String originFileName = file[i].getOriginalFilename();
/* 590 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 593 */           File outPath = new File(root_path + "/TrafficAccident/DealingPicture/");
/* 594 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 595 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 599 */           File outFile = new File(root_path + "/TrafficAccident/DealingPicture/" + filename + extension);
/*     */           try
/*     */           {
/* 602 */             file[i].transferTo(outFile);
/*     */             
/* 604 */             Picture p = new Picture();
/* 605 */             p.setPictureName(filename);
/* 606 */             p.setPictureSuffix(extension);
/* 607 */             p.setPicturePath("/TrafficAccident/DealingPicture/");
/* 608 */             flag = this.pictureMapper.insert(p) != 0;
/* 609 */             Long pictureID = p.getPictureID();
/* 610 */             TrafficAccidentDealingPicture picture = new TrafficAccidentDealingPicture();
/* 611 */             picture.setEventDealingID(ID);
/* 612 */             picture.setPictureID(pictureID);
/* 613 */             flag = this.trafficAccidentDealingPictureMapper.insert(picture) != 0;
/*     */           } catch (IOException e) {
/* 615 */             e.printStackTrace();
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     } else {
/* 621 */       flag = true;
/*     */     }
/* 623 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addTrafficAccidentDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 635 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 636 */     if ((file != null) && (!file.isEmpty())) {
/* 637 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 639 */       String originFileName = file.getOriginalFilename();
/* 640 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 643 */       File outPath = new File(root_path + "/TrafficAccident/DealingVideo/");
/* 644 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 645 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 649 */       File outFile = new File(root_path + "/TrafficAccident/DealingVideo/" + filename + extension);
/*     */       try
/*     */       {
/* 652 */         file.transferTo(outFile);
/*     */         
/* 654 */         TEFile f = new TEFile();
/* 655 */         f.setFileName(filename);
/* 656 */         f.setFilePath("/TrafficAccident/DealingVideo/");
/* 657 */         f.setFileSuffix(extension);
/* 658 */         this.teFileMapper.insert(f);
/* 659 */         Long fileID = f.getFileID();
/* 660 */         com.jtzh.entity.TrafficAccidentDealingVideoFile videoFile = new com.jtzh.entity.TrafficAccidentDealingVideoFile();
/* 661 */         videoFile.setEventDealingID(ID);
/* 662 */         videoFile.setFileID(fileID);
/* 663 */         return this.trafficAccidentDealingVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 665 */         e.printStackTrace();
/*     */       }
/*     */     } else {
/* 668 */       return true;
/*     */     }
/* 670 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addTrafficAccidentChecked(com.jtzh.entity.TrafficAccidentChecked checked)
/*     */   {
/* 675 */     return this.trafficAccidentCheckedMapper.insert(checked) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateTrafficAccidentStatus(String type, Long id)
/*     */   {
/* 680 */     return this.trafficAccidentMapper.updateTrafficAccidentStatus(type, id) != 0;
/*     */   }
/*     */   
/*     */   public boolean isDistribute(Long id)
/*     */   {
/* 685 */     List<com.jtzh.vo.trafficAccident.TrafficAccidentDistributeVO> vos = this.trafficAccidentDistributeMapper.selectByEventID(id);
/* 686 */     return vos.size() > 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\TrafficAccidentServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */