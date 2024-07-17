package com.example.Food.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Item needs a name")
    private String name;
    @Max(value = 10, message = "foods cannot have more than 10 calories per gram.")
    @Min(value = 0)
    private Integer caloriesPerGram;
    @Min(value = 1)
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
