package com.kainmvc.quan_ly_san_pham.repository;

import com.kainmvc.quan_ly_san_pham.entity.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> search(String keyword);

}
