package com.beans;

public class Customer_Reference {
	private String custName;
	private int custId;
	private Address custAddress;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Address getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer_Reference [custName=" + custName + ", custId=" + custId + ", custAddress=" + custAddress + "]";
	}

}
