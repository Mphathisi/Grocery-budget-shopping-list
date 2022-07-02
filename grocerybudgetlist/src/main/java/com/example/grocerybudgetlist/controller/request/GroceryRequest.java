package com.example.grocerybudgetlist.controller.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class GroceryRequest {
    private String item;
    private BigDecimal price;
}
