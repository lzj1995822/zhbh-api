package com.jtzh.controller;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.TbCamera;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.CameraPagination;
import com.jtzh.service.Impl.CameraServiceImpl;
import com.jtzh.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "87视频管理")
@RestController
@RequestMapping("/camera")
public class CameraController {

    @Resource
    private CameraServiceImpl cameraServiceImpl;

    @ApiOperation(value="获取视频资源")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getTotal(){
        cameraServiceImpl.getPointList();
    }

    @ApiOperation(value="获取视频资源坐标")
    @RequestMapping(value = "/getXY", method = RequestMethod.GET)
    public void getXY(){
        cameraServiceImpl.readExcelOrigin();
    }

    @ApiOperation(value="获取所有视频资源坐标")
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public List<TbCamera> getAll(){
        return cameraServiceImpl.selectAll();
    }

    @ApiOperation(value="分页获取监控点")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public BaseResponse<List<TbCamera>> page(@RequestBody CameraPagination cameraPagination){
        return cameraServiceImpl.page(cameraPagination);
    }

    @ApiOperation(value="获取播放xml")
    @RequestMapping(value = "/getPreviewXml/{cameraUuid}", method = RequestMethod.POST)
    public BaseResponse<JSONObject> getPreviewXml(@PathVariable String cameraUuid){
        com.alibaba.fastjson.JSONObject preivewList = cameraServiceImpl.getPreivewList(cameraUuid);
        if (preivewList == null) {
            return BaseResponse.ofFail();
        }
        return BaseResponse.of(preivewList);
    }
}
