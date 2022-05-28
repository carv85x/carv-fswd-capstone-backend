package com.simplilearn.fswd.foodbox.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERITEM")
@Getter
@Setter
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderitem_id")
	private int idOrderItem;
	
	@NaturalId
	private String orderitemNo;
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "idOrder", nullable = false)
	private Order order;
	
	@NotBlank
	@OneToOne
	@JoinColumn(name = "idItem", nullable = false)
	private Item item;
	
	@NotBlank
	private int qty;

}
