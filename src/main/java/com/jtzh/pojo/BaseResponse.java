package com.jtzh.pojo;

import com.jtzh.common.Constants;

public class BaseResponse<T> {
	private Integer statusCode;
	private String statusMsg;
	private T responseData;
	private boolean isOk;
	private int total;
	public BaseResponse() {
			this.isOk = Constants.IS_DELETE;
	        this.statusCode = Constants.RESPONSE_STATUS_CODE_SUCCESS;
	        this.statusMsg = Constants.RESPONSE_STATUS_MSG_SUCCESS;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public T getResponseData() {
		return responseData;
	}
	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
