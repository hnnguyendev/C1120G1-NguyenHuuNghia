package com.nhnghia.repository.impl;

import com.nhnghia.entity.Product;
import com.nhnghia.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);

        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        if (product.getId() != null) {
            BaseRepository.entityManager.merge(product);
        } else {
            entityTransaction.begin();
            BaseRepository.entityManager.persist(product);
            entityTransaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        Product product = findById(id);
        if (product != null) {
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            entityTransaction.commit();
        }
    }
}
