package com.beans;

import java.util.Properties;

public class Country {
	private String name;
	private String continent;
	private Properties stateCapitals;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Properties getStateCapitals() {
		return stateCapitals;
	}

	public void setStateCapitals(Properties stateCapitals) {
		this.stateCapitals = stateCapitals;
	}
	
	public void printStateCapitals() {
		for(String state: stateCapitals.stringPropertyNames()) {
			System.out.println(state + "\t" + stateCapitals.getProperty(state));
		}
	}

}
