package com.example.Food.controller.impl;

import com.example.Food.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ItemControllerTest {

    //need to create a mock client to make the request.

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    //Transform responses to something that the testing engine can understand.
    ObjectMapper objectMapper = new ObjectMapper();

    Item item;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Item item = new Item();
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
    void saveItem() {
        mockMvc.perform(save("/api/items/123123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void updateItem() {
    }

    @Test
    void updateItemMassInGrams() {
    }

    @Test
    void deleteItem() {
    }
}