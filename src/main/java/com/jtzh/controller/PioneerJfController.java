package com.jtzh.controller;

import javax.annotation.Resource;

import com.jtzh.mapper.PioneerOrgMapper;
import com.jtzh.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import com.jtzh.entity.PioneerDues;
import com.jtzh.entity.PioneerJf;
import com.jtzh.entity.PioneerLddy;
import com.jtzh.entity.PioneerServiceResult;
import com.jtzh.entity.PioneerSjxm;
import com.jtzh.entity.PioneerSjxmHb;
import com.jtzh.entity.PioneerVolunteer;
import com.jtzh.entity.PioneerVolunteerServiceE;
import com.jtzh.pojo.KeyParam;
import com.jtzh.service.PioneerJfService;
import com.jtzh.service.PioneerVolunteerService;

import io.swagger.annotations.Api;

@Api(tags = "宝华先锋党员积分管理")
@RestController
@RequestMapping("dyjf")
public class PioneerJfController {
	@Resource
	private PioneerJfService pioneerJfService;

	@Resource
	private PioneerVolunteerService pioneerVolunteerService;
    @Resource
    private PioneerOrgMapper orgMapper;
	/**
	 * 根据党员id and (季度 or 年度)获取党员积分
	 * 
	 * @return
	 */
	@RequestMapping(value = "getDyjf", method = RequestMethod.POST)
	public Object getDyjf(@RequestBody PioneerJf jf) {
		return pioneerJfService.getDyjf(jf);
	}

	/**
	 * 新增党员积分(按季度)
	 * 
	 * @param jf
	 * @return
	 */
	@RequestMapping(value = "addDyjf", method = RequestMethod.POST)
	public Object addDyjf(@RequestBody PioneerJf jf) {

		return pioneerJfService.addDyjf(jf);

	}

	/**
	 * 流动党员双扫 新增
	 * 
	 * @param lddy
	 * @return
	 */
	@RequestMapping(value = "addLddy", method = RequestMethod.POST)
	public Object addLddy(@RequestBody PioneerLddy lddy) {
		return pioneerJfService.addLddy(lddy);
	}
	/**
	 * 流动党员双扫 修改
	 *
	 * @param lddy
	 * @return
	 */
	@RequestMapping(value = "updateLddy", method = RequestMethod.POST)
	public Object updateLddy(@RequestBody PioneerLddy lddy) {
		return pioneerJfService.updateLddy(lddy);
	}
	/**
	 * 流动党员双扫列表
	 * @return
	 */
	@RequestMapping(value = "getLddy", method = RequestMethod.POST)
	public Object getLddy(@RequestBody KeyParam param) {
		return pioneerJfService.getLddy(param);
	}
	
	/**
	 * 删除流动党员
	 * @param id
	 * @return
	 */
	@RequestMapping(value="removeLddy/{id}",method=RequestMethod.GET)
	public Object removeLddy(@PathVariable("id")String id) {
		return pioneerJfService.removeLddy(id);
	}
	
	/**
	 * 流动党员双扫列表-全部
	 * @return
	 */
	@RequestMapping(value = "getLddys")
	public Object getLddys() {
		return pioneerJfService.getLddys();
	}
	/**
	 * 书记项目 申报
	 * 
	 * @param sjxm
	 * @return
	 */
	@RequestMapping(value = "addSjxm", method = RequestMethod.POST)
	public Object addSjxm(@RequestBody PioneerSjxm sjxm) {
		return pioneerJfService.addSjxm(sjxm);
	}
	
	/**
	 * 书记项目 申报
	 * 
	 * @param sjxm
	 * @return
	 */
	@RequestMapping(value = "updateSjxm", method = RequestMethod.POST)
	public Object updateSjxm(@RequestBody PioneerSjxm sjxm) {
		return pioneerJfService.modifySjxm(sjxm);
	}

