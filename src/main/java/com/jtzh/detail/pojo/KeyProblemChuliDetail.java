package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.KeyproProblemChuli;
import com.jtzh.entity.KeyproSource;

public class KeyProblemChuliDetail {
	private KeyproProblemChuli keyproProblemChuli;
	private List<KeyproSource> chuliSource;

	public KeyproProblemChuli getKeyproProblemChuli() {
		return keyproProblemChuli;
	}

	public void setKeyproProblemChuli(KeyproProblemChuli keyproProblemChuli) {
		this.keyproProblemChuli = keyproProblemChuli;
	}

	public List<KeyproSource> getChuliSource() {
		return chuliSource;
	}

	public void setChuliSource(List<KeyproSource> chuliSource) {
		this.chuliSource = chuliSource;
	}

}
