package com.example.Food.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Date;
import java.util.Optional;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Liquid extends Item{

    @Column(nullable = true)
    private Date expirationDate;
    private String container;


    public Liquid(){}

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }
}
