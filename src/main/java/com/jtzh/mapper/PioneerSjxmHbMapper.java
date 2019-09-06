package com.jtzh.mapper;

import com.jtzh.entity.PioneerSjxmHb;

public interface PioneerSjxmHbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerSjxmHb record);

    int insertSelective(PioneerSjxmHb record);

    PioneerSjxmHb selectByXmid(Long id);

    int updateByPrimaryKeySelective(PioneerSjxmHb record);

    int updateByPrimaryKey(PioneerSjxmHb record);
}