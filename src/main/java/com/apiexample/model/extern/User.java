package com.apiexample.model.extern;

public class User {

	private Long id;

	private String fullName;

	private String avatar;

	private Long controlNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(Long controlNumber) {
		this.controlNumber = controlNumber;
	}

}
