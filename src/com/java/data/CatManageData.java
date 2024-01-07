package com.java.data;

public class CatManageData {
	private String code;
	private String minday;
	private String cycle;
	private String money;
	public CatManageData(String code, String minday, String cycle, String money) {
		super();
		this.code = code;
		this.minday = minday;
		this.cycle = cycle;
		this.money = money;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMinday() {
		return minday;
	}
	public void setMinday(String minday) {
		this.minday = minday;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "CategoryManageData [code=" + code + ", minday=" + minday + ", cycle=" + cycle + ", money=" + money
				+ "]";
	}
	
	
}
