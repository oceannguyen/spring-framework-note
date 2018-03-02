package com.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car_API_Init implements InitializingBean, DisposableBean {
	private String chassisNumber, color, fuelType;
	private long price;
	private double average;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing the car through API");
		price = (long) (price + (price * 0.30));
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Demolishing the car through API");
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Car_Custom_Init [chassisNumber=" + chassisNumber + ", color=" + color + ", fuelType=" + fuelType
				+ ", price=" + price + ", average=" + average + "]";
	}
}
