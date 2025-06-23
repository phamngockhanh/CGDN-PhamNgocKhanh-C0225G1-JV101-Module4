package com.kainmvc.jpa.service;

import com.kainmvc.jpa.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> search(String keyword);
}
