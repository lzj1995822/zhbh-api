package com.jtzh.pojo;

import com.jtzh.entity.NewsInf;

public class NewsInfDto {
	private NewsInf newsInf;
	private String depNames[];
	private String people[];
	public NewsInf getNewsInf() {
		return newsInf;
	}

	public void setNewsInf(NewsInf newsInf) {
		this.newsInf = newsInf;
	}

	public String[] getDepNames() {
		return depNames;
	}

	public void setDepName(String[] depNames) {
		this.depNames = depNames;
	}

	public String[] getPeople() {
		return people;
	}

	public void setPeople(String[] people) {
		this.people = people;
	}
}
