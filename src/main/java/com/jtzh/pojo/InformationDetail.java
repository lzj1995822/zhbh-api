package com.jtzh.pojo;

import com.jtzh.entity.CgInformation;
import com.jtzh.entity.CountrysideNews;
import com.jtzh.entity.HwInformation;
import com.jtzh.entity.KeyproInfoDelivery;
import com.jtzh.entity.NoticeInf;

public class InformationDetail {
	
	private CgInformation cgInformation; //城管
	private HwInformation hwInformation; //环卫
	private NoticeInf noticeInf; //安全
	private CountrysideNews countrysideNews; //村建
	private KeyproInfoDelivery keyproInfoDelivery; //重点
	
	public CgInformation getCgInformation() {
		return cgInformation;
	}
	public void setCgInformation(CgInformation cgInformation) {
		this.cgInformation = cgInformation;
	}
	public HwInformation getHwInformation() {
		return hwInformation;
	}
	public void setHwInformation(HwInformation hwInformation) {
		this.hwInformation = hwInformation;
	}
	public NoticeInf getNoticeInf() {
		return noticeInf;
	}
	public void setNoticeInf(NoticeInf noticeInf) {
		this.noticeInf = noticeInf;
	}
	public CountrysideNews getCountrysideNews() {
		return countrysideNews;
	}
	public void setCountrysideNews(CountrysideNews countrysideNews) {
		this.countrysideNews = countrysideNews;
	}
	public KeyproInfoDelivery getKeyproInfoDelivery() {
		return keyproInfoDelivery;
	}
	public void setKeyproInfoDelivery(KeyproInfoDelivery keyproInfoDelivery) {
		this.keyproInfoDelivery = keyproInfoDelivery;
	}
	
	

}
