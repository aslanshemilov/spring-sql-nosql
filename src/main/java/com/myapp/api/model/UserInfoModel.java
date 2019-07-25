package com.myapp.api.model;

import java.util.List;

public class UserInfoModel {
	private int userId;
	private String name;
	private String emailAddress;
	private List<TechnologyModel> technologies;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public List<TechnologyModel> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<TechnologyModel> technologies) {
		this.technologies = technologies;
	}
	

}
