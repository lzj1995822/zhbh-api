package com.jtzh.pojo;

public class ProblemPagination extends BasePagination {
	private String problemType;
	private String lianren;
	private String paifaren;
	private String state;

	public String getLianren() {
		return lianren;
	}

	public void setLianren(String lianren) {
		this.lianren = lianren;
	}

	public String getPaifaren() {
		return paifaren;
	}

	public void setPaifaren(String paifaren) {
		this.paifaren = paifaren;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

}
