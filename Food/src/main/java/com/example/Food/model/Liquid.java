package com.example.Food.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Date;
import java.util.Optional;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Liquid extends Item{
    @Column(nullable = true)
    private Optional<Date> expirationDate;


}
