package com.jtzh.service;

import com.jtzh.mapper.CgchuliMapper;
import com.jtzh.entity.Cgchuli;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;

@Service
public class CgchuliService {
    @Resource
    public CgchuliMapper cgchuliMapper;

    public CgchuliMapper getCgchuliMapper() {
        return cgchuliMapper;
    }

    public void setCgchuliMapper(CgchuliMapper cgchuliMapper) {
        this.cgchuliMapper = cgchuliMapper;
    }
    public  int yichuli(Cgchuli cgchuli){
    	cgchuli.setChulitime(new Date());
    	cgchuli.setShenheState("0");
        return cgchuliMapper.yichuli(cgchuli);
    }
    public int shenghe(Cgchuli cgchuli){
    	cgchuli.setShehetime(new Date());
        return cgchuliMapper.shenghe(cgchuli);
    }

    /*public List<Cgchuli> findbyshangbaoid(int id){
        return cgchuliMapper.findbyshangbaoid(id);
    }*/
    
    public Object cgchulifindbyId(String shangbaoid) {
        return cgchuliMapper.cgchulifindbyId(shangbaoid);
    }
}
