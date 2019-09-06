/*     */ package com.jtzh.service.Impl;
/*     */ import com.jtzh.util.Page;
/*     */ import com.jtzh.util.PageUtil;
/*     */ import com.jtzh.vo.orgMember.OrgBasicInfQueryVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberQueryRequestVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberQueryResponseVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberQueryVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberServedPersonRecoedQueryResponseVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberServedPersonRecordQueryVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberTypesVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberVO;
/*     */ import com.jtzh.vo.orgMember.ServedRecordCountVO;
import com.jtzh.entity.OrgBasicInf;
import com.jtzh.entity.OrgMember;
import com.jtzh.entity.Picture;
import com.jtzh.entity.TEFile;
import com.jtzh.mapper.CODELevelTypeMapper;
import com.jtzh.mapper.CODEPersonPositionTypeMapper;
import com.jtzh.mapper.OrgBasicInfMapper;
import com.jtzh.mapper.OrgMemberMapper;
import com.jtzh.mapper.OrgMemberServedPersonRecordMapper;
import com.jtzh.mapper.PictureMapper;

/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ @org.springframework.stereotype.Service
/*     */ public class OrgMemberServiceImpl implements com.jtzh.service.OrgMemberService
/*     */ {
/*     */   @Autowired
/*     */   private OrgMemberMapper orgMemberDao;
/*     */   @Autowired
/*     */   private CODELevelTypeMapper levelTypeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODEOrganizationTypeMapper organizationTypeMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.CODEPersonLevelTypeMapper personLevelTypeMapper;
/*     */   @Autowired
/*     */   private OrgBasicInfMapper orgBasicInfMapper;
/*     */   @Autowired
/*     */   private CODEPersonPositionTypeMapper personPositionTypeMapper;
/*     */   @Autowired
/*     */   private OrgMemberServedPersonRecordMapper orgMemberServedPersonRecordMapper;
/*     */   @Autowired
/*     */   private PictureMapper pictureMapper;
/*     */   @Autowired
/*     */   private com.jtzh.mapper.TEFileMapper fileMapper;
/*     */   
/*     */   public OrgMemberVO getByOrgMemberId(long id)
/*     */   {
/*  54 */     org.springframework.util.Assert.notNull(Long.valueOf(id));
/*  55 */     OrgMember member = this.orgMemberDao.selectByPrimaryKey(Long.valueOf(id));
/*  56 */     if (member == null)
/*  57 */       return null;
/*  58 */     OrgMemberVO vo = new OrgMemberVO(member);
/*  59 */     return vo;
/*     */   }
/*     */   
/*     */   public OrgMemberQueryResponseVO query(OrgMemberQueryRequestVO query)
/*     */   {
/*  64 */     String name = query.getName();
/*  65 */     String positionTypeValue = query.getPositionTypeValue();
/*  66 */     Integer status = query.getStatus();
/*  67 */     int page = query.getPage();
/*  68 */     int pageSize = query.getPageSize();
/*  69 */     int count = this.orgMemberDao.getQueryCount(name, positionTypeValue, status);
/*  70 */     Page p = PageUtil.createPage(pageSize, count, page);
/*  71 */     List<OrgMemberQueryVO> vo = this.orgMemberDao.select(name, positionTypeValue, status, (page - 1) * pageSize, pageSize);
/*     */     
/*  73 */     OrgMemberQueryResponseVO resp = new OrgMemberQueryResponseVO();
/*  74 */     resp.setQueryVO(vo);
/*  75 */     resp.setPage(p);
/*  76 */     return resp;
/*     */   }
/*     */   
/*     */   public boolean updateStatus(long id, int status)
/*     */   {
/*  81 */     OrgMember member = this.orgMemberDao.selectByPrimaryKey(Long.valueOf(id));
/*  82 */     if (member == null) {
/*  83 */       return false;
/*     */     }
/*  85 */     member.setStatus(Integer.valueOf(status));
/*  86 */     int i = this.orgMemberDao.updateByPrimaryKey(member);
/*  87 */     return i != 0;
/*     */   }
/*     */   
/*     */   public boolean update(OrgMember member)
/*     */   {
/*  92 */     int i = this.orgMemberDao.updateByPrimaryKey(member);
/*  93 */     return i != 0;
/*     */   }
/*     */   
/*     */   public OrgMemberTypesVO getSpecs()
/*     */   {
/*  98 */     OrgMemberTypesVO types = new OrgMemberTypesVO();
/*  99 */     types.setLevelTypes(this.levelTypeMapper.selectAll());
/* 100 */     types.setPersonLevelTypes(this.personLevelTypeMapper.selectAll());
/* 101 */     types.setOrgBasicInfs(this.orgBasicInfMapper.selectAll());
/* 102 */     types.setPersonPositionTypes(this.personPositionTypeMapper.selectAll());
/* 103 */     types.setOrganizationTypes(this.organizationTypeMapper.selectAll());
/* 104 */     return types;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean add(OrgMemberVO member)
/*     */   {
/* 110 */     if (member == null) {
/* 111 */       return false;
/*     */     }
/* 113 */     java.util.Date date = null;
/*     */     try {
/* 115 */       date = com.jtzh.util.DateUtil.strToDate(member.getBirthDate());
/*     */     } catch (ParseException e) {
/* 117 */       e.printStackTrace();
/* 118 */       return false;
/*     */     }
/* 120 */     OrgMember newMember = new OrgMember();
/*     */     
/* 122 */     newMember.setBirthDate(date);
/* 123 */     newMember.setCertID(member.getCertID());
/* 124 */     newMember.setEducation(member.getEducation());
/* 125 */     newMember.setEthnicity(member.getEthnicity());
/* 126 */     newMember.setFixedTel(member.getFixedTel());
/* 127 */     newMember.setMobileTel(member.getMobileTel());
/* 128 */     newMember.setName(member.getName());
/* 129 */     newMember.setOrgID(member.getOrgID());
/* 130 */     newMember.setOrgMemberID(member.getOrgMemberID());
/* 131 */     newMember.setPositionTypeValue(member.getPositionTypeName());
/* 132 */     newMember.setPolitics(member.getPolitics());
/* 133 */     newMember.setLevelTypeValue(member.getLevelTypeName());
/* 134 */     newMember.setSex(member.getSex());
/* 135 */     newMember.setStatus(member.getStatus());
/*     */     
/* 137 */     int i = this.orgMemberDao.insert(newMember);
/*     */     
/* 139 */     return i != 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public OrgMemberServedPersonRecoedQueryResponseVO getServiceRecord(OrgMemberServedPersonRecordQueryVO query)
/*     */   {
/* 145 */     int start = 0;
/* 146 */     int pageSize = 10;
/* 147 */     int page = query.getPage() - 1;
/* 148 */     if (query.getPageSize() > 0)
/* 149 */       pageSize = query.getPageSize();
/* 150 */     if (query.getPage() > 1)
/* 151 */       start = page * pageSize;
/* 152 */     String orgMemberName = query.getOrgMemberName();
/* 153 */     String servedPersonName = query.getServedPersonName();
/* 154 */     Integer netGridID = query.getNetGridID();
/* 155 */     List<OrgMemberServedPersonRecordQueryVO> list = this.orgMemberServedPersonRecordMapper.select(orgMemberName, servedPersonName, netGridID, start, pageSize);
/*     */     
/* 157 */     int count = this.orgMemberServedPersonRecordMapper.getQueryCount(orgMemberName, servedPersonName, netGridID);
/* 158 */     Page p = PageUtil.createPage(pageSize, count, page);
/* 159 */     OrgMemberServedPersonRecoedQueryResponseVO resp = new OrgMemberServedPersonRecoedQueryResponseVO();
/* 160 */     resp.setPage(p);
/* 161 */     resp.setQueryVO(list);
/* 162 */     return resp;
/*     */   }
/*     */   
/*     */   public java.util.Map getServedRecordDetail(Long orgMServedPID)
/*     */   {
/* 167 */     String rootPath = com.jtzh.util.CommonUtils.getRootPath("server.root");
/* 168 */     com.jtzh.vo.orgMember.ServedRecordDetailVO detailVO = this.orgMemberServedPersonRecordMapper.getDetailByID(orgMServedPID);
/* 169 */     List<Picture> pictures = this.pictureMapper.selectByServedRecordID(orgMServedPID);
/* 170 */     List<String> picturePaths = new ArrayList();
/* 171 */     if (pictures.size() > 0) {
/* 172 */       for (Picture p : pictures) {
/* 173 */         String path = p.getPicturePath() + p.getPictureName() + p.getPictureSuffix();
/* 174 */         picturePaths.add(path);
/*     */       }
/*     */     }
/* 177 */     TEFile file = this.fileMapper.selectByServedRecordID(orgMServedPID);
/* 178 */     List<String> videoPaths = new ArrayList();
/* 179 */     if (file != null) {
/* 180 */       String videoPath = file.getFilePath() + file.getFileName() + file.getFileSuffix();
/* 181 */       videoPaths.add(videoPath);
/*     */     }
/* 183 */     HashMap map = new HashMap();
/* 184 */     map.put("servedRecord", detailVO);
/* 185 */     map.put("pictures", picturePaths);
/* 186 */     map.put("video", videoPaths);
/* 187 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<OrgMemberQueryVO> getOrgMemberByNameAndCertID(String name, String id)
/*     */   {
/* 193 */     return this.orgMemberDao.getOrgMemberByNameAndCertID(name, id);
/*     */   }
/*     */   
/*     */ 
/*     */   public Long getPrimaryKeyByName(String name, String certID)
/*     */   {
/* 199 */     return this.orgMemberDao.getPrimaryKeyByName(name, certID);
/*     */   }
/*     */   
/*     */ 
/*     */   public List getServedRecordCount()
/*     */   {
/* 205 */     List<ServedRecordCountVO> list = this.orgMemberServedPersonRecordMapper.getServedRecordCount();
/* 206 */     List lists = new ArrayList();
/* 207 */     int len = list.size();
/* 208 */     String[] date = new String[len];
/* 209 */     int[] count = new int[len];
/* 210 */     for (int i = 0; i < list.size(); i++) {
/* 211 */       ServedRecordCountVO s = (ServedRecordCountVO)list.get(i);
/* 212 */       date[i] = s.getDate();
/* 213 */       count[i] = s.getCount();
/*     */     }
/* 215 */     lists.add(date);
/* 216 */     lists.add(count);
/* 217 */     return lists;
/*     */   }
/*     */   
/*     */   public OrgBasicInfQueryVO getOrgBasicInf(String orgName, String orgType, Integer netGridID, String levelType, int page, int pageSize)
/*     */   {
/* 222 */     int start = 0;
/* 223 */     if (page > 1)
/* 224 */       start = (page - 1) * pageSize;
/* 225 */     List<com.jtzh.vo.orgMember.OrgBasicInfExVO> vos = this.orgBasicInfMapper.getOrgInfQuery(orgName, orgType, netGridID, levelType, start, pageSize);
/* 226 */     int count = this.orgBasicInfMapper.getOrgInfQueryCount(orgName, orgType, netGridID, levelType);
/* 227 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 228 */     OrgBasicInfQueryVO vo = new OrgBasicInfQueryVO();
/* 229 */     vo.setVos(vos);
/* 230 */     vo.setPage(p);
/* 231 */     return vo;
/*     */   }
/*     */   
/*     */   public com.jtzh.vo.orgMember.OrgBasicInfVO getOrgBasicInfDetail(Long id)
/*     */   {
/* 236 */     return this.orgBasicInfMapper.getOrgInfDetailByOrgID(id);
/*     */   }
/*     */   
/*     */   public OrgBasicInf getOrgBasicInfDetailToUpdate(Long id)
/*     */   {
/* 241 */     return this.orgBasicInfMapper.selectByPrimaryKey(id);
/*     */   }
/*     */   
/*     */   public boolean addOrgBasicInfo(OrgBasicInf inf)
/*     */   {
/* 246 */     return this.orgBasicInfMapper.insert(inf) != 0;
/*     */   }
/*     */   
/*     */   public boolean updateOrgBasicInfo(OrgBasicInf inf)
/*     */   {
/* 251 */     return this.orgBasicInfMapper.updateByPrimaryKey(inf) != 0;
/*     */   }
/*     */   
/*     */   public boolean deleteOrgBasicInfo(Long id)
/*     */   {
/* 256 */     return this.orgBasicInfMapper.deleteByPrimaryKey(id) != 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\OrgMemberServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */