package com.example.mdbspringboot.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mdbspringboot.model.ProductModel;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {

    Optional<ProductModel> findByName(String name);
}
