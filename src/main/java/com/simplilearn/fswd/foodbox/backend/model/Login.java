package com.simplilearn.fswd.foodbox.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
	
	private String username;
	private String password;
	
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
