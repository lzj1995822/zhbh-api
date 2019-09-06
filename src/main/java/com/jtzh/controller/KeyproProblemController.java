package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.detail.pojo.KeyProblemChuliDetail;
import com.jtzh.detail.pojo.KeyproProblemAppointmans;
import com.jtzh.detail.pojo.KeyproProblemDetail;
import com.jtzh.entity.KeyproProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.KeyproProblemReq;
import com.jtzh.pojo.ProblemPagination;
import com.jtzh.service.KeyproProblemService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "重点工程问题管理")
@RestController
@RequestMapping("keyproProblem")
public class KeyproProblemController {
	@Resource
	private KeyproProblemService keyproProblemService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取重点工程问题列表后台api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取问题web")
	@RequestMapping(value = "/getProblemListWeb", method = RequestMethod.POST)
	public Object getProblemListWeb(@RequestBody ProblemPagination param) {
		return keyproProblemService.getProblemListWeb(param);
	}

	/**
	 * 获取重点工程问题列表后台api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取重点工程问题")
	@RequestMapping(value = "/getProblemList", method = RequestMethod.POST)
	public Object getProblemList(@RequestBody ProblemPagination param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return keyproProblemService.getProblemList(param, user);
	}
	
	@ApiOperation(value="分页获取重点工程问题包含项目名称")
	@RequestMapping(value = "/selectProblemAndProName", method = RequestMethod.POST)
	public Object selectProblemAndProName(@RequestBody ProblemPagination param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return keyproProblemService.selectProblemAndProName(param, user);
	}

	/**
	 * 获取重点工程问题列表后台app api
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取重点工程问题")
	@RequestMapping(value = "/getProblemListApp", method = RequestMethod.POST)
	public Object getProblemListApp(@RequestBody ProblemPagination param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return keyproProblemService.getProblemListApp(param, user);
	}

	/**
	 * 获取不是“审核通过” 上报人是当前登录人 api
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取问题,获取不是“审核通过” 上报人是当前登录人")
	@RequestMapping(value = "/getProblemList1", method = RequestMethod.POST)
	public Object getProblemList1(@RequestBody ProblemPagination param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return keyproProblemService.getProblemList1(param, user);
	}

	/**
	 * 根据id查询重点工程问题信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询重点工程问题")
	@RequestMapping(value = "/getProblem/{id}", method = RequestMethod.GET)
	public Object getProblem(@PathVariable("id") String id) {
		return keyproProblemService.getProblem(id);
	}

	/**
	 * 根据id查询重点工程问题处理信息+图片
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询处理信息+图片")
	@RequestMapping(value = "/getProblemChuli/{id}", method = RequestMethod.GET)
	public Object getProblemChuli(@PathVariable("id") String id) {
		return keyproProblemService.getProblemChuli(id);
	}

	/**
	 * 删除重点工程问题后台api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除重点工程问题")
	@RequestMapping(value = "/removeProblem/{id}", method = RequestMethod.GET)
	public Object removeProblem(@PathVariable("id") String id) {
		return keyproProblemService.removeProblem(id);
	}

	/**
	 * 新建重点工程问题后台api ---> 问题登记00
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="登记重点工程问题")
	@RequestMapping(value = "/addProblem", method = RequestMethod.POST)
	public Object addProblem(@RequestBody KeyproProblemDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return keyproProblemService.addProblem(detail, user);
	}

	/**
	 * 修改重点工程问题后台api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="修改重点工程问题")
	@RequestMapping(value = "/modifyProblem", method = RequestMethod.POST)
	public Object modifyProblem(@RequestBody KeyproProblemDetail detail) {
		return keyproProblemService.modifyProblem(detail);
	}

	/**
	 * 问题废弃api 状态码“0”
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id废弃重点工程问题")
	@RequestMapping(value = "/keyDesert/{id}", method = RequestMethod.GET)
	public int desert(@PathVariable("id") String id) {
		return keyproProblemService.desert(id);
	}

	/**
	 * 问题派发 api 状态码“2”
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="指派重点工程问题")
	@RequestMapping(value = "/keyAppoint", method = RequestMethod.POST)
	public Object appoint(@RequestBody KeyproProblemAppointmans param) {
		return keyproProblemService.paifa(param);
	}

	/**
	 * 问题处理 api 状态码“3”
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="处理重点工程问题")
	@RequestMapping(value = "/keySolve", method = RequestMethod.POST) // 审核
	public Object keySolve(@RequestBody KeyProblemChuliDetail param) {
		return keyproProblemService.solve(param);
	}

	/**
	 * ---问题审核通过 api 状态码“3”--->4
	 * 更改为：问题审核通过 api 状态码“3”--->4  不通过 3---->2
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="审核重点工程问题")
	@RequestMapping(value = "/keyVerify", method = RequestMethod.POST) // 审核
	public Object keyVerify(@RequestBody KeyproProblemReq param) {
		return keyproProblemService.shenghe(param);
	}

	/**
	 * 问题审核不通过 api 状态码“3”--->2
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="审核不通过，已废弃")
	@RequestMapping(value = "/keyBack", method = RequestMethod.POST)
	public int finish(@RequestBody KeyproProblemReq param) {
		return keyproProblemService.finish(param);
	}

	/**
	 * 拉取所有问题处理信息根据上报id api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据上报id拉取所有处理")
	@RequestMapping(value = "/keyGetAllSolve/{shangbaoid}", method = RequestMethod.GET)
	public Object keyGetAllSolve(@PathVariable("shangbaoid") String shangbaoid) {
		return keyproProblemService.keyGetAllSolve(shangbaoid);
	}

	/**
	 * 问题恢复 api 状态码0 --->1
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id恢复重点工程问题")
	@RequestMapping(value = "/keyRecovery/{id}", method = RequestMethod.GET)
	public int recovery(@PathVariable("id") String id) {
		return keyproProblemService.recovery(id);
	}

	/**
	 * 问题已立案 api 状态码“02”
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/keyyilian", method = RequestMethod.POST)
	public int yilian(@RequestBody KeyproProblem param) {
		return keyproProblemService.yilian(param);
	}


	/**
	 * 问题已处理api 状态码“04”
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/keychuli/{id}", method = RequestMethod.GET)
	public int chuli(@PathVariable("id") String id) {
		return keyproProblemService.chuli(id);
	}

	/**
	 * 问题回退 api 状态码“03”
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/keyhuitui/{id}", method = RequestMethod.GET)
	public int huitui(@PathVariable("id") String id) {
		return keyproProblemService.huitui(id);
	}

	/**
	 * 问题已审核 api 状态码“05”
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/keyyishenghe/{id}", method = RequestMethod.GET) // 已审核05
	public int yishenghe(@PathVariable("id") String id) {
		return keyproProblemService.yishenghe(id);
	}

	/**
	 * 问题已逾期 api 状态码“06”
	 * 
	 * @return
	 */
	@RequestMapping(value = "/keyyuqi", method = RequestMethod.POST) // 逾期06
	public int yuqi() {
		return keyproProblemService.yuqi();
	}

