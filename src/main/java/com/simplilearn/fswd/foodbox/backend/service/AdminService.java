package com.simplilearn.fswd.foodbox.backend.service;

import java.util.List;

import com.simplilearn.fswd.foodbox.backend.model.Admin;

public interface AdminService {
	
	public void createUser(Admin user);
	public Admin getUser(Admin user);
	public void updateUser(Admin user);
	public void deleteUser(Admin user);
	public List<Admin> findByUsername(String username);
	public List<Admin> findByUsernameAndPassword(String username, String password);

}
