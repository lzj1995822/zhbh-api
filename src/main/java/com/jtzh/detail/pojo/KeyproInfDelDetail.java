package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.KeyproInfoDelivery;
import com.jtzh.entity.KeyproSource;

public class KeyproInfDelDetail {
	private KeyproInfoDelivery infDel;
	private List<KeyproSource> beforeSource;
	private List<KeyproSource> afterSource;

	public KeyproInfoDelivery getInfDel() {
		return infDel;
	}

	public void setInfDel(KeyproInfoDelivery infDel) {
		this.infDel = infDel;
	}

	public List<KeyproSource> getBeforeSource() {
		return beforeSource;
	}

	public void setBeforeSource(List<KeyproSource> beforeSource) {
		this.beforeSource = beforeSource;
	}

	public List<KeyproSource> getAfterSource() {
		return afterSource;
	}

	public void setAfterSource(List<KeyproSource> afterSource) {
		this.afterSource = afterSource;
	}


}
