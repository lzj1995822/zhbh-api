package com.jtzh.entity;

import java.util.List;

public class AA {

	private long count;
	private long totalPage;
	private long currPage;
	private long pageSize;
	private List <Cgshangbao> cgshangbaoList;
	private List <Hwshangbao> hwshangbaoList;

	public List<Cgshangbao> getCgshangbaoList() {
		return cgshangbaoList;
	}

	public void setCgshangbaoList(List<Cgshangbao> cgshangbaoList) {
		this.cgshangbaoList = cgshangbaoList;
	}

	public List<Hwshangbao> getHwshangbaoList() {
		return hwshangbaoList;
	}

	public void setHwshangbaoList(List<Hwshangbao> hwshangbaoList) {
		this.hwshangbaoList = hwshangbaoList;
	}

	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getCurrPage() {
		return currPage;
	}
	public void setCurrPage(long currPage) {
		this.currPage = currPage;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
}
