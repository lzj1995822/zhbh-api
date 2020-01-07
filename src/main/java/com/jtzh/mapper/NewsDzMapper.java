package com.jtzh.mapper;


import com.jtzh.pojo.NewsDz;
import com.jtzh.pojo.NewsFx;
import org.apache.ibatis.annotations.Param;

public interface NewsDzMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewsDz record);

    int insertSelective(NewsDz record);

    NewsDz selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsDz record);

    int updateByPrimaryKey(NewsDz record);

    int selectByUserId(@Param("userId") String userId, @Param("type")String type, @Param("id")String id);
    int deleteByUserId(@Param("userId") String userId, @Param("type")String type, @Param("id")String id);
    int updateDzNum(@Param("id")String id,@Param("tableName") String tableName);
    int updateDzNumJ(@Param("id")String id,@Param("tableName") String tableName);
    int updateReadNum(@Param("id")String id,@Param("tableName") String tableName);
    NewsFx getNewsInfo(@Param("id")String id, @Param("tableName") String tableName);
    NewsFx getNewsInfo1(@Param("id")String id, @Param("tableName") String tableName);
    NewsFx getNewsInfo2(@Param("id")String id, @Param("tableName") String tableName);
}