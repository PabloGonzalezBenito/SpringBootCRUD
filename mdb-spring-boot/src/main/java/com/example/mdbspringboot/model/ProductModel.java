package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class ProductModel {
    @Id
    private String id;
    private String name;
    private String category;
    private String measurementUnit;

    public ProductModel() {

    }

    public ProductModel(String id, String name, String category, String measurementUnit) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.measurementUnit = measurementUnit;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
