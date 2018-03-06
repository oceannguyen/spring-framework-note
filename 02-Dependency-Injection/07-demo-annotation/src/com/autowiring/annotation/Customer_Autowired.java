package com.autowiring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.beans.Address;

@Component
public class Customer_Autowired {
	private String custName;
	private int custId;

	@Autowired
	@Qualifier("address")
	private Address custAddress;

	public Customer_Autowired() {
		super();
		custId = 10;
		custName = "my name";
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
		return "Customer_Component [custName=" + custName + ", custId=" + custId + ", custAddress=" + custAddress + "]";
	}

}
