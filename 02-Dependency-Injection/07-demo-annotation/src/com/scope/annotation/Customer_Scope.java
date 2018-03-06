package com.scope.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.beans.Address;

@Component
@Scope(scopeName = "prototype")
public class Customer_Scope {
	private String custName;
	private int custId;

	@Autowired
	@Qualifier("cust_address")
	private Address address;

	public Customer_Scope() {
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

	@Override
	public String toString() {
		return "Customer_Scope [custName=" + custName + ", custId=" + custId + ", address=" + address + "]";
	}

}
