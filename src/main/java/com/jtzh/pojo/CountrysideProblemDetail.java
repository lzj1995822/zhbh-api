package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.CountrysideProblem;
import com.jtzh.entity.CountrysideSource;

public class CountrysideProblemDetail {
	
	private CountrysideProblem countrysideProblem;
	private List<CountrysideSource> source;
	
	public CountrysideProblem getCountrysideProblem() {
		return countrysideProblem;
	}
	public void setCountrysideProblem(CountrysideProblem countrysideProblem) {
		this.countrysideProblem = countrysideProblem;
	}
	public List<CountrysideSource> getSource() {
		return source;
	}
	public void setSource(List<CountrysideSource> source) {
		this.source = source;
	}

}
