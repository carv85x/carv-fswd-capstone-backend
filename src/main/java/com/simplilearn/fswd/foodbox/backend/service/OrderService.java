package com.simplilearn.fswd.foodbox.backend.service;

import java.util.List;

import com.simplilearn.fswd.foodbox.backend.model.Order;

public interface OrderService {
	
	public void createOrder(Order order);
	public Order getOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Order order);
	public List<Order> findByOrderNoByOrderAsc(String orderNo);
	public List<Order> findByOrder_User_Name(String username);	
	public List<Order> findAllWhereOrderStateIsPurchased();
	
}
