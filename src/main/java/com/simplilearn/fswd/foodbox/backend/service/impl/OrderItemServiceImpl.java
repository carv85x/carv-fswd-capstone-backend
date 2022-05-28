package com.simplilearn.fswd.foodbox.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fswd.foodbox.backend.model.OrderItem;
import com.simplilearn.fswd.foodbox.backend.repo.OrderItemRepository;
import com.simplilearn.fswd.foodbox.backend.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	OrderItemRepository repo;
	
	@Override
	public void createItem(OrderItem item) {
		repo.save(item);
		
	}

	@Override
	public OrderItem getItem(OrderItem item) {
		return repo.getById(item.getIdOrderItem());
		
	}

	@Override
	public void updateItem(OrderItem item) {
		repo.save(item);
		
	}

	@Override
	public void deleteItem(OrderItem item) {
		repo.deleteById(item.getIdOrderItem());
		
	}

	@Override
	public List<OrderItem> findByOrderNo(String orderNo) {
		return repo.findByOrder_OrderNo(orderNo);
		
	}

}
