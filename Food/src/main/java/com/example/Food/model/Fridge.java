package com.example.Food.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    public Fridge() {

    }

    public Fridge(List<Item> items, Integer id) {
        this.items = items;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
