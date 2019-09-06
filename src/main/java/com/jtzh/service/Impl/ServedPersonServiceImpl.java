/*     */ package com.jtzh.service.Impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.jtzh.exception.MsmisException;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.Page;
import com.jtzh.util.PageUtil;
import com.jtzh.vo.orgMember.ServedPersonBasicResponseVO;
/*     */ import com.jtzh.vo.served.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
import com.jtzh.common.ResultObject;
import com.jtzh.entity.ServedPersonBasic;
import com.jtzh.entity.ServedPersonExtendFloatingPopulation;
import com.jtzh.entity.ServedPersonExtendResident;
import com.jtzh.entity.ServedPersonExtendStayedPerson;
import com.jtzh.entity.ServedPersonForeigner;
import com.jtzh.entity.ServedPersonPhoto;
import com.jtzh.entity.SpecialServedPerson;
import com.jtzh.mapper.ServedPersonBasicMapper;
import com.jtzh.mapper.ServedPersonExtendFloatingPopulationMapper;
import com.jtzh.mapper.ServedPersonExtendResidentMapper;
import com.jtzh.mapper.ServedPersonExtendStayedPersonMapper;
import com.jtzh.mapper.ServedPersonForeignerMapper;
import com.jtzh.mapper.ServedPersonPhotoMapper;
import com.jtzh.mapper.SpecialPopulationExtendDrugAddictsMapper;
import com.jtzh.mapper.SpecialPopulationExtendSeverePsychoticMapper;
import com.jtzh.mapper.SpecialServedPersonMapper;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/*     */
/*     */ @org.springframework.stereotype.Service
/*     */ public class ServedPersonServiceImpl implements com.jtzh.service.ServedPersonService
/*     */ {
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEServedPersonTypeMapper codeServedPersonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODESpecialPopulationTypeMapper codeSpecialPopulationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEFloatingReasonTypeMapper codeFloatingReasonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODECertificateTypeMapper codeCertificateTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEHouseTypeMapper codeHouseTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEConsistforPersonHouseTypeMapper codeConsistforPersonHouseTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEStayedPersonTypeMapper codeStayedPersonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEHealthStatusTypeMapper codeHealthStatusTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEInfectedWayTypeMapper codeInfectedWayTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEAIDSAttentionTypeMapper codeaidsAttentionTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEAIDSReceiveCTypeMapper codeAIDSReceiveCTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODECorrectingTypeMapper codeCorrectingTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEAcceptTypeMapper codeAcceptTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEMembersofGroupTypeMapper codeMembersofGroupTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEStopCorrectionTypeMapper codeStopCorrectionTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEControlSituationTypeMapper codeControlSituationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEDangerousEvaulationTypeMapper codeDangerousEvaulationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEConnectionTypeMapper codeConnectionTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEPlacementTypeMapper codePlacementTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEFamilyEconomicSituationTypeMapper codeFamilyEconomicSituationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODECurrentDiagnosisTypeMapper codeCurrentDiagnosisTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEDangerousEvaulationLevelTypeMapper codeDangerousEvaulationLevelTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODETreatmentSituationTypeMapper codeTreatmentSituationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEReligiousBeliefTypeMapper codeReligiousBeliefTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODECareerTypeMapper codeCareerTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEUnSettledReasonTypeMapper codeUnSettledReasonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODECaseTypeMapper codeCaseTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEDrugReasonTypeMapper codeDrugReasonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEDrugResultTypeMapper codeDrugResultTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEOriginalSinTypeMapper codeOriginalSinTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEEthnicityTypeMapper codeEthnicityTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEEducationTypeMapper codeEducationTypeMapper;
/*     */   @Resource
/*     */   private ServedPersonPhotoMapper servedPersonPhotoMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEPopulationTypeMapper codePopulationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEFamilySituationTypeMapper codeFamilySituationTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEHelpingSolutionTypeMapper codeHelpingSolutionTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEMaritalStatusTypeMapper codeMaritalStatusTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODERelatedtoGuardianTypeMapper codeRelatedtoGuardianTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEPoliticsTypeMapper codePoliticsTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODETrafficAccidentKindMapper codeTrafficAccidentKindMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODETrafficAccidentTypeMapper codeTrafficAccidentTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODETrafficAccidentStatusTypeMapper codeTrafficAccidentStatusTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEEventScaleTypeMapper codeEventScaleTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEEventTypeMapper codeEventTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEMajorPersonTypeMapper codeMajorPersonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODESolvingMethodTypeMapper codeSolvingMethodTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEEventStatusTypeMapper codeEventStatusTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODETemporaryResidenceTypeMapper codeTemporaryResidenceTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODETemporaryResidencyeReasonTypeMapper codeTemporaryResidencyeReasonTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODENationalityTypeMapper codeNationalityTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEActivityTypeMapper codeActivityTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEMeasuresTypeMapper codeMeasuresTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODEEconomicSourceTypeMapper codeEconomicSourceTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODESteadyStateTypeMapper codeSteadyStateTypeMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.CODESteadyGradeTypeMapper codeSteadyGradeTypeMapper;
/*     */   @Resource
/*     */   private ServedPersonExtendFloatingPopulationMapper servedPersonExtendFloatingPopulationMapper;
/*     */   @Resource
/*     */   private ServedPersonExtendResidentMapper servedPersonExtendResidentMapper;
/*     */   @Resource
/*     */   private ServedPersonExtendStayedPersonMapper servedPersonExtendStayedPersonMapper;
/*     */   @Resource
/*     */   private ServedPersonForeignerMapper servedPersonForeignerMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.SpecialPopulationExtendAIDSdiseaseMapper specialPopulationExtendAIDSdiseaseMapper;
/*     */   @Resource
/*     */   private SpecialPopulationExtendDrugAddictsMapper specialPopulationExtendDrugAddictsMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.SpecialPopulationExtendEmancipistMapper specialPopulationExtendEmancipistMapper;
/*     */   @Resource
/*     */   private SpecialPopulationExtendSeverePsychoticMapper specialPopulationExtendSeverePsychoticMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.SpecialPopulationExtendCommunityCorrectionerMapper specialPopulationExtendCommunityCorrectionerMapper;
/*     */   @Resource
/*     */   private ServedPersonBasicMapper servedPersonBasicMapper;
/*     */   @Resource
/*     */   private SpecialServedPersonMapper specialServedPersonMapper;
/*     */   @Resource
/*     */   private com.jtzh.mapper.NetGridMapper netGridMapper;
/*     */   private static final String PHOTO_PATH = "/photoes/";
/*     */   
/*     */   public List<com.jtzh.entity.CODEServedPersonType> getServedPersonType()
/*     */   {
/* 180 */     return this.codeServedPersonTypeMapper.selectAll();
/*     */   }
/*     */   
/*     */   public HashMap<String, List> getAllTypes()
/*     */   {
/* 185 */     HashMap<String, List> maps = new HashMap();
/* 186 */     List a1 = this.codeServedPersonTypeMapper.selectAll();
/* 187 */     List a2 = this.codeSpecialPopulationTypeMapper.selectAll();
/* 188 */     List a3 = this.codeFloatingReasonTypeMapper.selectAll();
/* 189 */     List a4 = this.codeCertificateTypeMapper.selectAll();
/* 190 */     List a5 = this.codeHouseTypeMapper.selectAll();
/* 191 */     List a6 = this.codeConsistforPersonHouseTypeMapper.selectAll();
/* 192 */     List a7 = this.codeStayedPersonTypeMapper.selectAll();
/* 193 */     List a8 = this.codeHealthStatusTypeMapper.selectAll();
/* 194 */     List a9 = this.codeInfectedWayTypeMapper.selectAll();
/* 195 */     List a10 = this.codeaidsAttentionTypeMapper.selectAll();
/* 196 */     List a11 = this.codeAIDSReceiveCTypeMapper.selectAll();
/* 197 */     List a12 = this.codeCorrectingTypeMapper.selectAll();
/* 198 */     List a13 = this.codeAcceptTypeMapper.selectAll();
/* 199 */     List a14 = this.codeMembersofGroupTypeMapper.selectAll();
/* 200 */     List a15 = this.codeStopCorrectionTypeMapper.selectAll();
/* 201 */     List a16 = this.codeControlSituationTypeMapper.selectAll();
/* 202 */     List a17 = this.codeDangerousEvaulationTypeMapper.selectAll();
/* 203 */     List a18 = this.codeConnectionTypeMapper.selectAll();
/* 204 */     List a19 = this.codePlacementTypeMapper.selectAll();
/* 205 */     List a20 = this.codeFamilyEconomicSituationTypeMapper.selectAll();
/* 206 */     List a21 = this.codeCurrentDiagnosisTypeMapper.selectAll();
/* 207 */     List a22 = this.codeDangerousEvaulationLevelTypeMapper.selectAll();
/* 208 */     List a23 = this.codeTreatmentSituationTypeMapper.selectAll();
/* 209 */     List a24 = this.codeReligiousBeliefTypeMapper.selectAll();
/* 210 */     List a25 = this.codeCareerTypeMapper.selectAll();
/* 211 */     List a26 = this.codeUnSettledReasonTypeMapper.selectAll();
/* 212 */     List a27 = this.codeCaseTypeMapper.selectAll();
/* 213 */     List a28 = this.codeDrugReasonTypeMapper.selectAll();
/* 214 */     List a29 = this.codeDrugResultTypeMapper.selectAll();
/* 215 */     List a30 = this.codeOriginalSinTypeMapper.selectAll();
/* 216 */     List a31 = this.codeEthnicityTypeMapper.selectAll();
/* 217 */     List a32 = this.codeEducationTypeMapper.selectAll();
/* 218 */     List a33 = this.codePopulationTypeMapper.selectAll();
/* 219 */     List a34 = this.codeFamilySituationTypeMapper.selectAll();
/* 220 */     List a35 = this.codeHelpingSolutionTypeMapper.selectAll();
/* 221 */     List a36 = this.codeMaritalStatusTypeMapper.selectAll();
/* 222 */     List a37 = this.codeRelatedtoGuardianTypeMapper.selectAll();
/* 223 */     List a38 = this.netGridMapper.selectAll();
/* 224 */     List a39 = this.codePoliticsTypeMapper.selectAll();
/* 225 */     List a40 = this.codeTrafficAccidentKindMapper.selectAll();
/* 226 */     List a41 = this.codeTrafficAccidentTypeMapper.selectAll();
/* 227 */     List a42 = this.codeTrafficAccidentStatusTypeMapper.selectAll();
/* 228 */     List a43 = this.codeEventScaleTypeMapper.selectAll();
/* 229 */     List a44 = this.codeEventTypeMapper.selectAll();
/* 230 */     List a45 = this.codeMajorPersonTypeMapper.selectAll();
/* 231 */     List a46 = this.codeSolvingMethodTypeMapper.selectAll();
/* 232 */     List a47 = this.codeEventStatusTypeMapper.selectAll();
/* 233 */     List a48 = this.codeTemporaryResidenceTypeMapper.selectAll();
/* 234 */     List a49 = this.codeTemporaryResidencyeReasonTypeMapper.selectAll();
/* 235 */     List a50 = this.codeNationalityTypeMapper.selectAll();
/* 236 */     List a51 = this.codeActivityTypeMapper.selectAll();
/* 237 */     List a52 = this.codeMeasuresTypeMapper.selectAll();
/* 238 */     List a53 = this.codeEconomicSourceTypeMapper.selectAll();
/* 239 */     List a54 = this.codeSteadyStateTypeMapper.selectAll();
/* 240 */     List a55 = this.codeSteadyGradeTypeMapper.selectAll();
/*     */     
/* 242 */     maps.put("codeServedPersonType", a1);
/* 243 */     maps.put("codeSpecialPopulationType", a2);
/* 244 */     maps.put("codeFloatingReasonType", a3);
/* 245 */     maps.put("codeCertificateType", a4);
/* 246 */     maps.put("codeHouseType", a5);
/* 247 */     maps.put("codeConsistforPersonHouseType", a6);
/* 248 */     maps.put("codeStayedPersonType", a7);
/* 249 */     maps.put("codeHealthStatusType", a8);
/* 250 */     maps.put("codeInfectedWayType", a9);
/* 251 */     maps.put("codeaidsAttentionType", a10);
/* 252 */     maps.put("codeAIDSReceiveCType", a11);
/* 253 */     maps.put("codeCorrectingType", a12);
/* 254 */     maps.put("codeAcceptType", a13);
/* 255 */     maps.put("codeMembersofGroupType", a14);
/* 256 */     maps.put("codeStopCorrectionType", a15);
/* 257 */     maps.put("codeControlSituationType", a16);
/* 258 */     maps.put("codeDangerousEvaulationType", a17);
/* 259 */     maps.put("codeConnectionType", a18);
/* 260 */     maps.put("codePlacementType", a19);
/* 261 */     maps.put("codeFamilyEconomicSituationType", a20);
/* 262 */     maps.put("codeCurrentDiagnosisType", a21);
/* 263 */     maps.put("codeDangerousEvaulationLevelType", a22);
/* 264 */     maps.put("codeTreatmentSituationType", a23);
/* 265 */     maps.put("codeReligiousBeliefType", a24);
/* 266 */     maps.put("codeCareerType", a25);
/* 267 */     maps.put("codeUnSettledReasonType", a26);
/* 268 */     maps.put("codeCaseType", a27);
/* 269 */     maps.put("codeDrugReasonType", a28);
/* 270 */     maps.put("codeDrugResultType", a29);
/* 271 */     maps.put("codeOriginalSinType", a30);
/* 272 */     maps.put("codeEthnicityType", a31);
/* 273 */     maps.put("codeEducationTypeMapper", a32);
/* 274 */     maps.put("codePopulationType", a33);
/* 275 */     maps.put("codeFamilySituationType", a34);
/* 276 */     maps.put("codeHelpingSolutionType", a35);
/* 277 */     maps.put("codeMaritalStatusType", a36);
/* 278 */     maps.put("codeRelatedtoGuardianType", a37);
/* 279 */     maps.put("netGrid", a38);
/* 280 */     maps.put("codePoliticsType", a39);
/* 281 */     maps.put("codeTrafficAccidentKind", a40);
/* 282 */     maps.put("codeTrafficAccidentType", a41);
/* 283 */     maps.put("codeTrafficAccidentStatusType", a42);
/* 284 */     maps.put("codeEventScaleType", a43);
/* 285 */     maps.put("codeEventType", a44);
/* 286 */     maps.put("codeMajorPersonType", a45);
/* 287 */     maps.put("codeSolvingMethodType", a46);
/* 288 */     maps.put("codeEventStatusType", a47);
/* 289 */     maps.put("codeTemporaryResidenceType", a48);
/* 290 */     maps.put("codeTemporaryResidencyeReasonType", a49);
/* 291 */     maps.put("codeNationalityType", a50);
/* 292 */     maps.put("codeActivityType", a51);
/* 293 */     maps.put("codeMeasuresType", a52);
/* 294 */     maps.put("codeEconomicSourceType", a53);
/* 295 */     maps.put("codeSteadyStateType", a54);
/* 296 */     maps.put("codeSteadyGradeType", a55);
/* 297 */     return maps;
/*     */   }
/*     */   
/*     */   public long uploadServedPersonPhoto(MultipartFile file)
/*     */   {
/* 302 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 303 */     if ((file != null) && (!file.isEmpty())) {
/* 304 */       String filename = String.valueOf(System.currentTimeMillis());
/*     */       
/* 306 */       String originFileName = file.getOriginalFilename();
/* 307 */       String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */       
/*     */ 
/* 310 */       File outPath = new File(root_path + "/photoes/");
/* 311 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/* 312 */         outPath.mkdirs();
/*     */       }
/*     */       
/*     */ 
/* 316 */       File outFile = new File(root_path + "/photoes/" + filename + extension);
/*     */       try
/*     */       {
/* 319 */         file.transferTo(outFile);
/*     */         
/* 321 */         ServedPersonPhoto photo = new ServedPersonPhoto();
/* 322 */         photo.setPhotoFileName(filename);
/* 323 */         photo.setPhotoFileSuffix(extension);
/* 324 */         photo.setPhotoFilePath("/photoes/");
/* 325 */         this.servedPersonPhotoMapper.insert(photo);
/* 326 */         return photo.getServedPersonPhotoID();
/*     */       } catch (IOException e) {
/* 328 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 331 */     return 0L;
/*     */   }
/*     */   
/*     */   public boolean updateServedPersonPhoto(MultipartFile file, Long id)
/*     */   {
/* 336 */     String root_path = CommonUtils.getRootPath("msmis.file");
/* 337 */     if ((file != null) && (!file.isEmpty())) {
/* 338 */       ServedPersonPhoto photo = (ServedPersonPhoto)this.servedPersonPhotoMapper.selectByServedPersonID(id).get(0);
/* 339 */       if (photo == null) {
/* 340 */         return uploadServedPersonPhoto(file) != 0L;
/*     */       }
/* 342 */       String filename = photo.getPhotoFileName();
/*     */       
/* 344 */       String extension = photo.getPhotoFileSuffix();
/*     */       
/*     */ 
/* 347 */       File outFile = new File(root_path + "/photoes/" + filename + extension);
/*     */       try
/*     */       {
/* 350 */         file.transferTo(outFile);
/* 351 */         return true;
/*     */       } catch (IOException e) {
/* 353 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 359 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public boolean addServedPersonBasic(ServedPersonBasicAddVO vo)
/*     */   {
/* 366 */     if (vo == null)
/* 367 */       throw new MsmisException("传入的添加对象为空");
/* 368 */     long servedPersonID = 0L;
/* 369 */     ServedPersonBasicVO exist = check(vo.getCertifID());
/* 370 */     if (exist == null) {
/* 371 */       ServedPersonBasic basic = new ServedPersonBasic();
/*     */       try {
/* 373 */         basic.setBirthDate(com.jtzh.util.DateUtil.strToDate(vo.getBirthDate()));
/*     */       } catch (java.text.ParseException e) {
/* 375 */         throw new MsmisException("日期参数错误！");
/*     */       }
/* 377 */       basic.setCareer(vo.getCareer());
/* 378 */       basic.setCareerType(vo.getCareerType());
/* 379 */       basic.setCertifID(vo.getCertifID());
/* 380 */       basic.setDomicileAddress(vo.getDomicileAddress());
/* 381 */       basic.setDomicileAddressDetail(vo.getDomicileAddressDetail());
/* 382 */       basic.setEducation(vo.getEducation());
/* 383 */       basic.setEthnicity(vo.getEthnicity());
/* 384 */       basic.setFixedTel(vo.getFixedTel());
/* 385 */       basic.setIsSpecialPopulation(vo.getIsSpecialPopulation());
/* 386 */       basic.setMaritalStatus(vo.getMaritalStatus());
/* 387 */       basic.setMobileTel(vo.getMobileTel());
/* 388 */       basic.setName(vo.getName());
/* 389 */       basic.setNameUsed(vo.getNameUsed());
/* 390 */       basic.setNativePlace(vo.getNativePlace());
/* 391 */       basic.setPolitics(vo.getPolitics());
/* 392 */       basic.setPresentAddress(vo.getPresentAddress());
/* 393 */       basic.setPresentAddressDetail(vo.getPresentAddressDetail());
/* 394 */       basic.setReligiousBelief(vo.getReligiousBelief());
/* 395 */       basic.setServedPersonTypeValue(vo.getServedPersonTypeValue());
/* 396 */       basic.setServedPlace(vo.getServedPlace());
/* 397 */       basic.setSex(vo.getSex());
/* 398 */       this.servedPersonBasicMapper.insert(basic);
/* 399 */       if (basic.getServedPersonID().longValue() == 0L)
/* 400 */         throw new MsmisException("添加失败！");
/* 401 */       servedPersonID = basic.getServedPersonID().longValue();
/*     */     } else {
/* 403 */       servedPersonID = exist.getServedPersonID().longValue();
/*     */     }
/* 405 */     ServedPersonPhoto servedPersonPhoto = this.servedPersonPhotoMapper.selectByPrimaryKey(Long.valueOf(vo.getImgId()));
/* 406 */     servedPersonPhoto.setServedPersonID(Long.valueOf(servedPersonID));
/* 407 */     int i = this.servedPersonPhotoMapper.updateByPrimaryKey(servedPersonPhoto);
/* 408 */     if (i == 0)
/* 409 */       throw new MsmisException("添加失败！");
/* 410 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public ServedPersonBasicResponseVO query(ServedPersonBasicQueryVO vo)
/*     */   {
/* 416 */     int start = 0;
/* 417 */     int pageSize = 10;
/* 418 */     int page = vo.getPage() - 1;
/* 419 */     if (vo.getPageSize() > 0)
/* 420 */       pageSize = vo.getPageSize();
/* 421 */     if (vo.getPage() > 1)
/* 422 */       start = page * pageSize;
/* 423 */     List<ServedPersonBasicVO> vos = this.servedPersonBasicMapper.queryBasic(vo.getName(), vo.getServedPersonTypeValue(), vo
/* 424 */       .getCertifID(), Integer.valueOf(vo.getNetGridID()), vo.getIsSpecialPopulation(), start, pageSize);
/* 425 */     int count = this.servedPersonBasicMapper.getQueryCount(vo.getName(), vo.getServedPersonTypeValue(), vo
/* 426 */       .getCertifID(), Integer.valueOf(vo.getNetGridID()), vo.getIsSpecialPopulation());
/* 427 */     com.jtzh.util.Page p = com.jtzh.util.PageUtil.createPage(pageSize, count, page);
/* 428 */     for (ServedPersonBasicVO b : vos)
/* 429 */       b.setBirthDateStr(com.jtzh.util.DateUtil.dateToStr(b.getBirthDate()));
/* 430 */     ServedPersonBasicResponseVO spbr = new ServedPersonBasicResponseVO();
/* 431 */     spbr.setPage(p);
/* 432 */     spbr.setQueryVO(vos);
/* 433 */     return spbr;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addFloating(ServedPersonExtendFloatingPopulation floating)
/*     */   {
/* 439 */     List<ServedPersonExtendFloatingPopulation> exists = this.servedPersonExtendFloatingPopulationMapper.queryByCerfitID(floating.getCertifID());
/* 440 */     if (exists.size() != 0)
/* 441 */       throw new MsmisException("该人员信息已存在");
/* 442 */     int i = this.servedPersonExtendFloatingPopulationMapper.insert(floating);
/* 443 */     return i != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addResident(ServedPersonExtendResident resident)
/*     */   {
/* 449 */     List<ServedPersonExtendResident> exists = this.servedPersonExtendResidentMapper.queryByCerfitID(resident.getCertifID());
/* 450 */     if (exists.size() != 0)
/* 451 */       throw new MsmisException("该人员信息已存在");
/* 452 */     int i = this.servedPersonExtendResidentMapper.insert(resident);
/* 453 */     return i != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addStayed(ServedPersonExtendStayedPerson stayed)
/*     */   {
/* 459 */     List<ServedPersonExtendStayedPerson> exists = this.servedPersonExtendStayedPersonMapper.queryByCerfitID(stayed.getCertifID());
/* 460 */     if (exists.size() != 0)
/* 461 */       throw new MsmisException("该人员信息已存在");
/* 462 */     int i = this.servedPersonExtendStayedPersonMapper.insert(stayed);
/* 463 */     return i != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addForeigner(ServedPersonForeigner foreigner)
/*     */   {
/* 469 */     List<ServedPersonForeigner> exists = this.servedPersonForeignerMapper.queryByCerfitID("");
/* 470 */     if (exists.size() != 0)
/* 471 */       throw new MsmisException("该人员信息已存在");
/* 472 */     int i = this.servedPersonForeignerMapper.insert(foreigner);
/* 473 */     return i != 0;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public boolean addAIDS(SpecialAIDSAddVO aids)
/*     */   {
/* 479 */     String specialTypeValue = "05";
/* 480 */     long servedPersonID = aids.getServedPersonID();
/*     */     
/* 482 */     if (check(aids.getCertifID()) == null) {
/* 483 */       throw new MsmisException("不存在该身份证号的人员信息，请添加其基本信息。");
/*     */     }
/* 485 */     List<SpecialServedPerson> records = this.specialServedPersonMapper.query(servedPersonID, specialTypeValue);
/* 486 */     if (records.size() == 0) {
/* 487 */       int i = this.specialPopulationExtendAIDSdiseaseMapper.insert(aids);
/* 488 */       SpecialServedPerson ssp = new SpecialServedPerson();
/* 489 */       ssp.setServedPersonID(Long.valueOf(servedPersonID));
/* 490 */       ssp.setSpecialPopulationTypeValue(specialTypeValue);
/* 491 */       this.specialServedPersonMapper.insert(ssp);
/* 492 */       return i != 0;
/*     */     }
/* 494 */     throw new MsmisException("该人员信息已存在，未执行添加操作");
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public boolean addDrug(SpecialDrugAddVO drug)
/*     */   {
/* 501 */     String specialTypeValue = "04";
/* 502 */     long servedPersonID = drug.getServedPersonID();
/*     */     
/* 504 */     if (check(drug.getCertifID()) == null) {
/* 505 */       throw new MsmisException("不存在该身份证号的人员信息，请添加其基本信息。");
/*     */     }
/* 507 */     List<SpecialServedPerson> records = this.specialServedPersonMapper.query(servedPersonID, specialTypeValue);
/* 508 */     if (records.size() == 0) {
/* 509 */       int i = this.specialPopulationExtendDrugAddictsMapper.insert(drug);
/* 510 */       SpecialServedPerson ssp = new SpecialServedPerson();
/* 511 */       ssp.setServedPersonID(Long.valueOf(servedPersonID));
/* 512 */       ssp.setSpecialPopulationTypeValue(specialTypeValue);
/* 513 */       this.specialServedPersonMapper.insert(ssp);
/* 514 */       return i != 0;
/*     */     }
/* 516 */     throw new MsmisException("该人员信息已存在，未执行添加操作");
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public boolean addEmancipist(SpecialEmancipistAddVO emancipist)
/*     */   {
/* 523 */     String specialTypeValue = "01";
/* 524 */     long servedPersonID = emancipist.getServedPersonID();
/*     */     
/* 526 */     if (check(emancipist.getCertifID()) == null) {
/* 527 */       throw new MsmisException("不存在该身份证号的人员信息，请添加其基本信息。");
/*     */     }
/* 529 */     List<SpecialServedPerson> records = this.specialServedPersonMapper.query(servedPersonID, specialTypeValue);
/* 530 */     if (records.size() == 0) {
/* 531 */       int i = this.specialPopulationExtendEmancipistMapper.insert(emancipist);
/* 532 */       SpecialServedPerson ssp = new SpecialServedPerson();
/* 533 */       ssp.setServedPersonID(Long.valueOf(servedPersonID));
/* 534 */       ssp.setSpecialPopulationTypeValue(specialTypeValue);
/* 535 */       this.specialServedPersonMapper.insert(ssp);
/* 536 */       return i != 0;
/*     */     }
/* 538 */     throw new MsmisException("该人员信息已存在，未执行添加操作");
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public boolean addPsychotic(SpecialPsychoticAddVO psychotic)
/*     */   {
/* 545 */     String specialTypeValue = "03";
/* 546 */     long servedPersonID = psychotic.getServedPersonID();
/*     */     
/* 548 */     if (check(psychotic.getCertifID()) == null) {
/* 549 */       throw new MsmisException("不存在该身份证号的人员信息，请添加其基本信息。");
/*     */     }
/* 551 */     List<SpecialServedPerson> records = this.specialServedPersonMapper.query(servedPersonID, specialTypeValue);
/* 552 */     if (records.size() == 0) {
/* 553 */       int i = this.specialPopulationExtendSeverePsychoticMapper.insert(psychotic);
/* 554 */       SpecialServedPerson ssp = new SpecialServedPerson();
/* 555 */       ssp.setServedPersonID(Long.valueOf(servedPersonID));
/* 556 */       ssp.setSpecialPopulationTypeValue(specialTypeValue);
/* 557 */       this.specialServedPersonMapper.insert(ssp);
/* 558 */       return i != 0;
/*     */     }
/* 560 */     throw new MsmisException("该人员信息已存在，未执行添加操作");
/*     */   }
/*     */   
/*     */   public ServedPersonBasicVO check(String certifID)
/*     */   {
/* 565 */     if ((certifID == null) || ("".equals(certifID.trim())))
/* 566 */       throw new MsmisException("身份证不能为空");
/* 567 */     List<ServedPersonBasicVO> vos = this.servedPersonBasicMapper.queryBasic(null, null, certifID, null, null, 0, 10);
/*     */     
/* 569 */     if (vos.size() > 1)
/* 570 */       throw new MsmisException("数据唯一性异常：该身份证对应的人员信息不唯一");
/* 571 */     if (vos.size() == 1)
/* 572 */       return (ServedPersonBasicVO)vos.get(0);
/* 573 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public HashMap<String, List> getServedPersonInfo(String certifID)
/*     */   {
/* 580 */     List<com.jtzh.vo.served.ServedPersonBasicDetailVO> basicDetailVOs = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/* 581 */     List<ServedPersonBasic> basic = this.servedPersonBasicMapper.selectByCertifID(certifID);
/*     */     
/* 583 */     List<ServedPersonExtendFloatingPopulation> floatingPopulations = this.servedPersonExtendFloatingPopulationMapper.queryByCerfitID(certifID);
/* 584 */     List<ServedPersonExtendResident> residents = this.servedPersonExtendResidentMapper.queryByCerfitID(certifID);
/*     */     
/* 586 */     List<ServedPersonExtendStayedPerson> stayedPersons = this.servedPersonExtendStayedPersonMapper.queryByCerfitID(certifID);
/*     */     
/* 588 */     List<com.jtzh.entity.SpecialPopulationExtendAIDSdisease> aidSdiseases = this.specialPopulationExtendAIDSdiseaseMapper.selectByCertifID(certifID);
/*     */     
/* 590 */     List<com.jtzh.entity.SpecialPopulationExtendCommunityCorrectioner> communityCorrectioners = this.specialPopulationExtendCommunityCorrectionerMapper.selectByCertifID(certifID);
/*     */     
/* 592 */     List<com.jtzh.entity.SpecialPopulationExtendDrugAddicts> drugAddicts = this.specialPopulationExtendDrugAddictsMapper.selectByCertifID(certifID);
/*     */     
/* 594 */     List<com.jtzh.entity.SpecialPopulationExtendEmancipist> emancipists = this.specialPopulationExtendEmancipistMapper.selectByCertifID(certifID);
/*     */     
/* 596 */     List<com.jtzh.entity.SpecialPopulationExtendSeverePsychotic> severePsychotics = this.specialPopulationExtendSeverePsychoticMapper.selectByCertifID(certifID);
/* 597 */     Long servedID = this.servedPersonBasicMapper.getPrimaryKeyByCertifID(certifID);
/* 598 */     List<ServedPersonPhoto> photos = this.servedPersonPhotoMapper.selectByServedPersonID(servedID);
/* 599 */     List<String> paths = new java.util.ArrayList();
/* 600 */     String rootPath = CommonUtils.getRootPath("server.root");
/* 601 */     if (photos.size() > 0) {
/* 602 */       ServedPersonPhoto p = (ServedPersonPhoto)photos.get(0);
/*     */       
/* 604 */       String path =  p.getPhotoFilePath() + p.getPhotoFileName() + p.getPhotoFileSuffix();
/* 605 */       paths.add(path);
/*     */     }
/* 607 */     HashMap<String, List> map = new HashMap();
/* 608 */     map.put("basicDetailVOs", basicDetailVOs);
/* 609 */     map.put("basic", basic);
/* 610 */     map.put("floatingPopulations", floatingPopulations);
/* 611 */     map.put("residents", residents);
/* 612 */     map.put("stayedPersons", stayedPersons);
/* 613 */     map.put("aidSdiseases", aidSdiseases);
/* 614 */     map.put("communityCorrectioners", communityCorrectioners);
/* 615 */     map.put("drugAddicts", drugAddicts);
/* 616 */     map.put("emancipists", emancipists);
/* 617 */     map.put("severePsychotics", severePsychotics);
/* 618 */     map.put("path", paths);
/* 619 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public List getServedPersonCount()
/*     */   {
/* 625 */     List<ServedPersonBasicCountVO> list = this.servedPersonBasicMapper.getServedPersonCount();
/* 626 */     int len = list.size();
/* 627 */     List lists = new java.util.ArrayList();
/* 628 */     String[] name = new String[len];
/* 629 */     String[] type = { "户籍人口", "流动人口", "留守人口", "境外人员" };
/* 630 */     int[] residents = new int[len];
/* 631 */     int[] floatings = new int[len];
/* 632 */     int[] stays = new int[len];
/* 633 */     int[] foreigners = new int[len];
/* 634 */     for (int i = 0; i < list.size(); i++) {
/* 635 */       ServedPersonBasicCountVO s = (ServedPersonBasicCountVO)list.get(i);
/* 636 */       name[i] = s.getName();
/* 637 */       residents[i] = s.getResident();
/* 638 */       floatings[i] = s.getFloating();
/* 639 */       stays[i] = s.getStay();
/* 640 */       foreigners[i] = s.getForeigner();
/*     */     }
/* 642 */     lists.add(name);
/* 643 */     lists.add(type);
/* 644 */     lists.add(residents);
/* 645 */     lists.add(floatings);
/* 646 */     lists.add(stays);
/* 647 */     lists.add(foreigners);
/* 648 */     return lists;
/*     */   }
/*     */   
/*     */   public boolean updateServedPerson(String object, String type)
/*     */   {
/* 653 */     switch (type) {
/*     */     case "00": 
/* 655 */       return this.servedPersonBasicMapper.updateByPrimaryKey((ServedPersonBasic)JSON.parseObject(object, ServedPersonBasic.class)) != 0;
/*     */     case "01": 
/* 657 */       return this.servedPersonExtendResidentMapper.updateByPrimaryKey((ServedPersonExtendResident)JSON.parseObject(object, ServedPersonExtendResident.class)) != 0;
/*     */     case "02": 
/* 659 */       return this.servedPersonExtendFloatingPopulationMapper.updateByPrimaryKey((ServedPersonExtendFloatingPopulation)JSON.parseObject(object, ServedPersonExtendFloatingPopulation.class)) != 0;
/*     */     case "03": 
/* 661 */       return this.servedPersonExtendStayedPersonMapper.updateByPrimaryKey((ServedPersonExtendStayedPerson)JSON.parseObject(object, ServedPersonExtendStayedPerson.class)) != 0;
/*     */     case "99": 
/* 663 */       return this.servedPersonForeignerMapper.updateByPrimaryKey((ServedPersonForeigner)JSON.parseObject(object, ServedPersonForeigner.class)) != 0;
/*     */     }
/* 665 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteServedPerson(String id, String type)
/*     */   {
/* 671 */     if("01".equals(type)){
                  return this.servedPersonExtendResidentMapper.deleteByCertifID(id) != 0;
                }
/*     */     if("02".equals(type))
/* 675 */       {return this.servedPersonExtendFloatingPopulationMapper.deleteByCertifID(id) != 0;}
/*     */     if("03".equals(type))
/* 677 */       {return this.servedPersonExtendStayedPersonMapper.deleteByCertifID(id) != 0;}
/* 679 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ServedPersonBasic> selectByNameAndCertifID(String name, String certifID)
/*     */   {
/* 685 */     return this.servedPersonBasicMapper.selectByNameAndCertifID(name, certifID);
/*     */   }
public ServedPersonBasicQuery selectByNameAndCertifIDGh(String name, String certifID,int page,int pageSize) {
    int start = 0;
    if (page > 1) {
        start = (page - 1) * pageSize;
    }
    List<ServedPersonBasic> list = this.servedPersonBasicMapper.selectByNameAndCertifIDGh(name, certifID,start,pageSize);
    int count = this.servedPersonBasicMapper.selectByNameAndCertifIDGhTotal(name,certifID);
    Page p = PageUtil.createPage(pageSize, count, page - 1);
    ServedPersonBasicQuery vo = new ServedPersonBasicQuery();
    vo.setVos(list);
    vo.setPage(p);
    return vo;
  }

/*     */   public boolean checkCertifID(String certifID)
/*     */   {
/* 692 */     List list = this.servedPersonBasicMapper.getServedPersonBasicDetail(certifID);
/* 693 */     if (list.size() > 0)
/* 694 */       return true;
/* 695 */     return false;
/*     */   }

			@Override
			public Object updateBasic(ServedPersonBasic basic) {
				servedPersonBasicMapper.updateBasic(basic);
			return new ResultObject();
			}
			
			@Override
			public Object updateExtendRecord(ServedPersonExtendResident extend) {
				servedPersonExtendResidentMapper.updateExtendRecord(extend);
			return new ResultObject();
			}
			
			public boolean deleteBasic(Long ServedPersonID){
					return servedPersonBasicMapper.deleteBasic(ServedPersonID) != 0;
			}
/*     */ }
