package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.CountrysideChuli;
import com.jtzh.entity.CountrysideSource;

public class CountrysideChuliDetail {
	
	private CountrysideChuli countrysideChuli;
	private List<CountrysideSource> source;
	
	public CountrysideChuli getCountrysideChuli() {
		return countrysideChuli;
	}
	public void setCountrysideChuli(CountrysideChuli countrysideChuli) {
		this.countrysideChuli = countrysideChuli;
	}
	public List<CountrysideSource> getSource() {
		return source;
	}
	public void setSource(List<CountrysideSource> source) {
		this.source = source;
	}

}
