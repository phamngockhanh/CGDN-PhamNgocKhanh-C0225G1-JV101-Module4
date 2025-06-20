package com.kainmvc.quan_ly_san_pham.service;

import com.kainmvc.quan_ly_san_pham.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> search(String keyword);

}
