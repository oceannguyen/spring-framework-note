package com.ocean.beans;

public class Hobby {
	private String hobbyName;
	private int hobbyId;

	public Hobby() {
		super();
	}

	public Hobby(String hobbyName, int hobbyId) {
		super();
		this.hobbyName = hobbyName;
		this.hobbyId = hobbyId;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public int getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}

}
