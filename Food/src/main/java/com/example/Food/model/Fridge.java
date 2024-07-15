package com.example.Food.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private List<Item> items;

    public Fridge() {

    }
}
