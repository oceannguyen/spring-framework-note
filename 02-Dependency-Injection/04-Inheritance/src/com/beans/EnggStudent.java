package com.beans;

public class EnggStudent extends Student {
	private String branchCode;
	private String collegeCode;

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	@Override
	public String toString() {
		return "EnggStudent [branchCode=" + branchCode + ", collegeCode=" + collegeCode + "]";
	}

}
