/*    */ package com.jtzh.service.Impl;
/*    */

import com.jtzh.entity.User;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.UserMapper;
import com.jtzh.mapper.UserinformationMapper;
import com.jtzh.service.UserService;
import com.jtzh.util.MD5Utils;
import com.jtzh.util.Page;
import com.jtzh.util.PageUtil;
import com.jtzh.vo.app.UserVO;
import com.jtzh.vo.user.UserQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ @Service
/*    */ public class UserServiceImpl
/*    */   implements UserService
/*    */ {
/*    */   @Resource
/*    */   private UserMapper userMapper;


            @Resource
            private UserinformationMapper userinformationMapper;
/*    */
/*    */   public boolean addUser(User user)
/*    */   {
/* 24 */    String password = user.getPassword();
            Userinformation detail = new Userinformation();
            detail.setUicode(password);
            detail.setUiloginname(user.getUserName());
            detail.setCreateon(new Date());
            detail.setUirealname(user.getRealName());
            detail.setUisubordinatedepartment("综治部门");
            userinformationMapper.insert(detail);
/* 25 */    user.setPassword(MD5Utils.getPwd(password));

/* 26 */     return this.userMapper.insert(user) != 0;
/*    */   }
/*    */   
/*    */   public UserQueryVO getUserQuery(String key, int page, int pageSize)
/*    */   {
/* 31 */     int start = 0;
/* 32 */     if (page > 1)
/* 33 */       start = (page - 1) * pageSize;
/* 34 */     List<UserVO> vos = this.userMapper.getUserQuery(key, start, pageSize);
/* 35 */     int count = this.userMapper.getUserQueryCount(key);
/* 36 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 37 */     UserQueryVO vo = new UserQueryVO();
/* 38 */     vo.setList(vos);
/* 39 */     vo.setPage(p);
/* 40 */     return vo;
/*    */   }
/*    */   
/*    */   public boolean updateUser(User user)
/*    */   {
/* 45 */     String password = user.getPassword();
/* 46 */     user.setPassword(MD5Utils.getPwd(password));
/* 47 */     return this.userMapper.updateByPrimaryKey(user) != 0;
/*    */   }
/*    */   
/*    */   public boolean deleteUser(Long id)
/*    */   {
/* 52 */     return this.userMapper.deleteByPrimaryKey(id) != 0;
/*    */   }
/*    */   
/*    */   public User getUserDetail(Long id)
/*    */   {
/* 57 */     return this.userMapper.selectByPrimaryKey(id);
/*    */   }
/*    */   
/*    */   public String getRoleNameByUserID(Long id)
/*    */   {
/* 62 */     return this.userMapper.getRoleNameByUserID(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\UserServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */