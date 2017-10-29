package com.apiexample.model.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class UserApiResponse {

	@Column(name = "data")
	private List<UserApi> data = new ArrayList<UserApi>();

	public List<UserApi> getData() {
		return data;
	}

	public void setData(List<UserApi> data) {
		this.data = data;
	}

}
