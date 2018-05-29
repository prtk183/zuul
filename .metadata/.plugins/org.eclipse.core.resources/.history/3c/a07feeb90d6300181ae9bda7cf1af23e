package com.sbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.sbank.model.User;
import com.sbank.repository.UserRepository;
import com.sbank.wrapper.UpdateUser;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		User users= userRepository.save(user);
		return users;
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public User update(UpdateUser user) {
		// TODO Auto-generated method stub
		User user3 =(User) userRepository.findById(user.getUser().getId()).get();
		user3.setAge(user.getUser().getAge());
    	user3.setEmail(user.getUser().getEmail());
    	user3.setName(user.getUser().getName());
    	user3.setId(user.getId());
		return userRepository.save(user3);
	}

	@Override
	public List<User> delete(String Id) {
		// TODO Auto-generated method stub
		User entity = (User) userRepository.findById(Id).get();
    	userRepository.delete(entity.getId());
    	//userRepository.deleteById(Id);
    	
		return userRepository.findAll();
	}

	@Override
	public User readOne(String Id) {
		User user = (User) userRepository.findById(Id).get();
		
		return user;
	}

}
