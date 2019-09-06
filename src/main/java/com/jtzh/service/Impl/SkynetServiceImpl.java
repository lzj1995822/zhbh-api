/*      */ package com.jtzh.service.Impl;
/*      */ import com.jtzh.util.CommonUtils;
/*      */ import com.jtzh.util.Page;
/*      */ import com.jtzh.util.PageUtil;
/*      */ import com.jtzh.vo.app.EventDealingPictureVO;
import com.jtzh.vo.app.EventDealingVideoVO;
/*      */ import com.jtzh.vo.skynet.SPExVO;
/*      */ import com.jtzh.vo.skynet.SPQueryVO;
/*      */ import com.jtzh.vo.ss.FileUpdateVO;
import com.jtzh.entity.Picture;
import com.jtzh.entity.SPProcessionPhoto;
import com.jtzh.entity.SkynetPEDealingPicture;
import com.jtzh.entity.SkynetPatrolEventDealing;
import com.jtzh.entity.SkynetPatrolEventDealingVideoFile;
import com.jtzh.entity.SkynetPatrolEventInvolvedPersons;
import com.jtzh.entity.SkynetPatrolEventPicture;
import com.jtzh.entity.TEFile;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.SPProcessionMapper;
import com.jtzh.mapper.SPProcessionPersonMapper;
import com.jtzh.mapper.SPProcessionPhotoMapper;
import com.jtzh.mapper.SkynetPatrolEventInvolvedPersonsMapper;
import com.jtzh.mapper.SkynetPatrolEventMapper;
import com.jtzh.mapper.TEFileMapper;

