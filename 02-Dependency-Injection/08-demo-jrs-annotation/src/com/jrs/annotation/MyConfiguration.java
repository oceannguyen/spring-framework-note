package com.jrs.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.Address;
import com.beans.Customer;

@Configuration
public class MyConfiguration {

	@Bean(name = "myCustomer")
	public Customer myCustomer(Address address) {
		Customer customer = new Customer();
		customer.setCustName("name by config");
		customer.setCustAddress(address);
		return customer;
	}

}
