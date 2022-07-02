package com.example.grocerybudgetlist.repository;

import com.example.grocerybudgetlist.model.Grocery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends CrudRepository<Grocery, Long> {
}
