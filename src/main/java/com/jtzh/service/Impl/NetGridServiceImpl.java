/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.entity.*;
import com.jtzh.mapper.*;
import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.gis.PieCountVO;
/*     */ import com.jtzh.vo.netGrid.NetGridEventQueryVO;
/*     */ import com.jtzh.vo.netGrid.NetGridEventVO;
/*     */ import com.jtzh.vo.netGrid.NetGridMemberQueryVO;
/*     */ import com.jtzh.vo.netGrid.NetGridMemberVO;
import com.jtzh.vo.ss.FileUpdateVO;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.*;
/*     */
/*     */
/*     */
/*     */ import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/*     */
/*     */ @org.springframework.stereotype.Service
/*     */ public class NetGridServiceImpl implements com.jtzh.service.NetGridService
/*     */ {
/*     */   @Resource
/*     */   private NetGridMapper netGridMapper;
/*     */   @Resource
/*     */   private NetGridMemberMapper netGridMemberMapper;
/*     */   @Resource
/*     */   private NetGridEventMapper netGridEventMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODENetGridEventTypeMapper codeNetGridEventTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODENetGridEventStatusTypeMapper codeNetGridEventStatusTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventInvolvedPersonsMapper netGridEventInvolvedPersonsMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventCheckedMapper netGridEventCheckedMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventDealingMapper netGridEventDealingMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventDealingPictureMapper netGridEventDealingPictureMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventDealingVideoFileMapper netGridEventDealingVideoFileMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventDistributeMapper netGridEventDistributeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventPictureMapper netGridEventPictureMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridEventVideoFileMapper netGridEventVideoFileMapper;
/*     */   @Resource
/*     */   private PictureMapper pictureMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.TEFileMapper teFileMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridMemberTMapper netGridMemberTMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridMemberPhotoMapper netGridMemberPhotoMapper;
            @Resource
            private TenetgrideventreturnMapper tenetgrideventreturnMapper;
            @Resource
            private CgshangbaoMapper cgshangbaoMapper;
            @Resource
            private HwshangbaoMapper hwshangbaoMapper;
            @Resource
            private KeyproProblemMapper keyproProblemMapper;
/*     */   private static final String NETGRIDEVENTPICTURE = "/NetGrid/Event/Picture/";
/*     */   private static final String NETGRIDEVENTVIDEO = "/NetGrid/Event/Video/";
/*     */   private static final String NETGRIDEVENTDEALINGPICTURE = "/NetGrid/Event/DealingPicture/";
/*     */   private static final String NETGRIDEVENTDEALINGVIDEO = "/NetGrid/Event/DealingVideo/";
/*     */   
/*     */   public boolean insertNetGridMember(NetGridMember member)
/*     */   {
/*  74 */     return this.netGridMemberMapper.insert(member) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateNetGridMember(NetGridMember member)
/*     */   {
/*  79 */     return this.netGridMemberMapper.updateByPrimaryKey(member) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Map getNetGridEventCode()
/*     */   {
/*  85 */     Map map = new HashMap();
/*  86 */     map.put("NetGridEventType", this.codeNetGridEventTypeMapper.selectAll());
/*  87 */     map.put("NetGridEventStatusType", this.codeNetGridEventStatusTypeMapper.selectAll());
/*  88 */     return map;
/*     */   }
/*     */   
/*     */   public boolean updateNetGridEventStatus(String type, Long id)
/*     */   {
/*  93 */     return this.netGridEventMapper.updateNetGridEventStatus(type, id) != 0;
/*     */   }
/*     */   
/*     */   public NetGridMemberQueryVO getNetGridMemberQuery(Integer netGridID, String name, String certID, Integer isServicePerson, int page, int pageSize)
/*     */   {
/*  98 */     int start = 0;
/*  99 */     if (page > 1)
/* 100 */       start = (page - 1) * pageSize;
/* 101 */     List<com.jtzh.vo.netGrid.NetGridMemberVO> vos = this.netGridMemberMapper.getNetGridMemberQuery(netGridID, name, certID, isServicePerson, start, pageSize);
/* 102 */     int count = this.netGridMemberMapper.getNetGridMemberQueryCount(netGridID, name, certID, isServicePerson);
/* 103 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 104 */     NetGridMemberQueryVO vo = new NetGridMemberQueryVO();
/* 105 */     vo.setP(p);
/* 106 */     vo.setVos(vos);
/* 107 */     return vo;
/*     */   }
/*     */   
/*     */   public Map getNetGridMemberDetail(Long id)
/*     */   {
/* 112 */     NetGridMemberPhoto photo = this.netGridMemberPhotoMapper.selectByMemberID(id);
/* 113 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 114 */     String photoPath = photo.getPhotoFilePath() + photo.getPhotoFileName() + photo.getPhotoFileSuffix();
/* 115 */     com.jtzh.vo.netGrid.NetGridMemberVO vo = this.netGridMemberMapper.getNetGridMemberDetail(id);
/* 116 */     Map map = new HashMap();
/* 117 */     map.put("photoPath", photoPath);
/* 118 */     map.put("memberDetail", vo);
/* 119 */     return map;
/*     */   }
/*     */   
/*     */   public Map getNetGridMemberDetailToUpdate(Long id)
/*     */   {
/* 124 */     NetGridMemberPhoto photo = this.netGridMemberPhotoMapper.selectByMemberID(id);
/* 125 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 126 */     String photoPath = photo.getPhotoFilePath() + photo.getPhotoFileName() + photo.getPhotoFileSuffix();
/* 127 */     NetGridMember member = this.netGridMemberMapper.selectByPrimaryKey(id);
/* 128 */     Map map = new HashMap();
/* 129 */     map.put("photoPath", photoPath);
/* 130 */     map.put("memberDetail", member);
/* 131 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public List getNetGridMemberHistogram()
/*     */   {
/* 137 */     List<PieCountVO> list = this.netGridMemberMapper.getNetGridMemberCount();
/* 138 */     List l = new ArrayList();
/* 139 */     int len = list.size();
/* 140 */     String[] name = new String[len];
/* 141 */     int[] value = new int[len];
/* 142 */     for (int i = 0; i < len; i++) {
/* 143 */       PieCountVO v = (PieCountVO)list.get(i);
/* 144 */       name[i] = v.getName();
/* 145 */       value[i] = v.getValue();
/*     */     }
/* 147 */     l.add(name);
/* 148 */     l.add(value);
/* 149 */     return l;
/*     */   }
/*     */   
/*     */   public Long insertNetGridEventBasic(com.jtzh.entity.NetGridEvent event)
/*     */   {
/* 154 */     boolean flag = this.netGridEventMapper.insert(event) != 0;
/* 155 */     if (flag)
/* 156 */       return event.getEventID();
/* 157 */     return null;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventPictures(MultipartFile file, Long ID)
/*     */   {
/* 162 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 163 */     if ((file != null) && (!file.isEmpty())) {
/* 164 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 166 */       String originFileName = file.getOriginalFilename();
/* 167 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 170 */       File outPath = new File(root_path + "/NetGrid/Event/Picture/");
/* 171 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 172 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 176 */       File outFile = new File(root_path + "/NetGrid/Event/Picture/" + filename + extension);
/*     */       try
/*     */       {
/* 179 */         file.transferTo(outFile);
/*     */         
/* 181 */         Picture p = new Picture();
/* 182 */         p.setPictureName(filename);
/* 183 */         p.setPictureSuffix(extension);
/* 184 */         p.setPicturePath("/NetGrid/Event/Picture/");
/* 185 */         this.pictureMapper.insert(p);
/* 186 */         Long pictureID = p.getPictureID();
/* 187 */         com.jtzh.entity.NetGridEventPicture picture = new com.jtzh.entity.NetGridEventPicture();
/* 188 */         picture.setEventID(ID);
/* 189 */         picture.setPictureID(pictureID);
/* 190 */         return this.netGridEventPictureMapper.insert(picture) != 0;
/*     */       } catch (IOException e) {
/* 192 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 196 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventVideo(MultipartFile file, Long ID)
/*     */   {
/* 201 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 202 */     if ((file != null) && (!file.isEmpty())) {
/* 203 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 205 */       String originFileName = file.getOriginalFilename();
/* 206 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 209 */       File outPath = new File(root_path + "/NetGrid/Event/Video/");
/* 210 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 211 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 215 */       File outFile = new File(root_path + "/NetGrid/Event/Video/" + filename + extension);
/*     */       try
/*     */       {
/* 218 */         file.transferTo(outFile);
/*     */         
/* 220 */         TEFile f = new TEFile();
/* 221 */         f.setFileName(filename);
/* 222 */         f.setFilePath("/NetGrid/Event/Video/");
/* 223 */         f.setFileSuffix(extension);
/* 224 */         this.teFileMapper.insert(f);
/* 225 */         Long fileID = f.getFileID();
/* 226 */         com.jtzh.entity.NetGridEventVideoFile videoFile = new com.jtzh.entity.NetGridEventVideoFile();
/* 227 */         videoFile.setEventID(ID);
/* 228 */         videoFile.setFileID(fileID);
/* 229 */         return this.netGridEventVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 231 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventInvolvedPersons(com.jtzh.entity.NetGridEventInvolvedPersons persons)
/*     */   {
/* 239 */     return this.netGridEventInvolvedPersonsMapper.insert(persons) != 0;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventDistribute(com.jtzh.entity.NetGridEventDistribute distribute)
/*     */   {
/* 244 */     return this.netGridEventDistributeMapper.insert(distribute) != 0;
/*     */   }

    @Override
    @Transactional
    public boolean deleteNetGridEventDistribute(Tenetgrideventreturn tenetgrideventreturn) {
        tenetgrideventreturn.setDelflag("A");
        tenetgrideventreturn.setReturntime(new Date());
        tenetgrideventreturn.setType("1");
        tenetgrideventreturnMapper.insert(tenetgrideventreturn);
        netGridEventMapper.updateNetGridEventStatus("03",tenetgrideventreturn.getEventid());
        if(tenetgrideventreturn.getReturndep().equals("城管部门")){
            cgshangbaoMapper.deleteByPrimaryResouce(String.valueOf(tenetgrideventreturn.getEventid()),"综治网格联动问题");
        }else if (tenetgrideventreturn.getReturndep().equals("环卫部门")) {
            hwshangbaoMapper.deleteBySourceId(String.valueOf(tenetgrideventreturn.getEventid()),"综治网格联动问题");
        }else{
            keyproProblemMapper.deleteBySourceId(String.valueOf(tenetgrideventreturn.getEventid()),"综治网格联动问题");
        }
        return this.netGridEventDistributeMapper.deleteByPrimaryKey(tenetgrideventreturn.getEventid()) != 0;
    }

    /*     */
/*     */   public Long addNetGridEventDealingBasic(NetGridEventDealing dealing)
/*     */   {
/* 249 */     boolean flag = this.netGridEventDealingMapper.insert(dealing) != 0;
/* 250 */     if (flag)
/* 251 */       return dealing.getEventDealingID();
/* 252 */     return null;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventDealingPictures(MultipartFile[] file, Long ID)
/*     */   {
/* 257 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 258 */     boolean flag = false;
/* 259 */     if (file.length > 0) {
/* 260 */       for (int i = 0; i < file.length; i++) {
/* 261 */         if ((file[i] != null) && (!file[i].isEmpty())) {
/* 262 */           String filename = String.valueOf(System.currentTimeMillis());
/*     */           
/* 264 */           String originFileName = file[i].getOriginalFilename();
/* 265 */           String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */           
/*     */ 
/* 268 */           File outPath = new File(root_path + "/NetGrid/Event/DealingPicture/");
/* 269 */           if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 270 */             outPath.mkdirs();
/*     */           }
/*     */           
/*     */ 
/* 274 */           File outFile = new File(root_path + "/NetGrid/Event/DealingPicture/" + filename + extension);
/*     */           try
/*     */           {
/* 277 */             file[i].transferTo(outFile);
/*     */             
/* 279 */             Picture p = new Picture();
/* 280 */             p.setPictureName(filename);
/* 281 */             p.setPictureSuffix(extension);
/* 282 */             p.setPicturePath("/NetGrid/Event/DealingPicture/");
/* 283 */             this.pictureMapper.insert(p);
/* 284 */             Long pictureID = p.getPictureID();
/* 285 */             com.jtzh.entity.NetGridEventDealingPicture picture = new com.jtzh.entity.NetGridEventDealingPicture();
/* 286 */             picture.setEventDealingID(ID);
/* 287 */             picture.setPictureID(pictureID);
/* 288 */             flag = this.netGridEventDealingPictureMapper.insert(picture) != 0;
/* 289 */             if (!flag)
/*     */               break;
/*     */           } catch (IOException e) {
/* 292 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 297 */       flag = true;
/*     */     }
/* 299 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 304 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 305 */     if ((file != null) && (!file.isEmpty())) {
/* 306 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 308 */       String originFileName = file.getOriginalFilename();
/* 309 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 312 */       File outPath = new File(root_path + "/NetGrid/Event/DealingVideo/");
/* 313 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 314 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 318 */       File outFile = new File(root_path + "/NetGrid/Event/DealingVideo/" + filename + extension);
/*     */       try
/*     */       {
/* 321 */         file.transferTo(outFile);
/*     */         
/* 323 */         TEFile f = new TEFile();
/* 324 */         f.setFileName(filename);
/* 325 */         f.setFilePath("/NetGrid/Event/DealingVideo/");
/* 326 */         f.setFileSuffix(extension);
/* 327 */         this.teFileMapper.insert(f);
/* 328 */         Long fileID = f.getFileID();
/* 329 */         com.jtzh.entity.NetGridEventDealingVideoFile videoFile = new com.jtzh.entity.NetGridEventDealingVideoFile();
/* 330 */         videoFile.setEventDealingID(ID);
/* 331 */         videoFile.setFileID(fileID);
/* 332 */         return this.netGridEventDealingVideoFileMapper.insert(videoFile) != 0;
/*     */       } catch (IOException e) {
/* 334 */         e.printStackTrace();
/*     */       }
/*     */     } else {
/* 337 */       return true;
/*     */     }
/* 339 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addNetGridEventChecked(com.jtzh.entity.NetGridEventChecked checked)
/*     */   {
/* 344 */     return this.netGridEventCheckedMapper.insert(checked) != 0;
/*     */   }
/*     */   
/*     */   private Map getNetGridEventMedia(Long id)
/*     */   {
/* 349 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 350 */     List<Picture> pictures = this.pictureMapper.selectByNetGridEventID(id);
/* 351 */     List picturePaths = new ArrayList();
/* 352 */     List videoPaths = new ArrayList();
/* 353 */     if (pictures.size() > 0) {
/* 354 */       for (Picture p : pictures) {
/* 355 */         FileUpdateVO vo = new FileUpdateVO();
/* 356 */         String path =  p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 357 */         vo.setId(p.getPictureID());
/* 358 */         vo.setUrl(path);
/* 359 */         picturePaths.add(vo);
/*     */       }
/*     */     }
/* 362 */     TEFile file = this.teFileMapper.selectByNetGridEventID(id);
/* 363 */     String videoPath = null;
/* 364 */     if (file != null) {
/* 365 */       videoPath = file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 366 */       FileUpdateVO vo = new FileUpdateVO();
/* 367 */       vo.setId(file.getFileID());
/* 368 */       vo.setUrl(videoPath);
/* 369 */       videoPaths.add(vo);
/*     */     }
/* 371 */     Map map = new HashMap();
/* 372 */     map.put("pictures", picturePaths);
/* 373 */     map.put("video", videoPaths);
/* 374 */     return map;
/*     */   }
/*     */   
/*     */   private Map getNetGridEventDealingMedia(Long id) {
/* 378 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 379 */     List<Picture> pictures = this.pictureMapper.selectNetGridEventDealingPictureByEventID(id);
/* 380 */     List picturePaths = new ArrayList();
/* 381 */     List videoPaths = new ArrayList();
Picture p;
/* 382 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/* 383 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (Picture)localIterator.next();
/* 384 */         FileUpdateVO vo = new FileUpdateVO();
/* 385 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 386 */         vo.setId(p.getPictureID());
/* 387 */         vo.setUrl(path);
/* 388 */         picturePaths.add(vo);
/*     */       }
/*     */     
/* 391 */     List<TEFile> files = this.teFileMapper.selectNetGridEventDealingFileByEventID(id);
/* 392 */     if ((files).size() > 0) {
/* 393 */       for (TEFile file : files) {
/* 394 */         String videoPath = file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 395 */         FileUpdateVO vo = new FileUpdateVO();
/* 396 */         vo.setId(file.getFileID());
/* 397 */         vo.setUrl(videoPath);
/* 398 */         videoPaths.add(vo);
/*     */       }
/*     */     }
/* 401 */     Map map = new HashMap();
/* 402 */     map.put("pictures", picturePaths);
/* 403 */     map.put("video", videoPaths);
/* 404 */     return map;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventReporterQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 409 */     int start = 0;
/* 410 */     if (page > 1)
/* 411 */       start = (page - 1) * pageSize;
/* 412 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventReporterQuery(id, kind, name, netGridID, status, start, pageSize);
/* 413 */     int count = this.netGridEventMapper.getNetGridEventReporterQueryCount(id, kind, name, netGridID, status);
/* 414 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 415 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 416 */     vo.setVos(vos);
/* 417 */     vo.setPage(p);
/* 418 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 423 */     int start = 0;
/* 424 */     if (page > 1)
/* 425 */       start = (page - 1) * pageSize;
/* 426 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventDespatcherQuery(id, kind, name, netGridID, status, start, pageSize);
/* 427 */     int count = this.netGridEventMapper.getNetGridEventDespatcherQueryCount(id, kind, name, netGridID, status);
/* 428 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 429 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 430 */     vo.setVos(vos);
/* 431 */     vo.setPage(p);
/* 432 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventDeptDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 437 */     int start = 0;
/* 438 */     if (page > 1)
/* 439 */       start = (page - 1) * pageSize;
/* 440 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventDeptDespatcherQuery(id, kind, name, netGridID, status, start, pageSize);
/* 441 */     int count = this.netGridEventMapper.getNetGridEventDeptDespatcherQueryCount(id, kind, name, netGridID, status);
/* 442 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 443 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 444 */     vo.setVos(vos);
/* 445 */     vo.setPage(p);
/* 446 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventHandlerQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 451 */     int start = 0;
/* 452 */     if (page > 1)
/* 453 */       start = (page - 1) * pageSize;
/* 454 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventHandlerQuery(id, kind, name, netGridID, status, start, pageSize);
/* 455 */     int count = this.netGridEventMapper.getNetGridEventHandlerQueryCount(id, kind, name, netGridID, status);
/* 456 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 457 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 458 */     vo.setVos(vos);
/* 459 */     vo.setPage(p);
/* 460 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventAuditorQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 465 */     int start = 0;
/* 466 */     if (page > 1)
/* 467 */       start = (page - 1) * pageSize;
/* 468 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventAuditorQuery(id, kind, name, netGridID, status, start, pageSize);
/* 469 */     int count = this.netGridEventMapper.getNetGridEventAuditorQueryCount(id, kind, name, netGridID, status);
/* 470 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 471 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 472 */     vo.setVos(vos);
/* 473 */     vo.setPage(p);
/* 474 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventAPPQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 479 */     int start = 0;
/* 480 */     if (page > 1)
/* 481 */       start = (page - 1) * pageSize;
/* 482 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventAPPQuery(id, kind, name, netGridID, status, start, pageSize);
/* 483 */     int count = this.netGridEventMapper.getNetGridEventAPPQueryCount(id, kind, name, netGridID, status);
/* 484 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 485 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 486 */     vo.setVos(vos);
/* 487 */     vo.setPage(p);
/* 488 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGridEventQueryVO getNetGridEventForNetGrid(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 493 */     int start = 0;
/* 494 */     if (page > 1)
/* 495 */       start = (page - 1) * pageSize;
/* 496 */     List<NetGridEventVO> vos = this.netGridEventMapper.getNetGridEventForNetGrid(id, kind, name, netGridID, status, start, pageSize);
/* 497 */     int count = this.netGridEventMapper.getNetGridEventForNetGridCount(id, kind, name, netGridID, status);
/* 498 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 499 */     NetGridEventQueryVO vo = new NetGridEventQueryVO();
/* 500 */     vo.setVos(vos);
/* 501 */     vo.setPage(p);
/* 502 */     return vo;
/*     */   }
/*     */   
/*     */   public Map getNetGridEventDetail(Long id)
/*     */   {
/* 507 */     com.jtzh.vo.netGrid.NetGridEventDetailVO netGridEventDetailBasic = this.netGridEventMapper.getNetGridEventDetail(id);
/* 508 */     List<com.jtzh.entity.NetGridEventInvolvedPersons> involvedPersons = this.netGridEventInvolvedPersonsMapper.selectByEventID(id);
/* 509 */     List<com.jtzh.vo.netGrid.NetGridEventDistributeVO> distribute = this.netGridEventDistributeMapper.selectByEventID(id);
/* 510 */     List<com.jtzh.vo.netGrid.NetGridEventDealingVO> dealingBasic = this.netGridEventDealingMapper.selectByEventID(id);
/* 511 */     List<com.jtzh.vo.netGrid.NetGridEventCheckedVO> checked = this.netGridEventCheckedMapper.selectByEventID(id);
/* 512 */     Map map = new HashMap();
/* 513 */     map.put("netGridEventDetailBasic", netGridEventDetailBasic);
/* 514 */     map.put("involvedPersons", involvedPersons);
/* 515 */     map.put("netGridEventMedia", getNetGridEventMedia(id));
/* 516 */     map.put("distribute", distribute);
/* 517 */     map.put("dealingBasic", dealingBasic);
/* 518 */     map.put("dealingMedia", getNetGridEventDealingMedia(id));
/* 519 */     map.put("checked", checked);
/* 520 */     return map;
/*     */   }
/*     */   
/*     */   public com.jtzh.vo.netGrid.NetGridQueryVO getNetGridQuery(String netGridName, String netGridLeaderName, int page, int pageSize)
/*     */   {
/* 525 */     int start = 0;
/* 526 */     if (page > 1)
/* 527 */       start = (page - 1) * pageSize;
/* 528 */     List<com.jtzh.vo.netGrid.NetGridVO> grids = this.netGridMapper.getNetGridQuery(netGridName, netGridLeaderName, start, pageSize);
              List<com.jtzh.vo.netGrid.NetGridVO> g = new ArrayList<com.jtzh.vo.netGrid.NetGridVO>();
              for (com.jtzh.vo.netGrid.NetGridVO grid : grids){
                  if (grid.getFatherNetGridID() != -1){
                      g.add(grid);
                      continue;
                  }
                  com.jtzh.vo.netGrid.NetGridVO n = netGridMapper.getNetGirdNumber(grid.getNetGridID());
                  grid.setNetureGrid(String.valueOf(Integer.valueOf(n.getNetureGrid()) - Integer.valueOf(n.getExclusiveGrid())));
                  grid.setExclusiveGrid(n.getExclusiveGrid());
                  g.add(grid);
              }
/* 529 */     int count = this.netGridMapper.getNetGridQueryCount(netGridName, netGridLeaderName);
/* 530 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 531 */     com.jtzh.vo.netGrid.NetGridQueryVO vo = new com.jtzh.vo.netGrid.NetGridQueryVO();
/* 532 */     vo.setGrids(g);
/* 533 */     vo.setPage(p);
/* 534 */     return vo;
/*     */   }
/*     */   
/*     */   public NetGrid getNetGridDetail(Long id)
/*     */   {
/* 539 */     return this.netGridMapper.selectByPrimaryKey(id);
/*     */   }
/*     */   
/*     */   public boolean addNetGrid(NetGrid netGrid)
/*     */   {
/* 544 */     return this.netGridMapper.insert(netGrid) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateNetGrid(NetGrid netGrid)
/*     */   {
/* 549 */     return this.netGridMapper.updateByPrimaryKey(netGrid) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteNetGrid(Long id)
/*     */   {
/* 554 */     return this.netGridMapper.deleteByPrimaryKey(id) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.ss.SSCountVO> getNetGridEventCount()
/*     */   {
/* 560 */     return this.netGridEventMapper.getNetGridEventCount();
/*     */   }
/*     */   
/*     */   public boolean isDistribute(Long id)
/*     */   {
/* 565 */     List<com.jtzh.vo.netGrid.NetGridEventDistributeVO> vos = this.netGridEventDistributeMapper.selectByEventID(id);
/* 566 */     return vos.size() > 0;
/*     */   }
/*     */   
/*     */   public Map getNetGridMemberInfo(Long id)
/*     */   {
/* 571 */     com.jtzh.vo.netGrid.NetGridFatherAndChildVO fatherAndChildVO = this.netGridMapper.getNetGridFaterAndChildName(id);
/* 572 */     Map map = new HashMap();
/* 573 */     map.put("fatherAndChildVO", fatherAndChildVO);
/* 574 */     map.put("netGridMember", this.netGridMemberTMapper.selectByPrimaryKey(id));
/* 575 */     return map;
/*     */   }
/*     */   
/*     */   public List<com.jtzh.entity.NetGridMemberT> getNetGridMemberByFatherID(Long id)
/*     */   {
/* 580 */     return this.netGridMemberTMapper.getByFatherID(id);
/*     */   }
/*     */   
/*     */   public List<Map<String, String>> getNetGridByFaterID(Long netGridID)
/*     */   {
/* 585 */     return this.netGridMapper.getNetGridByFaterID(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Map<String, String>> getAllNetGrid()
/*     */   {
/* 591 */     return this.netGridMapper.getAllNetGrid();
/*     */   }



    /*     */
/*     */ 
/*     */   @org.springframework.transaction.annotation.Transactional
/*     */   public boolean addNetGridEventDealingFromAPP(String eventID, String dealingUserID, String dealingTime, String dealingInf, String remark, MultipartFile[] pictures, MultipartFile video)
/*     */   {
/* 598 */     boolean flag = false;
/* 599 */     NetGridEventDealing dealing = new NetGridEventDealing();
/* 600 */     dealing.setEventID(Long.valueOf(eventID));
/* 601 */     dealing.setDealingUserID(Long.valueOf(dealingUserID));
/*     */     try {
/* 603 */       dealing.setDealingTime(com.jtzh.util.DateUtil.strToDateTime(dealingTime));
/*     */     } catch (java.text.ParseException e) {
/* 605 */       e.printStackTrace();
/*     */     }
/* 607 */     dealing.setDealingInf(dealingInf);
/* 608 */     dealing.setRemark(remark);
/* 609 */     flag = this.netGridEventDealingMapper.insert(dealing) != 0;
/* 610 */     if (flag) {
/* 611 */       Long ID = dealing.getEventDealingID();
/* 612 */       flag = addNetGridEventDealingPictures(pictures, ID);
/* 613 */       if (flag) {
/* 614 */         flag = addNetGridEventDealingVideo(video, ID);
/*     */       }
/*     */     }
/* 617 */     return flag;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\NetGridServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */