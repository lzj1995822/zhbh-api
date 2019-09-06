package com.jtzh.controller;

import com.jtzh.entity.Hwchuli;
import com.jtzh.entity.Hwshangbao;
import com.jtzh.service.HwchuliService;
import com.jtzh.service.HwshangbaoService;

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

@Api(tags = "环卫问题处理")
@RestController
public class HwchuliController {
    @Resource
    public HwchuliService hwchuliService;
    @Resource
    public HwshangbaoService hwshangbaoService;

    public HwshangbaoService getHwshangbaoService() {
        return hwshangbaoService;
    }

    public void setHwshangbaoService(HwshangbaoService hwshangbaoService) {
        this.hwshangbaoService = hwshangbaoService;
    }

    public HwchuliService getHwchuliService() {
        return hwchuliService;
    }

    public void hw(HwchuliService hwchuliService) {
        this.hwchuliService = hwchuliService;
    }
    @RequestMapping("/hwyichuli")//已处理
    public int yichuli(@RequestBody Hwchuli hwchuli, Hwshangbao param){
    	hwshangbaoService.chuli(param);
        return hwchuliService.yichuli(hwchuli);
    }
    @RequestMapping("/hwshenghe")//审核
    public int shenghe(@RequestBody Hwchuli hwchuli){
        return hwchuliService.shenghe(hwchuli);
    }
    @RequestMapping("/hwupdatephoto")
    public String addphoto(MultipartFile file, ModelMap map)  throws IOException {


        String filePath = "D:/work/";//保存图片的路径
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
    /*@RequestMapping("/hwfindbyshangbaoid")
    public List<Hwchuli> findbyshangbaoid(int id){
        return hwchuliService.findbyshangbaoid(id);
    }*/
    
    /**
	 * 根据id查询所有信息api
	 * 
	 * @param id
	 * @return
	 */
    @RequestMapping("/hwchulifindbyId/{shangbaoid}")
    public Object hwchulifindbyId(@PathVariable("shangbaoid") String shangbaoid){
		return hwchuliService.hwchulifindbyId(shangbaoid);
    }
   

}
