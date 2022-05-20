package com.simplilearn.fswd.foodbox.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.fswd.foodbox.backend.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public List<Admin> findByUsername(String username);
	public List<Admin> findByUsernameAndPassword(String username, String password);

}
