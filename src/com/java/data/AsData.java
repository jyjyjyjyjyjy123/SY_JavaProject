package com.java.data;

public class AsData {
	private String code;
	private String reason;
	private String situation;
	private String applicationDay;
	private String completeDay;
	private String userNum;
	public AsData(String code, String reason, String situation, String applicationDay, String completeDay,
			String userNum) {
		super();
		this.code = code;
		this.reason = reason;
		this.situation = situation;
		this.applicationDay = applicationDay;
		this.completeDay = completeDay;
		this.userNum = userNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getApplicationDay() {
		return applicationDay;
	}
	public void setApplicationDay(String applicationDay) {
		this.applicationDay = applicationDay;
	}
	public String getCompleteDay() {
		return completeDay;
	}
	public void setCompleteDay(String completeDay) {
		this.completeDay = completeDay;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	@Override
	public String toString() {
		return "AsData [code=" + code + ", reason=" + reason + ", situation=" + situation + ", applicationDay="
				+ applicationDay + ", completeDay=" + completeDay + ", userNum=" + userNum + "]";
	}
	
}
