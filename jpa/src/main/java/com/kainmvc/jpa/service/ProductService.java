package com.kainmvc.jpa.service;

import com.kainmvc.jpa.entity.Product;
import com.kainmvc.jpa.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductService implements IProductService{
    private IProductRepo iProductRepo;
    public ProductService(IProductRepo iProductRepo){
        this.iProductRepo = iProductRepo;
    }
    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }

    @Override
    public void update( Product product) {
        iProductRepo.update(product);
    }

    @Override
    public void remove(int id) {
        iProductRepo.remove(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return iProductRepo.search(keyword);
    }
}
