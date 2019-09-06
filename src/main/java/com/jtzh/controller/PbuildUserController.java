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

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PworkUser;
import com.jtzh.pojo.UserPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.PbuildUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "党建人员管理")
@RestController
@RequestMapping("pbuser")
public class PbuildUserController {
	@Resource
	private PbuildUserService pbuserService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取党建人员列表后台api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取党建人员")
	@RequestMapping(value = "/getPbuserList", method = RequestMethod.POST)
	public Object getPbuserList(@RequestBody UserPagination param) {
		return pbuserService.getPbuserList(param);
	}

	/**
	 * 获取所选党建人员具体信息后台api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id获取党建人员详情")
	@RequestMapping(value = "/getPbuser/{id}", method = RequestMethod.GET)
	public Object getPbuser(@PathVariable("id") String id) {
		return pbuserService.getPbuser(id);
	}

	/**
	 * 删除所选党建人员后台api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除党建人员")
	@RequestMapping(value = "/removePbuser/{id}", method = RequestMethod.GET)
	public Object removePbuser(@PathVariable("id") String id) {
		return pbuserService.removePbuser(id);
	}

	/**
	 * 新建党建人员后台api
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value="新建党建人员")
	@RequestMapping(value = "/addPbuser", method = RequestMethod.POST)
	public Object insertUser(@RequestBody PworkUser user, HttpServletRequest request) {
		LoginUserTest loginUser = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return pbuserService.insertUser(user, loginUser);
	}

	/**
	 * 修改党建人员后台api
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value="修改党建人员")
	@RequestMapping(value = "/updatePbuser", method = RequestMethod.POST)
	public Object updatePbuser(@RequestBody PworkUser user) {
		return pbuserService.updatePbuser(user);
	}

	/**
	 * 导出党建员工excel后台api
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value="导出党建人员")
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		pbuserService.exportExcel(response);
		return null;
	}

	/**
	 * 导入党建员工excel后台api
	 * 
	 * @param file
	 * @return
	 */
	@ApiOperation(value="导入党建人员")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public boolean addUser(@RequestParam("file") MultipartFile file) {

		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = pbuserService.batchImport(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
