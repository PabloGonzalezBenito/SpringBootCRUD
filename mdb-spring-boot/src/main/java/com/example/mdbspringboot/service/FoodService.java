package com.example.mdbspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public void saveFood(FoodModel food) {
        // Verificar si ya existe un registro con el mismo nombre en la base de datos
        Optional<FoodModel> existingFoodOptional = foodRepository.findByName(food.getName());
        if (food.getName() != null && !food.getName().trim().isEmpty()) {
            food.setName(food.getName().toLowerCase());
            if (food.getQuantity() == null) {
                food.setQuantity(1);
            }
            if (existingFoodOptional.isPresent()) {
                // Si existe un registro con el mismo nombre, actualizar la cantidad del
                // registro existente
                FoodModel existingFood = existingFoodOptional.get();
                existingFood.setQuantity(food.getQuantity());
                existingFood.setName(existingFood.getName().toLowerCase());
                foodRepository.save(existingFood);
            } else {
                // Si no existe un registro con el mismo nombre, guardar un nuevo registro
                foodRepository.save(food);
            }
        }
    }

    public Optional<FoodModel> findFoodById(String id) {
        return foodRepository.findById(id);
    }

    public List<FoodModel> showAllFoods() {
        // Definir el tipo de ordenamiento (ascendente) por el campo 'name'
        Sort sortByName = Sort.by("name").ascending();

        // Utilizar el método findAll() del repositorio con el ordenamiento aplicado
        return foodRepository.findAll(sortByName);
    }

    public void deleteFoodById(String id) {
        foodRepository.deleteById(id);
    }

    public void deleteAll() {
        foodRepository.deleteAll();
    }
}
