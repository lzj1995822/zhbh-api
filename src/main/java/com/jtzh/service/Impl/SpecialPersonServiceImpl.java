/*     */ package com.jtzh.service.Impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.served.ServedPersonBasicDetailVO;
/*     */ import com.jtzh.vo.served.SpecialPersonCountByTypeVO;
/*     */ import com.jtzh.vo.served.SpecialPsychoticResponseVO;
import com.jtzh.entity.KeyPetitioners;
import com.jtzh.entity.KeyYoungers;
import com.jtzh.entity.SpecialPopulationExtendAIDSdisease;
import com.jtzh.entity.SpecialPopulationExtendCommunityCorrectioner;
import com.jtzh.entity.SpecialPopulationExtendDrugAddicts;
import com.jtzh.entity.SpecialPopulationExtendEmancipist;
import com.jtzh.entity.SpecialPopulationExtendSeverePsychotic;
import com.jtzh.entity.TRSpecialServedPerson;
import com.jtzh.mapper.KeyPetitionersMapper;
import com.jtzh.mapper.KeyYoungersMapper;
import com.jtzh.mapper.ServedPersonBasicMapper;
import com.jtzh.mapper.SpecialPopulationExtendEmancipistMapper;
import com.jtzh.mapper.SpecialPopulationExtendSeverePsychoticMapper;
import com.jtzh.mapper.TRSpecialServedPersonMapper;

