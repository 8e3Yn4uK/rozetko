package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 29.04.2019
 */

@Repository("productDAO")
@Transactional
public class ProductDAO implements IProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private String selectAllCategories = "FROM Product";
    private String selectAllActiveProducts = "FROM Product WHERE active = :active";
    private String selectAllActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
    private String selectLatestActiveProducts = "FROM Product WHERE active = :active ORDER BY id";

    @Override
    public Product findById(int id) {

        try {
            return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
        } catch (HibernateException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery(selectAllCategories, Product.class);

        return query.getResultList();
    }

    @Override
    public boolean add(Product theProduct) {

        try {
            sessionFactory.getCurrentSession().persist(theProduct);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product theProduct) {

        try {
            sessionFactory.getCurrentSession().update(theProduct);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deactivate(Product theProduct) {

        theProduct.setActive(false);

        try {
            sessionFactory.getCurrentSession().update(theProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product theProduct) {

        try {
            sessionFactory.getCurrentSession().delete(theProduct);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAllActive() {

        Query query = sessionFactory.getCurrentSession().createQuery(selectAllActiveProducts, Product.class);
        query.setParameter("active", true);

        return query.getResultList();
    }

    @Override
    public List<Product> findActiveByCategory(int categoryId) {

        Query query = sessionFactory.getCurrentSession().createQuery(selectAllActiveProductsByCategory, Product.class);
        query.setParameter("active", true).setParameter("categoryId", categoryId);

        return query.getResultList();
    }

    @Override
    public List<Product> findLatestActive(int count) {

        Query query = sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts, Product.class);
        query.setParameter("active", true).setFirstResult(0).setMaxResults(count);

        return query.getResultList();
    }
}
