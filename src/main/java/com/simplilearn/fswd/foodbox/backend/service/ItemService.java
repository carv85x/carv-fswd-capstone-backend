package com.simplilearn.fswd.foodbox.backend.service;

import java.util.List;

import com.simplilearn.fswd.foodbox.backend.model.Item;

public interface ItemService {
	
	public void createItem(Item item);
	public Item getItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
	public List<Item> findAllByOrderByNameAsc();
	public List<Item> findByCuisineByOrderByNameAsc(String cuisine);
	public List<Item> findByNameIgnoreCaseContaining(String name);
	public List<Item> findByDescriptionIgnoreCaseContaining(String description);	
	public List<Item> findAllWhereItemStateIsEnabled();	
	public List<Item> findAllWithDiscount();

}