/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class SpecialPersonServiceImpl implements com.jtzh.service.SpecialPersonService
/*     */ {
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SpecialServedPersonMapper specialServedPersonMapper;
/*     */   @Autowired
/*     */   private SpecialPopulationExtendSeverePsychoticMapper specialPopulationExtendSeverePsychoticMapper;
/*     */   @Autowired
/*     */   private SpecialPopulationExtendEmancipistMapper specialPopulationExtendEmancipistMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SpecialPopulationExtendAIDSdiseaseMapper specialPopulationExtendAIDSdiseaseMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SpecialPopulationExtendCommunityCorrectionerMapper specialPopulationExtendCommunityCorrectionerMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SpecialPopulationExtendDrugAddictsMapper specialPopulationExtendDrugAddictsMapper;
/*     */   @Autowired
/*     */   private ServedPersonBasicMapper servedPersonBasicMapper;
/*     */   @Autowired
/*     */   private TRSpecialServedPersonMapper trSpecialServedPersonMapper;
/*     */   @Autowired
/*     */   private KeyYoungersMapper keyYoungersMapper;
/*     */   @Autowired
/*     */   private KeyPetitionersMapper keyPetitionersMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.ServedPersonPhotoMapper servedPersonPhotoMapper;
/*     */   
/*     */   public List getSpecialPersonCount()
/*     */   {
/*  55 */     List<com.jtzh.vo.served.SpecialPersonCountVO> list = this.specialServedPersonMapper.getSpecialPersonCount();
/*  56 */     List lists = new java.util.ArrayList();
/*  57 */     int len = list.size();
/*  58 */     String[] name = new String[len];
/*  59 */     String[] type = { "刑满释放人员", "社区矫正人员", "精神障碍患者" };
/*     */     
/*  61 */     int[] emancipist = new int[len];
/*  62 */     int[] community = new int[len];
/*  63 */     int[] psychotic = new int[len];
/*  64 */     int[] drug = new int[len];
/*  65 */     int[] AIDS = new int[len];
/*  66 */     for (int i = 0; i < list.size(); i++) {
/*  67 */       com.jtzh.vo.served.SpecialPersonCountVO s = (com.jtzh.vo.served.SpecialPersonCountVO)list.get(i);
/*  68 */       name[i] = s.getName();
/*  69 */       emancipist[i] = s.getEmancipist();
/*  70 */       community[i] = s.getCommunity();
/*  71 */       psychotic[i] = s.getPsychotic();
/*     */     }
/*     */     
/*     */ 
/*  75 */     lists.add(name);
/*  76 */     lists.add(type);
/*  77 */     lists.add(emancipist);
/*  78 */     lists.add(community);
/*  79 */     lists.add(psychotic);
/*     */     
/*     */ 
/*  82 */     return lists;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SpecialPsychoticResponseVO getPsychoticInfo(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/*  89 */     int start = 0;
/*  90 */     if (page > 1)
/*  91 */       start = (page - 1) * pageSize;
/*  92 */     List<com.jtzh.vo.served.SpecialPsychoticInfoVO> infos = this.specialPopulationExtendSeverePsychoticMapper.getPsychoticInfo(name, certifID, netGridID, start, pageSize);
/*     */     
/*  94 */     int count = this.specialPopulationExtendSeverePsychoticMapper.getPsychoticInfoCount(name, certifID, netGridID);
/*  95 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/*  96 */     SpecialPsychoticResponseVO vo = new SpecialPsychoticResponseVO();
/*  97 */     vo.setVos(infos);
/*  98 */     vo.setPage(p);
/*  99 */     return vo;
/*     */   }
/*     */   
/*     */   private HashMap getPsychoticDetail(String certifID) {
/* 103 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/*     */     
/* 105 */     List<SpecialPopulationExtendSeverePsychotic> psychotics = this.specialPopulationExtendSeverePsychoticMapper.selectByCertifID(certifID);
/* 106 */     HashMap<String, Object> map = new HashMap();
/* 107 */     map.put("basic", basicDetailVOs);
/* 108 */     map.put("special", psychotics);
/* 109 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SpecialPsychoticResponseVO getEmancipistInfo(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 116 */     int start = 0;
/* 117 */     if (page > 1)
/* 118 */       start = (page - 1) * pageSize;
/* 119 */     List<com.jtzh.vo.served.SpecialPsychoticInfoVO> infos = this.specialPopulationExtendEmancipistMapper.getEmancipistInfo(name, certifID, netGridID, start, pageSize);
/*     */     
/* 121 */     int count = this.specialPopulationExtendEmancipistMapper.getEmancipistInfoCount(name, certifID, netGridID);
/* 122 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 123 */     SpecialPsychoticResponseVO vo = new SpecialPsychoticResponseVO();
/* 124 */     vo.setVos(infos);
/* 125 */     vo.setPage(p);
/* 126 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   private HashMap getEmancipistDetail(String certifID)
/*     */   {
/* 132 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/*     */     
/* 134 */     List<SpecialPopulationExtendEmancipist> emancipists = this.specialPopulationExtendEmancipistMapper.selectByCertifID(certifID);
/* 135 */     HashMap<String, Object> map = new HashMap();
/* 136 */     map.put("basic", basicDetailVOs);
/* 137 */     map.put("photo", getPhotoPath(certifID));
/* 138 */     map.put("special", emancipists);
/* 139 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SpecialPsychoticResponseVO getDrugAddictsInfo(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 146 */     int start = 0;
/* 147 */     if (page > 1)
/* 148 */       start = (page - 1) * pageSize;
/* 149 */     List<com.jtzh.vo.served.SpecialPsychoticInfoVO> infos = this.specialPopulationExtendDrugAddictsMapper.getDrugAddictsInfo(name, certifID, netGridID, start, pageSize);
/*     */     
/* 151 */     int count = this.specialPopulationExtendDrugAddictsMapper.getDrugAddictsInfoCount(name, certifID, netGridID);
/* 152 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 153 */     SpecialPsychoticResponseVO vo = new SpecialPsychoticResponseVO();
/* 154 */     vo.setVos(infos);
/* 155 */     vo.setPage(p);
/* 156 */     return vo;
/*     */   }
/*     */   
/*     */   private HashMap getDrugAddictsDetail(String certifID)
/*     */   {
/* 161 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/*     */     
/* 163 */     List<SpecialPopulationExtendDrugAddicts> drugAddicts = this.specialPopulationExtendDrugAddictsMapper.selectByCertifID(certifID);
/* 164 */     HashMap<String, Object> map = new HashMap();
/* 165 */     map.put("basic", basicDetailVOs);
/* 166 */     map.put("photo", getPhotoPath(certifID));
/* 167 */     map.put("special", drugAddicts);
/* 168 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SpecialPsychoticResponseVO getCommunityCorrectionerInfo(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 175 */     int start = 0;
/* 176 */     if (page > 1) {
/* 177 */       start = (page - 1) * pageSize;
/*     */     }
/* 179 */     List<com.jtzh.vo.served.SpecialPsychoticInfoVO> infos = this.specialPopulationExtendCommunityCorrectionerMapper.getCommunityCorrectionerInfo(name, certifID, netGridID, start, pageSize);
/* 180 */     int count = this.specialPopulationExtendCommunityCorrectionerMapper.getCommunityCorrectionerInfoCount(name, certifID, netGridID);
/*     */     
/* 182 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 183 */     SpecialPsychoticResponseVO vo = new SpecialPsychoticResponseVO();
/* 184 */     vo.setVos(infos);
/* 185 */     vo.setPage(p);
/* 186 */     return vo;
/*     */   }
/*     */   
/*     */   private HashMap getCommunityCorrectionerDetail(String certifID)
/*     */   {
/* 191 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/*     */     
/* 193 */     List<SpecialPopulationExtendCommunityCorrectioner> correctioners = this.specialPopulationExtendCommunityCorrectionerMapper.selectByCertifID(certifID);
/* 194 */     HashMap<String, Object> map = new HashMap();
/* 195 */     map.put("basic", basicDetailVOs);
/* 196 */     map.put("photo", getPhotoPath(certifID));
/* 197 */     map.put("special", correctioners);
/* 198 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SpecialPsychoticResponseVO getAIDSdiseasenfo(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 205 */     int start = 0;
/* 206 */     if (page > 1)
/* 207 */       start = (page - 1) * pageSize;
/* 208 */     List<com.jtzh.vo.served.SpecialPsychoticInfoVO> infos = this.specialPopulationExtendAIDSdiseaseMapper.getAIDSdiseaseInfo(name, certifID, netGridID, start, pageSize);
/*     */     
/* 210 */     int count = this.specialPopulationExtendAIDSdiseaseMapper.getAIDSdiseaseInfoCount(name, certifID, netGridID);
/* 211 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 212 */     SpecialPsychoticResponseVO vo = new SpecialPsychoticResponseVO();
/* 213 */     vo.setVos(infos);
/* 214 */     vo.setPage(p);
/* 215 */     return vo;
/*     */   }
/*     */   
/*     */   private HashMap getAIDSdiseaseDetail(String certifID)
/*     */   {
/* 220 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/*     */     
/* 222 */     List<SpecialPopulationExtendAIDSdisease> aidSdiseases = this.specialPopulationExtendAIDSdiseaseMapper.selectByCertifID(certifID);
/* 223 */     HashMap<String, Object> map = new HashMap();
/* 224 */     map.put("basic", basicDetailVOs);
/* 225 */     map.put("photo", getPhotoPath(certifID));
/* 226 */     map.put("special", aidSdiseases);
/* 227 */     return map;
/*     */   }
/*     */   
/*     */   public com.jtzh.vo.keyYoungers.KeyYoungersQueryVO getKeyYoungersQuery(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 232 */     int start = 0;
/* 233 */     if (page > 1)
/* 234 */       start = (page - 1) * pageSize;
/* 235 */     List<com.jtzh.vo.keyYoungers.KeyYoungersVO> vos = this.keyYoungersMapper.getKeyYoungersQuery(netGridID, name, certifID, start, pageSize);
/* 236 */     int count = this.keyYoungersMapper.getKeyYoungersQueryCount(netGridID, name, certifID);
/* 237 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 238 */     com.jtzh.vo.keyYoungers.KeyYoungersQueryVO vo = new com.jtzh.vo.keyYoungers.KeyYoungersQueryVO();
/* 239 */     vo.setPage(p);
/* 240 */     vo.setVos(vos);
/* 241 */     return vo;
/*     */   }
/*     */   
/*     */   private HashMap getKeyYoungersDetail(String certifID)
/*     */   {
/* 246 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/* 247 */     List<KeyYoungers> keyYoungers = this.keyYoungersMapper.selectByCertifID(certifID);
/* 248 */     HashMap<String, Object> map = new HashMap();
/* 249 */     map.put("basic", basicDetailVOs);
/* 250 */     map.put("photo", getPhotoPath(certifID));
/* 251 */     map.put("special", keyYoungers);
/* 252 */     return map;
/*     */   }
/*     */   
/*     */   public List getKeyYoungerHistogramCount()
/*     */   {
/* 257 */     List<com.jtzh.vo.gis.PieCountVO> list = this.keyYoungersMapper.getKeyYoungerHistogramCount();
/* 258 */     List l = new java.util.ArrayList();
/* 259 */     int len = list.size();
/* 260 */     String[] name = new String[len];
/* 261 */     int[] value = new int[len];
/* 262 */     for (int i = 0; i < len; i++) {
/* 263 */       com.jtzh.vo.gis.PieCountVO v = (com.jtzh.vo.gis.PieCountVO)list.get(i);
/* 264 */       name[i] = v.getName();
/* 265 */       value[i] = v.getValue();
/*     */     }
/* 267 */     l.add(name);
/* 268 */     l.add(value);
/* 269 */     return l;
/*     */   }
/*     */   
/*     */   public List getKeyYoungerPieCount()
/*     */   {
/* 274 */     return this.keyYoungersMapper.getKeyYoungerHistogramCount();
/*     */   }
/*     */   
/*     */   public com.jtzh.vo.KeyPetitioners.KeyPetitionersQueryVO getKeyPetitionersQuery(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/* 279 */     int start = 0;
/* 280 */     if (page > 1)
/* 281 */       start = (page - 1) * pageSize;
/* 282 */     List<com.jtzh.vo.KeyPetitioners.KeyPetitionersVO> vos = this.keyPetitionersMapper.getKeyPetitionersQuery(netGridID, name, certifID, start, pageSize);
/* 283 */     int count = this.keyPetitionersMapper.getKeyPetitionersQueryCount(netGridID, name, certifID);
/* 284 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 285 */     com.jtzh.vo.KeyPetitioners.KeyPetitionersQueryVO vo = new com.jtzh.vo.KeyPetitioners.KeyPetitionersQueryVO();
/* 286 */     vo.setPage(p);
/* 287 */     vo.setKeyPetitioners(vos);
/* 288 */     return vo;
/*     */   }
/*     */   
/*     */   public List getKeyPetitionersPieCount()
/*     */   {
/* 293 */     return this.keyPetitionersMapper.getKeyPetitionersPieCount();
/*     */   }
/*     */   
/*     */ 
/*     */   private HashMap getKeyPetitionersDetail(String certifID)
/*     */   {
/* 299 */     List<ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/* 300 */     KeyPetitioners keyPetitioners = this.keyPetitionersMapper.selectByCertifID(certifID);
/* 301 */     HashMap<String, Object> map = new HashMap();
/* 302 */     map.put("basic", basicDetailVOs);
/* 303 */     map.put("photo", getPhotoPath(certifID));
/* 304 */     map.put("special", keyPetitioners);
/* 305 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public List getSpecialPersonCountByType()
/*     */   {
/* 311 */     List<SpecialPersonCountByTypeVO> list = this.specialServedPersonMapper.getSpecialPersonCountByType();
/* 312 */     int len = list.size();
/* 313 */     List lists = new java.util.ArrayList();
/* 314 */     String[] name = new String[len];
/* 315 */     String[] type = { "宝华村", "宝华花园社区", "仓头村", "凤坛村", "和平村", "华山村", "栏江村", "栗庄村", "铜山村", "新城社区" };
/* 316 */     int[] yc = new int[len];
/* 317 */     int[] hh = new int[len];
/* 318 */     int[] tl = new int[len];
/* 319 */     int[] ms = new int[len];
/* 320 */     int[] md = new int[len];
/* 321 */     int[] xl = new int[len];
/* 322 */     int[] mg = new int[len];
/* 323 */     int[] pc = new int[len];
/* 324 */     int[] sg = new int[len];
/* 325 */     int[] lt = new int[len];
/* 326 */     int[] values = new int[10];
/* 327 */     List l = new java.util.ArrayList();
/* 328 */     for (int i = 0; i < list.size(); i++) {
/* 329 */       SpecialPersonCountByTypeVO s = (SpecialPersonCountByTypeVO)list.get(i);
/* 330 */       name[i] = s.getName();
/* 331 */       values[0] = s.getYc();
/* 332 */       values[1] = s.getHh();
/* 333 */       values[2] = s.getTl();
/* 334 */       values[3] = s.getMs();
/* 335 */       values[4] = s.getMd();
/* 336 */       values[5] = s.getXl();
/* 337 */       values[6] = s.getMg();
/* 338 */       values[7] = s.getPc();
/* 339 */       values[8] = s.getSg();
/* 340 */       values[9] = s.getLt();
/* 341 */       l.add(values);
/*     */     }
/* 343 */     lists.add(name);
/* 344 */     lists.add(type);
/* 345 */     lists.add(l);
/*     */     
/* 347 */     return lists;
/*     */   }
/*     */   
/*     */   public HashMap getSpecialDetail(String certifID, String type)
/*     */   {
/* 352 */     switch (type) {
/*     */     case "01": 
/* 354 */       return getEmancipistDetail(certifID);
/*     */     case "02": 
/* 356 */       return getCommunityCorrectionerDetail(certifID);
/*     */     case "03": 
/* 358 */       return getPsychoticDetail(certifID);
/*     */     case "04": 
/* 360 */       return getDrugAddictsDetail(certifID);
/*     */     case "05": 
/* 362 */       return getAIDSdiseaseDetail(certifID);
/*     */     case "06": 
/* 364 */       return getKeyYoungersDetail(certifID);
/*     */     case "07": 
/* 366 */       return getKeyPetitionersDetail(certifID);
/*     */     }
/* 368 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @org.springframework.transaction.annotation.Transactional
/*     */   public boolean addSpecialPerson(String object, String type)
/*     */   {
/* 377 */     switch (type) {
/*     */     case "01": 
/* 379 */       SpecialPopulationExtendEmancipist s = (SpecialPopulationExtendEmancipist)JSON.parseObject(object, SpecialPopulationExtendEmancipist.class);
/* 380 */       this.specialPopulationExtendEmancipistMapper.insert(s);
/* 381 */       this.servedPersonBasicMapper.changeSpecialStatus(s.getCertifID());
/* 382 */       TRSpecialServedPerson t = new TRSpecialServedPerson();
/* 383 */       t.setSpecialPopulationTypeValue(type);
/* 384 */       t.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(s.getCertifID()));
/* 385 */       return this.trSpecialServedPersonMapper.insert(t) != 0;
/*     */     case "02": 
/* 387 */       SpecialPopulationExtendCommunityCorrectioner cc = (SpecialPopulationExtendCommunityCorrectioner)JSON.parseObject(object, SpecialPopulationExtendCommunityCorrectioner.class);
/*     */       
/* 389 */       this.specialPopulationExtendCommunityCorrectionerMapper.insert(cc);
/* 390 */       this.servedPersonBasicMapper.changeSpecialStatus(cc.getCertifID());
/* 391 */       TRSpecialServedPerson t1 = new TRSpecialServedPerson();
/* 392 */       t1.setSpecialPopulationTypeValue(type);
/* 393 */       t1.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(cc.getCertifID()));
/* 394 */       return this.trSpecialServedPersonMapper.insert(t1) != 0;
/*     */     case "03": 
/* 396 */       SpecialPopulationExtendSeverePsychotic sp = (SpecialPopulationExtendSeverePsychotic)JSON.parseObject(object, SpecialPopulationExtendSeverePsychotic.class);
/*     */       
/* 398 */       this.specialPopulationExtendSeverePsychoticMapper.insert(sp);
/* 399 */       this.servedPersonBasicMapper.changeSpecialStatus(sp.getCertifID());
/* 400 */       TRSpecialServedPerson t2 = new TRSpecialServedPerson();
/* 401 */       t2.setSpecialPopulationTypeValue(type);
/* 402 */       t2.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(sp.getCertifID()));
/* 403 */       return this.trSpecialServedPersonMapper.insert(t2) != 0;
/*     */     case "04": 
/* 405 */       SpecialPopulationExtendDrugAddicts da = (SpecialPopulationExtendDrugAddicts)JSON.parseObject(object, SpecialPopulationExtendDrugAddicts.class);
/* 406 */       this.specialPopulationExtendDrugAddictsMapper.insert(da);
/* 407 */       this.servedPersonBasicMapper.changeSpecialStatus(da.getCertifID());
/* 408 */       TRSpecialServedPerson t3 = new TRSpecialServedPerson();
/* 409 */       t3.setSpecialPopulationTypeValue(type);
/* 410 */       t3.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(da.getCertifID()));
/* 411 */       return this.trSpecialServedPersonMapper.insert(t3) != 0;
/*     */     case "05": 
/* 413 */       SpecialPopulationExtendAIDSdisease AIDS = (SpecialPopulationExtendAIDSdisease)JSON.parseObject(object, SpecialPopulationExtendAIDSdisease.class);
/*     */       
/* 415 */       this.specialPopulationExtendAIDSdiseaseMapper.insert(AIDS);
/* 416 */       this.servedPersonBasicMapper.changeSpecialStatus(AIDS.getCertifID());
/* 417 */       TRSpecialServedPerson t4 = new TRSpecialServedPerson();
/* 418 */       t4.setSpecialPopulationTypeValue(type);
/* 419 */       t4.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(AIDS.getCertifID()));
/* 420 */       return this.trSpecialServedPersonMapper.insert(t4) != 0;
/*     */     case "06": 
/* 422 */       KeyYoungers youngers = (KeyYoungers)JSON.parseObject(object, KeyYoungers.class);
/* 423 */       this.keyYoungersMapper.insert(youngers);
/* 424 */       this.servedPersonBasicMapper.changeSpecialStatus(youngers.getCertifID());
/* 425 */       TRSpecialServedPerson t5 = new TRSpecialServedPerson();
/* 426 */       t5.setSpecialPopulationTypeValue(type);
/* 427 */       t5.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(youngers.getCertifID()));
/* 428 */       return this.trSpecialServedPersonMapper.insert(t5) != 0;
/*     */     case "07": 
/* 430 */       KeyPetitioners petitioners = (KeyPetitioners)JSON.parseObject(object, KeyPetitioners.class);
/* 431 */       this.keyPetitionersMapper.insert(petitioners);
/* 432 */       this.servedPersonBasicMapper.changeSpecialStatus(petitioners.getCertifID());
/* 433 */       TRSpecialServedPerson t6 = new TRSpecialServedPerson();
/* 434 */       t6.setSpecialPopulationTypeValue(type);
/* 435 */       t6.setServedPersonID(this.servedPersonBasicMapper.getPrimaryKeyByCertifID(petitioners.getCertifID()));
/* 436 */       return this.trSpecialServedPersonMapper.insert(t6) != 0;
/*     */     }
/* 438 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<com.jtzh.vo.served.SpecialPersonPieVO> getSpecialPersonPieCount(String type)
/*     */   {
/* 445 */     return this.specialServedPersonMapper.getSpecialPersonPieCount(type);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateSpecialPerson(String object, String type)
/*     */   {
/* 451 */     switch (type) {
/*     */     case "01": 
/* 453 */       return 
/* 454 */         this.specialPopulationExtendEmancipistMapper.updateByPrimaryKey((SpecialPopulationExtendEmancipist)JSON.parseObject(object, SpecialPopulationExtendEmancipist.class)) != 0;
/*     */     
/*     */     case "02": 
/* 457 */       return this.specialPopulationExtendCommunityCorrectionerMapper.updateByPrimaryKey(
/* 458 */         (SpecialPopulationExtendCommunityCorrectioner)JSON.parseObject(object, SpecialPopulationExtendCommunityCorrectioner.class)) != 0;
/*     */     case "03": 
/* 460 */       return this.specialPopulationExtendSeverePsychoticMapper.updateByPrimaryKey(
/* 461 */         (SpecialPopulationExtendSeverePsychotic)JSON.parseObject(object, SpecialPopulationExtendSeverePsychotic.class)) != 0;
/*     */     case "04": 
/* 463 */       return 
/* 464 */         this.specialPopulationExtendDrugAddictsMapper.updateByPrimaryKey((SpecialPopulationExtendDrugAddicts)JSON.parseObject(object, SpecialPopulationExtendDrugAddicts.class)) != 0;
/*     */     
/*     */     case "05": 
/* 467 */       return 
/* 468 */         this.specialPopulationExtendAIDSdiseaseMapper.updateByPrimaryKey((SpecialPopulationExtendAIDSdisease)JSON.parseObject(object, SpecialPopulationExtendAIDSdisease.class)) != 0;
/*     */     
/*     */     case "06": 
/* 471 */       return this.keyYoungersMapper.updateByPrimaryKey((KeyYoungers)JSON.parseObject(object, KeyYoungers.class)) != 0;
/*     */     case "07": 
/* 473 */       return this.keyPetitionersMapper.updateByPrimaryKey((KeyPetitioners)JSON.parseObject(object, KeyPetitioners.class)) != 0;
/*     */     }
/* 475 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean deleteSpecialPerson(Long id, String type)
/*     */   {
/* 483 */     switch (type)
/*     */     {
/*     */ 
/*     */ 
/*     */     case "01": 
/* 488 */       return this.specialPopulationExtendEmancipistMapper.deleteByPrimaryKey(id) != 0;
/*     */     
/*     */ 
/*     */ 
/*     */     case "02": 
/* 493 */       return this.specialPopulationExtendCommunityCorrectionerMapper.deleteByPrimaryKey(id) != 0;
/*     */     
/*     */ 
/*     */ 
/*     */     case "03": 
/* 498 */       return this.specialPopulationExtendSeverePsychoticMapper.deleteByPrimaryKey(id) != 0;
/*     */     
/*     */ 
/*     */ 
/*     */     case "04": 
/* 503 */       return this.specialPopulationExtendDrugAddictsMapper.deleteByPrimaryKey(id) != 0;
/*     */     
/*     */ 
/*     */ 
/*     */     case "05": 
/* 508 */       return this.specialPopulationExtendAIDSdiseaseMapper.deleteByPrimaryKey(id) != 0;
/*     */     case "06": 
/* 510 */       return this.keyYoungersMapper.deleteByPrimaryKey(Integer.valueOf(id.intValue())) != 0;
/*     */     case "07": 
/* 512 */       return this.keyPetitionersMapper.deleteByPrimaryKey(id) != 0; }
/*     */     
/* 514 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean checkSpecialPersonByCertifID(String certifID, String type)
/*     */   {
/* 520 */     HashMap map = getSpecialDetail(certifID, type);
/* 521 */     List basic = (List)map.get("basic");
/* 522 */     List special = (List)map.get("special");
/* 523 */     if ((basic.size() > 0) && (special.size() == 0))
/* 524 */       return true;
/* 525 */     return false;
/*     */   }
/*     */   
/*     */   private List<String> getPhotoPath(String certifID) {
/* 529 */     Long servedID = this.servedPersonBasicMapper.getPrimaryKeyByCertifID(certifID);
/* 530 */     List<com.jtzh.entity.ServedPersonPhoto> photos = this.servedPersonPhotoMapper.selectByServedPersonID(servedID);
/* 531 */     List<String> paths = new java.util.ArrayList();
/* 532 */     String rootPath = com.jtzh.util.CommonUtils.getRootPath("server.root");
/* 533 */     if (photos.size() > 0) {
/* 534 */       com.jtzh.entity.ServedPersonPhoto p = (com.jtzh.entity.ServedPersonPhoto)photos.get(0);
/*     */       
/* 536 */       String path = rootPath + p.getPhotoFilePath() + p.getPhotoFileName() + p.getPhotoFileSuffix();
/* 537 */       paths.add(path);
/*     */     }
/* 539 */     return paths;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\SpecialPersonServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */