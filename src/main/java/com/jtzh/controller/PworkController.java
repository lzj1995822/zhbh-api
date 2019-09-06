package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PworkBuild;
import com.jtzh.pojo.PworkPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.PworkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.*;

@Api(tags = "党建工作管理")
@RestController
@RequestMapping("pwork")
public class PworkController {
	@Resource
	private PworkService pworkService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取党建工作列表api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取党建工作")
	@RequestMapping(value = "/getPworkList", method = RequestMethod.POST)
	public Object getPworkList(@RequestBody PworkPagination param) {
		return pworkService.getPworkList(param);
	}

	/**
	 * 获取选中的党建工作信息后台api
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id、type获取党建工作详情")
	@RequestMapping(value = "/getPwork/{type}/{id}", method = RequestMethod.GET)
	public Object getPwork(@PathVariable("type") String type, @PathVariable("id") String id) {
		return pworkService.getPwork(type, id);
	}

	/**
	 * 删除所选党建工作后台api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除党建工作")
	@RequestMapping(value = "/removePwork/{id}", method = RequestMethod.GET)
	public Object removePwork(@PathVariable("id") String id) {
		return pworkService.removePwork(id);
	}

	/**
	 * 新建党建工作后台api
	 * 
	 * @param work
	 * @return
	 */
	@ApiOperation(value="新建党建工作")
	@RequestMapping(value = "/addPwork", method = RequestMethod.POST)
	public Object addPwork(@RequestBody PworkBuild work, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return pworkService.addPwork(work, user);
	}

	/**
	 * 修改党建工作后台api
	 * 
	 * @param work
	 * @return
	 */
	@ApiOperation(value="修改党建工作")
	@RequestMapping(value = "/modifyPwork", method = RequestMethod.POST)
	public Object modifyPwork(@RequestBody PworkBuild work) {
		return pworkService.modifyPwork(work);
	}
	
	@RequestMapping(value = "/downloadPwork", method = RequestMethod.GET)
	public void downloadPwork(HttpServletResponse response, @RequestParam("fileName") String fileName) {
		//要上传的文件名字
		//通过文件的保存文件夹路径加上文件的名字来获得文件
		File file=new File("D:/ynw/",fileName);
		//当文件存在
		if(file.exists()){
			//首先设置响应的内容格式是force-download，那么你一旦点击下载按钮就会自动下载文件了
			response.setContentType("application/force-download");
			//通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
			response.addHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", file.getName()));
			//进行读写操作
			byte[]buffer=new byte[1024];
			FileInputStream fis=null;
			BufferedInputStream bis=null;
			try{
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				OutputStream os=response.getOutputStream();
				//从源文件中读
				int i=bis.read(buffer);
				while(i!=-1){
					//写到response的输出流中
					os.write(buffer,0,i);
					i=bis.read(buffer);
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally {
				//善后工作，关闭各种流
				try {
					if(bis!=null){
						bis.close();
					}
					if(fis!=null){
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
