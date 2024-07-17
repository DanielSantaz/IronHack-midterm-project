package com.example.Food.controller.dto;


import jakarta.validation.constraints.Min;

public class ItemMassInGramsDTO {

    @Min(value = 1)
    private Integer massInGrams;


    public Integer getMassInGrams() {
        return massInGrams;
    }
}
