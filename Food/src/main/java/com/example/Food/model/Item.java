package com.example.Food.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer calories;
    private Integer massInGrams;

    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    public Item(Integer id, String name, Integer calories, Integer massInGrams) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.massInGrams = massInGrams;
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getMassInGrams() {
        return massInGrams;
    }

    public void setMassInGrams(Integer massInGrams) {
        this.massInGrams = massInGrams;
    }
}
