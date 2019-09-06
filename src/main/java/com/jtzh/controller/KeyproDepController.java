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

import com.jtzh.entity.KeyproDep;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.DepPagination;
import com.jtzh.service.KeyproDepService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "重点工程部门管理")
@RestController
@RequestMapping("keyproDep")
public class KeyproDepController {
	@Resource
	private KeyproDepService depService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取重点工程单位部门列表 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取重点工程部门")
	@RequestMapping(value = "/getDepList", method = RequestMethod.POST)
	public Object getDepList(@RequestBody DepPagination param) {
		return depService.getDepList(param);
	}

	/**
	 * 根据id查询单位部门详细信息 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询重点工程部门详情")
	@RequestMapping(value = "/getDep/{id}", method = RequestMethod.GET)
	public Object getDep(@PathVariable("id") String id) {
		return depService.getDep(id);
	}

	/**
	 * 根据id删除部门 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除重点工程部门")
	@RequestMapping(value = "/removeDep/{id}", method = RequestMethod.GET)
	public Object removeDep(@PathVariable("id") String id) {
		return depService.removeDep(id);
	}

	/**
	 * 新建部门 api
	 * 
	 * @param dep
	 * @return
	 */
	@ApiOperation(value="新建重点工程部门")
	@RequestMapping(value = "/addDep", method = RequestMethod.POST)
	public Object insertDep(@RequestBody KeyproDep dep, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return depService.insertDep(dep, user);
	}

	/**
	 * 修改部门 api
	 * 
	 * @param dep
	 * @return
	 */
	@ApiOperation(value="修改重点工程部门")
	@RequestMapping(value = "/updateDep", method = RequestMethod.POST)
	public Object updateDep(@RequestBody KeyproDep dep) {
		return depService.updateDep(dep);
	}

	/**
	 * 导出excel接口 api
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value="导出重点工程部门")
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		depService.exportExcel(response);
		return null;
	}

	/**
	 * 根据上传的excel导入数据 api
	 * 
	 * @param file
	 * @return
	 */
	@ApiOperation(value="导入重点工程部门")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public boolean addDep(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		boolean a = false;
		String fileName = file.getOriginalFilename();
		try {
			a = depService.batchImport(fileName, file, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
