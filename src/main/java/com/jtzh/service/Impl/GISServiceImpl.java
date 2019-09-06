/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.mapper.*;
import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.vo.gis.PieCountVO;
/*     */ import com.jtzh.vo.gis.RealTimeLocationVO;
import com.jtzh.vo.gis.ServedPersonCountVO;
/*     */ import com.jtzh.vo.gis.SpecialPopulationCountVO;
import com.jtzh.entity.DisputeEvent;
import com.jtzh.entity.Picture;
import com.jtzh.entity.TEFile;

/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/*     */
/*     */ @org.springframework.stereotype.Service
/*     */ public class GISServiceImpl implements com.jtzh.service.GISService
/*     */ {
/*     */   @Autowired
/*     */   private ServedPersonBasicMapper servedPersonBasicMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.SpecialPopulationExtendAIDSdiseaseMapper AIDSdiseaseMapper;
/*     */   @Autowired
/*     */   private SpecialPopulationExtendCommunityCorrectionerMapper communityCorrectionerMapper;
/*     */   @Autowired
/*     */   private SpecialPopulationExtendDrugAddictsMapper drugAddictsMapper;
/*     */   @Autowired
/*     */   private SpecialPopulationExtendEmancipistMapper emancipistMapper;
/*     */   @Autowired
/*     */   private SpecialPopulationExtendSeverePsychoticMapper severePsychoticMapper;
/*     */   @Autowired
/*     */   private NonPublicEconomyOrgMapper nonPublicEconomyOrgMapper;
/*     */   @Autowired
/*     */   private SocietyOrgMapper societyOrgMapper;
/*     */   @Autowired
/*     */   private DisputeEventMapper disputeEventMapper;
/*     */   @Autowired
/*     */   private VideoMapper videoMapper;
/*     */   @Autowired
/*     */   private OrgMemberServedPersonRecordMapper orgMemberServedPersonRecordMapper;
/*     */   @Autowired
/*     */   private TrafficAccidentMapper trafficAccidentMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TEFileMapper fileMapper;
/*     */   @Autowired
/*     */   private SocietySecurityEventMapper societySecurityEventMapper;
/*     */   @Autowired
/*     */   private ScenicAreaDutyPointMapper scenicAreaDutyPointMapper;
/*     */   @Autowired
/*     */   private KeyYoungersMapper keyYoungersMapper;
/*     */   @Autowired
/*     */   private SSEventInvolvedPersonsMapper ssEventInvolvedPersonsMapper;
/*     */   @Autowired
/*     */   private KeyPetitionersMapper keyPetitionersMapper;
            @Resource
            private RealTimeLocationMapper realTimeLocationMapper;
/*     */   
/*     */   public List<ServedPersonCountVO> getCount(Long netGridID)
/*     */   {
/*  77 */     return this.servedPersonBasicMapper.getCount(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ServedPersonCountVO> getCountByNetGrid(String servedPersonTypeValue, String netGridID)
/*     */   {
/*  83 */     return this.servedPersonBasicMapper.getCountByNetGrid(servedPersonTypeValue, netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.ServedPersonBasicVO> getServedPersonBasic(String servedPersonTypeValue)
/*     */   {
/*  89 */     return this.servedPersonBasicMapper.getServedPersonBasic(servedPersonTypeValue);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.ServedPersonBasicVO> getServedPersonBasicByNetGrid(String servedPersonTypeValue, String netGridID)
/*     */   {
/*  95 */     return this.servedPersonBasicMapper.getServedPersonBasicByNetGrid(servedPersonTypeValue, netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SpecialPopulationCountVO> getSpecialPopulationCount(Long netGridID)
/*     */   {
/* 101 */     List<SpecialPopulationCountVO> vos = new ArrayList();
/* 102 */     SpecialPopulationCountVO vo1 = new SpecialPopulationCountVO();
/* 103 */     vo1.setType("刑满释放人员");
/* 104 */     vo1.setCount(this.emancipistMapper.getCount(netGridID));
/* 105 */     SpecialPopulationCountVO vo2 = new SpecialPopulationCountVO();
/* 106 */     vo2.setType("社区矫正人员");
/* 107 */     vo2.setCount(this.communityCorrectionerMapper.getCount(netGridID));
/* 108 */     SpecialPopulationCountVO vo3 = new SpecialPopulationCountVO();
/* 109 */     vo3.setType("精神障碍患者");
/* 110 */     vo3.setCount(this.severePsychoticMapper.getCount(netGridID));
/* 111 */     SpecialPopulationCountVO vo6 = new SpecialPopulationCountVO();
/* 112 */     vo6.setType("重点信访人员");
/* 113 */     vo6.setCount(this.keyPetitionersMapper.getCountForGIS(netGridID));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     vos.add(vo1);
/* 121 */     vos.add(vo2);
/* 122 */     vos.add(vo3);
/* 123 */     vos.add(vo6);
/*     */     
/*     */ 
/* 126 */     return vos;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.AIDSdiseaseVO> getAIDSdiseaseWithLocation(Long netGridID)
/*     */   {
/* 132 */     return this.AIDSdiseaseMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.CommunityCorrectionerVO> getCommunityCorrectionerWithLocation(Long netGridID)
/*     */   {
/* 138 */     return this.communityCorrectionerMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.EmancipistVO> getEmancipistWithLocation(Long netGridID)
/*     */   {
/* 144 */     return this.emancipistMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.DrugAddictsVO> getDrugAddictsWithLocation(Long netGridID)
/*     */   {
/* 150 */     return this.drugAddictsMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.SeverePsychoticVO> getSeverePsychoticWithLocation(Long netGridID)
/*     */   {
/* 156 */     return this.severePsychoticMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */   public List<com.jtzh.vo.gis.KeyYoungersVO> getKeyYoungersWithLocation(Integer netGridID)
/*     */   {
/* 161 */     return this.keyYoungersMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */   public List<com.jtzh.vo.KeyPetitioners.KeyPetitionersForGISVO> getKeyPetitionersWithLocation(Integer netGridID)
/*     */   {
/* 166 */     return this.keyPetitionersMapper.selectWithLocation(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.entity.NonPublicEconomyOrg> getAllNonPublicEconomyOrg(Long netGridID)
/*     */   {
/* 172 */     return this.nonPublicEconomyOrgMapper.selectAll(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.entity.SocietyOrg> getAllSocietyOrg(Long netGridID)
/*     */   {
/* 178 */     return this.societyOrgMapper.selectAll(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SpecialPopulationCountVO> getOrgCount(Long netGridID)
/*     */   {
/* 184 */     List<SpecialPopulationCountVO> vos = new ArrayList();
/* 185 */     SpecialPopulationCountVO v1 = new SpecialPopulationCountVO();
/* 186 */     v1.setType("非公经济组织");
/* 187 */     v1.setCount(this.nonPublicEconomyOrgMapper.getCount(netGridID));
/* 188 */     SpecialPopulationCountVO v2 = new SpecialPopulationCountVO();
/* 189 */     v2.setType("社会组织");
/* 190 */     v2.setCount(this.societyOrgMapper.getCount(netGridID));
/* 191 */     vos.add(v1);
/* 192 */     vos.add(v2);
/* 193 */     return vos;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SpecialPopulationCountVO> getDisputeEventCount(Long netGridID)
/*     */   {
/* 199 */     List<SpecialPopulationCountVO> vos = new ArrayList();
/* 200 */     SpecialPopulationCountVO v1 = new SpecialPopulationCountVO();
/* 201 */     v1.setType("待办事项");
/* 202 */     v1.setCount(this.disputeEventMapper.getUnSovleCount(netGridID));
/* 203 */     SpecialPopulationCountVO v2 = new SpecialPopulationCountVO();
/* 204 */     v2.setType("已办结事项");
/* 205 */     v2.setCount(this.disputeEventMapper.getSovleCount(netGridID));
/* 206 */     vos.add(v1);
/* 207 */     vos.add(v2);
/* 208 */     return vos;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SpecialPopulationCountVO> getTrafficAccidentCount(Long netGridID)
/*     */   {
/* 214 */     List<SpecialPopulationCountVO> vos = new ArrayList();
/* 215 */     SpecialPopulationCountVO v1 = new SpecialPopulationCountVO();
/* 216 */     v1.setType("待处理事故");
/* 217 */     v1.setCount(this.trafficAccidentMapper.getUnSovleCount(netGridID));
/* 218 */     SpecialPopulationCountVO v2 = new SpecialPopulationCountVO();
/* 219 */     v2.setType("已办结事故");
/* 220 */     v2.setCount(this.trafficAccidentMapper.getSovleCount(netGridID));
/* 221 */     vos.add(v1);
/* 222 */     vos.add(v2);
/* 223 */     return vos;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<SpecialPopulationCountVO> getSSEventCount(Long netGridID)
/*     */   {
/* 229 */     List<SpecialPopulationCountVO> vos = new ArrayList();
/* 230 */     SpecialPopulationCountVO v1 = new SpecialPopulationCountVO();
/* 231 */     v1.setType("一般事件");
/* 232 */     v1.setCount(this.societySecurityEventMapper.getCommonCount(netGridID));
/* 233 */     SpecialPopulationCountVO v2 = new SpecialPopulationCountVO();
/* 234 */     v2.setType("重点事件");
/* 235 */     v2.setCount(this.societySecurityEventMapper.getImportantCount(netGridID));
/* 236 */     SpecialPopulationCountVO v3 = new SpecialPopulationCountVO();
/* 237 */     v3.setType("物流安全");
/* 238 */     v3.setCount(this.nonPublicEconomyOrgMapper.getNonPublicEconomyOrgInfoCount("", "", netGridID, Integer.valueOf(1), Integer.valueOf(0)));
/* 239 */     SpecialPopulationCountVO v4 = new SpecialPopulationCountVO();
/* 240 */     v4.setType("重点企业");
/* 241 */     v4.setCount(this.nonPublicEconomyOrgMapper.getNonPublicEconomyOrgInfoCount("", "", netGridID, Integer.valueOf(0), Integer.valueOf(1)));
/* 242 */     SpecialPopulationCountVO v5 = new SpecialPopulationCountVO();
/* 243 */     v5.setType("景区执勤点");
/* 244 */     v5.setCount(this.scenicAreaDutyPointMapper.getCount(netGridID));
/* 245 */     vos.add(v1);
/* 246 */     vos.add(v2);
/* 247 */     vos.add(v3);
/* 248 */     vos.add(v4);
/* 249 */     vos.add(v5);
/* 250 */     return vos;
/*     */   }
/*     */   
/*     */   public List<com.jtzh.vo.gis.TrafficAccidentVO> getTrafficAccidentByStatus(String type, Integer netGridID)
/*     */   {
/* 255 */     return this.trafficAccidentMapper.getTrafficAccidentByStatus(type, netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<DisputeEvent> getAllDisputeEvent()
/*     */   {
/* 262 */     return this.disputeEventMapper.getAll();
/*     */   }
/*     */   
/*     */ 
/*     */   public List<DisputeEvent> selectForGIS(String key)
/*     */   {
/* 268 */     return this.disputeEventMapper.selectForGIS(key);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<DisputeEvent> getSolveEvent(Long netGridID)
/*     */   {
/* 274 */     return this.disputeEventMapper.getSolveEvent(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<DisputeEvent> getUnSolveEvent(Long netGridID)
/*     */   {
/* 281 */     return this.disputeEventMapper.getUnSolveEvent(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<PieCountVO> getVideoPieCount()
/*     */   {
/* 288 */     return this.videoMapper.getVideoPieCount();
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.video.VideoInfoVO> getVideoByNetGridID(Integer netGridID)
/*     */   {
/* 294 */     return this.videoMapper.getVideoByNetGridID(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.ServedRecordVO> getServedRecordForGIS(Integer netGridID)
/*     */   {
/* 300 */     return this.orgMemberServedPersonRecordMapper.getServedRecordForGIS(netGridID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<PieCountVO> getTrafficAccidentPieCount(Long netGridID)
/*     */   {
/* 306 */     return this.trafficAccidentMapper.getTrafficAccidentPieCount(netGridID);
/*     */   }
/*     */   
/*     */   public List<com.jtzh.vo.gis.SocietySecurityEventVO> getSSEventByType(Integer netGridID, Integer type)
/*     */   {
/* 311 */     return this.societySecurityEventMapper.getSSEventByType(netGridID, type);
/*     */   }
/*     */   
/*     */   public Map getSSEventMedia(Long id)
/*     */   {
/* 316 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 317 */     List<Picture> pictures = this.pictureMapper.selectBySSEventID(id);
/* 318 */     List<com.jtzh.entity.SSEventInvolvedPersons> involvedPersons = this.ssEventInvolvedPersonsMapper.selectBySSEventID(id);
/* 319 */     List<String> picturePaths = new ArrayList();
/* 320 */     if (pictures.size() > 0) {
/* 321 */       for (Picture p : pictures) {
/* 322 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 323 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 326 */     TEFile file = this.fileMapper.selectBySSEventID(id);
/* 327 */     String videoPath = null;
/* 328 */     if (file != null)
/* 329 */       videoPath = rootPath + file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 330 */     Map map = new HashMap();
/* 331 */     map.put("pictures", picturePaths);
/* 332 */     map.put("video", videoPath);
/* 333 */     map.put("involvedPersons", involvedPersons);
/* 334 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<com.jtzh.vo.gis.ScenicAreaDutyPointVO> getDutyPoint(Integer netGridID)
/*     */   {
/* 340 */     return this.scenicAreaDutyPointMapper.getScenicAreaDutyPointDetail(netGridID);
/*     */   }
/*     */   
/*     */   public Map getDutyPointMedia(Long id)
/*     */   {
/* 345 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 346 */     List<Picture> pictures = this.pictureMapper.selectByDutyPointID(id);
/* 347 */     List<String> picturePaths = new ArrayList();
/* 348 */     if (pictures.size() > 0) {
/* 349 */       for (Picture p : pictures) {
/* 350 */         String path = rootPath + p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 351 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 354 */     Object map = new HashMap();
/* 355 */     ((Map)map).put("pictures", picturePaths);
/* 356 */     return (Map)map;
/*     */   }
/*     */   
/*     */   public List<PieCountVO> getKeyYoungersCountForGIS(Long netGridID)
/*     */   {
/* 361 */     return this.keyYoungersMapper.getKeyYoungersCountForGIS(netGridID);
/*     */   }
    public List<RealTimeLocationVO> getRealTimeLocation(Long netGridID)
    {
        return this.realTimeLocationMapper.getRealTimeLocation(netGridID);
    }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\GISServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */