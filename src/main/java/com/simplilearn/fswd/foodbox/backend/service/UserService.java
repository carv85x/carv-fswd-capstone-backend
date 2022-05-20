package com.simplilearn.fswd.foodbox.backend.service;

import java.util.List;

import com.simplilearn.fswd.foodbox.backend.model.User;

public interface UserService {
	
	public void createUser(User user);
	public User getUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public List<User> findByUsername(String username);
	public List<User> findByUsernameAndPassword(String username, String password);

}
