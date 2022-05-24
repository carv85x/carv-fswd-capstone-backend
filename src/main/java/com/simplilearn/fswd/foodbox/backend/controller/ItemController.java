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
import com.simplilearn.fswd.foodbox.backend.model.Item;
import com.simplilearn.fswd.foodbox.backend.model.Message;
import com.simplilearn.fswd.foodbox.backend.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService service;

	@PostMapping("/item")
	public ResponseEntity<?> createItem(@RequestBody Item item) {

		service.createItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Item Created", new Gson().toJson(item)), HttpStatus.OK);
	}

	@PutMapping("/item/{id}")
	public ResponseEntity<?> updateItem(@RequestBody Item item) {

		service.updateItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Item Updated", new Gson().toJson(item)), HttpStatus.OK);
	}

	@DeleteMapping("/item/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable int id) {

		Item item = new Item();
		item.setId(id);
		service.deleteItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Item Deleted", new Gson().toJson(item)), HttpStatus.OK);
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<?> getItem(@PathVariable int id) {

		Item item = new Item();
		item.setId(id);
		item = service.getItem(item);

		return new ResponseEntity<>(new Message(HttpStatus.OK, "Item Fetched", new Gson().toJson(item)), HttpStatus.OK);
	}

	@GetMapping("/items")
	public ResponseEntity<?> findAllByOrderByNameAsc() {
		return new ResponseEntity<>(
				new Message(HttpStatus.OK, "Items Fetched", new Gson().toJson(service.findAllByOrderByNameAsc())),
				HttpStatus.OK);
	}

	@GetMapping("/items/cuisine/{cuisine}")
	public ResponseEntity<?> findByCuisineByOrderByNameAsc(@PathVariable String cuisine) {
		return new ResponseEntity<>(new Message(HttpStatus.OK, "Items Fetched",
				new Gson().toJson(service.findByCuisineByOrderByNameAsc(cuisine))), HttpStatus.OK);
	}

	@GetMapping("/items/name/{name}")
	public ResponseEntity<?> findByNameIgnoreCaseContaining(@PathVariable String name) {
		return new ResponseEntity<>(new Message(HttpStatus.OK, "Items Fetched",
				new Gson().toJson(service.findByNameIgnoreCaseContaining(name))), HttpStatus.OK);
	}

	@GetMapping("/items/desc/{desc}")
	public ResponseEntity<?> findByDescriptionIgnoreCaseContaining(@PathVariable String desc) {
		return new ResponseEntity<>(new Message(HttpStatus.OK, "Items Fetched",
				new Gson().toJson(service.findByDescriptionIgnoreCaseContaining(desc))), HttpStatus.OK);
	}

	@GetMapping("/items/enabled")
	public ResponseEntity<?> findAllWhereItemStateIsEnabled() {
		return new ResponseEntity<>(new Message(HttpStatus.OK, "Items Fetched",
				new Gson().toJson(service.findAllWhereItemStateIsEnabled())), HttpStatus.OK);
	}

	@GetMapping("/items/discount")
	public ResponseEntity<?> findAllWithDiscount() {
		return new ResponseEntity<>(
				new Message(HttpStatus.OK, "Items Fetched", new Gson().toJson(service.findAllWithDiscount())),
				HttpStatus.OK);
	}

}
