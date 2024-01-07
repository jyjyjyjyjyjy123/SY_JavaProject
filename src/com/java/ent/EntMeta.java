package com.java.ent;

public class EntMeta {
    private String infoFile;
	private String category;
	private String manageFile;

    public String getInfoFile() {
		return infoFile;
	}
	public void setInfoFile(String infoFile) {
		this.infoFile = infoFile;
	}

    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

    public String getManageFile() {
		return manageFile;
	}
	public void setManageFile(String manageFile) {
		this.manageFile = manageFile;
	}

    public EntMeta(String infoFile, String category, String manageFile) {
		this.infoFile = infoFile;
		this.category = category;
		this.manageFile = manageFile;
	}
}
