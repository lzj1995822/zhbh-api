package com.jtzh.service;

import org.springframework.stereotype.Service;

import com.jtzh.entity.Hwchuli;
import com.jtzh.mapper.HwchuliMapper;

import javax.annotation.Resource;

import java.util.Date;

@Service
public class HwchuliService {
    @Resource
    public HwchuliMapper hwchuliMapper;

    public HwchuliMapper getHwchuliMapper() {
        return hwchuliMapper;
    }

    public void setHwchuliMapper(HwchuliMapper hwchuliMapper) {
        this.hwchuliMapper = hwchuliMapper;
    }
    public  int yichuli(Hwchuli hwchuli){
    	hwchuli.setChulitime(new Date());
    	hwchuli.setShenheState("0");
        return hwchuliMapper.yichuli(hwchuli);
    }
    public int shenghe(Hwchuli hwchuli){
    	hwchuli.setShehetime(new Date());
        return hwchuliMapper.shenghe(hwchuli);
    }

    /*public List<Hwchuli> findbyshangbaoid(int id){
        return hwchuliMapper.findbyshangbaoid(id);
    }*/
    
    public Object hwchulifindbyId(String shangbaoid) {
        return hwchuliMapper.hwchulifindbyId(shangbaoid);
    }
}
