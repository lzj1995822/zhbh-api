package com.jtzh.pojo;

import com.jtzh.entity.NoticeInf;

public class SafeNoticeDto {
	private NoticeInf noticeInf;
	private String countrysideNames[];
	private int committeeIds[];
	public NoticeInf getNoticeInf() {
		return noticeInf;
	}
	public void setNoticeInf(NoticeInf noticeInf) {
		this.noticeInf = noticeInf;
	}
	public String[] getCountrysideNames() {
		return countrysideNames;
	}
	public void setCountrysideNames(String[] countrysideNames) {
		this.countrysideNames = countrysideNames;
	}
	public int[] getCommitteeIds() {
		return committeeIds;
	}
	public void setCommitteeIds(int[] committeeIds) {
		this.committeeIds = committeeIds;
	}

}