	/**
	 * 统计数据 api
	 * 
	 * @return
	 */
	@ApiOperation(value="统计重点工程问题")
	@RequestMapping(value = "/countProblemState", method = RequestMethod.POST)
	public Object countProblemState() {
		return keyproProblemService.countProblemState();
	}

	/**
	 * 根据状态严格搜索 api
	 * 
	 * @param state
	 * @return
	 */
	@ApiOperation(value="根据状态严格搜索重点工程问题")
	@RequestMapping(value = "/findByStateStrict/{state}", method = RequestMethod.GET)
	public Object findByStateStrict(@PathVariable("state") String state) {
		return keyproProblemService.findAllByState(state);
	}

	/**
	 * 根据状态宽松查询 api
	 * 
	 * @param state
	 * @return
	 */
	@ApiOperation(value="根据状态宽松查询重点工程问题")
	@RequestMapping(value = "/findByIdRelax/{id}", method = RequestMethod.GET)
	public Object findByStateRelax(@PathVariable("id") String id) {
		return keyproProblemService.findByStateRelax(id);
	}

	/**
	 * 获取重点工程问题坐标api
	 * 
	 * @return
	 */
	@ApiOperation(value="获取重点工程问题坐标(无参)")
	@RequestMapping(value = "/getKeyCoordinate", method = RequestMethod.POST)
	public Object getKeyCoordinate() {
		return keyproProblemService.getKeyCoordinate();
	}
	
	@ApiOperation(value="根据问题对应的工程id获取问题五方人员")
	@RequestMapping(value = "/getFivePeople/{proId}", method = RequestMethod.GET)
	public Object getFivePeople(@PathVariable("proId") String proId) {
		return keyproProblemService.getFivePeople(proId);
	}
	
	@ApiOperation(value="按村统计工程问题数量(无参)")
	@RequestMapping(value = "/countProblemAllCountryside", method = RequestMethod.POST)
	public Object countProblemAllCountryside() {
		return keyproProblemService.countProblemAllCountryside();
	}
	
	@ApiOperation(value="根据状态(包含所有)统计工程问题数量(无参)")
	@RequestMapping(value = "/countProblemStateAll", method = RequestMethod.POST)
	public Object countProblemStateAll() {
		return keyproProblemService.countProblemStateAll();
	}
	
	@ApiOperation(value="根据年份按照季度统计问题")
	@RequestMapping(value = "/countProblemByYear/{year}", method = RequestMethod.GET)
	public Object countProblemByYear(@PathVariable("year") String year) {
		return keyproProblemService.countProblemByYear(year);
	}

	/**
	 * 按类型统计数据 api
	 *
	 * @return
	 */
	@ApiOperation(value="按类型统计数据")
	@RequestMapping(value = "/countProblemType", method = RequestMethod.GET)
	public Object countProblemType() {
		return keyproProblemService.countProblemType();
	}


}
