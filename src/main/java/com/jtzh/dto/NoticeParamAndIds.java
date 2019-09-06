package com.jtzh.dto;

import com.jtzh.pojo.NoticeParam;

public class NoticeParamAndIds extends NoticeParam{
	private int [] newsIds;

	public int[] getNewsIds() {
		return newsIds;
	}

	public void setNewsIds(int[] newsIds) {
		this.newsIds = newsIds;
	}
	
}
