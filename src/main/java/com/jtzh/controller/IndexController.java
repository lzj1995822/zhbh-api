package com.jtzh.controller;

import com.jtzh.entity.Cgshangbao;
import com.jtzh.entity.CountrysideProblem;
import com.jtzh.entity.Hwshangbao;
import com.jtzh.entity.KeyproProblem;
import com.jtzh.mapper.*;
import com.jtzh.pojo.*;
import com.jtzh.vo.gis.SocietySecurityEventVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "首页统计信息")
@RestController
@RequestMapping("index")
public class IndexController {

    @Resource
    private CgshangbaoMapper cgshangbaoMapper;
    @Resource
    private HwshangbaoMapper hwshangbaoMapper;
    @Resource
    private KeyproProblemMapper keyproProblemMapper;
    @Resource
    private CountrysideProblemMapper countrysideProblemMapper;
    @Resource
    private PioneerUserMapper pioneeruserMapper;

    @Resource
    private CguserMapper cguserMapper;

    @Resource
    private HwuserMapper hwuserMapper;
    @Resource
    private UserMapper userMapper;

    @Resource
    private KeyproProMapper proMapper;

    @Resource
    private CountrysideMapper countrysideMapper;

    @Resource
    private SocietySecurityEventMapper societySecurityEventMapper;

    @RequestMapping(value = "getDclCg" ,method = RequestMethod.GET)
    @ApiOperation(value="获取城管待处理")
    public Object getDclCg(){
        List<Cgshangbao> list  = cgshangbaoMapper.getDcl();
        Map<String,Object> map = new HashMap<>();
        map.put("res",list);
        return map;
    }

    @RequestMapping(value = "getDclHw",method = RequestMethod.GET)
    @ApiOperation(value="获取环卫待处理")
    public Object getDclHw(){
        List<Hwshangbao> list  = hwshangbaoMapper.getDcl();
        Map<String,Object> map = new HashMap<>();
        map.put("res",list);
        return map;
    }

    @RequestMapping(value = "getDclZdgc",method = RequestMethod.GET)
    @ApiOperation(value="获取重点工程待处理")
    public Object getDclZdgc(){
        List<KeyproProblem> list  = keyproProblemMapper.getDcl();
        Map<String,Object> map = new HashMap<>();
        map.put("res",list);
        return map;
    }

    @RequestMapping(value = "getDclCj",method = RequestMethod.GET)
    @ApiOperation(value="获取村建工程待处理")
    public Object getDclCj(){
        List<CountrysideProblem> list  = countrysideProblemMapper.getDcl();
        Map<String,Object> map = new HashMap<>();
        map.put("res",list);
        return map;
    }
    @RequestMapping(value = "getDclShza",method = RequestMethod.GET)
    @ApiOperation(value="获取社会治安待处理")
    public Object getDclShza(){
        List<SocietySecurityEventVO> list  = societySecurityEventMapper.getDcl();
        Map<String,Object> map = new HashMap<>();
        map.put("res",list);
        return map;
    }

    @RequestMapping(value = "getIndexTj",method = RequestMethod.GET)
    @ApiOperation(value="获取首页统计信息")
    public Object getIndexTj(){
        PioneerUserPagination param = new PioneerUserPagination();
        int total = pioneeruserMapper.selectTotal(param);

        CguserParam param1 = new CguserParam();
        int total1 = cguserMapper.selectCguTotal(param1);

        HwuserParam param2 = new HwuserParam();
        int total2 = hwuserMapper.selectHwuTotal(param2);


        int count = this.userMapper.getUserQueryCount("");
        Map<String,Object> map = new HashMap<>();
        KbuildPagination param3 = new KbuildPagination();
        int total3 = proMapper.selectTotal(param3);
        CountrysideParam param4 = new CountrysideParam();
        int total4 = countrysideMapper.selectCouTotal(param4);
        map.put("DY",total);
        map.put("CG",total1);
        map.put("HW",total2);
        map.put("ZZ",count);
        map.put("ZDGC",total3);
        map.put("ZJF",total4);
        return map;
    }

}
