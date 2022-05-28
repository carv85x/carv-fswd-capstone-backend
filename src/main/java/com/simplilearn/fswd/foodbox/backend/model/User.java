package com.simplilearn.fswd.foodbox.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER") 
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int idUser;
	
	@NaturalId
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
    @OneToMany(mappedBy = "user")
	private Set<Order> orders;
    
	
}
