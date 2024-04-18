package com.example.mdbspringboot.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mdbspringboot.model.FoodModel;

@Repository
public interface FoodRepository extends MongoRepository<FoodModel, String> {

    Optional<FoodModel> findByName(String name);
}
