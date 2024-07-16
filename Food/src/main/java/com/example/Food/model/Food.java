package com.example.Food.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Food extends Item{


    private Date expirationDate;


    public Food(){}

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
