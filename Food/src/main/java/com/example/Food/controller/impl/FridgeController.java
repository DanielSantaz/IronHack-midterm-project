package com.example.Food.controller.impl;


import com.example.Food.model.Fridge;
import com.example.Food.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FridgeController {

    @Autowired
    FridgeRepository fridgeRepository;

    @GetMapping("/fridges")
    public List<Fridge> getAllFridges() {
        return fridgeRepository.findAll();
    }

    @GetMapping("Fridges/{id}")
    public Fridge getFridgeById(@PathVariable Integer id){
        Optional<Fridge> fridgeOptional = fridgeRepository.findById(id);
        return fridgeOptional.orElse(null);


    }






}
