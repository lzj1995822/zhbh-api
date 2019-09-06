package com.jtzh.pojo;

public class BasePagination {
	private String key;
	private String page;
	private int start;
	private int pageSize;
	private String startTime;
	private String endTime;
	private String yhzh;
	private String createId;

	private String position_x;
	private String position_y;


	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPosition_x() {
		return position_x;
	}

	public void setPosition_x(String position_x) {
		this.position_x = position_x;
	}

	public String getPosition_y() {
		return position_y;
	}

	public void setPosition_y(String position_y) {
		this.position_y = position_y;
	}

}
