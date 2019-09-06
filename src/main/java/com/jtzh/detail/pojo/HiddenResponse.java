package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.SecuritySource;
import com.jtzh.pojo.HiddenDetail;

public class HiddenResponse extends HiddenDetail {
	private List<SecuritySource> afterSource;

	public List<SecuritySource> getAfterSource() {
		return afterSource;
	}

	public void setAfterSource(List<SecuritySource> afterSource) {
		this.afterSource = afterSource;
	}

}
