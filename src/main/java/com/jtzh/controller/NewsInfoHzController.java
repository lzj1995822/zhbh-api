package com.jtzh.controller;

import com.jtzh.entity.UserDistance;
import com.jtzh.mapper.*;
import com.jtzh.pojo.FkParam;
import com.jtzh.pojo.NewsDz;
import com.jtzh.pojo.NewsFx;
import com.jtzh.service.NewsInfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.substring;

@Api(tags = "通知公告管理汇总")
@RestController
@RequestMapping("newsInfoHz")
public class NewsInfoHzController {
    @Resource
    private NewsDzMapper newsDzMapper;

    @Resource
    private UserDistanceMapper userDistanceMapper;

    @ApiOperation(value="查询是否已点赞")
    @Transactional
    @RequestMapping(value = "/hasdz", method = RequestMethod.POST)
    public Object hasdz(@RequestBody NewsDz newsDz){
        Map<String,Boolean> map = new HashMap<>();
        int num = newsDzMapper.selectByUserId(newsDz.getUserId(),newsDz.getTypeName(),newsDz.getNewsId());
        if (num > 0){
            map.put("res",true);
        }else {
            map.put("res",false);
        }
        return map;
    }


    @ApiOperation(value="取消点赞")
    @Transactional
    @RequestMapping(value = "/qxdz", method = RequestMethod.POST)
    public Object qxdz(@RequestBody NewsDz newsDz){
        Map<String,Boolean> map = new HashMap<>();
        newsDzMapper.deleteByUserId(newsDz.getUserId(),newsDz.getTypeName(),newsDz.getNewsId());
        String type = newsDz.getTypeName();
        if (type.equals("sy")){//首页
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"news_inf");
        }else if (type.equals("zhcg")){//城管
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"cginformation");
        }else if(type.equals("zhhw")){//环卫
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"hwinformation");
        } else if(type.equals("zhcj")){//村建
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"countryside_news");
        }else if(type.equals("yjgl")){//应急
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"security_inf");
        }else if(type.equals("zwgl")){//政务里面风采
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"govmgt_work");
        }else if(type.equals("zdgc")){//重点工程
            newsDzMapper.updateDzNumJ(newsDz.getNewsId(),"keypro_info_delivery");
        }
        map.put("res",true);
        return map;
    }
    @ApiOperation(value="点赞")
    @Transactional
    @RequestMapping(value = "/dz", method = RequestMethod.POST)
    public Object dz(@RequestBody NewsDz newsDz){
        Map<String,Boolean> map = new HashMap<>();
        int num = newsDzMapper.selectByUserId(newsDz.getUserId(),newsDz.getTypeName(),newsDz.getNewsId());
        if (num > 0 ){
            map.put("res",false);
            return map;
        }
        newsDzMapper.insert(newsDz);
        String type = newsDz.getTypeName();
        if (type.equals("sy")){//首页
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"news_inf");
        }else if (type.equals("zhcg")){//城管
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"cginformation");
        }else if(type.equals("zhhw")){//环卫
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"hwinformation");
        } else if(type.equals("zhcj")){//村建
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"countryside_news");
        }else if(type.equals("yjgl")){//应急
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"security_inf");
        }else if(type.equals("zwgl")){//政务里面风采
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"govmgt_work");
        }else if(type.equals("zdgc")){//重点工程
            newsDzMapper.updateDzNum(newsDz.getNewsId(),"keypro_info_delivery");
        }
        map.put("res",true);
        return map;
    }

    @ApiOperation(value="阅读")
    @Transactional
    @RequestMapping(value = "/yd", method = RequestMethod.POST)
    public Object yd(@RequestBody NewsDz newsDz){
        Map<String,Boolean> map = new HashMap<>();
        String type = newsDz.getTypeName();
        if (type.equals("sy")){//首页
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"news_inf");
        }else if (type.equals("zhcg")){//城管
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"cginformation");
        }else if(type.equals("zhhw")){//环卫
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"hwinformation");
        } else if(type.equals("zhcj")){//村建
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"countryside_news");
        }else if(type.equals("yjgl")){//应急
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"security_inf");
        }else if(type.equals("zwgl")){//政务里面风采
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"govmgt_work");
        }else if(type.equals("zdgc")){//重点工程
            newsDzMapper.updateReadNum(newsDz.getNewsId(),"keypro_info_delivery");
        }
        map.put("res",true);
        return map;
    }

    @ApiOperation(value="分享")
    @Transactional
    @RequestMapping(value = "/fx", method = RequestMethod.POST)
    public Object fx(@RequestBody NewsDz newsDz){
        Map<String,Object> map = new HashMap<>();
        String type = newsDz.getTypeName();
        NewsFx newsFx = null;
        if (type.equals("sy")){//首页
            newsFx = newsDzMapper.getNewsInfo(newsDz.getNewsId(),"news_inf");
        }else if (type.equals("zhcg")){//城管
            newsFx = newsDzMapper.getNewsInfo(newsDz.getNewsId(),"cginformation");
        }else if(type.equals("zhhw")){//环卫
            newsFx = newsDzMapper.getNewsInfo(newsDz.getNewsId(),"hwinformation");
        } else if(type.equals("zhcj")){//村建
            newsFx = newsDzMapper.getNewsInfo(newsDz.getNewsId(),"countryside_news");
        }else if(type.equals("yjgl")){//应急
            newsFx = newsDzMapper.getNewsInfo(newsDz.getNewsId(),"security_inf");
        }else if(type.equals("zwgl")){//政务里面风采
            newsFx = newsDzMapper.getNewsInfo1(newsDz.getNewsId(),"govmgt_work");//1
        }else if(type.equals("zdgc")){//重点工程
            newsFx = newsDzMapper.getNewsInfo2(newsDz.getNewsId(),"keypro_info_delivery");//2
        }
        map.put("res",true);
        map.put("data",newsFx);
        return map;
    }
    @ApiOperation(value="反馈")
    @Transactional
    @RequestMapping(value = "/fk", method = RequestMethod.POST)
    public Object yd(@RequestBody FkParam fkParam){
        Map<String,Boolean> map = new HashMap<>();
        map.put("res",true);
        return map;
    }

    @ApiOperation(value="里程")
    @Transactional
    @RequestMapping(value = "/distance", method = RequestMethod.POST)
    public Object distance(@RequestBody UserDistance distance){
        Map<String,Boolean> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        distance.setDistance(substring(0, distance.getDistance().indexOf(".")));
        distance.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        distance.setMonth(String.valueOf(calendar.get((Calendar.MONTH))+1));
        distance.setDay(String.valueOf(calendar.get(Calendar.DATE)));
        int num = userDistanceMapper.selectCount(distance);
        if (num > 0 ){
            userDistanceMapper.updateByPrimaryKey(distance);
            map.put("res",true);
            return map;
        }
        userDistanceMapper.insert(distance);
        map.put("res",true);
        return map;
    }

    @ApiOperation(value="查询实时点位")
    @Transactional
    @RequestMapping(value = "/leftByTime", method = RequestMethod.GET)
    public Object leftByTime(){
        Map<String,Object> map = new HashMap<>();
        UserDistance distance = new UserDistance();
        Calendar calendar = Calendar.getInstance();
        distance.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        distance.setMonth(String.valueOf(calendar.get((Calendar.MONTH))+1));
        distance.setDay(String.valueOf(calendar.get(Calendar.DATE)));
        List<UserDistance> list = userDistanceMapper.selectLeft(distance);
        map.put("res",true);
        map.put("data",list);
        return map;
    }

    @ApiOperation(value="根据时间、loginId查询实时里程")
    @Transactional
    @RequestMapping(value = "/distanceByTime", method = RequestMethod.POST)
    public Object distanceByTime(@RequestBody UserDistance distance){
        Map<String,Object> map = new HashMap<>();
        List<UserDistance> list = userDistanceMapper.getDistance(distance);
        map.put("res",true);
        map.put("data",list);
        return map;
    }

    @ApiOperation(value="获取本日、本月里程排行榜")
    @Transactional
    @RequestMapping(value = "/cuurDistance", method = RequestMethod.POST)
    public Object cuurDistance(){
        Map<String,Object> map = new HashMap<>();
        UserDistance distance = new UserDistance();
        Calendar calendar = Calendar.getInstance();
        distance.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        distance.setMonth(String.valueOf(calendar.get((Calendar.MONTH))+1));
        List<UserDistance> list = userDistanceMapper.cuurDistance(distance);//本月
        distance.setDay(String.valueOf(calendar.get(Calendar.DATE)));
        List<UserDistance> list1 = userDistanceMapper.cuurDistance(distance);//本日
        map.put("res",true);
        map.put("month",list);
        map.put("day",list1);
        return map;
    }

    @ApiOperation(value="获取轨迹")
    @Transactional
    @RequestMapping(value = "/getGj/{loginId}", method = RequestMethod.GET)
    public Object getGj(@PathVariable("loginId")String loginId){
        Map<String,Object> map = new HashMap<>();
        UserDistance distance = new UserDistance();
        Calendar calendar = Calendar.getInstance();
        distance.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        distance.setMonth(String.valueOf(calendar.get((Calendar.MONTH))+1));
        distance.setDay(String.valueOf(calendar.get(Calendar.DATE)));
        distance.setLoginId(loginId);
        List<UserDistance> list = userDistanceMapper.getGj(distance);
        map.put("res",true);
        map.put("month",list);
        return map;
    }


    @ApiOperation(value="新增轨迹点位")
    @Transactional
    @RequestMapping(value = "/setGj", method = RequestMethod.POST)
    public Object getGj(@RequestBody UserDistance distance){
        Map<String,Object> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        distance.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
        distance.setMonth(String.valueOf(calendar.get((Calendar.MONTH))+1));
        distance.setDay(String.valueOf(calendar.get(Calendar.DATE)));
        userDistanceMapper.setGj(distance);
        map.put("res",true);
        return map;
    }

}
