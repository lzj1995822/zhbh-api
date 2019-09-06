package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.detail.pojo.KeyproInfDelDetail;
import com.jtzh.entity.KeyproInfoDelivery;
import com.jtzh.entity.KeyproSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.KeyproInfoDeliveryMapper;
import com.jtzh.mapper.KeyproSourceMapper;
import com.jtzh.pojo.KeyproInfoPagination;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.KeyproInfoDelService;

@Service("keyproInfoDelService")
public class KeyproInfoDelServiceImpl implements KeyproInfoDelService {
	@Resource
	private KeyproInfoDeliveryMapper infDelMapper;
	@Resource
	private KeyproSourceMapper sourceMapper;

	@Override
	public Object getKeyproInfoDelList(KeyproInfoPagination param) {
		// 查询总数
		int total = infDelMapper.selectTotal(param);
		List<KeyproInfoDelivery> list = new ArrayList<KeyproInfoDelivery>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = infDelMapper.selectInfo(param);
		}
		List<KeyproInfDelDetail> detaillist = new ArrayList<KeyproInfDelDetail>();
		for (KeyproInfoDelivery inf : list) {
			KeyproInfDelDetail det = new KeyproInfDelDetail();
			List<KeyproSource> beforeSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_REFORM_BEFORE,
					inf.getId());
			List<KeyproSource> afterSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_REFORM_AFTER,
					inf.getId());
			det.setInfDel(inf);
			det.setBeforeSource(beforeSource);
			det.setAfterSource(afterSource);
			detaillist.add(det);
		}
		response.setRows(detaillist);
		return response;
	}

	@Override
	public Object getKeyproInfoDel(String type, String id) {
		// Constants.ATTACHSOURCE_REFORM_BEFORE即"03"代表整改前资源在source表中对应的attachsource
		// Constants.ATTACHSOURCE_REFORM_AFTER即"04"代表整改后资源在source表中对应的attachsource
		KeyproInfDelDetail detail = new KeyproInfDelDetail();
		KeyproInfoDelivery inf = infDelMapper.selectInf(type, id);
		detail.setInfDel(inf);
		List<KeyproSource> beforeSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_REFORM_BEFORE, id);
		List<KeyproSource> afterSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_REFORM_AFTER, id);
		if (null != beforeSource && beforeSource.size() > 0) {
			detail.setBeforeSource(beforeSource);
		}
		if (null != afterSource && afterSource.size() > 0) {
			detail.setAfterSource(afterSource);
		}
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	@Override
	public Object removeKeyproInfoDel(String id) {
		// 删除信息发布记录---a).删除信息表记录; b)删除信息对应的资源表记录.
		infDelMapper.deleteInf(id);
		List<KeyproSource> beforeSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_REFORM_BEFORE, id);
		if (beforeSource != null && beforeSource.size() > 0) {
			for (KeyproSource source : beforeSource) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<KeyproSource> afterSource = sourceMapper.selectSource(Constants.ATTACHSOURCE_REFORM_AFTER, id);
		if (afterSource != null && afterSource.size() > 0) {
			for (KeyproSource source : afterSource) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object addKeyproInfDel(KeyproInfDelDetail detail, LoginUserTest user) {
		// 1.add工作资源
		KeyproInfoDelivery inf = detail.getInfDel();
		// inf.setWorkNumber("ZW" + NumberUtil.getNumber());
		inf.setCreateTime(new Date());
		inf.setDelflag(Constants.DELFLAG_FALSE);
		// inf.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
		inf.setYhzh(Constants.YHZH_BAOHUA);
		inf.setCreateId(user.getLoginId());
		infDelMapper.insertInf(inf);
		// 2.add整改前图片资源
		List<KeyproSource> beforeSource = detail.getBeforeSource();
		if (beforeSource != null && beforeSource.size() > 0) {
			for (KeyproSource source : beforeSource) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_REFORM_BEFORE);
				source.setSourceId(inf.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		// 3.add整改后图片资源
		List<KeyproSource> afterSource = detail.getAfterSource();
		if (afterSource != null && afterSource.size() > 0) {
			for (KeyproSource source : afterSource) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_REFORM_AFTER);
				source.setSourceId(inf.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object modifyKeyproInfDel(KeyproInfDelDetail detail) {
		KeyproInfoDelivery inf = detail.getInfDel();
		inf.setDelflag(Constants.DELFLAG_FALSE);
		// inf.setAttachmentSource(Constants.ATTACHSOURCE_WORK);
		infDelMapper.updateByPrimaryKey(inf);
		// 1.删除整改前原来的照片
		List<KeyproSource> workList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_REFORM_BEFORE, inf.getId());
		if (workList != null && workList.size() > 0) {
			for (KeyproSource source : workList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		// 2.删除整改后原来的照片
		List<KeyproSource> afterList = sourceMapper.getSourceInfo(Constants.ATTACHSOURCE_REFORM_AFTER, inf.getId());
		if (afterList != null && afterList.size() > 0) {
			for (KeyproSource source : afterList) {
				String a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		// 3.获取detail需要修改的资源即新增
		List<KeyproSource> mbList = detail.getBeforeSource();
		if (mbList != null && mbList.size() > 0) {
			for (KeyproSource source : mbList) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_REFORM_BEFORE);
				source.setSourceId(inf.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		// 4.获取detail需要修改的整改后资源即新增
		List<KeyproSource> maList = detail.getAfterSource();
		if (maList != null && maList.size() > 0) {
			for (KeyproSource source : maList) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.DELFLAG_FALSE);
				source.setAttachmentSource(Constants.ATTACHSOURCE_REFORM_AFTER);
				source.setSourceId(inf.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object getKeyproInfoDelList2(KeyproInfoPagination param) {
		// 查询总数
		int total = infDelMapper.selectTotal(param);
		List<KeyproInfoDelivery> list = new ArrayList<KeyproInfoDelivery>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = infDelMapper.selectInfo(param);
		}
		response.setRows(list);
		return response;
	}

}
