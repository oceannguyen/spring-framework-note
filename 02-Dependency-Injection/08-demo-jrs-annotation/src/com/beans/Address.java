package com.beans;

import javax.inject.Named;

@Named
public class Address {
	private String cityName;
	private int buildNo;
	private long pinCode;
	
	public Address() {
		 cityName="Mumbai";
		 buildNo=2;
		 pinCode= 412004l;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(int buildNo) {
		this.buildNo = buildNo;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", buildNo=" + buildNo + ", pinCode=" + pinCode + "]";
	}

}
