/*    */ package com.jtzh.service.Impl;
import com.jtzh.entity.Role;
import com.jtzh.mapper.RoleMapper;
import com.jtzh.service.RoleService;

/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class RoleServiceImpl
/*    */   implements RoleService
/*    */ {
/*    */   @Autowired
/*    */   private RoleMapper roleMapper;
/*    */   
/*    */   public boolean addRoleMenu(Role role)
/*    */   {
/* 19 */     return this.roleMapper.insert(role) != 0;
/*    */   }
/*    */   
/*    */   public boolean updateRoleMenu(Role role)
/*    */   {
/* 24 */     return this.roleMapper.updateByPrimaryKey(role) != 0;
/*    */   }
/*    */   
/*    */   public boolean deleteRoleMenu(Long id)
/*    */   {
/* 29 */     return this.roleMapper.deleteByPrimaryKey(id) != 0;
/*    */   }
/*    */   
/*    */   public List<Role> getAllRoleMenu()
/*    */   {
/* 34 */     return this.roleMapper.selectAll();
/*    */   }
/*    */   
/*    */   public Role getRoleInfoByID(Long id)
/*    */   {
/* 39 */     return this.roleMapper.selectByPrimaryKey(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\RoleServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */