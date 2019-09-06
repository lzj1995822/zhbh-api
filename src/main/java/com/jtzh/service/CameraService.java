package com.jtzh.service;

import com.jtzh.entity.TbCamera;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.CameraPagination;

import java.util.List;

public interface CameraService {
    BaseResponse<List<TbCamera>> page(CameraPagination cameraPagination);
}
