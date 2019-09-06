package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.Userinformation;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.UseService;
/**
 * 通过用户获取对应的权限
 * @author JTZH
 *
 */
@RestController
@RequestMapping("use")
public class UseController extends BaseCController{
	@Resource
	private UseService useService;	
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 获取用户权限
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public Object getlist(HttpServletRequest request, HttpServletResponse response) {
		Userinformation user=new Userinformation(); 
		Cookie cs=null;
		String	authUser=null;
		//获取登陆用户
		Cookie[] coos=request.getCookies();
		if(coos!=null) {
			for (Cookie c : coos) {
				if(c.getName().equals("auth_user")) {
					cs=c;
				}
			}
		}
		if(cs!=null) 	authUser=cs.getValue();
		//对登陆用户解密
		String keys = decrypt(authUser);
		if(keys!=null){
			//对登陆用户加密
			user.setId(Integer.parseInt(keys));
		}

		return useService.getlist(user);
	}
}
