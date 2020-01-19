package com.jtzh.mapper;

import com.jtzh.entity.UserDistance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDistanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDistance record);

    int insertSelective(UserDistance record);

    UserDistance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDistance record);

    int updateByPrimaryKey(UserDistance record);

    int selectCount(UserDistance record);

    List<UserDistance> selectLeft(UserDistance record);

    List<UserDistance> getDistance(UserDistance record);

    List<UserDistance> cuurDistance(UserDistance record);


    List<UserDistance> getGj(UserDistance record);

    int setGj(UserDistance record);
}