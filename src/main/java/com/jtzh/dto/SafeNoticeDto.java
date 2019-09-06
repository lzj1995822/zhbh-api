package com.jtzh.dto;

import com.jtzh.entity.NoticeInf;

public class SafeNoticeDto {
	private NoticeInf noticeInf;
	private int countrysideIds[];
	private int committeeIds[];
	private String depName;
	public NoticeInf getNoticeInf() {
		return noticeInf;
	}
	public void setNoticeInf(NoticeInf noticeInf) {
		this.noticeInf = noticeInf;
	}
	public int[] getCountrysideIds() {
		return countrysideIds;
	}
	public void setCountrysideIds(int[] countrysideIds) {
		this.countrysideIds = countrysideIds;
	}
	public int[] getCommitteeIds() {
		return committeeIds;
	}
	public void setCommitteeIds(int[] committeeIds) {
		this.committeeIds = committeeIds;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}

}
