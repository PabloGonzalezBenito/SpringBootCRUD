package com.example.mdbspringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mdbspringboot.model.FoodModel;
import com.example.mdbspringboot.service.FoodService;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    List<FoodModel> foodList = new ArrayList<FoodModel>();

    @GetMapping("/")
    public String index(Model model) {
        foodList = foodService.showAllFoods();
        model.addAttribute("foods", foodList);
        return "index";
    }

    /*
     * Renderizar vista "add.html" y pasarle una instancia de Food
     */
    @GetMapping("/add")
    public String showFoodForm(@RequestParam(required = false) String id, Model model) {
        FoodModel food = new FoodModel();

        // Si se proporciona un ID, obtener la comida correspondiente para edición
        if (id != null && !id.isEmpty()) {
            Optional<FoodModel> foodOptional = foodService.findFoodById(id);
            if (foodOptional.isPresent()) {
                food = foodOptional.get();
            }
        }

        model.addAttribute("food", food);
        return "add";
    }

    /*
     * Recibir objeto a partir de los campos del formulario y enviarlo a la BD.
     * Después redirigir a "index.html"
     */
    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute FoodModel food, Model model) {
        
        foodService.saveFood(food);

        return "redirect:/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteFoodById(@PathVariable String id) {
        foodService.deleteFoodById(id);
        return "redirect:/";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        foodService.deleteAll();
        return "redirect:/";
    }
}