package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.jtzh.entity.RoleUser;
import com.jtzh.mapper.RoleUserMapper;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CharacterUserinfo;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CharacterUserinfoMapper;
import com.jtzh.mapper.MenuRoleMapper;
import com.jtzh.mapper.MenuconfigurationMapper;
import com.jtzh.pojo.CharacterUserTree;
import com.jtzh.pojo.CharacterUserinfoPagination;
import com.jtzh.pojo.MenuTree;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.CharacterUserinfoService;

@Service("characterUserinfoServiceImpl")
public class CharacterUserinfoServiceImpl implements CharacterUserinfoService {
	@Resource
	private CharacterUserinfoMapper characterUserinfoMapper;
	@Resource
	private MenuRoleMapper menuRoleMapper;
	@Resource
	private MenuconfigurationMapper menuconfigurationMapper;

	@Resource
	private RoleUserMapper roleUserMapper;
	@Resource
	private CharacterUserinfoService CharacterUserinfoService;

    /**
     * 根据用户id获取权限树
     * @param id
     * @return
     */
	@Override
	public Object getMenuTreeByUserId(String id) {
		RoleUser role = roleUserMapper.selectByUserId(id);
		if(role != null){
			return CharacterUserinfoService.getMenuTree(role.getPcrole());
		}
		return false;
	}

	/**
	 * 获得角色信息 id：角色的主键
	 */
	@Override
	public Object getCharacterUserinfo(Integer id) {
		CharacterUserinfo detail = characterUserinfoMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	/**
	 * 删除角色
	 */
	@Override
	public Object removeCharacterUserinfo(Integer id) {
		characterUserinfoMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	/**
	 * 添加角色 user：登陆用户
	 */
	@Override
	public Object addCharacterUserinfo(CharacterUserinfo detail,LoginUserTest user) {
		detail.setCreateon(new Date());
		detail.setCreateby(user.getUserName());
		characterUserinfoMapper.insertSelective(detail);
		return new ResultObject();
	}

	/**
	 * 修改角色信息
	 */
	@Override
	public Object modifyCharacterUserinfo(CharacterUserinfo detail,LoginUserTest user) {
		detail.setUpdateon(new Date());
		detail.setUpdateby(user.getUserName());
		characterUserinfoMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}

	/**
	 * 获得分页的角色信息
	 */
	@Override
	public Object getCharacterUserinfoList(CharacterUserinfoPagination param) {
		// 查询总数
		int total = characterUserinfoMapper.selectCharacterUserinfofigTotal(param);
		List<CharacterUserinfo> list = new ArrayList<CharacterUserinfo>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {

			list = characterUserinfoMapper.selectCharacterUserinfo(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public String getCharacterUserinfoName(Integer id) {
		return characterUserinfoMapper.SelectNameById(id);
	}

	@Override
	public Object getCharacersList(CharacterUserinfoPagination param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getIdByName(String CRoleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCharacterUserTree() {
		List<CharacterUserTree> t111 = characterUserinfoMapper.selectBySId(Constants.PARENT_ID);
		List<CharacterUserTree> treef = new ArrayList<CharacterUserTree>();
		for (CharacterUserTree t0 : t111) {
			List<CharacterUserTree> t2 = characterUserinfoMapper.selectBySId(t0.getId());
			List<CharacterUserTree> tree2 = new ArrayList<CharacterUserTree>();
			for (CharacterUserTree t : t2) {
				List<CharacterUserTree> t3 = characterUserinfoMapper.selectBySId(t.getId());
				List<CharacterUserTree> tree3 = new ArrayList<CharacterUserTree>();
				for (CharacterUserTree tt : t3) {
					List<CharacterUserTree> t4 = characterUserinfoMapper.selectBySId(tt.getId());
					tt.setChildren(t4);
					tree3.add(tt);
				}
				t.setChildren(tree3);
				tree2.add(t);
			}
			t0.setChildren(tree2);
			treef.add(t0);
		}
		return treef;
	}

	@Override
	public Object getMenuTree(Integer id) {
        CharacterUserinfo detail = characterUserinfoMapper.selectByPrimaryKey(id);
        return detail;
//		List<String> a = menuRoleMapper.selectMenusByRoleId(id);
//		menuconfigurationMapper.selectBySId(id);
//		List<MenuTree> t111 = menuconfigurationMapper.selectBySId(Constants.MENU_P_ID);
//		List<MenuTree> treef = new ArrayList<MenuTree>();
//		//String menuHasPermission;
//		for (MenuTree t0 : t111) {
//			//menuHasPermission = (a.contains(t0.getId().toString()))? Constants.MENU_HAS_PERMISSION_YES:Constants.MENU_HAS_PERMISSION_NO;
//			//t0.setHasPermission(menuHasPermission);
//			t0.setHasPermission(this.getMenuHasPermission(t0, a));
//			List<MenuTree> t2 = menuconfigurationMapper.selectBySId(t0.getId());
//			List<MenuTree> tree2 = new ArrayList<MenuTree>();
//			for (MenuTree t : t2) {
//				t.setHasPermission(this.getMenuHasPermission(t, a));
//				List<MenuTree> t3 = menuconfigurationMapper.selectBySId(t.getId());
//				List<MenuTree> tree3 = new ArrayList<MenuTree>();
//				for (MenuTree tt : t3) {
//					tt.setHasPermission(this.getMenuHasPermission(tt, a));
//					List<MenuTree> t4 = menuconfigurationMapper.selectBySId(tt.getId());
//					tt.setChildren(t4);
//					tree3.add(tt);
//				}
//				t.setChildren(tree3);
//				tree2.add(t);
//			}
//			t0.setChildren(tree2);
//			treef.add(t0);
//		}
//		return treef;
	}
	
	public String getMenuHasPermission(MenuTree t,List<String> a){
		return (a.contains(t.getId().toString()))? Constants.MENU_HAS_PERMISSION_YES:Constants.MENU_HAS_PERMISSION_NO;
	}

	@Override
	public Object getAllRole() {
		List<CharacterUserinfo> roles = characterUserinfoMapper.getAllRole();
		ResultObject res = new ResultObject();
		res.setObj(roles);
		return res;
	}

}
