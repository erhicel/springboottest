package com.apiexample.model.extern;

import java.util.ArrayList;

public class UserResponse {

	List<User> userList = new ArrayList();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
