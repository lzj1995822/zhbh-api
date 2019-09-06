package com.jtzh.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jtzh.common.PublicMsg;
import com.jtzh.common.Ueditor;


@Controller
public class UeditorController {
	@RequestMapping(value="/ueditor")
    @ResponseBody
    public String ueditor(HttpServletRequest request) {

        return PublicMsg.UEDITOR_CONFIG;
        
    }
	
    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(MultipartFile upfile) {
    	Instant.now(); 
    	Ueditor ueditor = new Ueditor();
    	String suffix = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf(".") + 1);
    	String name  = upfile.getOriginalFilename();
    	String fileName = String.valueOf(name.substring(0,name.lastIndexOf("."))+new Date().getTime())+name.substring(name.lastIndexOf("."));
        String path = "D:/ynw" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
        	upfile.transferTo(dest); //保存文件
            ueditor.setState("SUCCESS");
            ueditor.setTitle(fileName);
            ueditor.setUrl("http://47.98.236.132:8887/file/"+fileName);
            return ueditor;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            ueditor.setState("ERROR");
        	return ueditor;
        } catch (IOException e) {
            e.printStackTrace();
            ueditor.setState("ERROR");
        	return ueditor;
        }
       
    }

}
