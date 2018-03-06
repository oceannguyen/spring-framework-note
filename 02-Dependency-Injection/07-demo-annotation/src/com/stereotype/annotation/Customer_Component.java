package com.stereotype.annotation;

import org.springframework.stereotype.Component;

import com.beans.Address;

@Component
public class Customer_Component {
	private String custName;
	private int custId;
	private Address custAddress;

	public Customer_Component() {
		custId = 100;
		custName = "cust_name";
		custAddress = new Address();
		custAddress.setBuildNo(2);
		custAddress.setCityName("Delhi");
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
