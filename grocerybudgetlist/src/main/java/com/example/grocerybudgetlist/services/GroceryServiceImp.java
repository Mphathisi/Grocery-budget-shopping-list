package com.example.grocerybudgetlist.services;

import com.example.grocerybudgetlist.model.Grocery;
import com.example.grocerybudgetlist.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GroceryServiceImp implements GroceryService{
    @Autowired
    private GroceryRepository groceryRepository;
    @Override
    public List<Grocery> getList() {
        List<Grocery> groceryList = new ArrayList<>();
        groceryRepository.findAll().forEach(groceryList::add);
        return groceryList;
    }

    @Override
    public Grocery getListById(Long id) {

       return groceryRepository.findById(id).get();
    }

    @Override
    public void addItem(String item, BigDecimal price) {
        Grocery grocery = new Grocery();
        BigDecimal zero = new BigDecimal(0);

        if(grocery.getBudget() == null || Objects.equals(grocery.getBudget() ,zero)){
             grocery.setBudget(zero);
             //don't save since the user does not have balance  at the moment
        }
        else {
            if(grocery.getBudget() !=null && !Objects.equals(grocery.getBudget(), zero)){
                 BigDecimal newBalance  = grocery.getBudget().subtract(price);
                 grocery.setBudget(newBalance);
                 groceryRepository.save(grocery);
            }
        }

    }


    @Override
    public void updateList(Long id, Grocery grocery) {

        Grocery grocery1 = groceryRepository.findById(id).get();
        System.out.println(grocery1.toString());
        grocery1.setItem(grocery.getItem());
        grocery1.setPrice(grocery.getPrice());
        grocery1.setBudget(grocery.getBudget());
        groceryRepository.save(grocery);

    }

    @Override
    public void deleteItem(Long groceryItem) {
        groceryRepository.deleteById(groceryItem);
    }

    @Override
    public void addBudget(BigDecimal budget) {
        Grocery grocery = new Grocery();
        BigDecimal zero = new BigDecimal(0);
        if(grocery.getBudget().equals(zero)){
            grocery.setBudget(zero);
            groceryRepository.save(grocery);
        }
        else{
            if(grocery.getBudget() !=null && !Objects.equals(grocery.getBudget() , zero)){
               BigDecimal newBudgetAmount = grocery.getBudget().add(budget);
               grocery.setBudget(newBudgetAmount);
               groceryRepository.save(grocery);
            }
        }
    }

    @Override
    public BigDecimal totalAmount(BigDecimal price, BigDecimal budgetAmount) {
        return null;
    }
}
