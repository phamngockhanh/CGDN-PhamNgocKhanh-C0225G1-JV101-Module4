package com.kainmvc.orm.repository;

import com.kainmvc.orm.entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static final SessionFactory sessionFactory;
    private static final EntityManager entityManager;

    static {
        SessionFactory factory = null;
        EntityManager em = null;
        try {
            factory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            em = factory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        sessionFactory = factory;
        entityManager = em;
    }
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }


    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Product origin;
        if (product.getId() == 0) {
            origin = new Product();
        } else {
            origin = findById(product.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setName(product.getName());
            origin.setDescription(product.getDescription());
            origin.setManufacture(product.getManufacture());
            origin.setPrice(product.getPrice());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
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
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(product);
            tx.commit(); // bắt buộc phải commit
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String keyword) {
        keyword = "%" + keyword.toLowerCase() + "%";
        TypedQuery<Product> query = entityManager.createQuery("FROM Product p WHERE LOWER(p.name) LIKE :keyword", Product.class);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }
}