	/**
	 * 书记项目列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "getSjxm", method = RequestMethod.POST)
	public Object getSjxm(@RequestBody KeyParam param) {
		return pioneerJfService.getSjxm(param);
	}

    /**
     * 书记项目all
     *
     * @return
     */
    @RequestMapping(value = "getAllSjxm", method = RequestMethod.POST)
    public Object getAllSjxm(@RequestBody KeyParam param) {
        return pioneerJfService.getAllSjxm(param);
    }
	/**
	 * 书记项目删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "removeSjxm/{id}", method = RequestMethod.GET)
	public Object removeSjxm(@PathVariable("id")String id) {
		return pioneerJfService.removeSjxm(id);
	}
	

	/**
	 * 书记项目审核
	 */
	@RequestMapping(value = "sjjxmsh/{id}/{shzt}", method = RequestMethod.GET)
	public Object updateSh(@PathVariable("id")String id,@PathVariable("shzt")String zt) {
		return pioneerJfService.updateSjxmZt(id, zt);
	}
	/**
	 * 书记项目进度督察
	 */
	@RequestMapping(value = "addJddc", method = RequestMethod.POST)
	public Object addJddc(@RequestBody PioneerSjxmHb hb) {
		return pioneerJfService.addJdhb(hb);
	}
	
	/**
	 * 查询书记项目进度督查
	 */
	@RequestMapping(value = "getJddc/{id}", method = RequestMethod.GET)
	public Object addJddc(@PathVariable("id")String id) {
		return pioneerJfService.getJdhb(id);
	}
	/**
	 * 新增志愿者
	 * 
	 * @return
	 */
	@RequestMapping(value = "addZyz", method = RequestMethod.POST)
	public Object addZyz(@RequestBody PioneerVolunteer pioneerVolunteer) {
		return pioneerVolunteerService.addZyz(pioneerVolunteer);
	}

	/**
	 * 志愿者列表
	 * 
	 * @param keyParam
	 * @return
	 */
	@RequestMapping(value = "getZyz", method = RequestMethod.POST)
	public Object getZyz(@RequestBody KeyParam keyParam) {
		return pioneerVolunteerService.getZyz(keyParam);
	}
    /**
     * 志愿者报名数量-年月日
     *
     * @param keyParam
     * @return
     */
    @RequestMapping(value = "getZyzBmInfo", method = RequestMethod.GET)
    public Object getZyzBmInfo() {
        return pioneerVolunteerService.getZyzBmInfo();
    }
	/**
	 * 志愿者详情
	 * 
	 * @param keyParam
	 * @return
	 */
	@RequestMapping(value = "getZyzInfo/{id}", method = RequestMethod.GET)
	public Object getZyzInfo(@PathVariable("id") String id) {
		return pioneerVolunteerService.getZyzInfo(id);
	}

	/**
	 * 志愿者审核
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "updateZyzZt/{id}/{zt}", method = RequestMethod.GET)
	public Object updateZyzZt(@PathVariable("id") String id, @PathVariable("zt") String zt) {
		return pioneerVolunteerService.updateZyzZt(id, zt);
	}

	/**
	 * 修改志愿者信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateZyz", method = RequestMethod.POST)
	public Object updateZyz(@RequestBody PioneerVolunteer pioneerVolunteer) {
		return pioneerVolunteerService.updateZyz(pioneerVolunteer);
	}

	/**
	 * 新建志愿者活动
	 */
	@RequestMapping(value = "addZyzHd", method = RequestMethod.POST)
	public Object addZyzHd(@RequestBody PioneerVolunteerServiceE p) {
		return pioneerVolunteerService.addZyzhd(p);
	}

	/**
	 * 查询志愿者活动 app端
	 * 
	 * @param keyParam
	 * @return
	 */
	@RequestMapping(value = "getZyzHdApp", method = RequestMethod.POST)
	public Object getZyzHdApp(@RequestBody KeyParam keyParam) {
		return pioneerVolunteerService.getZyzhdApp(keyParam);
	}

	/**
	 * 查询志愿者活动 app端 已结束
	 * 
	 * @param keyParam
	 * @return
	 */
	@RequestMapping(value = "getZyzHdAppYjs", method = RequestMethod.POST)
	public Object getZyzHdAppYjs(@RequestBody KeyParam keyParam) {
		return pioneerVolunteerService.getZyzhdAppYjs(keyParam);
	}

	/**
	 * 新增志愿活动成果
	 * 
	 * @param pioneerServiceResult
	 * @return
	 */
	@RequestMapping(value = "addZyzHdCg", method = RequestMethod.POST)
	public Object addZyzHdJg(@RequestBody PioneerServiceResult pioneerServiceResult) {
		return pioneerVolunteerService.addHdJg(pioneerServiceResult);
	}
	
