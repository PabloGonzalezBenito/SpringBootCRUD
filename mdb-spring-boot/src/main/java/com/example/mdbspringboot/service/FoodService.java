package com.example.mdbspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.FoodModel;
import com.example.mdbspringboot.repository.CustomFoodRepository;
import com.example.mdbspringboot.repository.FoodRepository;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    CustomFoodRepository customRepo;


    // CRUD operations

    public void saveFood( FoodModel food){
        foodRepository.save(food);
    }

    public Optional<FoodModel> findFoodById(String id) {
        return foodRepository.findById(id);
    }

    public List<FoodModel> showAllFoods() {
        return foodRepository.findAll();
    }

    public void deleteFoodById(String id) {
        foodRepository.deleteById(id);
    }

    public void deleteAll(){
        foodRepository.deleteAll();
    }
}
