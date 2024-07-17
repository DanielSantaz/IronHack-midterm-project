package com.example.Food.repository;


import com.example.Food.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByCaloriesPerGramLessThan(Integer caloriesPerGram);


}
