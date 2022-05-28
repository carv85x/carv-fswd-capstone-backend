package com.simplilearn.fswd.foodbox.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.fswd.foodbox.backend.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	public List<OrderItem> findByOrder_OrderNo(String orderNo);

}
