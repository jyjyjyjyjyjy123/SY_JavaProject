package com.java.data;

public class RentData {
	private String code;
	private String period;
	private String status;
	private String days;
	private String nextVisit;
	private String userNum;
	public RentData(String code, String period, String status, String days, String nextVisit, String userNum) {
		super();
		this.code = code;
		this.period = period;
		this.status = status;
		this.days = days;
		this.nextVisit = nextVisit;
		this.userNum = userNum;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
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
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getNextVisit() {
		return nextVisit;
	}
	public void setNextVisit(String nextVisit) {
		this.nextVisit = nextVisit;
	}
	@Override
	public String toString() {
		return "RentManage [code=" + code + ", period=" + period + ", status=" + status + ", days=" + days
				+ ", nextVisit=" + nextVisit + ", userNum=" + userNum + "]";
	}
	
}