/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.web.multipart.MultipartFile;
/*      */ 
/*      */ @org.springframework.stereotype.Service
/*      */ public class SkynetServiceImpl implements com.jtzh.service.SkynetService
/*      */ {
/*      */   @Autowired
/*      */   private SkynetPatrolEventMapper skynetPatrolEventMapper;
/*      */   @Autowired
/*      */   private SkynetPatrolEventInvolvedPersonsMapper skynetPatrolEventInvolvedPersonsMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPatrolEventPictureMapper skynetPatrolEventPictureMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPatrolEventVideoFileMapper skynetPatrolEventVideoFileMapper;
/*      */   @Autowired
/*      */   private PictureMapper pictureMapper;
/*      */   @Autowired
/*      */   private TEFileMapper teFileMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.CODESkynetPatrolEventTypeMapper codeSkynetPatrolEventTypeMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.CODESkynetPatrolEventStatusTypeMapper codeSkynetPatrolEventStatusTypeMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPatrolEventDealingMapper skynetPatrolEventDealingMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPEDealingPictureMapper skynetPEDealingPictureMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPatrolEventDealingVideoFileMapper skynetPatrolEventDealingVideoFileMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPatrolEventDistributeMapper skynetPatrolEventDistributeMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SkynetPatrolEventCheckedMapper skynetPatrolEventCheckedMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.UserMapper userMapper;
/*      */   @Autowired
/*      */   private SPProcessionMapper processionMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SPRegionMapper regionMapper;
/*      */   @Autowired
/*      */   private SPProcessionPersonMapper spProcessionPersonMapper;
/*      */   @Autowired
/*      */   private SPProcessionPhotoMapper spProcessionPhotoMapper;
/*      */   @Autowired
/*      */   private com.jtzh.mapper.SPTrailMapper trailMapper;
/*      */   private static final String SPEVENTPICTURE_PATH = "/SkynetPatrolEvent/picture/";
/*      */   private static final String SPEVENTVIDEO_PATH = "/SkynetPatrolEvent/video/";
/*      */   private static final String SPEVENTDEALINGPICTURE_PATH = "/SkynetPatrolEvent/DealingPicture/";
/*      */   private static final String SPEVENTDEALINGVIDEO_PATH = "/SkynetPatrolEvent/DealingVideo/";
/*      */   private static final String PROCESSIONPERSONPHOTO = "/SkynetPatrolEvent/procession/PersonPhoto/";
/*      */   
/*      */   public Long insertSPEvent(com.jtzh.entity.SkynetPatrolEvent event)
/*      */   {
/*   82 */     boolean flag = this.skynetPatrolEventMapper.insert(event) != 0;
/*   83 */     if (flag)
/*   84 */       return event.getSpEventID();
/*   85 */     return null;
/*      */   }
/*      */   
/*      */   public boolean updateSPEvent(com.jtzh.entity.SkynetPatrolEvent event)
/*      */   {
/*   90 */     return this.skynetPatrolEventMapper.updateByPrimaryKey(event) != 0;
/*      */   }
/*      */   
/*      */   public boolean changeSPEventStatus(String type, Long id)
/*      */   {
/*   95 */     return this.skynetPatrolEventMapper.updateSPEventStatus(type, id) != 0;
/*      */   }
/*      */   
/*      */   public boolean insertSPEventInvolvedPersons(SkynetPatrolEventInvolvedPersons persons)
/*      */   {
/*  100 */     return this.skynetPatrolEventInvolvedPersonsMapper.insert(persons) != 0;
/*      */   }
/*      */   
/*      */   public boolean updateSPEventInvolvedPersons(SkynetPatrolEventInvolvedPersons persons)
/*      */   {
/*  105 */     return this.skynetPatrolEventInvolvedPersonsMapper.updateByPrimaryKey(persons) != 0;
/*      */   }
/*      */   
/*      */   public boolean deleteSPEventInvolvedPersons(Long id)
/*      */   {
/*  110 */     return this.skynetPatrolEventInvolvedPersonsMapper.deleteByPrimaryKey(id) != 0;
/*      */   }
/*      */   
/*      */   public List<com.jtzh.vo.skynet.UserVO> getUserInfoByKey(String key)
/*      */   {
/*  115 */     return this.userMapper.selectUserByKey(key);
/*      */   }

    /*      */   public List<com.jtzh.vo.skynet.UserVO> getUserInfoByKeyDept(String key)
    /*      */   {
        /*  115 */     return this.userMapper.selectUserByKeyDept(key);
        /*      */   }
/*      */   
/*      */ 
/*      */   public boolean insertSPEventDistribute(com.jtzh.entity.SkynetPatrolEventDistribute distribute)
/*      */   {
/*  121 */     return this.skynetPatrolEventDistributeMapper.insert(distribute) != 0;
/*      */   }
/*      */   
/*      */   public boolean insertSPEventChecked(com.jtzh.entity.SkynetPatrolEventChecked checked)
/*      */   {
/*  126 */     return this.skynetPatrolEventCheckedMapper.insert(checked) != 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPQueryVO getSPEventReporterQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  142 */     int start = 0;
/*  143 */     if (page > 1)
/*  144 */       start = (page - 1) * pageSize;
/*  145 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventReporterQuery(id, name, type, netGridID, status, start, pageSize);
/*  146 */     int count = this.skynetPatrolEventMapper.getSPEventReporterQueryCount(id, name, type, netGridID, status);
/*  147 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  148 */     SPQueryVO vo = new SPQueryVO();
/*  149 */     vo.setList(list);
/*  150 */     vo.setPage(p);
/*  151 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPQueryVO getSPEventDespatcherQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  167 */     int start = 0;
/*  168 */     if (page > 1)
/*  169 */       start = (page - 1) * pageSize;
/*  170 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventDespatcherQuery(id, name, type, netGridID, status, start, pageSize);
/*  171 */     int count = this.skynetPatrolEventMapper.getSPEventDespatcherQueryCount(id, name, type, netGridID, status);
/*  172 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  173 */     SPQueryVO vo = new SPQueryVO();
/*  174 */     vo.setList(list);
/*  175 */     vo.setPage(p);
/*  176 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPQueryVO getSPEventDeptDespatcherQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  192 */     int start = 0;
/*  193 */     if (page > 1)
/*  194 */       start = (page - 1) * pageSize;
/*  195 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventDeptDespatcherQuery(id, name, type, netGridID, status, start, pageSize);
/*  196 */     int count = this.skynetPatrolEventMapper.getSPEventDeptDespatcherQueryCount(id, name, type, netGridID, status);
/*  197 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  198 */     SPQueryVO vo = new SPQueryVO();
/*  199 */     vo.setList(list);
/*  200 */     vo.setPage(p);
/*  201 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPQueryVO getSPEventHandlerQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  217 */     int start = 0;
/*  218 */     if (page > 1)
/*  219 */       start = (page - 1) * pageSize;
/*  220 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventHandlerQuery(id, name, type, netGridID, status, start, pageSize);
/*  221 */     int count = this.skynetPatrolEventMapper.getSPEventHandlerQueryCount(id, name, type, netGridID, status);
/*  222 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  223 */     SPQueryVO vo = new SPQueryVO();
/*  224 */     vo.setList(list);
/*  225 */     vo.setPage(p);
/*  226 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPQueryVO getSPEventAuditorQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  242 */     int start = 0;
/*  243 */     if (page > 1)
/*  244 */       start = (page - 1) * pageSize;
/*  245 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventAuditorQuery(id, name, type, netGridID, status, start, pageSize);
/*  246 */     int count = this.skynetPatrolEventMapper.getSPEventAuditorQueryCount(id, name, type, netGridID, status);
/*  247 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  248 */     SPQueryVO vo = new SPQueryVO();
/*  249 */     vo.setList(list);
/*  250 */     vo.setPage(p);
/*  251 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPQueryVO getSPEventAPPQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  267 */     int start = 0;
/*  268 */     if (page > 1)
/*  269 */       start = (page - 1) * pageSize;
/*  270 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventAPPQuery(id, name, type, netGridID, status, start, pageSize);
/*  271 */     int count = this.skynetPatrolEventMapper.getSPEventAPPQueryCount(id, name, type, netGridID, status);
/*  272 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  273 */     SPQueryVO vo = new SPQueryVO();
/*  274 */     vo.setList(list);
/*  275 */     vo.setPage(p);
/*  276 */     return vo;
/*      */   }
/*      */   
/*      */   public SPQueryVO getSPEventForNetGrid(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*      */   {
/*  281 */     int start = 0;
/*  282 */     if (page > 1)
/*  283 */       start = (page - 1) * pageSize;
/*  284 */     List<SPExVO> list = this.skynetPatrolEventMapper.getSPEventForNetGrid(id, name, type, netGridID, status, start, pageSize);
/*  285 */     int count = this.skynetPatrolEventMapper.getSPEventForNetGridCount(id, name, type, netGridID, status);
/*  286 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  287 */     SPQueryVO vo = new SPQueryVO();
/*  288 */     vo.setList(list);
/*  289 */     vo.setPage(p);
/*  290 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map getSPEventDetail(Long id)
/*      */   {
/*  302 */     Map map = new HashMap();
/*  303 */     com.jtzh.vo.skynet.SPVO spvo = this.skynetPatrolEventMapper.selectBySPEventID(id);
/*  304 */     List<SkynetPatrolEventInvolvedPersons> involvedPersons = this.skynetPatrolEventInvolvedPersonsMapper.selectBySPEventID(id);
/*  305 */     List<com.jtzh.vo.skynet.SPDistributeVO> distributeVOS = this.skynetPatrolEventDistributeMapper.selectBySPEventID(id);
/*  306 */     List<com.jtzh.vo.skynet.SPDealingVO> dealingVOS = this.skynetPatrolEventDealingMapper.selectBySPEventID(id);
/*  307 */     List<com.jtzh.vo.skynet.SPCheckedVO> checkedVOS = this.skynetPatrolEventCheckedMapper.selectBySPEventID(id);
/*  308 */     map.put("SPEventBasic", spvo);
/*  309 */     map.put("involvedPersons", involvedPersons);
/*  310 */     map.put("SPEventMedia", getSPEventMedia(id));
/*  311 */     map.put("distribute", distributeVOS);
/*  312 */     map.put("dealingBasic", dealingVOS);
/*  313 */     map.put("dealingMedia", getSPEventDealingMedia(id));
/*  314 */     map.put("checked", checkedVOS);
/*  315 */     return map;
/*      */   }
/*      */   
/*      */   public Map getSPEventDetailForAPP(Long id)
/*      */   {
/*  320 */     Map map = new HashMap();
/*  321 */     com.jtzh.vo.skynet.SPVO spvo = this.skynetPatrolEventMapper.selectBySPEventID(id);
/*  322 */     List<SkynetPatrolEventInvolvedPersons> involvedPersons = this.skynetPatrolEventInvolvedPersonsMapper.selectBySPEventID(id);
/*  323 */     List<com.jtzh.vo.skynet.SPDistributeVO> distributeVOS = this.skynetPatrolEventDistributeMapper.selectBySPEventID(id);
/*  324 */     List<com.jtzh.vo.skynet.SPDealingVO> dealingVOS = this.skynetPatrolEventDealingMapper.selectBySPEventID(id);
/*  325 */     List<com.jtzh.vo.skynet.SPCheckedVO> checkedVOS = this.skynetPatrolEventCheckedMapper.selectBySPEventID(id);
/*  326 */     map.put("SPEventBasic", spvo);
/*  327 */     map.put("involvedPersons", involvedPersons);
/*  328 */     map.put("SPEventMedia", getSPEventMedia(id));
/*  329 */     map.put("distribute", distributeVOS);
/*  330 */     map.put("dealingBasic", dealingVOS);
/*  331 */     map.put("dealingMedia", getSPEventDealingMediaForAPP(id));
/*  332 */     map.put("checked", checkedVOS);
/*  333 */     return map;
/*      */   }
/*      */   
/*      */   public Map getSPEventDetailToUpdate(Long id)
/*      */   {
/*  338 */     Map map = new HashMap();
/*  339 */     com.jtzh.entity.SkynetPatrolEvent spe = this.skynetPatrolEventMapper.selectByPrimaryKey(id);
/*  340 */     List<SkynetPatrolEventInvolvedPersons> involvedPersons = this.skynetPatrolEventInvolvedPersonsMapper.selectBySPEventID(id);
/*  341 */     map.put("basic", spe);
/*  342 */     map.put("involvedPersons", involvedPersons);
/*  343 */     map.put("media", getSPEventMedia(id));
/*  344 */     return map;
/*      */   }
/*      */   
/*      */   public Map getSPEventCode()
/*      */   {
/*  349 */     Map map = new HashMap();
/*  350 */     map.put("SkynetPatrolEventType", this.codeSkynetPatrolEventTypeMapper.selectAll());
/*  351 */     map.put("SkynetPatrolEventStatusType", this.codeSkynetPatrolEventStatusTypeMapper.selectAll());
/*  352 */     return map;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean deleteSPEvent(Long id)
/*      */   {
/*  358 */     boolean flag = deleteSPEventMedia(id);
/*  359 */     if (flag) {
/*  360 */       flag = this.skynetPatrolEventMapper.deleteByPrimaryKey(id) != 0;
/*      */     }
/*  362 */     if (flag) {
/*  363 */       List<SkynetPatrolEventInvolvedPersons> involvedPersons = this.skynetPatrolEventInvolvedPersonsMapper.selectBySPEventID(id);
/*  364 */       if (involvedPersons.size() > 0)
/*  365 */         flag = this.skynetPatrolEventInvolvedPersonsMapper.deleteBySPEventID(id) != 0;
/*      */     }
/*  367 */     return flag;
/*      */   }
/*      */   
/*      */   private Map getSPEventMedia(Long id) {
/*  371 */     String rootPath = CommonUtils.getRootPath("server.root");
/*  372 */     List<Picture> pictures = this.pictureMapper.selectBySPEventID(id);
/*  373 */     List picturePaths = new java.util.ArrayList();
/*  374 */     List videoPaths = new java.util.ArrayList();
/*  375 */     if (pictures.size() > 0) {
/*  376 */       for (Picture p : pictures) {
/*  377 */         FileUpdateVO vo = new FileUpdateVO();
/*  378 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/*  379 */         vo.setId(p.getPictureID());
/*  380 */         vo.setUrl(path);
/*  381 */         picturePaths.add(vo);
/*      */       }
/*      */     }
/*  384 */     TEFile file = this.teFileMapper.selectBySPEventID(id);
/*  385 */     String videoPath = null;
/*  386 */     if (file != null) {
/*  387 */       videoPath = file.getFilePath() + file.getFileName() + file.getFileSuffix();
/*  388 */       FileUpdateVO vo = new FileUpdateVO();
/*  389 */       vo.setId(file.getFileID());
/*  390 */       vo.setUrl(videoPath);
/*  391 */       videoPaths.add(vo);
/*      */     }
/*  393 */     Map map = new HashMap();
/*  394 */     map.put("pictures", picturePaths);
/*  395 */     map.put("video", videoPaths);
/*  396 */     return map;
/*      */   }
/*      */   
/*      */   private Map getSPEventDealingMedia(Long id) {
/*  400 */     String rootPath = CommonUtils.getRootPath("server.root");
/*  401 */     List<Picture> pictures = this.pictureMapper.selectSPEventDealingPictureBySPEventID(id);
/*  402 */     List picturePaths = new java.util.ArrayList();
/*  403 */     List videoPaths = new java.util.ArrayList();
Picture p;
/*  404 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/*  405 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (Picture)localIterator.next();
/*  406 */         FileUpdateVO vo = new FileUpdateVO();
/*  407 */         String path =  p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/*  408 */         vo.setId(p.getPictureID());
/*  409 */         vo.setUrl(path);
/*  410 */         picturePaths.add(vo);
/*      */       }
/*  413 */     List<TEFile> files = this.teFileMapper.selectSPEventDealingFileBySPEventID(id);
/*  414 */     if (files.size() > 0) {
/*  415 */       for (TEFile file : files) {
/*  416 */         String videoPath = file.getFilePath() + file.getFileName() + file.getFileSuffix();
/*  417 */         FileUpdateVO vo = new FileUpdateVO();
/*  418 */         vo.setId(file.getFileID());
/*  419 */         vo.setUrl(videoPath);
/*  420 */         videoPaths.add(vo);
/*      */       }
/*      */     }
/*  423 */     Map map = new HashMap();
/*  424 */     map.put("pictures", picturePaths);
/*  425 */     map.put("video", videoPaths);
/*  426 */     return map;
/*      */   }
/*      */   
/*      */   private Map getSPEventDealingMediaForAPP(Long id) {
/*  430 */     String rootPath = CommonUtils.getRootPath("server.root");
/*  431 */     List<EventDealingPictureVO> pictures = this.pictureMapper.selectSPEventDealingPictureForAPP(id);
/*  432 */     List picturePaths = new java.util.ArrayList();
/*  433 */     List videoPaths = new java.util.ArrayList();
/*      */     EventDealingPictureVO p;
/*  434 */     java.util.Iterator localIterator; if (pictures.size() > 0)
/*  435 */       for (localIterator = pictures.iterator(); localIterator.hasNext();) { p = (EventDealingPictureVO)localIterator.next();
/*  436 */         FileUpdateVO vo = new FileUpdateVO();
/*  437 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/*  438 */         vo.setId(p.getEventDealingID());
/*  439 */         vo.setUrl(path);
/*  440 */         picturePaths.add(vo);
/*      */       }
/*  443 */     List<EventDealingVideoVO> files = this.teFileMapper.selectSPEventDealingFileForAPP(id);
/*  444 */     if (files.size() > 0) {
/*  445 */       for (com.jtzh.vo.app.EventDealingVideoVO file : files) {
/*  446 */         String videoPath = file.getFilePath() + file.getFileName() + file.getFileSuffix();
/*  447 */         FileUpdateVO vo = new FileUpdateVO();
/*  448 */         vo.setId(file.getEventDealingID());
/*  449 */         vo.setUrl(videoPath);
/*  450 */         videoPaths.add(vo);
/*      */       }
/*      */     }
/*  453 */     Map map = new HashMap();
/*  454 */     map.put("pictures", picturePaths);
/*  455 */     map.put("video", videoPaths);
/*  456 */     return map;
/*      */   }
/*      */   
/*      */   public boolean addSPEventPictures(MultipartFile file, Long ID)
/*      */   {
/*  461 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  462 */     if ((file != null) && (!file.isEmpty())) {
/*  463 */       String filename = String.valueOf(System.currentTimeMillis());
/*      */       
/*  465 */       String originFileName = file.getOriginalFilename();
/*  466 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */       
/*      */ 
/*  469 */       File outPath = new File(root_path + "/SkynetPatrolEvent/picture/");
/*  470 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  471 */         outPath.mkdirs();
/*      */       }
/*      */       
/*      */ 
/*  475 */       File outFile = new File(root_path + "/SkynetPatrolEvent/picture/" + filename + extension);
/*      */       try
/*      */       {
/*  478 */         file.transferTo(outFile);
/*      */         
/*  480 */         Picture p = new Picture();
/*  481 */         p.setPictureName(filename);
/*  482 */         p.setPictureSuffix(extension);
/*  483 */         p.setPicturePath("/SkynetPatrolEvent/picture/");
/*  484 */         this.pictureMapper.insert(p);
/*  485 */         Long pictureID = p.getPictureID();
/*  486 */         SkynetPatrolEventPicture picture = new SkynetPatrolEventPicture();
/*  487 */         picture.setSPEventID(ID);
/*  488 */         picture.setPictureID(pictureID);
/*  489 */         return this.skynetPatrolEventPictureMapper.insert(picture) != 0;
/*      */       } catch (IOException e) {
/*  491 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */     
/*  495 */     return false;
/*      */   }
/*      */   
/*      */   public boolean addSPEventVideo(MultipartFile file, Long ID)
/*      */   {
/*  500 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  501 */     if ((file != null) && (!file.isEmpty())) {
/*  502 */       String filename = String.valueOf(System.currentTimeMillis());
/*      */       
/*  504 */       String originFileName = file.getOriginalFilename();
/*  505 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */       
/*      */ 
/*  508 */       File outPath = new File(root_path + "/SkynetPatrolEvent/video/");
/*  509 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  510 */         outPath.mkdirs();
/*      */       }
/*      */       
/*      */ 
/*  514 */       File outFile = new File(root_path + "/SkynetPatrolEvent/video/" + filename + extension);
/*      */       try
/*      */       {
/*  517 */         file.transferTo(outFile);
/*      */         
/*  519 */         TEFile f = new TEFile();
/*  520 */         f.setFileName(filename);
/*  521 */         f.setFilePath("/SkynetPatrolEvent/video/");
/*  522 */         f.setFileSuffix(extension);
/*  523 */         this.teFileMapper.insert(f);
/*  524 */         Long fileID = f.getFileID();
/*  525 */         com.jtzh.entity.SkynetPatrolEventVideoFile videoFile = new com.jtzh.entity.SkynetPatrolEventVideoFile();
/*  526 */         videoFile.setSPEventID(ID);
/*  527 */         videoFile.setFileID(fileID);
/*  528 */         return this.skynetPatrolEventVideoFileMapper.insert(videoFile) != 0;
/*      */       } catch (IOException e) {
/*  530 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  533 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean deleteSPEventMedia(Long id)
/*      */   {
/*  545 */     boolean flag = false;
/*  546 */     String rootPath = CommonUtils.getRootPath("msmis.file");
/*  547 */     List<SkynetPatrolEventPicture> sep = this.skynetPatrolEventPictureMapper.selectBySPEventID(id);
/*  548 */     if (sep.size() > 0) {
/*  549 */       for (SkynetPatrolEventPicture image : sep) {
/*  550 */         Picture p = this.pictureMapper.selectByPrimaryKey(image.getPictureID());
/*  551 */         String path =  p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/*  552 */         if (CommonUtils.deleteFile(path)) {
/*  553 */           flag = this.skynetPatrolEventPictureMapper.deleteByPictureID(image.getPictureID()) != 0;
/*      */         } else {
/*  555 */           flag = false;
/*  556 */           break;
/*      */         }
/*      */       }
/*      */     } else {
/*  560 */       flag = true;
/*      */     }
/*  562 */     if (flag) {
/*      */       com.jtzh.entity.SkynetPatrolEventVideoFile videoFile;
/*  564 */       if ((videoFile = this.skynetPatrolEventVideoFileMapper.selectBySPEventID(id)) != null) {
/*  565 */         TEFile f = this.teFileMapper.selectByPrimaryKey(videoFile.getFileID());
/*  566 */         String file =  f.getFilePath() + f.getFileName() + f.getFileSuffix();
/*  567 */         if (CommonUtils.deleteFile(file)) {
/*  568 */           flag = this.skynetPatrolEventVideoFileMapper.deleteByFileID(videoFile.getFileID()) != 0;
/*      */         } else {
/*  570 */           flag = false;
/*      */         }
/*      */       } else {
/*  573 */         flag = true;
/*      */       }
/*      */     }
/*  576 */     return flag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Long insertSPEventDealing(SkynetPatrolEventDealing eventDealing)
/*      */   {
/*  583 */     boolean flag = this.skynetPatrolEventDealingMapper.insert(eventDealing) != 0;
/*  584 */     if (flag)
/*  585 */       return eventDealing.getSkynetPatrolEventDealingID();
/*  586 */     return null;
/*      */   }
/*      */   
/*      */   public boolean updateSPEventDealing(SkynetPatrolEventDealing eventDealing)
/*      */   {
/*  591 */     return this.skynetPatrolEventDealingMapper.updateByPrimaryKey(eventDealing) != 0;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean addSPEventDealingPictures(MultipartFile file, Long ID)
/*      */   {
/*  597 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  598 */     boolean flag = false;
/*  599 */     if ((file != null) && (!file.isEmpty())) {
/*  600 */       String filename = String.valueOf(System.currentTimeMillis());
/*      */       
/*  602 */       String originFileName = file.getOriginalFilename();
/*  603 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */       
/*      */ 
/*  606 */       File outPath = new File(root_path + "/SkynetPatrolEvent/DealingPicture/");
/*  607 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  608 */         outPath.mkdirs();
/*      */       }
/*      */       
/*      */ 
/*  612 */       File outFile = new File(root_path + "/SkynetPatrolEvent/DealingPicture/" + filename + extension);
/*      */       try
/*      */       {
/*  615 */         file.transferTo(outFile);
/*      */         
/*  617 */         Picture p = new Picture();
/*  618 */         p.setPictureName(filename);
/*  619 */         p.setPictureSuffix(extension);
/*  620 */         p.setPicturePath("/SkynetPatrolEvent/DealingPicture/");
/*  621 */         this.pictureMapper.insert(p);
/*  622 */         Long pictureID = p.getPictureID();
/*  623 */         SkynetPEDealingPicture picture = new SkynetPEDealingPicture();
/*  624 */         picture.setSkynetPatrolEventDealingID(ID);
/*  625 */         picture.setPictureID(pictureID);
/*  626 */         flag = this.skynetPEDealingPictureMapper.insert(picture) != 0;
/*      */       } catch (IOException e) {
/*  628 */         e.printStackTrace();
/*      */       }
/*      */     } else {
/*  631 */       flag = true;
/*      */     }
/*  633 */     return flag;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean addSPEventDealingPictures(MultipartFile[] file, Long ID)
/*      */   {
/*  639 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  640 */     boolean flag = false;
/*  641 */     if (file.length > 0) {
/*  642 */       for (int i = 0; i < file.length; i++) {
/*  643 */         String filename = String.valueOf(System.currentTimeMillis());
/*      */         
/*  645 */         String originFileName = file[i].getOriginalFilename();
/*  646 */         String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */         
/*      */ 
/*  649 */         File outPath = new File(root_path + "/SkynetPatrolEvent/DealingPicture/");
/*  650 */         if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  651 */           outPath.mkdirs();
/*      */         }
/*      */         
/*      */ 
/*  655 */         File outFile = new File(root_path + "/SkynetPatrolEvent/DealingPicture/" + filename + extension);
/*      */         try
/*      */         {
/*  658 */           file[i].transferTo(outFile);
/*      */           
/*  660 */           Picture p = new Picture();
/*  661 */           p.setPictureName(filename);
/*  662 */           p.setPictureSuffix(extension);
/*  663 */           p.setPicturePath("/SkynetPatrolEvent/DealingPicture/");
/*  664 */           this.pictureMapper.insert(p);
/*  665 */           Long pictureID = p.getPictureID();
/*  666 */           SkynetPEDealingPicture picture = new SkynetPEDealingPicture();
/*  667 */           picture.setSkynetPatrolEventDealingID(ID);
/*  668 */           picture.setPictureID(pictureID);
/*  669 */           flag = this.skynetPEDealingPictureMapper.insert(picture) != 0;
/*  670 */           if (!flag)
/*      */             break;
/*      */         } catch (IOException e) {
/*  673 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     } else {
/*  677 */       flag = true;
/*      */     }
/*  679 */     return flag;
/*      */   }
/*      */   
/*      */   public boolean addSPEventDealingVideo(MultipartFile file, Long ID)
/*      */   {
/*  684 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  685 */     if ((file != null) && (!file.isEmpty())) {
/*  686 */       String filename = String.valueOf(System.currentTimeMillis());
/*      */       
/*  688 */       String originFileName = file.getOriginalFilename();
/*  689 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */       
/*      */ 
/*  692 */       File outPath = new File(root_path + "/SkynetPatrolEvent/DealingVideo/");
/*  693 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  694 */         outPath.mkdirs();
/*      */       }
/*      */       
/*      */ 
/*  698 */       File outFile = new File(root_path + "/SkynetPatrolEvent/DealingVideo/" + filename + extension);
/*      */       try
/*      */       {
/*  701 */         file.transferTo(outFile);
/*      */         
/*  703 */         TEFile f = new TEFile();
/*  704 */         f.setFileName(filename);
/*  705 */         f.setFilePath("/SkynetPatrolEvent/DealingVideo/");
/*  706 */         f.setFileSuffix(extension);
/*  707 */         this.teFileMapper.insert(f);
/*  708 */         Long fileID = f.getFileID();
/*  709 */         SkynetPatrolEventDealingVideoFile videoFile = new SkynetPatrolEventDealingVideoFile();
/*  710 */         videoFile.setSkynetPatrolEventDealingID(ID);
/*  711 */         videoFile.setFileID(fileID);
/*  712 */         return this.skynetPatrolEventDealingVideoFileMapper.insert(videoFile) != 0;
/*      */       } catch (IOException e) {
/*  714 */         e.printStackTrace();
/*      */       }
/*      */     } else {
/*  717 */       return true;
/*      */     }
/*  719 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean deleteSPDealingEventMedia(Long id)
/*      */   {
/*  732 */     boolean flag = false;
/*  733 */     String rootPath = CommonUtils.getRootPath("msmis.file");
/*  734 */     List<SkynetPEDealingPicture> sep = this.skynetPEDealingPictureMapper.selectBySkynetPatrolEventDealingID(id);
/*  735 */     if (sep.size() > 0) {
/*  736 */       for (SkynetPEDealingPicture image : sep) {
/*  737 */         Picture p = this.pictureMapper.selectByPrimaryKey(image.getPictureID());
/*  738 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/*  739 */         if (CommonUtils.deleteFile(path)) {
/*  740 */           flag = this.skynetPatrolEventPictureMapper.deleteByPictureID(image.getPictureID()) != 0;
/*      */         } else {
/*  742 */           flag = false;
/*  743 */           break;
/*      */         }
/*      */       }
/*      */     } else {
/*  747 */       flag = true;
/*      */     }
/*  749 */     if (flag) {
/*      */       SkynetPatrolEventDealingVideoFile videoFile;
/*  751 */       if ((videoFile = this.skynetPatrolEventDealingVideoFileMapper.selectBySkynetPatrolEventDealingID(id)) != null) {
/*  752 */         TEFile f = this.teFileMapper.selectByPrimaryKey(videoFile.getFileID());
/*  753 */         String file =  f.getFilePath() + f.getFileName() + f.getFileSuffix();
/*  754 */         if (CommonUtils.deleteFile(file)) {
/*  755 */           flag = this.skynetPatrolEventVideoFileMapper.deleteByFileID(videoFile.getFileID()) != 0;
/*      */         } else {
/*  757 */           flag = false;
/*      */         }
/*      */       } else {
/*  760 */         flag = true;
/*      */       }
/*      */     }
/*  763 */     return flag;
/*      */   }
/*      */   
/*      */   public List<com.jtzh.vo.ss.SSCountVO> getSPEventCount()
/*      */   {
/*  768 */     return this.skynetPatrolEventMapper.getSPEventCount();
/*      */   }
/*      */   
/*      */   public boolean isDistribute(Long id)
/*      */   {
/*  773 */     List<com.jtzh.vo.skynet.SPDistributeVO> vos = this.skynetPatrolEventDistributeMapper.selectBySPEventID(id);
/*  774 */     return vos.size() > 0;
/*      */   }
/*      */   
/*      */ 
/*      */   public com.jtzh.vo.skynet.SPProcessionQueryVO getSPProcessionQuery(String processionName, String processionLeaderName, Integer area, int page, int pageSize)
/*      */   {
/*  780 */     int start = 0;
/*  781 */     if (page > 1)
/*  782 */       start = (page - 1) * pageSize;
/*  783 */     List<com.jtzh.vo.skynet.SPProcessionDetailVO> list = this.processionMapper.getProcessionQuery(processionName, processionLeaderName, area, start, pageSize);
/*  784 */     int count = this.processionMapper.getProcessionQueryCount(processionName, processionLeaderName, area);
/*  785 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  786 */     com.jtzh.vo.skynet.SPProcessionQueryVO vo = new com.jtzh.vo.skynet.SPProcessionQueryVO();
/*  787 */     vo.setList(list);
/*  788 */     vo.setPage(p);
/*  789 */     return vo;
/*      */   }
/*      */   
/*      */   public boolean addProcession(com.jtzh.entity.SPProcession procession)
/*      */   {
/*  794 */     return this.processionMapper.insert(procession) != 0;
/*      */   }
/*      */   
/*      */   public List<com.jtzh.entity.SPProcession> getAllProcession()
/*      */   {
/*  799 */     return this.processionMapper.selectAll();
/*      */   }
/*      */   
/*      */   public boolean updateProcession(com.jtzh.entity.SPProcession procession)
/*      */   {
/*  804 */     return this.processionMapper.updateByPrimaryKey(procession) != 0;
/*      */   }
/*      */   
/*      */   public com.jtzh.vo.skynet.SPProcessionDetailVO getProcessionDetailByID(Long id)
/*      */   {
/*  809 */     return this.processionMapper.getProcessionDetailByID(id);
/*      */   }
/*      */   
/*      */   public List<com.jtzh.vo.skynet.SPProcessionDetailVO> getProcessionDetailByInspectionArea(Long id)
/*      */   {
/*  814 */     return this.processionMapper.getProcessionDetailByInspectionArea(id);
/*      */   }
/*      */   
/*      */   public com.jtzh.entity.SPProcession getProcessionDetailToUpdate(Long id)
/*      */   {
/*  819 */     return this.processionMapper.selectByPrimaryKey(id);
/*      */   }
/*      */   
/*      */   public boolean deleteProcession(Long id)
/*      */   {
/*  824 */     return this.processionMapper.deleteByPrimaryKey(id) != 0;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean addSPRegion(com.jtzh.entity.SPRegion region)
/*      */   {
/*  830 */     return this.regionMapper.insert(region) != 0;
/*      */   }
/*      */   
/*      */   public boolean updateSPRegion(com.jtzh.entity.SPRegion region)
/*      */   {
/*  835 */     return this.regionMapper.updateByPrimaryKey(region) != 0;
/*      */   }
/*      */   
/*      */   public boolean deleteSPRegion(Long id)
/*      */   {
/*  840 */     return this.regionMapper.deleteByPrimaryKey(id) != 0;
/*      */   }
/*      */   
/*      */   public List<com.jtzh.entity.SPRegion> selectByRegionName(String name)
/*      */   {
/*  845 */     return this.regionMapper.selectByRegionName(name);
/*      */   }
/*      */   
/*      */   public List<com.jtzh.entity.SPRegion> selectAllRegion()
/*      */   {
/*  850 */     return this.regionMapper.selectAll();
/*      */   }
/*      */   
/*      */   public boolean addProcessionPerson(com.jtzh.entity.SPProcessionPerson person, Long id)
/*      */   {
/*  855 */     boolean flag = this.spProcessionPersonMapper.insert(person) != 0;
/*  856 */     if (flag) {
/*  857 */       SPProcessionPhoto photo = this.spProcessionPhotoMapper.selectByPrimaryKey(id);
/*  858 */       photo.setPersonID(person.getPersonID());
/*  859 */       flag = this.spProcessionPhotoMapper.updateByPrimaryKey(photo) != 0;
/*      */     }
/*  861 */     return flag;
/*      */   }
/*      */   
/*      */   public Long uploadProcessionPersonPhoto(MultipartFile file)
/*      */   {
/*  866 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  867 */     if ((file != null) && (!file.isEmpty())) {
/*  868 */       String filename = String.valueOf(System.currentTimeMillis());
/*      */       
/*  870 */       String originFileName = file.getOriginalFilename();
/*  871 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */       
/*      */ 
/*  874 */       File outPath = new File(root_path + "/SkynetPatrolEvent/procession/PersonPhoto/");
/*  875 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  876 */         outPath.mkdirs();
/*      */       }
/*      */       
/*      */ 
/*  880 */       File outFile = new File(root_path + "/SkynetPatrolEvent/procession/PersonPhoto/" + filename + extension);
/*      */       try
/*      */       {
/*  883 */         file.transferTo(outFile);
/*      */         
/*  885 */         SPProcessionPhoto photo = new SPProcessionPhoto();
/*  886 */         photo.setPhotoFileName(filename);
/*  887 */         photo.setPhotoFileSuffix(extension);
/*  888 */         photo.setPhotoFilePath("/SkynetPatrolEvent/procession/PersonPhoto/");
/*  889 */         this.spProcessionPhotoMapper.insert(photo);
/*  890 */         return photo.getPersonPhotoID();
/*      */       } catch (IOException e) {
/*  892 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  895 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean updateProcessionPersonPhoto(MultipartFile file, Long id)
/*      */   {
/*  901 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  902 */     if ((file != null) && (!file.isEmpty())) {
/*  903 */       SPProcessionPhoto photo = this.spProcessionPhotoMapper.selectByPersonID(id);
/*  904 */       if (photo == null) {
/*  905 */         String filename = String.valueOf(System.currentTimeMillis());
/*      */         
/*  907 */         String originFileName = file.getOriginalFilename();
/*  908 */         String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*      */         
/*      */ 
/*  911 */         File outPath = new File(root_path + "/SkynetPatrolEvent/procession/PersonPhoto/");
/*  912 */         if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  913 */           outPath.mkdirs();
/*      */         }
/*      */         
/*      */ 
/*  917 */         File outFile = new File(root_path + "/SkynetPatrolEvent/procession/PersonPhoto/" + filename + extension);
/*      */         try
/*      */         {
/*  920 */           file.transferTo(outFile);
/*      */           
/*  922 */           photo = new SPProcessionPhoto();
/*  923 */           photo.setPersonID(id);
/*  924 */           photo.setPhotoFileName(filename);
/*  925 */           photo.setPhotoFileSuffix(extension);
/*  926 */           photo.setPhotoFilePath("/SkynetPatrolEvent/procession/PersonPhoto/");
/*  927 */           this.spProcessionPhotoMapper.insert(photo);
/*      */         } catch (IOException e) {
/*  929 */           e.printStackTrace();
/*      */         }
/*      */       } else {
/*  932 */         String filename = photo.getPhotoFileName();
/*      */         
/*  934 */         String extension = photo.getPhotoFileSuffix();
/*      */         
/*      */ 
/*  937 */         File outFile = new File(root_path + "/SkynetPatrolEvent/procession/PersonPhoto/" + filename + extension);
/*      */         try
/*      */         {
/*  940 */           file.transferTo(outFile);
/*  941 */           return true;
/*      */         } catch (IOException e) {
/*  943 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*  947 */     return false;
/*      */   }
/*      */   
/*      */   public com.jtzh.vo.skynet.ProcessionPersonQueryVO getProcessionPersonQuery(String name, Integer processionID, int page, int pageSize)
/*      */   {
/*  952 */     int start = 0;
/*  953 */     if (page > 1)
/*  954 */       start = (page - 1) * pageSize;
/*  955 */     List<com.jtzh.vo.skynet.ProcessionPersonVO> list = this.spProcessionPersonMapper.getProcessionPersonQuery(name, processionID, start, pageSize);
/*  956 */     int count = this.spProcessionPersonMapper.getProcessionPersonQueryCount(name, processionID);
/*  957 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  958 */     com.jtzh.vo.skynet.ProcessionPersonQueryVO vo = new com.jtzh.vo.skynet.ProcessionPersonQueryVO();
/*  959 */     vo.setVos(list);
/*  960 */     vo.setPage(p);
/*  961 */     return vo;
/*      */   }
/*      */   
/*      */   public Map getProcessionPersonDetail(Long id)
/*      */   {
/*  966 */     SPProcessionPhoto photo = this.spProcessionPhotoMapper.selectByPersonID(id);
/*  967 */     String photoPath = null;
/*  968 */     if (photo != null) {
/*  969 */       String rootPath = CommonUtils.getRootPath("server.root");
/*  970 */       photoPath = photo.getPhotoFilePath() + photo.getPhotoFileName() + photo.getPhotoFileSuffix();
/*      */     }
/*  972 */     com.jtzh.vo.skynet.ProcessionPersonVO vo = this.spProcessionPersonMapper.getProcessionPersonDetail(id);
/*  973 */     Map map = new HashMap();
/*  974 */     map.put("PersonBasic", vo);
/*  975 */     map.put("PhotoPath", photoPath);
/*  976 */     return map;
/*      */   }
/*      */   
/*      */   public Map getProcessionPersonDetailToUpdate(Long id)
/*      */   {
/*  981 */     SPProcessionPhoto photo = this.spProcessionPhotoMapper.selectByPersonID(id);
/*  982 */     String photoPath = null;
/*  983 */     if (photo != null) {
/*  984 */       String rootPath = CommonUtils.getRootPath("server.root");
/*  985 */       photoPath =  photo.getPhotoFilePath() + photo.getPhotoFileName() + photo.getPhotoFileSuffix();
/*      */     }
/*  987 */     com.jtzh.entity.SPProcessionPerson processionPerson = this.spProcessionPersonMapper.selectByPrimaryKey(id);
/*  988 */     Map map = new HashMap();
/*  989 */     map.put("PersonBasic", processionPerson);
/*  990 */     map.put("PhotoPath", photoPath);
/*  991 */     return map;
/*      */   }
/*      */   
/*      */   public boolean deleteSPProcessionPerson(Long id)
/*      */   {
/*  996 */     return this.spProcessionPersonMapper.deleteByPrimaryKey(id) != 0;
/*      */   }
/*      */   
/*      */   public boolean updateSPProcessionPerson(com.jtzh.entity.SPProcessionPerson person)
/*      */   {
/* 1001 */     return this.spProcessionPersonMapper.updateByPrimaryKey(person) != 0;
/*      */   }
/*      */   
/*      */ 
/*      */   public com.jtzh.vo.skynet.SPTrailQueryVO getSPTrailQuery(String name, String startTime, String endTime, int page, int pageSize)
/*      */   {
/* 1007 */     int start = 0;
/* 1008 */     if (page > 1)
/* 1009 */       start = (page - 1) * pageSize;
/* 1010 */     List<com.jtzh.vo.skynet.SPTrailVO> list = this.trailMapper.getSPTrailQuery(name, startTime, endTime, start, pageSize);
/* 1011 */     int count = this.trailMapper.getSPTrailQueryCount(name, startTime, endTime);
/* 1012 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 1013 */     com.jtzh.vo.skynet.SPTrailQueryVO vo = new com.jtzh.vo.skynet.SPTrailQueryVO();
/* 1014 */     vo.setVos(list);
/* 1015 */     vo.setPage(p);
/* 1016 */     return vo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   @org.springframework.transaction.annotation.Transactional
/*      */   public boolean addSPEventDealingFromAPP(String eventID, String dealingUserID, String dealingTime, String dealingInf, String remark, MultipartFile[] pictures, MultipartFile video)
/*      */   {
/* 1024 */     SkynetPatrolEventDealing dealing = new SkynetPatrolEventDealing();
/* 1025 */     dealing.setSpEventID(Long.valueOf(eventID));
/* 1026 */     dealing.setDealingUserID(Long.valueOf(dealingUserID));
/*      */     try {
/* 1028 */       dealing.setDealingTime(com.jtzh.util.DateUtil.strToDateTime(dealingTime));
/*      */     } catch (java.text.ParseException e) {
/* 1030 */       e.printStackTrace();
/*      */     }
/* 1032 */     dealing.setDealingInf(dealingInf);
/* 1033 */     dealing.setRemark(remark);
/* 1034 */     boolean flag = this.skynetPatrolEventDealingMapper.insert(dealing) != 0;
/* 1035 */     if (flag) {
/* 1036 */       Long ID = dealing.getSkynetPatrolEventDealingID();
/* 1037 */       flag = addSPEventDealingPictures(pictures, ID);
/* 1038 */       if (flag) {
/* 1039 */         flag = addSPEventDealingVideo(video, ID);
/*      */       }
/*      */     }
/* 1042 */     return flag;
/*      */   }
/*      */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\SkynetServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */