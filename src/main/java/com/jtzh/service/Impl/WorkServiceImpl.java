package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.NumberUtil;
import com.jtzh.detail.pojo.WorkDetail;
import com.jtzh.entity.GovmgtSource;
import com.jtzh.entity.GovmgtWork;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.GovmgtSourceMapper;
import com.jtzh.mapper.GovmgtWorkMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.WorkPagination;
import com.jtzh.pojo.WorkSourceParam;
import com.jtzh.service.WorkService;

@Service("workService")
public class WorkServiceImpl implements WorkService {
	@Resource
	private GovmgtWorkMapper workMapper;
	@Resource
	private GovmgtSourceMapper sourceMapper;

	@Override
	public Object getWorkList(WorkPagination param) {
		// 查询总数
		int total = workMapper.selectTotal(param);
		List<GovmgtWork> list = new ArrayList<GovmgtWork>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = workMapper.selectInfo(param);
		}
		List<WorkDetail> detaillist = new ArrayList<WorkDetail>();
		for (GovmgtWork work : list) {
			WorkDetail det = new WorkDetail();
			List<GovmgtSource> source = sourceMapper.selectSource(Constants.ATTACHSOURCE_WORK,work.getId());
			det.setWork(work);
			det.setSource(source);
			detaillist.add(det);
		}
		response.setRows(detaillist);
		return response;
	}

	@Override
	public Object getWork(String type, String id) {
		// Constants.ATTACHSOURCE_WORK即"01"代表工作资源在source表中对应的attachsource
		WorkDetail workDetail = new WorkDetail();
		GovmgtWork work = workMapper.selectWork(type, id);
		workDetail.setWork(work);
		workDetail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_WORK, id));
		ResultObject obj = new ResultObject();
		obj.setObj(workDetail);
		return obj;
	}

	@Override
	public Object removeWork(String id) {
		// 删除工作---a).删除工作表记录; b)删除工作对应的资源表记录.
		workMapper.deleteWork(id);
		List<GovmgtSource> workList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_WORK, id);
		if (workList != null && workList.size() > 0) {
			for (GovmgtSource source : workList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object addWork(WorkDetail detail, LoginUserTest user) {
		// 1.add工作资源
		GovmgtWork work = detail.getWork();
		work.setWorkNumber("ZW" + NumberUtil.getNumber());
		work.setCreateTime(new Date());
		work.setDelflag(Constants.DELFLAG_FALSE);
		work.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
		work.setYhzh(Constants.YHZH_BAOHUA);
		work.setCreateId(user.getLoginId());
		workMapper.insertWork(work);
		// 2.add图片资源
		List<GovmgtSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (GovmgtSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
				source.setSourceId(work.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				source.setFileType(work.getWorkType());
				source.setFileName(work.getWorkTitle());
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object modifyWork(WorkDetail detail) {
		GovmgtWork work = detail.getWork();
		work.setDelflag(Constants.DELFLAG_FALSE);
		work.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
		workMapper.updateByPrimaryKey(work);
		List<GovmgtSource> workList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_WORK, work.getId());
		if (workList != null && workList.size() > 0) {
			for (GovmgtSource source : workList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<GovmgtSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (GovmgtSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
				source.setSourceId(work.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				source.setFileType(work.getWorkType());
				source.setFileName(work.getWorkTitle());
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object getphotoList(WorkSourceParam param) {
		// 查询总数
		int total = sourceMapper.selectphotoTotal(param);
		List<GovmgtSource> list = new ArrayList<GovmgtSource>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = sourceMapper.selectphotoInfo(param);
		}
		response.setRows(list);
		return response;
	}

}
