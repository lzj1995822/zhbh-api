package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jtzh.detail.pojo.KeyproBuildDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.KbuildPagination;
import com.jtzh.service.KeyproBuildService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "重点工程项目管理")
@RestController
@RequestMapping("keyproBuild")
public class KeyproBuildController {
	@Resource
	private KeyproBuildService buildService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取重点工程项目列表 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取重点工程项目")
	@RequestMapping(value = "/getKeyproBuildList", method = RequestMethod.POST)
	public Object getKeyproBuildList(@RequestBody KbuildPagination param) {
		return buildService.getKeyproBuildList(param);
	}

	/**
	 * 根据id获取详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询重点工程项目详情")
	@RequestMapping(value = "/getKeyproBuildInfo/{id}", method = RequestMethod.GET)
	public Object getKeyproBuildInfo(@PathVariable("id") String id) {
		return buildService.getKeyproBuildInfo(id);
	}

	/**
	 * 根据id删除项目 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除重点工程项目")
	@RequestMapping(value = "/removePro/{id}", method = RequestMethod.GET)
	public Object removePro(@PathVariable("id") String id) {
		return buildService.removePro(id);
	}

	/**
	 * 新建重点工程项目 api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="新建重点工程项目")
	@RequestMapping(value = "/addPro", method = RequestMethod.POST)
	public Object addPro(@RequestBody KeyproBuildDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return buildService.addPro(detail, user);
	}

	/**
	 * 修改项目 api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="修改重点工程项目")
	@RequestMapping(value = "/modifyPro", method = RequestMethod.POST)
	public Object modifyPro(@RequestBody KeyproBuildDetail detail) {
		return buildService.modifyPro(detail);
	}

	/**
	 * 导出excel api
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value="导出重点工程项目")
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		buildService.exportExcel(response);
		return null;
	}

	/**
	 * 根据上传的excel导入数据 api
	 * 
	 * @param file
	 * @return
	 */
	@ApiOperation(value="导入重点工程项目")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public boolean addPro(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = buildService.batchImport(fileName, file, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * 获取重点工程项目坐标api
	 * 
	 * @return
	 */
	@ApiOperation(value="获取重点工程项目坐标")
	@RequestMapping(value = "/getKeyProjectCoordinate", method = RequestMethod.POST)
	public Object getKeyProjectCoordinate() {
		return buildService.getKeyProjectCoordinate();
	}
	
	@ApiOperation(value="获取项目名称和id(无参)")
	@RequestMapping(value = "/getProNameAndId", method = RequestMethod.POST)
	public Object getProNameAndId() {
		return buildService.getProNameAndId();
	}
	
	@ApiOperation(value="按村统计重点工程项目数量")
	@RequestMapping(value = "/countProAllCountryside", method = RequestMethod.POST)
	public Object countProAllCountryside() {
		return buildService.countProAllCountryside();
	}
}
