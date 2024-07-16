package com.example.Food.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Owner;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;


    public Fridge(Integer id, String owner, List<Item> items) {
        this.id = id;
        Owner = owner;
        this.items = items;
    }
}
