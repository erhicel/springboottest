package com.apiexample.model.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostApiResponse {

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@Column(name = "user_id")
	private String userId;

	private String message;

	private String upperName;

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUpperName() {
		return upperName;
	}

	public void setUpperName(String upperName) {
		this.upperName = upperName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PostApiResponse [id=" + id + ", userId=" + userId + ", message=" + message + ", upperName=" + upperName
				+ "]";
	}

}
