package com.kainmvc.quan_ly_san_pham.service;

import com.kainmvc.quan_ly_san_pham.entity.Product;
import com.kainmvc.quan_ly_san_pham.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private final IProductRepository iProductRepository;

    public  ProductService(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return iProductRepository.search(keyword);
    }
}
