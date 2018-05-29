package com.szuul.wrapper;

import com.szuul.model.User;

public class UpdateUser {

	String Id;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	User user;
}