	/**
	 * 修改志愿活动
	 * 
	 * @param pioneerServiceResult
	 * @return
	 */
	@RequestMapping(value = "updateZyzHd", method = RequestMethod.POST)
	public Object updateZyzHd(@RequestBody PioneerVolunteerServiceE pioneerServiceResult) {
		return pioneerVolunteerService.updateZyzHd(pioneerServiceResult);
	}

    /**
     * 删除活动
     * @param id
     * @return
     */
	@RequestMapping(value = "removeZyzHd/{id}", method = RequestMethod.GET)
	public Object removeZyzHdJg(@PathVariable("id")String id) {
		return pioneerVolunteerService.removeZyzHd(id);
	}

    /**
     * 查看志愿活动成果
     * @param id
     * @return
     */
	@RequestMapping(value = "getZyzHdCg/{id}", method = RequestMethod.GET)
	public Object getZyzHdJg(@PathVariable("id")String id) {
		return pioneerVolunteerService.getHdJg(id);
	}

	/**
	 * 查询志愿者活动 web端
	 * 
	 * @param keyParam
	 * @return
	 */
	@RequestMapping(value = "getZyzHd", method = RequestMethod.POST)
	public Object getZyzHd(@RequestBody KeyParam keyParam) {
		return pioneerVolunteerService.getZyzhd(keyParam);
	}

    /**
     * 查询志愿者活动数量 年月日
     *
     * @param keyParam
     * @return
     */
    @RequestMapping(value = "getZyzHdByTime", method = RequestMethod.GET)
    public Object getZyzHdByTime() {
        return pioneerVolunteerService.getZyzHdByTime();
    }


    /**
	 * 志愿者报名情况
	 * 
	 * @param hdid
	 * @param zyzzh
	 * @return
	 */
	@RequestMapping(value = "getZyzhdBm/{hdid}/{zyzzh}", method = RequestMethod.GET)
	public Object getZyzhdBm(@PathVariable("hdid") String hdid, @PathVariable("zyzzh") String zyzzh) {
		return pioneerVolunteerService.getZyzhdBm(hdid, zyzzh);
	}


	/**
	 * 志愿活动报名情况
	 * @return
	 */
	@RequestMapping(value = "getZyzhdBmInfo", method = RequestMethod.POST)
	public Object getZyzhdBmInfo(@RequestBody KeyParam keyParam) {
		return pioneerVolunteerService.getZyzhdBmInfo(keyParam);
	}

	/**
	 * 志愿者报名
	 * 
	 * @param hdid
	 * @param zyzzh
	 * @return
	 */
	@RequestMapping(value = "addBmInfo/{hdid}/{zyzzh}", method = RequestMethod.GET)
	public Object addBmInfo(@PathVariable("hdid") String hdid, @PathVariable("zyzzh") String zyzzh) {
		return pioneerVolunteerService.addBmInfo(hdid, zyzzh);
	}


	/**
	 * 新增党费
	 * 
	 * @return
	 */
	@RequestMapping(value = "addDf", method = RequestMethod.POST)
	public Object addDf(@RequestBody PioneerDues dues) {
		return pioneerJfService.addDf(dues);
	}

	/**
	 * 获取党费列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "getDfs", method = RequestMethod.POST)
	public Object getDfs(@RequestBody KeyParam keyParam) {
		return pioneerJfService.getDfs(keyParam);
	}

    /**
     *  更新党费信息
     * @param dues
     * @return
     */
    @RequestMapping(value = "updateDf",method = RequestMethod.POST)
	public Object updateDf(@RequestBody PioneerDues dues){
        return pioneerJfService.updateDf(dues);
	}
	/**
	 * 删除党费
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "removeDf/{id}",method = RequestMethod.GET)
	public Object removeDf(@PathVariable("id") String id){
        return pioneerJfService.removeDf(id);
	}

	/**
	 * 获取所有组织信息
	 * @return
	 */
	@RequestMapping(value = "getAllOrgs",method = RequestMethod.GET)
	public Object getAllOrgs(){
		return orgMapper.selectAllOrg();
	}

	@RequestMapping(value = "getOrgCount",method = RequestMethod.GET)
	public Object getOrgCount(){
		return orgMapper.getOrgCount();
	}

	@GetMapping(value = "countByMonthAndType")
	public Object countByMonthAndType() {
		return pioneerVolunteerService.countByMonthAndType();
	}
}
