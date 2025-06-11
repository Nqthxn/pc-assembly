package com.example.pcbuilderapi.dto;

public class ComponentRequestDTO {
    private String name;
    private String type;
    private String brand;
    private double price;
    private String imageUrl;

    public ComponentRequestDTO(){}
    
    public ComponentRequestDTO(String name, String type, String brand, double price, String imageUrl){
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
