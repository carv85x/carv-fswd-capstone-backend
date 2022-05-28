package com.simplilearn.fswd.foodbox.backend.service;

import java.util.List;

import com.simplilearn.fswd.foodbox.backend.model.OrderItem;

public interface OrderItemService {

	public void createItem(OrderItem item);
	public OrderItem getItem(OrderItem item);
	public void updateItem(OrderItem item);
	public void deleteItem(OrderItem item);
	public List<OrderItem> findByOrderNo(String orderNo);
	
}
