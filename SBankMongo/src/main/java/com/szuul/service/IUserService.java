package com.szuul.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Update;

import com.szuul.model.User;
import com.szuul.wrapper.UpdateUser;

public interface IUserService {

	public User createUser(User user);
	
	public List<User> readAll();
	
	public User readOne(String Id);
	
	public List<User> delete(String Id);

	public User update(UpdateUser User);
}
