package com.beans;

public class Customer {
	private String custName;
	private String custId;
	private boolean secondHanded;
	private double prodPrice;
	private String prodName;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public boolean isSecondHanded() {
		return secondHanded;
	}

	public void setSecondHanded(boolean secondHanded) {
		this.secondHanded = secondHanded;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custId=" + custId + ", secondHanded=" + secondHanded
				+ ", prodPrice=" + prodPrice + ", prodName=" + prodName + "]";
	}

}
