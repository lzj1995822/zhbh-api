package com.jtzh.controller;

import com.jtzh.pojo.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
public class CustomisedAuthenticationController extends BaseCController {

    @Autowired
    private HttpServletRequest request;


    /**
     * getAuth 接口
     *
     * @return 标准返回结果
     */
    @RequestMapping("/getAuth")//已处理
    public DefaultResponse getAuth(HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(new Cookie("auth_user", "普通用户"));
        try {
            return list(500, Arrays.asList(request.getCookies()));
        } catch (Exception ex) {
            return error(ex.getMessage());
        }
    }
}
