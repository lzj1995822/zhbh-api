/*     */ package com.jtzh.service.Impl;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.jtzh.util.CommonUtils;
import com.jtzh.entity.NetGridMember;
import com.jtzh.entity.NetGridMemberPhoto;
import com.jtzh.mapper.NetGridMemberMapper;
import com.jtzh.mapper.NetGridMemberPhotoMapper;
import com.jtzh.service.NetGridMemberService;

/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.*;
/*     */
/*     */ import com.jtzh.vo.netGrid.NetGridMemberVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Service
/*     */ public class NetGridMemberServiceImpl
/*     */   implements NetGridMemberService
/*     */ {
/*     */   @Autowired
/*     */   private NetGridMemberPhotoMapper netGridMemberPhotoMapper;
/*     */   @Autowired
/*     */   private NetGridMemberMapper netGridMemberMapper;
/*  27 */   private static String MEMBERPHOTO_PATH = "/NetGrid/NetGridMemberPhotos/";
/*     */   
/*     */   @Transactional
/*     */   public boolean addNetGridMember(MultipartFile file, String netGridMember)
/*     */   {
/*  32 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  33 */     boolean flag = false;
/*  34 */     NetGridMember member = (NetGridMember)JSON.parseObject(netGridMember, NetGridMember.class);
/*  35 */     flag = this.netGridMemberMapper.insert(member) != 0;
/*  36 */     if (flag) {
/*  37 */       Long ID = member.getNetGridMemberID();
/*  38 */       if ((file != null) && (!file.isEmpty())) {
/*  39 */         String filename = String.valueOf(System.currentTimeMillis());
/*     */         
/*  41 */         String originFileName = file.getOriginalFilename();
/*  42 */         String extension = originFileName.substring(originFileName.lastIndexOf("."));
/*     */         
/*     */ 
/*  45 */         File outPath = new File(root_path + MEMBERPHOTO_PATH);
/*  46 */         if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  47 */           outPath.mkdirs();
/*     */         }
/*     */         
/*     */ 
/*  51 */         File outFile = new File(root_path + MEMBERPHOTO_PATH + filename + extension);
/*     */         try
/*     */         {
/*  54 */           file.transferTo(outFile);
/*     */           
/*  56 */           NetGridMemberPhoto photo = new NetGridMemberPhoto();
/*  57 */           photo.setMemberID(ID);
/*  58 */           photo.setPhotoFileName(filename);
/*  59 */           photo.setPhotoFilePath(MEMBERPHOTO_PATH);
/*  60 */           photo.setPhotoFileSuffix(extension);
/*  61 */           flag = this.netGridMemberPhotoMapper.insert(photo) != 0;
/*     */         } catch (IOException e) {
/*  63 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*  67 */     return flag;
/*     */   }
/*     */   
/*     */   public boolean updateNetGridMember(MultipartFile file, String netGridMember)
/*     */   {
/*  72 */     boolean flag = false;
/*  73 */     NetGridMember member = (NetGridMember)JSON.parseObject(netGridMember, NetGridMember.class);
/*  74 */     Long id = member.getNetGridMemberID();
/*  75 */     String root_path = CommonUtils.getRootPath("msmis.file");
/*  76 */     if ((file != null) && (!file.isEmpty())) {
/*  77 */       NetGridMemberPhoto photo = this.netGridMemberPhotoMapper.selectByMemberID(id);
/*  78 */       String filename = photo.getPhotoFileName();
/*     */       
/*  80 */       String extension = photo.getPhotoFileSuffix();
/*     */       
/*  82 */       File outPath = new File(root_path + MEMBERPHOTO_PATH);
/*  83 */       if ((!outPath.exists()) || (!outPath.isDirectory())) {
/*  84 */         outPath.mkdirs();
/*     */       }
/*     */       
/*  87 */       File outFile = new File(root_path + MEMBERPHOTO_PATH + filename + extension);
/*     */       try
/*     */       {
/*  90 */         file.transferTo(outFile);
/*     */         
/*  92 */         flag = true;
/*     */       } catch (IOException e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */     } else { flag = true; }
/*  97 */     if (flag) {
/*  98 */       flag = this.netGridMemberMapper.updateByPrimaryKey(member) != 0;
/*     */     }
/* 100 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   @Transactional
/*     */   public boolean deleteNetGridMember(Long id)
/*     */   {
/* 107 */     boolean flag = this.netGridMemberPhotoMapper.deleteByMemberID(id) != 0;
/* 108 */     if (flag)
/* 109 */       flag = this.netGridMemberMapper.deleteByPrimaryKey(id) != 0;
/* 110 */     return flag;
/*     */   }
/*     */   
/*     */   public List<Map<String, String>> getNetGridMemberForOrg(Long id)
/*     */   {
/* 115 */     List<Map<String, String>> maps = this.netGridMemberMapper.getNetGridMemberForOrg(id);
/* 117 */     for (Map<String, String> map : maps) {
                if(StringUtils.isNotBlank(map.get("PhotoFileSuffix"))){
                    String path = (String)map.get("PhotoFilePath") + (String)map.get("PhotoFileName") + (String)map.get("PhotoFileSuffix");
                    map.put("photoPath", path);
                    map.remove("PhotoFilePath");
                    map.remove("PhotoFileName");
                    map.remove("PhotoFileSuffix");
                }
/*     */     }
/* 124 */     return maps;
/*     */   }
    public Map getNetGridMemberByNetGridID(Long id)
    {
        NetGridMemberVO vo = this.netGridMemberMapper.getNetGridMemberByNetGridID(id);
        NetGridMemberPhoto photo = this.netGridMemberPhotoMapper.selectByMemberID(vo.getNetGridMemberID());
        String photoPath = photo.getPhotoFilePath() + photo.getPhotoFileName() + photo.getPhotoFileSuffix();
        Map map = new HashMap();
        map.put("photoPath", photoPath);
        map.put("memberDetail", vo);
        return map;
    }

    @Override
    public List<NetGridMemberVO> Achievements() {
        return netGridMemberMapper.Achievements();
    }
    /*     */ }
