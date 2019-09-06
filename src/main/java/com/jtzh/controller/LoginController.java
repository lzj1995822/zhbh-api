package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jtzh.entity.UserLoginLog;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.UserLoginLogPagination;
import com.jtzh.pojo.UserPassword;
import com.jtzh.service.APPService;
import com.jtzh.service.UserLoginLogService;
import com.jtzh.service.UserinfomationService;
import com.jtzh.vo.app.UserVO;

import io.swagger.annotations.Api;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.CommonUtil;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "运维登录管理")
@RestController
@RequestMapping("user")
public class LoginController {

	@Resource
	private UserinfomationService userinfomationService;
	@Resource
	private UserLoginLogService userLoginLogService;
	@Autowired
	private HttpSession session;
    @Autowired
    private APPService appService;
	/**
	 * 登陆
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(HttpServletResponse response, HttpServletRequest request, @RequestBody Userinformation user)
			throws IOException {
		Userinformation u = (Userinformation) userinfomationService.getLoginInfo(user);

		ResultObject res = new ResultObject();
		UserLoginLog userLoginLog = new UserLoginLog();
		try {
			userLoginLog.setIp(CommonUtil.getIpAddr(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		userLoginLog.setCreateTime(new Date());
		userLoginLog.setUserName(user.getUiloginname());
        u.setUicode("");
		if (u != null) {
			Map map = new HashMap();
			if(u.getUisubordinatedepartment().equals("综治部门")){
                UserVO userVo = this.appService.APPLogin(u.getUiloginname(), u.getUicode());
                u.setUicode(String.valueOf(u.getId()));
                u.setId(Integer.valueOf(String.valueOf(userVo.getUserID())));
                u.setUirealname(userVo.getRealName());
                u.setUiloginname(userVo.getUserName());
                u.setUicustomertype(userVo.getDept());
                if(StringUtils.isNotBlank(userVo.getNetGridID())){
                    u.setUisubordinatevillage(userVo.getNetGridID());
                }else{
                    u.setUisubordinatevillage(userVo.getDept());
                }
			}
			map.put("user", u);
			res.setResult(true);
			res.setMessage("登录成功！");
			res.setObj(map);
			this.session.setAttribute("user", u);
			String token = this.session.getId();
			map.put("token", token);
			userLoginLog.setResult(Constants.LOGIN_TURE);
		} else {
			res.setResult(false);
			res.setMessage("用户名或密码不正确！");
			userLoginLog.setResult(Constants.LOGIN_FALSE);
		}
		userLoginLogService.addUserLoginLog(userLoginLog);
		return res;
	}

	/**
	 * 分页获取登录日志api
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getUserLoginLogList", method = RequestMethod.POST)
	public Object getUserLoginLogList(@RequestBody UserLoginLogPagination param) {
		return userLoginLogService.getUserLoginLogList(param);
	}

	/**
	 * 修改密码及重置密码 api
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/modifyUserPwd", method = RequestMethod.POST)
	public Object modifyUserPwd(@RequestBody UserPassword param) {
		return userinfomationService.modifyUserPwd(param);
	}

}
