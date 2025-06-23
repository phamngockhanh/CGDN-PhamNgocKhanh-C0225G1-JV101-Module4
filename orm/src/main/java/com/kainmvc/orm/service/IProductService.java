package com.kainmvc.orm.service;

import com.kainmvc.orm.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> search(String keyword);
}
