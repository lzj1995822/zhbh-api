package com.jtzh.controller;

import com.jtzh.entity.Cgchuli;
import com.jtzh.entity.Cgshangbao;
import com.jtzh.service.CgchuliService;
import com.jtzh.service.CgshangbaoService;

import io.swagger.annotations.Api;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Api(tags = "城管问题处理")
@RestController
public class CgchuliController {
    @Resource
    public CgchuliService cgchuliService;
    @Resource
    public CgshangbaoService cgshangbaoService;

    public CgshangbaoService getCgshangbaoService() {
        return cgshangbaoService;
    }

    public void setCgshangbaoService(CgshangbaoService cgshangbaoService) {
        this.cgshangbaoService = cgshangbaoService;
    }

    public CgchuliService getCgchuliService() {
        return cgchuliService;
    }

    public void setCgchuliService(CgchuliService cgchuliService) {
        this.cgchuliService = cgchuliService;
    }
    @RequestMapping("/yichuli")//已处理
    public  int yichuli(@RequestBody Cgchuli cgchuli, Cgshangbao param){
        cgshangbaoService.chuli(param);
        return cgchuliService.yichuli(cgchuli);
    }
    @RequestMapping("/shenghe")//审核
    public int shenghe(@RequestBody Cgchuli cgchuli){
        return cgchuliService.shenghe(cgchuli);
    }
    @RequestMapping("/updatephoto")
    public String addphoto(MultipartFile file, ModelMap map)  throws IOException {


        String filePath = "D:/ynw/";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        String newFileName = UUID.randomUUID()+originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        return newFileName;


    }
    /*@RequestMapping("/findbyshangbaoi")
    public List<Cgchuli> findbyshangbaoid(int id){
        return cgchuliService.findbyshangbaoid(id);
    }*/
    
    /**
	 * 根据id查询所有信息api
	 * 
	 * @param id
	 * @return
	 */
    @RequestMapping("/cgchulifindbyId/{shangbaoid}")
    public Object cgchulifindbyId(@PathVariable("shangbaoid") String shangbaoid){
		return cgchuliService.cgchulifindbyId(shangbaoid);
    }

}
