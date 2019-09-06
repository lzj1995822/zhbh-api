package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CgInformation;
import com.jtzh.entity.CountrysideNews;
import com.jtzh.entity.CountrysideSource;
import com.jtzh.entity.HwInformation;
import com.jtzh.entity.KeyproInfoDelivery;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.mapper.CgInformationMapper;
import com.jtzh.mapper.CountrysideNewsMapper;
import com.jtzh.mapper.CountrysideSourceMapper;
import com.jtzh.mapper.HwInformationMapper;
import com.jtzh.mapper.KeyproInfoDeliveryMapper;
import com.jtzh.mapper.NoticeInfMapper;
import com.jtzh.pojo.CgInformationParam;
import com.jtzh.pojo.CountrysideNewsDetail;
import com.jtzh.pojo.CountrysideParam;
import com.jtzh.pojo.HwInformationParam;
import com.jtzh.pojo.InformationDetail;
import com.jtzh.pojo.KeyproInfoPagination;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.pojo.PageResult;

@Service("CountrysideNewsService")
public class CountrysideNewsServiceImpl implements CountrysideNewsService {
	@Resource
	private CountrysideNewsMapper countrysideNewsMapper;

	@Resource
	private CountrysideSourceMapper countrysideSourceMapper;
	
	@Resource
	private CgInformationMapper cgInformationMapper;
	
	@Resource
	private HwInformationMapper hwInformationMapper;
	
	@Resource
	private NoticeInfMapper noticeInfMapper;
	
	@Resource
	private KeyproInfoDeliveryMapper infDelMapper;
	
	@Override
	public Object getCountrysideNewsList(CountrysideParam param) {
		// 查询总数
		int total = countrysideNewsMapper.selectCNTotal(param);
		List<CountrysideNews> list = new ArrayList<CountrysideNews>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = countrysideNewsMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public CountrysideNewsDetail getCountrysideNewsInfo(String id) {
		// 根据id去查询信息和图片资源信息
		CountrysideNewsDetail countrysideNewsDetail = new CountrysideNewsDetail();
		CountrysideNews countrysideNews = countrysideNewsMapper.getCountrysideNewsInfo(id);
		countrysideNewsDetail.setCountrysideNews(countrysideNews);
		// 02
		countrysideNewsDetail.setSource(countrysideSourceMapper.getSourceInfo("02", id));
		return countrysideNewsDetail;
	}
	
	@Override
	public Object addCountrysideNews(CountrysideNewsDetail countrysideNewsDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		CountrysideNews countrysideNews = countrysideNewsDetail.getCountrysideNews();
		// 01
		countrysideNews.setAttachmentSource("02");
		countrysideNews.setYhzh(Constants.YHZH_BAOHUA);
		countrysideNews.setCreateId(user.getLoginId());
		countrysideNews.setCreateTime(new Date());
		countrysideNews.setDelflag("A");
		countrysideNewsMapper.insertCountrysideNews(countrysideNews);
		List<CountrysideSource> couList = countrysideNewsDetail.getSource();
		// 如果图片存在
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				source.setAttachmentSource("02");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setDelflag("A");
				source.setSourceId(countrysideNews.getId());
				countrysideSourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object deleteCountrysideNews(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		countrysideNewsMapper.deleteCountrysideNews(id);
		List<CountrysideSource> couList = countrysideSourceMapper.getSourceInfo(sourceType, id);
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				Integer a = source.getId();
				countrysideSourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}
	// 修改
	@Override
	public Object updateCountrysideNews(CountrysideNews param) {
		countrysideNewsMapper.updateCountrysideNews(param);
		return new ResultObject();
	}

	@Override
	public Object getAllNewsList() {
		CgInformationParam param = new CgInformationParam();
		param.setStart(0);
		param.setPageSize(10);
		HwInformationParam param1 = new HwInformationParam();
		param1.setStart(0);
		param1.setPageSize(10);
		NoticeParam param2 = new NoticeParam();
		param2.setStart(0);
		param2.setPageSize(10);
		CountrysideParam param3 = new CountrysideParam();
		param3.setStart(0);
		param3.setPageSize(10);
		KeyproInfoPagination param4 = new KeyproInfoPagination();
		param4.setType("1");
		param4.setStart(0);
		param4.setPageSize(10);
		// 查询总数
		int total = cgInformationMapper.selectCgITotal(param);
		List<CgInformation> list = new ArrayList<CgInformation>();
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = cgInformationMapper.selectInfo(param);
		}
		// 查询总数
		int total1 = hwInformationMapper.selectHwITotal(param1);
		List<HwInformation> list1 = new ArrayList<HwInformation>();
		// 如果存在，查询具体的数据作为分页数据
		if (total1 > 0) {
			list1 = hwInformationMapper.selectInfo(param1);
		}
		// 查询总数
		int total2 = noticeInfMapper.selectInfTotal(param2);
		List<NoticeInf> list2 = new ArrayList<NoticeInf>();
		// 如果存在，查询具体的数据作为分页数据
		if (total2 > 0) {
			list2 = noticeInfMapper.selectInfo(param2);
		}
		// 查询总数
		int total3 = countrysideNewsMapper.selectCNTotal(param3);
		List<CountrysideNews> list3 = new ArrayList<CountrysideNews>();
		// 如果存在，查询具体的数据作为分页数据
		if (total3 > 0) {
			list3 = countrysideNewsMapper.selectInfo(param3);
		}
		// 查询总数
		int total4 = infDelMapper.selectTotal(param4);
		List<KeyproInfoDelivery> list4 = new ArrayList<KeyproInfoDelivery>();
		// 如果存在，查询具体的数据作为分页数据
		if (total4 > 0) {
			list4 = infDelMapper.selectInfo(param4);
		}
		InformationDetail detail = new InformationDetail();
		detail.setCgInformation(list.get(0));
		detail.setHwInformation(list1.get(0));
		detail.setNoticeInf(list2.get(0));
		detail.setCountrysideNews(list3.get(0));
		detail.setKeyproInfoDelivery(list4.get(0));
		return detail;

	}
	
}
