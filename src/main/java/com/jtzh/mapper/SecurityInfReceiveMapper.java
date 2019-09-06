package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SecurityInfReceive;
import com.jtzh.responsevo.SecurityInfReceiveVo;

public interface SecurityInfReceiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecurityInfReceive record);

    int insertSelective(SecurityInfReceive record);

    SecurityInfReceive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecurityInfReceive record);

    int updateByPrimaryKey(SecurityInfReceive record);
    
    int hasReceiveOrNot(SecurityInfReceive record);
    
    int hasReadOrNot(SecurityInfReceive record);
    
    int insertSecurityInfReceive(SecurityInfReceive record);
    
    SecurityInfReceiveVo getSafeNoticeDetail(SecurityInfReceive record);
    
    List<SecurityInfReceive> getReceiveByNewsId(Integer newsId);
    
    SecurityInfReceive getReceiveInf(SecurityInfReceive record);
}