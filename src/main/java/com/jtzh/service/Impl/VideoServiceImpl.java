/*    */ package com.jtzh.service.Impl;
/*    */ import com.jtzh.util.Page;
/*    */ import com.jtzh.util.PageUtil;
/*    */ import com.jtzh.vo.video.CheckVideoVO;
/*    */ import com.jtzh.vo.video.VideoInfoVO;
/*    */ import com.jtzh.vo.video.VideoQueryVO;
import com.jtzh.entity.CODEVideoType;
import com.jtzh.entity.NetGrid;
import com.jtzh.entity.Video;
import com.jtzh.mapper.CODEVideoTypeMapper;
import com.jtzh.mapper.NetGridMapper;
import com.jtzh.mapper.VideoMapper;
import com.jtzh.service.VideoService;

/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class VideoServiceImpl
/*    */   implements VideoService
/*    */ {
/*    */   @Autowired
/*    */   private CODEVideoTypeMapper codeVideoTypeMapper;
/*    */   @Autowired
/*    */   private VideoMapper videoMapper;
/*    */   @Autowired
/*    */   private NetGridMapper netGridMapper;
/*    */   
/*    */   public List<CODEVideoType> getVideoCode()
/*    */   {
/* 34 */     return this.codeVideoTypeMapper.selectAll();
/*    */   }
/*    */   
/*    */ 
/*    */   public List<NetGrid> getAllNetGrid()
/*    */   {
/* 40 */     return this.netGridMapper.selectAll();
/*    */   }
/*    */   
/*    */ 
/*    */   public VideoQueryVO getVideoInfo(String name, Integer netGridID, int page, int pageSize)
/*    */   {
/* 46 */     int start = 0;
/* 47 */     if (page > 1)
/* 48 */       start = (page - 1) * pageSize;
/* 49 */     List<VideoInfoVO> vos = this.videoMapper.getVideoInfo(name, netGridID, start, pageSize);
/* 50 */     int count = this.videoMapper.getVideoInfoCount(name, netGridID);
/* 51 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 52 */     VideoQueryVO vo = new VideoQueryVO();
/* 53 */     vo.setVos(vos);
/* 54 */     vo.setPage(p);
/* 55 */     return vo;
/*    */   }
/*    */   
/*    */ 
/*    */   public VideoInfoVO getDetailByID(Long id)
/*    */   {
/* 61 */     return this.videoMapper.getByPrimaryKey(id);
/*    */   }
/*    */   
/*    */ 
/*    */   public Video getToUpdateVideoInfo(Long id)
/*    */   {
/* 67 */     return this.videoMapper.selectByPrimaryKey(id);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean addVideo(Video v)
/*    */   {
/* 73 */     return this.videoMapper.insert(v) != 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean updateVideo(Video v)
/*    */   {
/* 79 */     return this.videoMapper.updateByPrimaryKey(v) != 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean deleteVideo(Long id)
/*    */   {
/* 85 */     return this.videoMapper.deleteByPrimaryKey(id) != 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<CheckVideoVO> getNetGridForTree()
/*    */   {
/* 91 */     return this.netGridMapper.getNetGridForTree();
/*    */   }
/*    */   
/*    */ 
/*    */   public List<CheckVideoVO> getVideoForTree(Long id)
/*    */   {
/* 97 */     return this.videoMapper.getVideoForTree(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\VideoServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */