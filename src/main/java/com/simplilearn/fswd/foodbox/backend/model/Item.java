package com.simplilearn.fswd.foodbox.backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ITEM") 
@Getter
@Setter
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NaturalId
	private String name;
	
	@NotBlank
	private String cuisine;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private double price;
	
	@NotBlank
	private int discount;
	
	@NotBlank
	private String img;
	
	@NotBlank
	@ManyToMany(mappedBy = "likedCourses")
	private Set<Order> orders;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private ItemStatus status;

}
