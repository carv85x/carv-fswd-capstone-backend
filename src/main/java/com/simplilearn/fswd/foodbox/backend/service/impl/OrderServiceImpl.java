package com.simplilearn.fswd.foodbox.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fswd.foodbox.backend.model.Order;
import com.simplilearn.fswd.foodbox.backend.repo.OrderRepository;
import com.simplilearn.fswd.foodbox.backend.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository repo;
	
	@Override
	public void createOrder(Order order) {
		repo.save(order);
		
	}

	@Override
	public Order getOrder(Order order) {		
		return repo.getById(order.getId());
	}

	@Override
	public void updateOrder(Order order) {
		repo.save(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		repo.deleteById(order.getId());		
	}

	@Override
	public List<Order> findByOrderNoByOrderAsc(String orderNo) {
		return repo.findByOrderNoByOrderAsc(orderNo);
	}

	@Override
	public List<Order> findByOrder_User_Name(String username) {
		return repo.findByOrder_User_Name(username);
	}

	@Override
	public List<Order> findAllWhereOrderStateIsPurchased() {
		return repo.findAllWhereOrderStateIsPurchased();
	}

}
