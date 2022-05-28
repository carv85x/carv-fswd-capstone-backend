package com.simplilearn.fswd.foodbox.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fswd.foodbox.backend.model.Admin;
import com.simplilearn.fswd.foodbox.backend.repo.AdminRepository;
import com.simplilearn.fswd.foodbox.backend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository repo;

	@Override
	public void createUser(Admin user) {
		repo.save(user);

	}

	@Override
	public Admin getUser(Admin user) {
		return repo.getById(user.getIdAdmin());
	}

	@Override
	public void updateUser(Admin user) {
		repo.save(user);
	}

	@Override
	public void deleteUser(Admin user) {
		repo.deleteById(user.getIdAdmin());
	}

	@Override
	public List<Admin> findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public List<Admin> findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

}
