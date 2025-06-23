package com.kainmvc.orm.entity;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String manufacture;
    private double price;

    public Product(){

    }
    public Product(int id, String name, String description, String manufacture, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacture = manufacture;
        this.price = price;
    }
    public Product(String name, String description, String manufacture, double price) {
        this.name = name;
        this.description = description;
        this.manufacture = manufacture;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
