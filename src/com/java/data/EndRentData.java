package com.java.data;

public class EndRentData {
	private String code;
	private String period;
	private String status;
	private String userNum;
	public EndRentData(String code, String period, String status, String userNum) {
		super();
		this.code = code;
		this.period = period;
		this.status = status;
		this.userNum = userNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	@Override
	public String toString() {
		return "EndRentManage [code=" + code + ", period=" + period + ", status=" + status + ", userNum=" + userNum
				+ "]";
	}

}
