package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.KeyproSource;
import com.jtzh.pojo.KeyproProblemVo;

public class KeyproProblemDetailVo {
	private KeyproProblemVo problemVo;
	private List<KeyproSource> source;
	public KeyproProblemVo getProblemVo() {
		return problemVo;
	}
	public void setProblemVo(KeyproProblemVo problemVo) {
		this.problemVo = problemVo;
	}
	public List<KeyproSource> getSource() {
		return source;
	}
	public void setSource(List<KeyproSource> source) {
		this.source = source;
	}
	
}
