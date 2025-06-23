package com.kainmvc.jpa.repository;

import com.kainmvc.jpa.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class ProductRepo implements IProductRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.id =: id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String keyword) {
        keyword = "%"+keyword+"%";
        TypedQuery<Product> query = entityManager.createQuery("FROM Product p where p.name like :keyword", Product.class);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }
}
