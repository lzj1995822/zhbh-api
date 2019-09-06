package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.NoticeLaw;
import com.jtzh.entity.NoticeTrain;

public class NoticeDetail {
	
	private List<NoticeInf> noticeInf;
	private List<NoticeLaw> noticeLaw;
	private List<NoticeTrain> noticeTrain;
	public List<NoticeInf> getNoticeInf() {
		return noticeInf;
	}
	public void setNoticeInf(List<NoticeInf> noticeInf) {
		this.noticeInf = noticeInf;
	}
	public List<NoticeLaw> getNoticeLaw() {
		return noticeLaw;
	}
	public void setNoticeLaw(List<NoticeLaw> noticeLaw) {
		this.noticeLaw = noticeLaw;
	}
	public List<NoticeTrain> getNoticeTrain() {
		return noticeTrain;
	}
	public void setNoticeTrain(List<NoticeTrain> noticeTrain) {
		this.noticeTrain = noticeTrain;
	}
	
	

}
