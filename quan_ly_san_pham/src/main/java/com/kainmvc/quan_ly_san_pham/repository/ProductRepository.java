package com.kainmvc.quan_ly_san_pham.repository;


import com.kainmvc.quan_ly_san_pham.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{


    private static final Map<Integer,Product> products;

    static{
        products = new HashMap<>();
        products.put(1,new Product(1,"Giấy","Mỏng thơm","Việt Nam",15.5));
        products.put(2,new Product(2,"Ly","Giày thơm","Việt Nam",15.5));
        products.put(3,new Product(3,"Ghế","Êm ái, thoải mái","Việt Nam",20.5));
        products.put(4,new Product(4,"Kẹo","Ngon","Việt Nam",21));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> productList1 = findAll();
        List<Product> productList2 = new ArrayList<>();
        for (Product product : productList1) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                productList2.add(product);
            }
        }
        return productList2;
    }
}
