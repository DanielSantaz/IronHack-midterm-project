package com.example.Food.repository;

import com.example.Food.model.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FridgeRepository extends JpaRepository<Integer, Fridge>{


}
