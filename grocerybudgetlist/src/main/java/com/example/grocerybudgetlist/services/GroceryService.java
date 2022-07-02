package com.example.grocerybudgetlist.services;

import com.example.grocerybudgetlist.model.Grocery;

import java.math.BigDecimal;
import java.util.List;

public interface GroceryService {
    List<Grocery> getList();
    Grocery getListById(Long id);

    void addItem(String item, BigDecimal price);
    void updateList(Long id, Grocery grocery);
    void deleteItem(Long groceryItem);
    void addBudget(BigDecimal budget);
    BigDecimal totalAmount(BigDecimal price,BigDecimal budgetAmount);

}
