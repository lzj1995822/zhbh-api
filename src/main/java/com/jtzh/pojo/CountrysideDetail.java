package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.CountrysideBuild;
import com.jtzh.entity.CountrysideSource;

public class CountrysideDetail {
	
	private CountrysideBuild countrysideBuild;
	private List<CountrysideSource> source;
	public CountrysideBuild getCountrysideBuild() {
		return countrysideBuild;
	}
	public void setCountrysideBuild(CountrysideBuild countrysideBuild) {
		this.countrysideBuild = countrysideBuild;
	}
	public List<CountrysideSource> getSource() {
		return source;
	}
	public void setSource(List<CountrysideSource> source) {
		this.source = source;
	}

}
