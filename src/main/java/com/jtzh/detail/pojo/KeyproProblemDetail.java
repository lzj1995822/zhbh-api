package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.KeyproProblem;
import com.jtzh.entity.KeyproSource;

public class KeyproProblemDetail {
	private KeyproProblem problem;
	private List<KeyproSource> source;

	public KeyproProblem getProblem() {
		return problem;
	}

	public void setProblem(KeyproProblem problem) {
		this.problem = problem;
	}

	public List<KeyproSource> getSource() {
		return source;
	}

	public void setSource(List<KeyproSource> source) {
		this.source = source;
	}

}
