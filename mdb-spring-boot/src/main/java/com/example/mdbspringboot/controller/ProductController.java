package com.example.mdbspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.mdbspringboot.model.ProductModel;
import com.example.mdbspringboot.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        List<ProductModel> products = productService.showAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("product", new ProductModel());
        return "addProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute ProductModel product) {

        productService.saveProduct(product);
        return "redirect:/addProduct";
    }

    @GetMapping("/delete/product/{id}")
    public String deleteProduct(@PathVariable String id) {

        productService.deleteProductById(id);
        return "redirect:/addProduct";
    }

}
