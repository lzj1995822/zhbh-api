package com.jtzh.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jtzh.common.Constants;
import com.jtzh.entity.AA;
import com.jtzh.entity.AB;
import com.jtzh.entity.Hwshangbao;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Yhzhshangbao;
import com.jtzh.jpush.JpushUtils;
import com.jtzh.jpush.Push;
import com.jtzh.service.HwshangbaoService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "环卫问题上报")
@RestController
public class HwshangbaoController {
	@Resource
    public HwshangbaoService hwshangbaoService;
	@Resource
	private JpushUtils jpushUtils;
	
	@Resource
	private LoginUserTestService loginUserTestService;

    public HwshangbaoService getHwshangbaoService() {
        return hwshangbaoService;
    }

    public void setHwshangbaoService(HwshangbaoService hwshangbaoService) {
        this.hwshangbaoService = hwshangbaoService;
    }
    @RequestMapping("/hwwentidengji")//问题登记
    public int insertSelective(@RequestBody Hwshangbao param,HttpServletRequest request){
    	LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
        return hwshangbaoService.insertSelective(param, user);
    }
    @RequestMapping("/hwyilian")//已立案
    public int yilian(@RequestBody Hwshangbao param){
        return hwshangbaoService.yilian(param);
    }
    @RequestMapping("/hwpaifa")//派发
    public int paifa(@RequestBody Hwshangbao param){
    	String alias = Constants.JPUSH_HW_DEPNAME+param.getPaifaren();
    	jpushUtils.sendMsgToAndroid(Constants.JPUSH_DEFAULT_MSG, alias);
        return hwshangbaoService.paifa(param);
    }
    @RequestMapping("/hwchuli")//处理
    public int chuli(@RequestBody Hwshangbao param){
        return hwshangbaoService.chuli(param);
    }
    @RequestMapping("/hwhuitui")//回退
    public int huitui(@RequestBody Hwshangbao param){
        return hwshangbaoService.huitui(param);
    }
    @RequestMapping("/hwyishenghe")//已审核
    public int yishenghe(@RequestBody Hwshangbao param){
        return hwshangbaoService.yishenghe(param);
    }
    @RequestMapping("/hwmohusousuo") // 模糊搜索
    public  List <Hwshangbao> mohusousuo(String arg0,String arg1){

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

        return hwshangbaoService.mohusousuo(arg0,arg1);
    }
    @RequestMapping("/hwgaojisousuo")//高级搜索
    public   List <Hwshangbao> gaojisousuo(@RequestParam(value="Categories",required=false)String Categories, @RequestParam(value="smallcategories",required=false)String smallcategories,
                                           @RequestParam(value="isdeleted",required=false)String isdeleted, @RequestParam(value="submittime",required=false)String submittime,@RequestParam(value="endtime",required=false)String endtime){
        return hwshangbaoService.gaojisousuo(Categories,smallcategories,isdeleted,submittime,endtime);
    }
    @RequestMapping("/hwfindbypaifaren") // 根据派发人
    public List <Hwshangbao> findbypaifaren(String paifaren){
        return hwshangbaoService.findbypaifaren(paifaren);
    }
    @RequestMapping("/hwdeleteshangbao") // 删除-真删
    public  int deleteByPrimaryKey(Integer id){
        hwshangbaoService.deletehwchuli(id);
        return hwshangbaoService.deleteByPrimaryKey(id);
    }
    @RequestMapping("/hwtongjizhuangtai")
    public List<AB> tongjizhuangtai(){
        return hwshangbaoService.tongjizhuangtai();
    }
    @RequestMapping("/hwcountzhuangtai")
    public Long selectcount3(){
        return hwshangbaoService.selectcount3();
    }
    @RequestMapping("/hwfindall")
    public List <Hwshangbao> findall(@RequestParam(value="lianren",required=false)String lianren){
        return hwshangbaoService.findall(lianren);
    }
    // 新增信息
    @RequestMapping("/hwaddhwshangbao")
    public Object addHwshangbao(@RequestBody Hwshangbao param,HttpServletRequest request) {
    	LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return hwshangbaoService.addHwshangbao(param, user);
	}
    // 修改信息
    @RequestMapping("/hwupdateHwshangbao")
    public Object updateHwshangbao(@RequestBody Hwshangbao param) {
		return hwshangbaoService.updateHwshangbao(param);
	}
    // 删除信息
    @RequestMapping("/hwdeleteHwshangbao/{id}")
    public Object deleteHwshangbao(@PathVariable("id") String id) {
		return hwshangbaoService.deleteHwshangbao(id);
	}
    // 申请信息
    @RequestMapping("/hwapplyHwshangbao")
    public Object ApplyHwshangbao(@RequestBody Hwshangbao param,HttpServletRequest request) {
    	LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return hwshangbaoService.ApplyHwshangbao(param, user);
	}
    // 信息列表
    @RequestMapping("/hwgetHwshangbaoList")
    public AA getHwshangbaoList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize){

    	List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.getHwshangbaoList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount9(yhzhshangbao);
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;
    }
    // 案卷列表
    @RequestMapping("/hwanjuan")
    public AA findshangbao(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize){

    	List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.findshangbao(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount1();
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;
    }
    // 问题列表
    @RequestMapping("/hwwenti")
    public AA findshangbao1(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize){

    	List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.findshangbao1(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount2();
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;
    }
    // 状态查找
    @RequestMapping("/hwfindzhuangtai")
    public AA findzhuangtai(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
    						@RequestParam(value="key",required=false) String key,
    						@RequestParam(value="paifaren",required=false) String paifaren){

    	List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.findzhuangtai(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount8(yhzhshangbao);
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;
    }
    // 问题状态统计
    @RequestMapping("/hwgetCountList1")
    public Object hwgetCountList1(@RequestBody Hwshangbao param) {
    	Long count=hwshangbaoService.hwgetCountList1(param);
		return count;
	}
    // 问题上报统计
    @RequestMapping("/hwgetCountList2")
    public Object hwgetCountList2(@RequestBody Hwshangbao param) {
    	Long count=hwshangbaoService.hwgetCountList2(param);
		return count;
	}
    // 问题处理情况统计
    @RequestMapping("/hwgetCountList3")
    public Object hwgetCountList3(@RequestBody Hwshangbao param) {
    	Long count=hwshangbaoService.hwgetCountList3(param);
		return count;
	}
    // 人员处理情况季度统计
    @RequestMapping("/hwgetCountList4")
    public Object hwgetCountList4(@RequestBody Hwshangbao param) {
    	Long count=hwshangbaoService.hwgetCountList4(param);
		return count;
	}
    // 问题质量统计
    @RequestMapping("/hwgetCountList5")
    public Object hwgetCountList5(@RequestBody Hwshangbao param) {
    	Long count=hwshangbaoService.hwgetCountList5(param);
		return count;
	}
    // 问题状态统计-所有状态
    @RequestMapping("/hwgetCountList6")
    public Object hwgetCountList6(Hwshangbao param) {
    	Object obj =hwshangbaoService.hwgetCountList6(param);
		return obj;
	}
    // 查询双表全部信息(上报表、处理表)
    @RequestMapping(value = "/hwfindbyisdeleted/{isdeleted}", method = RequestMethod.GET)
    public Object hwfindbyisdeleted(@PathVariable("isdeleted") String isdeleted){
    	return hwshangbaoService.findbyisdeleted(isdeleted);
    }
    // 废弃问题统计
    @RequestMapping("/hwgetCountListfeiqi")
    public Object hwgetCountListfeiqi() {
    	Long count=hwshangbaoService.hwgetCountListfeiqi();
		return count;
	}
    // 上报问题统计
    @RequestMapping("/hwgetCountListshangbao")
    public Object hwgetCountListshangbao() {
    	Long count=hwshangbaoService.hwgetCountListshangbao();
		return count;
	}
    // 立案问题统计
    @RequestMapping("/hwgetCountListlian")
    public Object hwgetCountListlian() {
    	Long count=hwshangbaoService.hwgetCountListlian();
		return count;
	}
    // 派发问题统计
    @RequestMapping("/hwgetCountListpaifa")
    public Object hwgetCountListpaifa() {
    	Long count=hwshangbaoService.hwgetCountListpaifa();
		return count;
	}
    // 处理问题统计
    @RequestMapping("/hwgetCountListchuli")
    public Object hwgetCountListchuli() {
    	Long count=hwshangbaoService.hwgetCountListchuli();
		return count;
	}
    // 待审核问题统计
    @RequestMapping("/hwgetCountListdaishenhe")
    public Object hwgetCountListdaishenhe() {
    	Long count=hwshangbaoService.hwgetCountListdaishenhe();
		return count;
	}
    // 审核问题统计
    @RequestMapping("/hwgetCountListshenhe")
    public Object hwgetCountListshenhe() {
    	Long count=hwshangbaoService.hwgetCountListshenhe();
		return count;
	}
    // 根据季度统计问题数
    @RequestMapping("/hwgetCountListjidu/{year}")
    public Object hwgetCountListjidu(@PathVariable String year) {
    	return hwshangbaoService.hwgetCountListjidu(year);
		//return count;
	}
    // 上报人非审核通过状态查找
    @RequestMapping("/hwgetStateshangbaorenList")
    public Object hwgetStateshangbaorenList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="people",required=false) String people,
                            HttpServletRequest request){
    	List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.hwgetStateshangbaorenList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount4(yhzhshangbao.getIsdeleted());
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;}

    // 派发人待处理通过状态查找
    @RequestMapping("/hwgetStatepaifarenList")
    public Object hwgetStatepaifarenList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="paifaren",required=false) String paifaren,
                            HttpServletRequest request){
    	List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.hwgetStatepaifarenList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount4(yhzhshangbao.getIsdeleted());
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;
    	
    }
    // 立案人派发人审核通过状态查找
    @RequestMapping("/hwgetStatePeopleList")
    public Object hwgetStatePeopleList(@RequestBody Yhzhshangbao yhzhshangbao, @RequestParam(value="currPage",required=false) Long currPage,
                            @RequestParam(value="pageSize",required=false) Long pageSize,
                            @RequestParam(value="isdeleted",required=false) Long isdeleted,
                            @RequestParam(value="paifaren",required=false) String paifaren,
                            @RequestParam(value="lianren",required=false) String lianren,
                            HttpServletRequest request){
    		List<Hwshangbao>  hwshangbaolist=  hwshangbaoService.hwgetStatePeopleList(yhzhshangbao);
        if(currPage==null){
            currPage=1L;
        }
        if(currPage==0){
            currPage=currPage+1;
        }
        if(pageSize==null){
            pageSize=10L;
        }

        Long count=hwshangbaoService.selectcount4(yhzhshangbao.getIsdeleted());
        Long totalPage = 0L;

        if(count>0){
            totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        }
        AA a = new AA();
        a.setCount(count);
        a.setCurrPage(currPage);
        a.setPageSize(pageSize);
        a.setTotalPage(totalPage);
        a.setHwshangbaoList(hwshangbaolist);
        return a;}
    // 根据id查询所有信息-上报表
    @RequestMapping("/hwfindbyId/{id}")
    public Object hwfindbyId(@PathVariable("id") String id){
		return hwshangbaoService.hwfindbyId(id);
    }
    // 根据id查询所有信息-上报表、处理表（多条处理多条数据）
    @RequestMapping("/hwfindallbyId/{id}")
    public Object hwfindallbyId(@PathVariable("id") String id){
		return hwshangbaoService.hwfindallbyId(id);
    }
    @RequestMapping("/findhwbyisdeleted")
    public  List <Hwshangbao> findhwbyisdeleted(String isdeleted){
        return hwshangbaoService.findhwbyisdeleted(isdeleted);
    }
    // 修改状态
    @RequestMapping("/hwupdatezhuangtai")
    public  Object updateByPrimaryKeySelective(@RequestBody Hwshangbao record){
        return hwshangbaoService.updateByPrimaryKeySelective(record);
    }
    // 根据村进行统计
    @RequestMapping("/hwgetCountrysideList")
    public Object getCountrysideList(Hwshangbao param) {
    	Object obj =hwshangbaoService.getCountrysideList(param);
		return obj;
	}
    // 根据来源进行统计
    @RequestMapping("/hwgetCountSource")
    public Object hwgetCountSource(Hwshangbao param) {
    	Object obj =hwshangbaoService.hwgetCountSource(param);
		return obj;
	}

    // 根据小类进行统计
    @RequestMapping(value = "/getHwCountSmallcategories", method = RequestMethod.GET)
    public Object getHwCountSmallcategories() {
        Object obj =hwshangbaoService.getHwCountSmallcategories();
        return obj;
    }

    //环卫问题来源
    @GetMapping(value = "/calByHwSource")
    public List<Map> calBySource(@RequestParam @Nullable String calDay) {
        return hwshangbaoService.calBySource(calDay);
    }
    //今日环卫上报统计
    @GetMapping(value = "/todayHwSituation")
    public Map<String, Integer> todaySituation() {
        return hwshangbaoService.todaySituation();
    }

    //环卫上报涨幅

    @RequestMapping(value = "/getHwIncreare", method = RequestMethod.GET)
    public   int getHwIncreare() {
       int   res= (int) hwshangbaoService.getHwIncreare();
        return res;
    }



    @GetMapping(value = "/calByHwPeople")
    public List<Map> calByPeople(@RequestParam @Nullable String calDay) {
        return hwshangbaoService.calByPeople(calDay);
    }
}
