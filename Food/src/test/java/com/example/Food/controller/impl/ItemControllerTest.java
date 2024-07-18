package com.example.Food.controller.impl;

import com.example.Food.model.Fridge;
import com.example.Food.model.Item;
import com.example.Food.repository.FridgeRepository;
import com.example.Food.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ItemControllerTest {


    @Autowired
    ItemRepository itemRepository;
    //need to create a mock client to make the request.
    @Autowired
    FridgeRepository fridgeRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    //Transform responses to something that the testing engine can understand.
    ObjectMapper objectMapper = new ObjectMapper();

    Item item;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Optional<Fridge> fridgeOptional = fridgeRepository.findById(1);


        assertTrue(fridgeOptional.isPresent());
        Item item = new Item(2, "apple", 1, 150, fridgeOptional.get());
    }

    @AfterEach
    void tearDown() {
        itemRepository.deleteById(2);
    }

    @Test
    void getAllItems_validRequest_allItems() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("pizza"));

    }

    @Test
    void getItemByCaloriesPerGramLessThan() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    @Test
    void getByItemId_InvalidRequest_NotFound() throws Exception {
        mockMvc.perform(get("/api/items/123123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void saveItem() throws Exception {
        String body = objectMapper.writeValueAsString(item);

        mockMvc.perform(post("/api/items").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        assertTrue(itemRepository.findAll().toString().contains("apple"));


    }


}