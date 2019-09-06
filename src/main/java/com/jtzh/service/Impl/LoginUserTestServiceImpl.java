package com.jtzh.service.Impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jtzh.entity.Userinformation;
import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.LoginUserTestMapper;
import com.jtzh.service.LoginUserTestService;

@Service("loginUserTestService")
public class LoginUserTestServiceImpl implements LoginUserTestService {
	@Resource
	private LoginUserTestMapper loginUseruserMapper;
	@Override
	public Object getTestUser(HttpServletRequest request, LoginUserTest user) {
		// 登录user村session
		LoginUserTest loginUser = loginUseruserMapper.getTestUser(user.getLoginId());
		ResultObject object = new ResultObject();
		object.setResult(false);
		if (loginUser != null) {
			request.getSession().setAttribute("user", loginUser);
			request.getSession().setMaxInactiveInterval(-1);
			// logger.info(loginUser.getLoginId() + "登陆成功");
			object.setResult(true);
			loginUser.setPassword("");
			loginUser.setSessionId(request.getSession().getId());
			object.setObj(loginUser);
			object.setResult(true);
		}
		return object;
	}

	public Object getTestUserInfo(HttpServletRequest request){
		String sid = request.getHeader("token");
		//HttpSession sess = session.getSessionContext().getSession(sid);
		LoginUserTest user = new LoginUserTest();
		Userinformation userInfo = (Userinformation)request.getSession().getAttribute("user");
		user.setLoginId("17712659161");
		user.setUserName("admin");
		user.setPassword("123456");
		if ( userInfo != null) {
			user.setLoginId(userInfo.getUiloginname());
			user.setUserName(userInfo.getUinickname());
		}
		return user;
	}

}
