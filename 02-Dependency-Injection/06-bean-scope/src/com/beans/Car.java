package com.beans;

public class Car {
	private String chassisNumber, color, fuelType;
	private long price;
	private double average;
	
	public String getChassisNumber() {
		return chassisNumber;
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
		return "Car [chassisNumber=" + chassisNumber + ", color=" + color + ", fuelType=" + fuelType + ", price="
				+ price + ", average=" + average + "]";
	}
}
