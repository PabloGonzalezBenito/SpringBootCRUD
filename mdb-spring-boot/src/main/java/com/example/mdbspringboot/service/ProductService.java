package com.example.mdbspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.ProductModel;
import com.example.mdbspringboot.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void saveProduct(ProductModel product) {
        if (product.getName() != null && !product.getName().trim().isEmpty() && 
        product.getCategory() != null && !product.getCategory().trim().isEmpty() && 
        product.getMeasurementUnit() != null && !product.getMeasurementUnit().trim().isEmpty()) {

            productRepository.save(product);
        }
    }

    public Optional<ProductModel> findProductById(String id) {
        return productRepository.findById(id);
    }

    public List<ProductModel> showAllProducts() {
        // Definir el tipo de ordenamiento (ascendente) por el campo 'name'
        Sort sortByName = Sort.by("name").ascending();

        // Utilizar el método findAll() del repositorio con el ordenamiento aplicado
        return productRepository.findAll(sortByName);
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

}
