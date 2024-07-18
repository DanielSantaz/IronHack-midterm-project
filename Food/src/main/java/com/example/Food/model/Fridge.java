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
    private String owner;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;


    public Fridge(Integer id, String owner, List<Item> items) {
        this.id = id;
        this.owner = owner;
        this.items = items;
    }

    public Fridge(int i, String name) {
        id = i;
        owner = name;
    }


    @Override
    public String toString() {
        return "Fridge{" +
                "id=" + id +
                ", Owner='" + owner + '\'' +
                ", items=" + items +
                '}';
    }
}
