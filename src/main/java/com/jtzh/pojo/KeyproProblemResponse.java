package com.jtzh.pojo;

import java.util.Date;

import com.jtzh.entity.KeyproProblem;

public class KeyproProblemResponse extends KeyproProblem {
	private Integer shangbaoid;

	private String chuliren;

	private Date chulitime;

	private String chulidep;

	private String chulimiaoshu;

	private String sheheren;

	private Date shehetime;

	private String shehemiaoshu;

	public Integer getShangbaoid() {
		return shangbaoid;
	}

	public void setShangbaoid(Integer shangbaoid) {
		this.shangbaoid = shangbaoid;
	}

	public String getChuliren() {
		return chuliren;
	}

	public void setChuliren(String chuliren) {
		this.chuliren = chuliren;
	}

	public Date getChulitime() {
		return chulitime;
	}

	public void setChulitime(Date chulitime) {
		this.chulitime = chulitime;
	}

	public String getChulidep() {
		return chulidep;
	}

	public void setChulidep(String chulidep) {
		this.chulidep = chulidep;
	}

	public String getChulimiaoshu() {
		return chulimiaoshu;
	}

	public void setChulimiaoshu(String chulimiaoshu) {
		this.chulimiaoshu = chulimiaoshu;
	}

	public String getSheheren() {
		return sheheren;
	}

	public void setSheheren(String sheheren) {
		this.sheheren = sheheren;
	}

	public Date getShehetime() {
		return shehetime;
	}

	public void setShehetime(Date shehetime) {
		this.shehetime = shehetime;
	}

	public String getShehemiaoshu() {
		return shehemiaoshu;
	}

	public void setShehemiaoshu(String shehemiaoshu) {
		this.shehemiaoshu = shehemiaoshu;
	}

}
