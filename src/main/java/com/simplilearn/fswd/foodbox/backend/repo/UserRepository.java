package com.simplilearn.fswd.foodbox.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.fswd.foodbox.backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByUsername(String username);
	public List<User> findByUsernameAndPassword(String username, String password);

}
