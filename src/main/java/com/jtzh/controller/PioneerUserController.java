package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jtzh.entity.MapParm;
import com.jtzh.mapper.PioneerUserMapper;
import org.springframework.web.bind.annotation.*;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerUser;
import com.jtzh.pojo.PioneerUserPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.PioneerUserService;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Api(tags = "宝华先锋党员管理")
@RestController
@RequestMapping("pioneerUser")
public class PioneerUserController {
	@Resource
	private PioneerUserService pioneerUserService;
	@Resource
	private LoginUserTestService loginUserTestService;
	@Resource
	private PioneerUserMapper pioneerUserMapper;

	/**
	 * 获取人员年龄信息
	 * @author zdw
	 *
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "getPioneerUserAgeList", method = RequestMethod.GET)
	public Object getPioneerUserAgeList() {

		TreeMap<String,Integer> map =new TreeMap<>();
		map.put("18-30岁", 0);
		map.put("30-40岁", 0);
		map.put("40-50岁", 0);
		map.put("50-60岁", 0);
		map.put("60岁以上" , 0);
		List<String> list = pioneerUserService.getPioneerUserAgeList();
		for(String item: list) {
			if (item == null) {
				continue;
			}
			Integer year = Integer.valueOf(item);
			if (year >= 18 && year <= 30) {
				Integer integer = map.get("18-30岁");
				integer ++;
				map.put("18-30岁", integer);
			} else if (year > 30 && year <= 40) {
				Integer integer = map.get("30-40岁");
				integer ++;
				map.put("30-40岁", integer);
			} else if (year >40 && year <= 50) {
				Integer integer = map.get("40-50岁");
				integer ++;
				map.put("40-50岁", integer);
			} else if (year >50 && year <= 60) {
				Integer integer = map.get("50-60岁");
				integer ++;
				map.put("50-60岁", integer);
			}else if (year >60) {
				Integer integer = map.get("60岁以上");
				integer ++;
				map.put("60岁以上", integer);
			}
		}



		for (Map.Entry<String,Integer> entry:map.entrySet()){
			System.out.println("key:"+entry.getKey()+','+entry.getValue());
		}
		return map;
	}




	/**
	 * 宝华先锋党员分页 api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "getPioneerUserList", method = RequestMethod.POST)
	public Object getPioneerUserList(@RequestBody PioneerUserPagination param) {
		return pioneerUserService.getPioneerUserList(param);
	}

	/**
	 * 根据id查询详细信息 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getPioneerUser/{id}", method = RequestMethod.GET)
	public Object getPioneerUser(@PathVariable("id") String id) {
		return pioneerUserService.getPioneerUser(id);
	}

	/**
	 * 根据id删除党员 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "removePioneerUser/{id}", method = RequestMethod.GET)
	public Object removePioneerUser(@PathVariable("id") String id) {
		return pioneerUserService.removePioneerUser(id);
	}

	/**
	 * 添加党员 api
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "addPioneerUser", method = RequestMethod.POST)
	public Object insertPioneerUser(@RequestBody PioneerUser user, HttpServletRequest request) {
		LoginUserTest loginUser = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return pioneerUserService.insertPioneerUser(user, loginUser);
	}

	/**
	 * 修改党员 api
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public Object updatePioneerUser(@RequestBody PioneerUser user) {
		return pioneerUserService.updatePioneerUser(user);
	}

	/**
	 * 统计党组织对应的党员数量 api
	 * 
	 * @return
	 */
	@RequestMapping(value = "countNumber", method = RequestMethod.POST)
	public Object countNumber() {
		return pioneerUserService.countNumber();
	}

	/**
	 * 导出党员信息 api
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		pioneerUserService.exportExcel(response);
		return null;
	}

	/**
	 * 获取性别统计
	 * @return
	 */
	@RequestMapping(value = "getPioneerSex", method = RequestMethod.GET)
	public Object getPioneerSex() {
		List<MapParm> list = pioneerUserMapper.getPioneerSex();
		return list;
	}
    @RequestMapping(value = "getPioneerAge", method = RequestMethod.GET)
	public Object getPioneerAge(){
       int a = 0,b = 0,c = 0, d = 0,e = 0,f = 0;
        List<MapParm> res = new ArrayList<>();
        List<String> list = pioneerUserService.getPioneerUserAgeList();
        for(String item: list) {
            if (item == null) {
                continue;
            }
            Integer year = Integer.valueOf(item);
            if (year >= 18 && year <= 30) {
               a++;
            } else if (year > 30 && year <= 40) {
               b++;
            } else if (year >40 && year <= 50) {
               c++;
            } else if (year >50 && year <= 60) {
               d++;
            }else if (year >60) {
               e++;
            }
        }
        MapParm m1 = new MapParm();
        m1.setName("18-30岁");
        m1.setNum(a);
        MapParm m2 = new MapParm();
        m2.setName("30-40岁");
        m2.setNum(b);
        MapParm m3 = new MapParm();
        m3.setName("40-50岁");
        m3.setNum(c);
        MapParm m4 = new MapParm();
        m4.setName("50-60岁");
        m4.setNum(d);
        MapParm m5 = new MapParm();
        m5.setName("60岁以上");
        m5.setNum(e);
        res.add(m1);
        res.add(m2);
        res.add(m3);
        res.add(m4);
        res.add(m5);
        return res;
    }
}
