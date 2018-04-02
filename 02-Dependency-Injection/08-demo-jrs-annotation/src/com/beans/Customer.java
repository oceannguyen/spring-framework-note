package com.beans;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Customer {
	private String custName;
	private int custId;

	@Inject
	private Address custAddress;

	public Customer() {
		super();
		custId = 10;
		custName = "customer name";
	}

	public Customer(String custName, int custId, Address custAddress) {
		super();
		this.custName = custName;
		this.custId = custId;
		this.custAddress = custAddress;
	}

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
		return "Customer [custName=" + custName + ", custId=" + custId + ", custAddress=" + custAddress + "]";
	}

}
