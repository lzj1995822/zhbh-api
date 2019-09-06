package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.detail.pojo.RecordDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionRecord;
import com.jtzh.entity.RoadProtectionSource;
import com.jtzh.mapper.RoadProtectionRecordMapper;
import com.jtzh.mapper.RoadProtectionSourceMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.RoadProtectionRecordPagination;
import com.jtzh.service.RoadProtectionRecordService;

@Service("roadProtectionRecordService")
public class RoadProtectionRecordServiceImpl implements RoadProtectionRecordService {
	@Resource
	private RoadProtectionRecordMapper recordMapper;
	@Resource
	private RoadProtectionSourceMapper sourceMapper;

	@Override
	public Object getRoadProtectionRecordList(RoadProtectionRecordPagination param) {
		// 查询总数
		int total = recordMapper.selectTotal(param);
		List<RoadProtectionRecord> list = new ArrayList<RoadProtectionRecord>();
		PageResult response = new PageResult();
		if (total > 0) {
			list = recordMapper.selectInfo(param);
			response.setTotal(total);	
		} else {
			response.setTotal(0);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getRoadProtectionRecord(Long id) {
		// Constants.ATTACHSOURCE_RECORD即"02"代表记录图片资源在source表中对应的attachsource
		RecordDetail recordDetail = new RecordDetail();
		RoadProtectionRecord record = recordMapper.selectRecord(id);
		recordDetail.setRecord(record);
		recordDetail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_RECORD, id));
		ResultObject obj = new ResultObject();
		obj.setObj(recordDetail);
		return obj;
	}

	@Override
	public Object removeRoadProtectionRecord(Long id) {
		// 删除记录---a).删除记录表记录; b)删除记录对应的资源表记录.
		recordMapper.deleteRecord(id);
		List<RoadProtectionSource> workList = sourceMapper.selectSource(Constants.ATTACHSOURCE_RECORD, id);
		if (workList != null && workList.size() > 0) {
			for (RoadProtectionSource source : workList) {
				Long a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object addRoadProtectionRecord(RecordDetail detail, LoginUserTest user) {
		// 1.add记录资源
		RoadProtectionRecord record = detail.getRecord();
		record.setCreateTime(new Date());
		record.setDelflag(Constants.String_DEL_FLG);
		record.setAttachmentSource(Constants.ATTACHSOURCE_RECORD);
		record.setYhzh(Constants.YHZH_BAOHUA);
		record.setCreateId(user.getLoginId());
		recordMapper.insertRecord(record);
		// 2.add图片资源
		List<RoadProtectionSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (RoadProtectionSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.String_DEL_FLG);
				source.setAttachmentSource(Constants.ATTACHSOURCE_RECORD);
				source.setSourceId(record.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object modifyRoadProtectionRecord(RecordDetail detail) {
		RoadProtectionRecord record = detail.getRecord();
		recordMapper.updateByPrimaryKeySelective(record);
		List<RoadProtectionSource> workList = sourceMapper.selectSource(Constants.ATTACHSOURCE_RECORD, record.getId());
		if (workList != null && workList.size() > 0) {
			for (RoadProtectionSource source : workList) {
				Long a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<RoadProtectionSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (RoadProtectionSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.String_DEL_FLG);
				source.setAttachmentSource(Constants.ATTACHSOURCE_RECORD);
				source.setSourceId(record.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

}
