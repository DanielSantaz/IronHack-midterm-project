package com.example.Food.controller.impl;

import com.example.Food.controller.dto.ItemMassInGramsDTO;
import com.example.Food.model.Item;
import com.example.Food.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/item")
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @GetMapping("/item/cpg")
    public List<Item> getItemByCaloriesPerGramLessThan(@RequestParam(defaultValue = "50")Integer cpg){
        return itemRepository.findAllByCaloriesPerGramLess(cpg);
    }


    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@RequestBody @Valid Item item){
        itemRepository.save(item);

    }


    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@RequestBody @Valid Item item, @PathVariable Integer id){
        Optional<Item> itemOptional= itemRepository.findById(id);
        if (itemOptional.isEmpty()) return;
        itemRepository.save(item);
     }


    @PatchMapping("items/massInGrams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItemMassInGrams(@RequestBody @Valid ItemMassInGramsDTO migDTO, @PathVariable Integer id){
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty()) return;
        Item item = itemOptional.get();
        item.setMassInGrams(migDTO.getMassInGrams());
        itemRepository.save(item);
    }


    @DeleteMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Integer id){
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty()) return;
        itemRepository.deleteById(id);

    }
}
