package com.jtzh.detail.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class KeySolveResponse {
	private String id;

	private Long shangbaoid;

	private String chuliren;

	private Date chulitime;

	private String chulidep;

	private String chulimiaoshu;

	private String sheheren;

	private String shehetime;

	private String shehemiaoshu;
	
	private String huituiren;

	private String delflag;
	private String appointMan;
    private String appointDep;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointTime;
    private String isSolve;
    private String isCheck;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getShangbaoid() {
		return shangbaoid;
	}

	public void setShangbaoid(Long shangbaoid) {
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

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getSheheren() {
		return sheheren;
	}

	public void setSheheren(String sheheren) {
		this.sheheren = sheheren;
	}

	public String getShehetime() {
		return shehetime;
	}

	public void setShehetime(String shehetime) {
		this.shehetime = shehetime;
	}

	public String getShehemiaoshu() {
		return shehemiaoshu;
	}

	public void setShehemiaoshu(String shehemiaoshu) {
		this.shehemiaoshu = shehemiaoshu;
	}

	public String getHuituiren() {
		return huituiren;
	}

	public void setHuituiren(String huituiren) {
		this.huituiren = huituiren;
	}

	public String getAppointMan() {
		return appointMan;
	}

	public void setAppointMan(String appointMan) {
		this.appointMan = appointMan;
	}

	public String getAppointDep() {
		return appointDep;
	}

	public void setAppointDep(String appointDep) {
		this.appointDep = appointDep;
	}

	public Date getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	public String getIsSolve() {
		return isSolve;
	}

	public void setIsSolve(String isSolve) {
		this.isSolve = isSolve;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	
}
