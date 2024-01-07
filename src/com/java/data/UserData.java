package com.java.data;

public class UserData {
	private String Num;
	private String ID;
	private String PW;
	private String name;
	private String birth;
	private String phone;
	private String bank;
	private String address;
	public UserData(String num, String iD, String pW, String name, String birth, String phone, String bank,
			String address) {
		super();
		Num = num;
		ID = iD;
		PW = pW;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.bank = bank;
		this.address = address;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserData [Num=" + Num + ", ID=" + ID + ", PW=" + PW + ", name=" + name + ", birth=" + birth + ", phone="
				+ phone + ", bank=" + bank + ", address=" + address + "]";
	}
	
}
