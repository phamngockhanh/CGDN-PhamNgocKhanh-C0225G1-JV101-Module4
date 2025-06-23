package com.kainmvc.orm.repository;

import com.kainmvc.orm.entity.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(int id);

     List<Product> search(String keyword);
}
