package com.simplilearn.fswd.foodbox.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.simplilearn.fswd.foodbox.backend.model.Message;
import com.simplilearn.fswd.foodbox.backend.model.Order;
import com.simplilearn.fswd.foodbox.backend.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {

		service.createOrder(order);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Created", new Gson().toJson(order)),
				HttpStatus.OK);
	}

	@PutMapping("/order/{id}")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) {

		service.updateOrder(order);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Updated", new Gson().toJson(order)),
				HttpStatus.OK);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable int id) {

		Order order = new Order();
		order.setId(id);
		service.deleteOrder(order);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Deleted", new Gson().toJson(order)),
				HttpStatus.OK);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrder(@PathVariable int id) {

		Order order = new Order();
		order.setId(id);
		order = service.getOrder(order);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Fetched", new Gson().toJson(order)), HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<?> findAllWhereOrderStateIsPurchased() {
		return new ResponseEntity<>(
				new Message(HttpStatus.OK, "Orders Fetched", new Gson().toJson(service.findAllWhereOrderStateIsPurchased())),
				HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<?> findByOrderNoByOrderAsc(@PathVariable String orderNo) {
		return new ResponseEntity<>(
				new Message(HttpStatus.OK, "Orders Fetched", new Gson().toJson(service.findByOrderNoByOrderAsc(orderNo))),
				HttpStatus.OK);
	}	
	
	@GetMapping("/orders")
	public ResponseEntity<?> findByOrder_User_Name(@PathVariable String username) {
		return new ResponseEntity<>(
				new Message(HttpStatus.OK, "Orders Fetched", new Gson().toJson(service.findByOrder_User_Name(username))),
				HttpStatus.OK);
	}

}
