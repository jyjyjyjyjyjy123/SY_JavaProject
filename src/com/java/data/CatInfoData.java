package com.java.data;

public class CatInfoData {
	private String code;
	private String categoryName;
	private String entName;
	private String itemName;
	private String itemCode;
	private String color;
	private String status;
	public CatInfoData(String code, String categoryName, String entName, String itemName, String itemCode,
			String color, String status) {
		super();
		this.code = code;
		this.categoryName = categoryName;
		this.entName = entName;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.color = color;
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CategoryData [code=" + code + ", categoryName=" + categoryName + ", entName=" + entName + ", itemName="
				+ itemName + ", itemCode=" + itemCode + ", color=" + color + ", status=" + status + "]";
	}
	
}
