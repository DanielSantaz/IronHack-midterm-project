package com.example.Food.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer caloriesPerGram;
    private Integer massInGrams;


    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;


    public Item(int i, String name, int i1, int i2) {
        id = i;
        this.name = name;
        caloriesPerGram = i1;
        massInGrams = i2;

    }
}
