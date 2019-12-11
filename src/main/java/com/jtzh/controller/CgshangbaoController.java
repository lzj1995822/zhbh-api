package com.jtzh.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import com.jtzh.common.Constants;
import com.jtzh.entity.AA;
import com.jtzh.entity.AB;
import com.jtzh.entity.Cgshangbao;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Yhzhshangbao;
import com.jtzh.jpush.JpushUtils;
import com.jtzh.service.CgshangbaoService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "城管问题上报")
@RestController
public class CgshangbaoController {
    @Resource
    public CgshangbaoService cgshangbaoService;
    @Resource
	private JpushUtils jpushUtils;
    
    @Resource
	private LoginUserTestService loginUserTestService;

    public CgshangbaoService getCgshangbaoService() {
        return cgshangbaoService;
    }

    public void setCgshangbaoService(CgshangbaoService cgshangbaoService) {
        this.cgshangbaoService = cgshangbaoService;
    }
    @RequestMapping("/wentidengji")//问题登记
    public int insertSelective(@RequestBody Cgshangbao param,HttpServletRequest request){
    	LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
        return cgshangbaoService.insertSelective(param, user);
    }
    @RequestMapping("/yilian")//已立案
    public int yilian(@RequestBody Cgshangbao param){
        return cgshangbaoService.yilian(param);
    }
    @RequestMapping("/paifa")//派发
    public int paifa(@RequestBody Cgshangbao param){
    	String alias = Constants.JPUSH_CG_DEPNAME+param.getPaifaren();
    	jpushUtils.sendMsgToAndroid(Constants.JPUSH_DEFAULT_MSG, alias);
        return cgshangbaoService.paifa(param);
    }
    @RequestMapping("/chuli")//处理
    public int chuli(@RequestBody Cgshangbao param){
        return cgshangbaoService.chuli(param);
    }
    @RequestMapping("/huitui")//回退
    public int huitui(@RequestBody Cgshangbao param){
        return cgshangbaoService.huitui(param);
    }
    @RequestMapping("/yishenghe")//已审核
    public int yishenghe(@RequestBody Cgshangbao param){
        return cgshangbaoService.yishenghe(param);
    }
    @RequestMapping("/mohusousuo") // 模糊搜索
    public  List <Cgshangbao> mohusousuo(String arg0,String arg1){

        if(arg0.equals("未立案")){

            arg1="0";
        }else if(arg0.equals("已立案")||arg0.equals("未处理")){
            arg1="1";
        }
        else if(arg0.equals("处理中")){
            arg1="2";
        }
        else if(arg0.equals("未审核")){
            arg1="3";
        }
        else if(arg0.equals("已结案")){
            arg1="4";
        }
        else if(arg0.equals("已逾期")){
            arg1="5";
        }else {
            arg1="9";
        }

        return cgshangbaoService.mohusousuo(arg0,arg1);
    }
    @RequestMapping("/gaojisousuo")//高级搜索
    public   List <Cgshangbao> gaojisousuo(@RequestParam(value="Categories",required=false)String Categories, @RequestParam(value="smallcategories",required=false)String smallcategories,
                                           @RequestParam(value="isdeleted",required=false)String isdeleted, @RequestParam(value="submittime",required=false)String submittime,@RequestParam(value="endtime",required=false)String endtime){
        return cgshangbaoService.gaojisousuo(Categories,smallcategories,isdeleted,submittime,endtime);
    }
    @RequestMapping("/findbypaifaren") //根据派发人
    public List <Cgshangbao> findbypaifaren(String paifaren){
        return cgshangbaoService.findbypaifaren(paifaren);
    }
    @RequestMapping("/deleteshangbao") //删除-真删
    public  int deleteByPrimaryKey(Integer id){
        cgshangbaoService.deletecgchuli(id);
        return cgshangbaoService.deleteByPrimaryKey(id);
    }
    @RequestMapping("/tongjizhuangtai")
    public List<AB> tongjizhuangtai(){
        return cgshangbaoService.tongjizhuangtai();
    }
    @RequestMapping("/countzhuangtai")
    public Long selectcount3(){
        return cgshangbaoService.selectcount3();
    }
    @RequestMapping("/findall")
    public List <Cgshangbao> findall(@RequestParam(value="lianren",required=false)String lianren){
        return cgshangbaoService.findall(lianren);
    }
    // 新增信息
    @RequestMapping("/addCgshangbao")
    public Object addCgshangbao(@RequestBody Cgshangbao param,HttpServletRequest request) {
    	LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return cgshangbaoService.addCgshangbao(param,user);
	}
    // 修改信息
    @RequestMapping("/updateCgshangbao")
    public Object updateCgshangbao(@RequestBody Cgshangbao param) {
		return cgshangbaoService.updateCgshangbao(param);
	}
    // 删除-假删
    @RequestMapping("/deleteCgshangbao/{id}")
    public Object deleteCgshangbao(@PathVariable("id") String id) {
		return cgshangbaoService.deleteCgshangbao(id);
	}
    // 申请信息
    @RequestMapping("/applyCgshangbao")
    public Object ApplyCgshangbao(@RequestBody Cgshangbao param,HttpServletRequest request) {
    	LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return cgshangbaoService.ApplyCgshangbao(param,user);
	}
    // 信息列表
    @RequestMapping("/getCgshangbaoList")
    public AA getCgshangbaoList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize){

    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.getCgshangbaoList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount9(yhzhshangbao);
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    }
    // 案卷列表
    @RequestMapping("/anjuan")
    public AA findshangbao(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize){

    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.findshangbao(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount1();
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    }
    // 问题列表
    @RequestMapping("/wenti")
    public AA findshangbao1(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize){

    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.findshangbao1(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount2();
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    }
    // 状态查找
    @RequestMapping("/findzhuangtai")
    public AA findzhuangtai(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="key",required=false) String key,
                            @RequestParam(value="paifaren",required=false) String paifaren,
                            @RequestParam(value="startTime",required=false) String startTime,
                            @RequestParam(value="endTime",required=false) String endTime){

    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.findzhuangtai(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount8(yhzhshangbao);
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    }
    
    // 问题状态统计
    @RequestMapping("/getCountList1")
    public Object getCountList1(@RequestBody Cgshangbao param) {
    	Long count=cgshangbaoService.getCountList1(param);
		return count;
	}
    // 问题上报统计
    @RequestMapping("/getCountList2")
    public Object getCountList2(@RequestBody Cgshangbao param) {
    	Long count=cgshangbaoService.getCountList2(param);
		return count;
	}
    // 问题处理情况统计
    @RequestMapping("/getCountList3")
    public Object getCountList3(@RequestBody Cgshangbao param) {
    	Long count=cgshangbaoService.getCountList3(param);
		return count;
	}
    // 人员处理情况季度统计
    @RequestMapping("/getCountList4")
    public Object getCountList4(@RequestBody Cgshangbao param) {
    	Long count=cgshangbaoService.getCountList4(param);
		return count;
	}
    // 问题质量统计
    @RequestMapping("/getCountList5")
    public Object getCountList5(@RequestBody Cgshangbao param) {
    	Long count=cgshangbaoService.getCountList5(param);
		return count;
	}
    // 问题状态统计-所有状态
    @RequestMapping("/getCountList6")
    public Object getCountList6(Cgshangbao param) {
    	Object obj =cgshangbaoService.getCountList6(param);
		return obj;
	}

    // 查询双表全部信息(上报表、处理表)
    @RequestMapping(value = "/findbyisdeleted/{isdeleted}", method = RequestMethod.GET)
    public Object findbyisdeleted(@PathVariable("isdeleted") String isdeleted){
    	return cgshangbaoService.findbyisdeleted(isdeleted);
    }
    // 废弃问题统计
    @RequestMapping("/getCountListfeiqi")
    public Object getCountListfeiqi() {
    	Long count=cgshangbaoService.getCountListfeiqi();
		return count;
	}
    // 上报问题统计
    @RequestMapping("/getCountListshangbao")
    public Object getCountListshangbao() {
    	Long count=cgshangbaoService.getCountListshangbao();
		return count;
	}
    // 立案问题统计
    @RequestMapping("/getCountListlian")
    public Object getCountListlian() {
    	Long count=cgshangbaoService.getCountListlian();
		return count;
	}
    // 派发问题统计
    @RequestMapping("/getCountListpaifa")
    public Object getCountListpaifa() {
    	Long count=cgshangbaoService.getCountListpaifa();
		return count;
	}
    // 处理问题统计
    @RequestMapping("/getCountListchuli")
    public Object getCountListchuli() {
    	Long count=cgshangbaoService.getCountListchuli();
		return count;
	}
    // 待审核问题统计
    @RequestMapping("/getCountListdaishenhe")
    public Object getCountListdaishenhe() {
    	Long count=cgshangbaoService.getCountListdaishenhe();
		return count;
	}
    // 审核问题统计
    @RequestMapping("/getCountListshenhe")
    public Object getCountListshenhe() {
    	Long count=cgshangbaoService.getCountListshenhe();
		return count;
	}
    // 根据季度统计问题数
    @RequestMapping("/getCountListjidu/{year}")
    public Object getCountListjidu(@PathVariable String year) {
    	return cgshangbaoService.getCountListjidu(year);
		//return count;
	}
    // 上报人非审核通过状态查找
    @RequestMapping("/getStateshangbaorenList")
    public Object getStateshangbaorenList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="people",required=false) String people,
                            @RequestParam(value="realName",required=false) String realName,
                            HttpServletRequest request){
    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.getStateshangbaorenList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount4(yhzhshangbao.getIsdeleted());
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    	
    }
    // 派发人待处理通过状态查找
    @RequestMapping("/getStatepaifarenList")
    public Object getStatepaifarenList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="paifaren",required=false) String paifaren,
                            @RequestParam(value="realName",required=false) String realName,
                            HttpServletRequest request){
    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.getStatepaifarenList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount4(yhzhshangbao.getIsdeleted());
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    	
    }
    // 立案人派发人审核通过状态查找
    @RequestMapping("/getStatePeopleList")
    public Object getStatePeopleList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="paifaren",required=false) String paifaren,
                            @RequestParam(value="lianren",required=false) String lianren,
                            @RequestParam(value="realName",required=false) String realName,
                            HttpServletRequest request){
    	List<Cgshangbao>  cgshangbaolist=  cgshangbaoService.getStatePeopleList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=cgshangbaoService.selectcount4(yhzhshangbao.getIsdeleted());
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setCgshangbaoList(cgshangbaolist);
        return a;
    	
    }
    // 根据id查询所有信息-上报表
    @RequestMapping("/cgfindbyId/{id}")
    public Object cgfindbyId(@PathVariable("id") String id){
		return cgshangbaoService.cgfindbyId(id);
    }
    // 根据id查询所有信息-上报表、处理表（多条处理多条数据）
    @RequestMapping("/cgfindallbyId/{id}")
    public Object cgfindallbyId(@PathVariable("id") String id){
		return cgshangbaoService.cgfindallbyId(id);
    }
    @RequestMapping("/findcgbyisdeleted")
    public   List <Cgshangbao> findcgbyisdeleted(String isdeleted){
        return cgshangbaoService.findcgbyisdeleted(isdeleted);
    }
    // 修改状态
    @RequestMapping("/updatezhuangtai")
    public Object updatezhuangtai(@RequestBody Cgshangbao param) {
		return cgshangbaoService.updatezhuangtai(param);
	}
    // 根据村进行统计
    @RequestMapping("/getCountrysideList")
    public Object getCountrysideList(Cgshangbao param) {
    	Object obj =cgshangbaoService.getCountrysideList(param);
		return obj;
	}
    // 根据来源进行统计
    @RequestMapping("/getCountSource")
    public Object getCountSource(Cgshangbao param) {
    	Object obj =cgshangbaoService.getCountSource(param);
		return obj;
	}

    // 根据小类进行统计
    @RequestMapping(value = "/getCgCountSmallcategories", method = RequestMethod.GET)
    public Object getCgCountSmallcategories(@RequestParam @Nullable String calDay) {
        Object obj =cgshangbaoService.getCgCountSmallcategories(calDay);
        return obj;
    }

    @GetMapping(value = "/calBySource")
    public List<Map> calBySource(@RequestParam @Nullable String calDay) {
        return cgshangbaoService.calBySource(calDay);
    }

    @GetMapping(value = "/calByPeople")
    public List<Map> calByPeople(@RequestParam @Nullable String calDay) {
        return cgshangbaoService.calByPeople(calDay);
    }

    @GetMapping(value = "/todaySituation")
    public Map<String, Integer> todaySituation() {
        return cgshangbaoService.todaySituation();
    }
}