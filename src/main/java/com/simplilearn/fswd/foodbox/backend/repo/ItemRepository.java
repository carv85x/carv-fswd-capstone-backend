package com.simplilearn.fswd.foodbox.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.fswd.foodbox.backend.model.Item;
import com.simplilearn.fswd.foodbox.backend.model.ItemStatus;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	public List<Item> findAllByOrderByNameAsc();
	public List<Item> findByCuisineByOrderByNameAsc(String cuisine);
	public List<Item> findByNameIgnoreCaseContaining(String name);
	public List<Item> findByDescriptionIgnoreCaseContaining(String description);
	
	default List<Item> findAllWhereItemStateIsEnabled() {
        return findByStatus(ItemStatus.ENABLED);
    }

    public List<Item> findByStatus(ItemStatus status);	

	
	@Query("SELECT i FROM ITEM i WHERE i.discount > 0 ORDER BY i.name")
	public List<Item> findAllWithDiscount();
	
	

}
