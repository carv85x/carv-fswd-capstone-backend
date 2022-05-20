package com.simplilearn.fswd.foodbox.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.fswd.foodbox.backend.model.Order;
import com.simplilearn.fswd.foodbox.backend.model.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	public List<Order> findByOrderNoByOrderAsc(String orderNo);
	public List<Order> findByOrder_User_Name(String username);
	
	default List<Order> findAllWhereOrderStateIsPurchased() {
        return findByStatus(OrderStatus.PURCHASED);
    }

    public List<Order> findByStatus(OrderStatus status);	
}
