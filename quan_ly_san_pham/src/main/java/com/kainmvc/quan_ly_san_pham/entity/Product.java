package com.kainmvc.quan_ly_san_pham.entity;

public class Product {
    private int id;
    private String name;
    private String desc;
    private String manufacture;
    private double price;


    public Product() {
    }

    public Product(int id, String name, String desc, String manufacture, double price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
