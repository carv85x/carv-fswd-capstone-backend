package com.simplilearn.fswd.foodbox.backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
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
	@Column(name = "item_id")
	private int idItem;
	
	@NaturalId
	private String name;
	
	@NotBlank
	private String cuisine;
	
	@NotBlank
	private String description;
	
	private double price;	

	private int discount;
	
	@NotBlank
	private String img;
	
	@OneToOne(mappedBy = "item")
	private OrderItem orderItem;
	
	@Enumerated(EnumType.STRING)
	private ItemStatus status;

}
