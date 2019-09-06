package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.CountrysideNews;
import com.jtzh.entity.CountrysideSource;

public class CountrysideNewsDetail {
	
	private CountrysideNews countrysideNews;
	private List<CountrysideSource> source;
	
	public CountrysideNews getCountrysideNews() {
		return countrysideNews;
	}
	public void setCountrysideNews(CountrysideNews countrysideNews) {
		this.countrysideNews = countrysideNews;
	}
	public List<CountrysideSource> getSource() {
		return source;
	}
	public void setSource(List<CountrysideSource> source) {
		this.source = source;
	}

}
