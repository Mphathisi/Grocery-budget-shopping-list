package com.example.grocerybudgetlist.controller;

import com.example.grocerybudgetlist.controller.request.GroceryRequest;
import com.example.grocerybudgetlist.model.Grocery;
import com.example.grocerybudgetlist.repository.GroceryRepository;
import com.example.grocerybudgetlist.services.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class GroceryBudgetController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/list")
    public ResponseEntity<List<Grocery>> getGroceryList() {
        List<Grocery> groceryList = groceryService.getList();
        return new ResponseEntity<>( groceryList, HttpStatus.OK);
    }

    @PostMapping("/newItem")
    public ResponseEntity<Grocery> saveItem(@RequestBody GroceryRequest groceryRequest) {
        Grocery grocery = groceryService.addItem(groceryRequest.getItem() , groceryRequest.getPrice());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("/", "/" + grocery.getId().toString());
        return new ResponseEntity<>(grocery, httpHeaders, HttpStatus.CREATED);
    }

}
