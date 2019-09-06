package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.GovmgtProblem;
import com.jtzh.entity.GovmgtSource;

public class ProblemDetail {
	private GovmgtProblem problem;
	private List<GovmgtSource> source;

	public GovmgtProblem getProblem() {
		return problem;
	}

	public void setProblem(GovmgtProblem problem) {
		this.problem = problem;
	}

	public List<GovmgtSource> getSource() {
		return source;
	}

	public void setSource(List<GovmgtSource> source) {
		this.source = source;
	}

}
