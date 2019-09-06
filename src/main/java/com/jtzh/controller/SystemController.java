package com.jtzh.controller;

import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.DefaultResponse;
import com.jtzh.service.SystemService;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SystemController extends BaseCController {

    @Resource
    public SystemService systemService;


    /**
     * 登陆接口
     *
     * @param request
     * @param response
     * @param userinfo 用户信息
     * @<code>
     * {
     * 	"uiloginname":"admin",
     * 	"uicode":"admin1"
     * }
     * </code>
     * @param authUser 当前登录状态
     * @return 登录结果
     */
    @RequestMapping("/login")
    public DefaultResponse login(HttpServletRequest request, HttpServletResponse response, @RequestBody Userinformation userinfo, @CookieValue("auth_user") String authUser) {
        try {
            String key = decrypt(authUser);
            if(key!=null){
                Userinformation user = systemService.selectByPrimaryKey(Integer.parseInt(key));
                if(user!=null) return success("登录成功");
            }
            if (systemService.login(userinfo)) {
                response.addCookie(new Cookie("auth_user", encrypt(userinfo.getId().toString())));
                return success("登录成功");
            }
            return error("登录尝试失败，请稍后再试");
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}
