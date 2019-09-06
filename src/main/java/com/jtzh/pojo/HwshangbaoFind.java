package com.jtzh.pojo;

import java.util.Date;

import com.jtzh.entity.Hwshangbao;

public class HwshangbaoFind extends Hwshangbao {
	private Integer id;
    private Integer shangbaoid;
    private String chuliren;
    private Date chulitime;
    private String chulimiaoshu;
    private String sheheren;
    private Date shehetime;
    private String shehemiaoshu;
    public String photo1;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

}
