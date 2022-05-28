package com.simplilearn.fswd.foodbox.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int idOrder;

	@NaturalId
	private String orderNo;

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@NotBlank
	@OneToMany(mappedBy = "idOrderItem")	
	private Set<OrderItem> items;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
}
