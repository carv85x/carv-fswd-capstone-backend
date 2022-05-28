package com.simplilearn.fswd.foodbox.backend.controller;

import java.util.List;

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
import com.simplilearn.fswd.foodbox.backend.model.OrderItem;
import com.simplilearn.fswd.foodbox.backend.service.OrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
	
	@Autowired
	OrderItemService service;
	
	@PostMapping("/orderitem")
	public ResponseEntity<?> createItem(@RequestBody OrderItem item) {

		service.createItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Item Created", new Gson().toJson(item)), HttpStatus.OK);
	}

	@PutMapping("/orderitem/{id}")
	public ResponseEntity<?> updateItem(@RequestBody OrderItem item) {

		service.updateItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Item Updated", new Gson().toJson(item)), HttpStatus.OK);
	}

	@DeleteMapping("/orderitem/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable int id) {

		OrderItem item = new OrderItem();
		item.setIdOrderItem(id);
		service.deleteItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Item Deleted", new Gson().toJson(item)), HttpStatus.OK);
	}

	@GetMapping("/orderitem/{id}")
	public ResponseEntity<?> getItem(@PathVariable int id) {

		OrderItem item = new OrderItem();
		item.setIdOrderItem(id);
		item = service.getItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Order Item Fetched", new Gson().toJson(item)), HttpStatus.OK);
	}

	@GetMapping("/orderitems/{orderno}")
	public ResponseEntity<?> findByOrderNo(@PathVariable String orderNo) {
		return new ResponseEntity<>(
				new Message(HttpStatus.OK, "Order Items Fetched", new Gson().toJson(service.findByOrderNo(orderNo))),
				HttpStatus.OK);
	}

}
