package com.simplilearn.fswd.foodbox.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fswd.foodbox.backend.model.User;
import com.simplilearn.fswd.foodbox.backend.repo.UserRepository;
import com.simplilearn.fswd.foodbox.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public void createUser(User user) {
		repo.save(user);
	}

	@Override
	public User getUser(User user) {
		return repo.getById(user.getIdUser());
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);

	}

	@Override
	public void deleteUser(User user) {
		repo.deleteById(user.getIdUser());

	}
	
	@Override
	public List<User> findByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	@Override
	public List<User> findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}



}
