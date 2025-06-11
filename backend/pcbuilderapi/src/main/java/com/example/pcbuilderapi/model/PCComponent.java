package com.example.pcbuilderapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PCComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String brand;
    private double price;

    @Column(length = 1024)
    private String imageUrl;

    public PCComponent(){}


    public PCComponent(String name, String type, String brand, double price, String imageUrl){
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
    public String getBrand(){
        return brand;
    }
    public double getPrice(){
        return price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setBrand(String brand){
            this.brand = brand;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
