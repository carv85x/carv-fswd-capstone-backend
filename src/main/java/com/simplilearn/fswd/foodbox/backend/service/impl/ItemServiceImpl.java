package com.simplilearn.fswd.foodbox.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fswd.foodbox.backend.model.Item;
import com.simplilearn.fswd.foodbox.backend.repo.ItemRepository;
import com.simplilearn.fswd.foodbox.backend.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository repo;

	@Override
	public void createItem(Item item) {
		repo.save(item);
	}

	@Override
	public Item getItem(Item item) {
		return repo.getById(item.getId());
	}

	@Override
	public void updateItem(Item item) {
		repo.save(item);

	}

	@Override
	public void deleteItem(Item item) {
		repo.save(item);

	}

	@Override
	public List<Item> findAllByOrderByNameAsc() {
		return repo.findAllByOrderByNameAsc();
	}

	@Override
	public List<Item> findByCuisineByOrderByNameAsc(String cuisine) {
		return repo.findByCuisineByOrderByNameAsc(cuisine);
	}

	@Override
	public List<Item> findByNameIgnoreCaseContaining(String name) {
		return repo.findByNameIgnoreCaseContaining(name);
	}

	@Override
	public List<Item> findByDescriptionIgnoreCaseContaining(String description) {
		return repo.findByDescriptionIgnoreCaseContaining(description);
	}

	@Override
	public List<Item> findAllWhereItemStateIsEnabled() {
		return repo.findAllWhereItemStateIsEnabled();
	}

	@Override
	public List<Item> findAllWithDiscount() {
		return repo.findAllWithDiscount();
	}

}
