package com.example.Food.repository;

import com.example.Food.model.Fridge;
import com.example.Food.model.Item;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FridgeRepositoryTest {

    @Autowired
    FridgeRepository fridgeRepository;

    @Autowired
    ItemRepository itemRepository;

    Fridge fridge;

    @BeforeEach
    void setUp(){




        fridge = new Fridge(1, "Daniel");
        Item item = new Item(4, "Pizza", 10, 300, fridge);
        itemRepository.save(item);
        List<Item> items = new ArrayList<>();
        items.add(item);
        fridge.setItems(items);

        System.out.println(fridge);

    }

    @AfterEach
    void tearDown(){
        fridgeRepository.deleteById(fridge.getId());
        itemRepository.deleteById(4);
    }

}