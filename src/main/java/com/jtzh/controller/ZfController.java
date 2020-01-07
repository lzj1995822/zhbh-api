package com.jtzh.controller;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.*;
import com.jtzh.mapper.*;
import com.jtzh.pojo.KeyproProblemVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "问题转发")
@RestController
@RequestMapping("public")
public class ZfController {

    @Resource
    public CgshangbaoMapper cgshangbaoMapper;

    @Resource
    public HwshangbaoMapper hwshangbaoMapper;

    @Resource
    private CountrysideProblemMapper problemMapper;

    @Resource
    private KeyproProblemMapper keyproProblemMapper;

    @Resource
    private KeyproSourceMapper sourceMapper;


    @Resource
    private CountrysideSourceMapper csourceMapper;
    @ApiOperation(value="问题转发ly:问题来源（1-城管2-环卫3-村建-4重点工程）zd终点同上")
    @RequestMapping(value = "zf/{ly}/{id}/{zd}",method = RequestMethod.GET)
    public Object Zf(@PathVariable("ly") String ly,@PathVariable("id") String id,@PathVariable("zd") String zd){
        String bt,ms,dz,x,y,l;
        String tp = "";
        List<KeyproSource> l1 = new ArrayList<>();
        List<CountrysideSource> l2 = new ArrayList<>();
        if (ly.equals("1")){
            l="城管";
            Cgshangbao cgshangbao =  cgshangbaoMapper.cgfindbyId(id).get(0);
            bt = cgshangbao.getSmallcategories();
            ms = cgshangbao.getMiaoshu();
            dz = cgshangbao.getDizhi2();
            x = cgshangbao.getX();
            y = cgshangbao.getY();
            tp = cgshangbao.getPhoto();
            String[] ss = tp.split(",");
            for(String s : ss ){
                KeyproSource k = new KeyproSource();
                CountrysideSource c = new CountrysideSource();
                k.setFileUrl(tp);
                c.setFileUrl(tp);
                l1.add(k);
                l2.add(c);
            }
            cgshangbaoMapper.deleteCgshangbao(id);
        }else if (ly.equals("2")){
            l="环卫";
            Hwshangbao  hwshangbao =hwshangbaoMapper.hwfindbyId(id).get(0);
            bt = hwshangbao.getSmallcategories();
            ms = hwshangbao.getMiaoshu();
            dz = hwshangbao.getDizhi2();
            x = hwshangbao.getX();
            y = hwshangbao.getY();
            tp = hwshangbao.getPhoto();
            String[] ss = tp.split(",");
            for(String s : ss ){
                KeyproSource k = new KeyproSource();
                CountrysideSource c = new CountrysideSource();
                k.setFileUrl(tp);
                c.setFileUrl(tp);
                l1.add(k);
                l2.add(c);
            }
            hwshangbaoMapper.deleteHwshangbao(id);
        }else if (ly.equals("3")){
            l="村建";
            CountrysideProblem countrysideProblem = problemMapper.getCountrysideProblemInfo(id);
            List<CountrysideSource> countrysideSources = csourceMapper.getSourceInfo("03", id);
            bt = countrysideProblem.getTitle();
            ms = countrysideProblem.getContent();
            dz = countrysideProblem.getAddress();
            x = countrysideProblem.getX();
            y = countrysideProblem.getY();
            if (countrysideSources != null && countrysideSources.size() > 0){
                l2.addAll(countrysideSources);
                for (CountrysideSource c : countrysideSources){
                    tp+= c.getFileUrl()+",";
                    KeyproSource k = new KeyproSource();
                    k.setFileUrl(c.getFileUrl());
                    l1.add(k);
                }
            }

        }else{
            l="重点工程";
            KeyproProblemVo problemVo = keyproProblemMapper.selectProblemVo(id);
            List<KeyproSource> sources = sourceMapper.selectSource(Constants.ATTACHSOURCE_PROBLEM, id);
            bt = problemVo.getKeyproProblemTitle();
            ms = problemVo.getKeyproProblemContent();
            dz = problemVo.getKeyproProblemAddress();
            x = problemVo.getX();
            y = problemVo.getY();
            if (sources != null && sources.size() > 0){
                l1.addAll(sources);
                for (KeyproSource k : sources){
                    tp+= k.getFileUrl()+",";
                    CountrysideSource c = new CountrysideSource();
                    c.setFileUrl(k.getFileUrl());
                    l2.add(c);
                }
            }
        }

        if (zd.equals("1")){
            Cgshangbao param = new Cgshangbao();
            param.setSubmittime(new Date());
            param.setYhzh(Constants.YHZH_BAOHUA);
            param.setCreateId(l);
            param.setCreateTime(new Date());
            param.setDelflag("A");
            param.setCategories("其他");
            param.setCountrysideId(1);
            param.setDizhi1(dz);
            param.setDizhi2(dz);
            param.setMiaoshu(ms);
            param.setPeople(l);
            param.setPhoto(tp);
            param.setSmallcategories("其他");
            param.setSource(l);
            param.setX(x);
            param.setY(y);
            cgshangbaoMapper.insertCgshangbao(param);
            return new ResultObject();
        }else if (zd.equals("2")){
            Hwshangbao param = new Hwshangbao();
            param.setSubmittime(new Date());
            param.setYhzh(Constants.YHZH_BAOHUA);
            param.setCreateId(l);
            param.setCreateTime(new Date());
            param.setDelflag("A");
            param.setCategories("其他");
            param.setCountrysideId(1);
            param.setDizhi1(dz);
            param.setDizhi2(dz);
            param.setMiaoshu(ms);
            param.setPeople(l);
            param.setPhoto(tp);
            param.setSmallcategories("其他");
            param.setSource(l);
            param.setX(x);
            param.setY(y);
            hwshangbaoMapper.insertHwshangbao(param);
            return new ResultObject();
        }else if (zd.equals("3")){
            CountrysideProblem problem = new CountrysideProblem();
            problem.setIsdeleted("1");
            problem.setShangbaotime(new Date());
            problem.setAttachmentSource("03");
            problem.setYhzh(Constants.YHZH_BAOHUA);
            problem.setCreateId(l);
            problem.setCreateTime(new Date());
            problem.setDelflag("A");
            problem.setAddress(dz);
            problem.setContent(ms);
            problem.setShangbaoren(l);
            problem.setTitle(bt);
            problem.setType("其他");
            problem.setX(x);
            problem.setY(y);
            problemMapper.insertCountrysideProblem(problem);
            if (l2 != null && l2.size() > 0) {
                for (CountrysideSource source : l2) {
                    source.setAttachmentSource("03");
                    source.setType("01");
                    source.setCreateTime(new Date());
                    source.setDelflag("A");
                    source.setSourceId(problem.getId());
                    csourceMapper.insertSelective(source);
                }
            }
            return new ResultObject();
        }else{
            KeyproProblem problem = new KeyproProblem();
            problem.setCreateTime(new Date());
            problem.setDelflag(Constants.DELFLAG_FALSE);
            problem.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM);
            problem.setYhzh(Constants.YHZH_BAOHUA);
            problem.setProcessState(Constants.REPORT_PROCESS);
            problem.setCreateId(l);
            problem.setKeyproProblemAddress(dz);
            problem.setKeyproProblemContent(ms);
            problem.setKeyproProblemReportPerson(l);
            problem.setKeyproProblemReportTime(new Date());
            problem.setKeyproProblemTitle(bt);
            problem.setKeyproProblemType("其他");
            problem.setX(x);
            problem.setY(y);
            keyproProblemMapper.insertProblem(problem);
            if (l1 != null && l1.size() > 0) {
                for (KeyproSource source : l1) {
                    source.setCreateTime(new Date());
                    source.setDelflag(Constants.DELFLAG_FALSE);
                    source.setAttachmentSource(Constants.ATTACHSOURCE_PROBLEM);
                    source.setSourceId(problem.getId());
                    source.setYhzh(Constants.YHZH_BAOHUA);
                    sourceMapper.insert(source);
                }
            }
            return new ResultObject();
        }

    }
}
