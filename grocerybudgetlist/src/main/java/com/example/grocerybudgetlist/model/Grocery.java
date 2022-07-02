package com.example.grocerybudgetlist.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Grocery {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    @Column
    String item;
    @Column
    BigDecimal budget;
    @Column
    BigDecimal price;
}
