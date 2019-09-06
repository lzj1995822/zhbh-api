package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.NewsUserReceive;
import com.jtzh.pojo.NewsDepReq;
import com.jtzh.pojo.ReceivePerson;

public interface NewsUserReceiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsUserReceive record);

    int insertSelective(NewsUserReceive record);

    NewsUserReceive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsUserReceive record);

    int updateByPrimaryKey(NewsUserReceive record);
    
    List<ReceivePerson> getReceiveNameAndDep(NewsDepReq id);
    
    int hasReceiveOrNot(NewsUserReceive record);
}