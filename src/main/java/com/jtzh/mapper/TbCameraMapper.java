package com.jtzh.mapper;

import com.jtzh.entity.TbCamera;
import com.jtzh.pojo.CameraPagination;

import java.util.List;

public interface TbCameraMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCamera record);

    int insertSelective(TbCamera record);

    TbCamera selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCamera record);

    int updateByPrimaryKey(TbCamera record);

    TbCamera selectByCameraName(String cameraName);

    TbCamera selectByCameraUuid(String cameraUuid);

    List<TbCamera> selectAll();

    List<TbCamera> page(CameraPagination cameraPagination);

    int count(CameraPagination cameraPagination);
}