/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.nonpublic.NonPublicEconomyOrgDetailVO;
/*     */ import com.jtzh.vo.nonpublic.NonPublicEconomyOrgInfoVO;
/*     */ import com.jtzh.vo.nonpublic.NonPublicEconomyOrgQueryVO;
/*     */ import com.jtzh.vo.nonpublic.NonpublicHistogramVO;
/*     */ import com.jtzh.vo.nonpublic.SocietyOrgDetailVO;
/*     */ import com.jtzh.vo.nonpublic.SocietyOrgInfoVO;
/*     */ import com.jtzh.vo.nonpublic.SocietyOrgQueryVO;
import com.jtzh.entity.EnterprisePicture;
import com.jtzh.entity.NonPublicEconomyOrg;
import com.jtzh.entity.Picture;
import com.jtzh.entity.SocietyOrg;
import com.jtzh.mapper.CODEAttentionTypeValueMapper;
import com.jtzh.mapper.CODEDocumentTypeMapper;
import com.jtzh.mapper.CODEEnterpriseTypeMapper;
import com.jtzh.mapper.CODEHiddenDangerTypeMapper;
import com.jtzh.mapper.CODESocietyOrgTypeValueMapper;
import com.jtzh.mapper.EnterprisePictureMapper;
import com.jtzh.mapper.NetGridMapper;
import com.jtzh.mapper.NonPublicEconomyOrgMapper;
import com.jtzh.mapper.PictureMapper;
import com.jtzh.mapper.SocietyOrgMapper;
import com.jtzh.service.NonpublicService;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class NonpublicServiceImpl
/*     */   implements NonpublicService
/*     */ {
/*     */   @Autowired
/*     */   private CODEEnterpriseTypeMapper codeEnterpriseTypeMapper;
/*     */   @Autowired
/*     */   private CODEDocumentTypeMapper codeDocumentTypeMapper;
/*     */   @Autowired
/*     */   private CODEHiddenDangerTypeMapper codeHiddenDangerTypeMapper;
/*     */   @Autowired
/*     */   private CODEAttentionTypeValueMapper codeAttentionTypeValueMapper;
/*     */   @Autowired
/*     */   private CODESocietyOrgTypeValueMapper codeSocietyOrgTypeValueMapper;
/*     */   @Autowired
/*     */   private NetGridMapper netGridMapper;
/*     */   @Autowired
/*     */   private NonPublicEconomyOrgMapper nonPublicEconomyOrgMapper;
/*     */   @Autowired
/*     */   private SocietyOrgMapper societyOrgMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private EnterprisePictureMapper enterprisePictureMapper;
/*     */   private static final String PICTURE_PATH = "/enterprise_picture/";
/*     */   
/*     */   public HashMap getNopublicCode()
/*     */   {
/*  72 */     HashMap<String, List> maps = new HashMap();
/*  73 */     List a1 = this.codeEnterpriseTypeMapper.selectAll();
/*  74 */     List a2 = this.codeDocumentTypeMapper.selectAll();
/*  75 */     List a3 = this.codeHiddenDangerTypeMapper.selectAll();
/*  76 */     List a4 = this.codeAttentionTypeValueMapper.selectAll();
/*  77 */     List a5 = this.codeSocietyOrgTypeValueMapper.selectAll();
/*  78 */     List a6 = this.netGridMapper.selectAll();
/*  79 */     maps.put("codeEnterpriseType", a1);
/*  80 */     maps.put("codeDocumentType", a2);
/*  81 */     maps.put("codeHiddenDangerType", a3);
/*  82 */     maps.put("codeAttentionTypeValue", a4);
/*  83 */     maps.put("codeSocietyOrgTypeValue", a5);
/*  84 */     maps.put("netGrid", a6);
/*  85 */     return maps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public NonPublicEconomyOrgQueryVO getNonPublicEconomyOrgInfo(String name, String type, Long netGridID, Integer isLogisticsEnterprise, Integer isKeyEnterprise, int page, int pageSize)
/*     */   {
/*  92 */     int start = 0;
/*  93 */     if (page > 1)
/*  94 */       start = (page - 1) * pageSize;
/*  95 */     List<NonPublicEconomyOrgInfoVO> infoVOs = this.nonPublicEconomyOrgMapper.getNonPublicEconomyOrgInfo(name, type, netGridID, isLogisticsEnterprise, isKeyEnterprise, start, pageSize);
/*     */     
/*  97 */     int count = this.nonPublicEconomyOrgMapper.getNonPublicEconomyOrgInfoCount(name, type, netGridID, isLogisticsEnterprise, isKeyEnterprise);
/*     */     
/*  99 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 100 */     NonPublicEconomyOrgQueryVO vo = new NonPublicEconomyOrgQueryVO();
/* 101 */     vo.setNonPublicEconomyOrgInfo(infoVOs);
/* 102 */     vo.setPage(p);
/* 103 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<NonPublicEconomyOrgDetailVO> getNonPublicEconomyOrgDetailForGIS(Integer netGridID, Integer isLogisticsEnterprise, Integer isKeyEnterprise)
/*     */   {
/* 109 */     return this.nonPublicEconomyOrgMapper.getNonPublicEconomyOrgDetailForGIS(netGridID, isLogisticsEnterprise, isKeyEnterprise);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map getNonPublicEconomyOrgDetailByCode(String code)
/*     */   {
/* 116 */     List pictures = getPictures(code);
/* 117 */     List<NonPublicEconomyOrgDetailVO> list = this.nonPublicEconomyOrgMapper.getNonPublicEconomyOrgDetailByCode(code);
/* 118 */     Map map = new HashMap();
/* 119 */     map.put("basic", list);
/* 120 */     map.put("pictures", pictures);
/* 121 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addNonpublic(NonPublicEconomyOrg org)
/*     */   {
/* 127 */     return this.nonPublicEconomyOrgMapper.insert(org) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateNonpublic(NonPublicEconomyOrg org)
/*     */   {
/* 133 */     return this.nonPublicEconomyOrgMapper.updateByPrimaryKey(org) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteNonpublic(String code)
/*     */   {
/* 139 */     if (getPictures(code).size() > 0)
/* 140 */       this.enterprisePictureMapper.deleteByUSCode(code);
/* 141 */     return this.nonPublicEconomyOrgMapper.deleteByPrimaryKey(code) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public List getEconomyHistogram()
/*     */   {
/* 147 */     List<NonpublicHistogramVO> list = this.nonPublicEconomyOrgMapper.getHistogram();
/* 148 */     List l = new ArrayList();
/* 149 */     int len = list.size();
/* 150 */     String[] name = new String[len];
/* 151 */     int[] count = new int[len];
/* 152 */     for (int i = 0; i < len; i++) {
/* 153 */       NonpublicHistogramVO v = (NonpublicHistogramVO)list.get(i);
/* 154 */       name[i] = v.getName();
/* 155 */       count[i] = v.getCount();
/*     */     }
/* 157 */     l.add(name);
/* 158 */     l.add(count);
/* 159 */     return l;
/*     */   }
/*     */   
/*     */ 
/*     */   public NonPublicEconomyOrg getToUpdateInfo(String code)
/*     */   {
/* 165 */     return this.nonPublicEconomyOrgMapper.selectByPrimaryKey(code);
/*     */   }
/*     */   
/*     */ 
/*     */   public SocietyOrgQueryVO getSocietyOrgInfo(String name, String type, Integer netGridID, int page, int pageSize)
/*     */   {
/* 171 */     int start = 0;
/* 172 */     if (page > 1)
/* 173 */       start = (page - 1) * pageSize;
/* 174 */     List<SocietyOrgInfoVO> list = this.societyOrgMapper.getSocietyOrgInfo(name, type, netGridID, start, pageSize);
/* 175 */     int count = this.societyOrgMapper.getSocietyOrgInfoCount(name, type, netGridID);
/* 176 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 177 */     SocietyOrgQueryVO vo = new SocietyOrgQueryVO();
/* 178 */     vo.setSocietyOrgInfos(list);
/* 179 */     vo.setP(p);
/* 180 */     return vo;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SocietyOrgDetailVO> getSocietyOrgDetailByCode(String code)
/*     */   {
/* 186 */     return this.societyOrgMapper.getSocietyOrgDetailByCode(code);
/*     */   }
/*     */   
/*     */ 
/*     */   public SocietyOrg getToUpdateSocietyOrgInfo(String code)
/*     */   {
/* 192 */     return this.societyOrgMapper.selectByPrimaryKey(code);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addSocietyOrg(SocietyOrg s)
/*     */   {
/* 198 */     return this.societyOrgMapper.insert(s) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean updateSocietyOrg(SocietyOrg s)
/*     */   {
/* 204 */     return this.societyOrgMapper.updateByPrimaryKey(s) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteSocietyOrg(String code)
/*     */   {
/* 210 */     return this.societyOrgMapper.deleteByPrimaryKey(code) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public List getSocietyOrgHistogram()
/*     */   {
/* 216 */     List<NonpublicHistogramVO> list = this.societyOrgMapper.getSocietyOrgHistogram();
/* 217 */     List l = new ArrayList();
/* 218 */     int len = list.size();
/* 219 */     String[] name = new String[len];
/* 220 */     int[] count = new int[len];
/* 221 */     for (int i = 0; i < len; i++) {
/* 222 */       NonpublicHistogramVO v = (NonpublicHistogramVO)list.get(i);
/* 223 */       name[i] = v.getName();
/* 224 */       count[i] = v.getCount();
/*     */     }
/* 226 */     l.add(name);
/* 227 */     l.add(count);
/* 228 */     return l;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean uploadEnterprisePicture(MultipartFile file, String code)
/*     */   {
/* 234 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 235 */     if ((file != null) && (!file.isEmpty())) {
/* 236 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 238 */       String originFileName = file.getOriginalFilename();
/* 239 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 242 */       File outPath = new File(root_path + "/enterprise_picture/");
/* 243 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 244 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 248 */       File outFile = new File(root_path + "/enterprise_picture/" + filename + extension);
/*     */       try
/*     */       {
/* 251 */         file.transferTo(outFile);
/*     */         
/* 253 */         Picture p = new Picture();
/* 254 */         p.setPictureName(filename);
/* 255 */         p.setPictureSuffix(extension);
/* 256 */         p.setPicturePath("/enterprise_picture/");
/* 257 */         this.pictureMapper.insert(p);
/* 258 */         Long pictureID = p.getPictureID();
/* 259 */         EnterprisePicture e = new EnterprisePicture();
/* 260 */         e.setEnterpriseUSCode(code);
/* 261 */         e.setPictureID(pictureID);
/* 262 */         return this.enterprisePictureMapper.insert(e) != 0;
/*     */       } catch (IOException e) {
/* 264 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 267 */     return false;
/*     */   }
/*     */   
/*     */   private List getPictures(String code) {
/* 271 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 272 */     List<Picture> pictures = this.pictureMapper.selectByEnterpriseUSCode(code);
/* 273 */     List<String> picturePaths = new ArrayList();
/* 274 */     if (pictures.size() > 0) {
/* 275 */       for (Picture p : pictures) {
/* 276 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 277 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 280 */     return picturePaths;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\NonpublicServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */