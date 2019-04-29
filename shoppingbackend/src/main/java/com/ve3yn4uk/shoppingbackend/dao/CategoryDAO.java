package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 26.04.2019
 */

@Repository("categoryDAO")
@Transactional
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    String selectAllCategories = "FROM Category";
    String selectAllActiveCategories = "FROM Category WHERE active = :active";

    @Override
    public List<Category> findActive() {

        Query query = sessionFactory.getCurrentSession().createQuery(selectAllActiveCategories, Category.class);
        query.setParameter("active", true);
        List<Category> categories = query.getResultList();

        return categories;
    }

    @Override
    public Category findById(int id) {

        try {
            return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
        } catch (HibernateException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Category theCategory) {

        try {
            sessionFactory.getCurrentSession().persist(theCategory);
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category theCategory) {

        try {
            sessionFactory.getCurrentSession().update(theCategory);
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deactivate(Category theCategory) {

        theCategory.setActive(false);

        try {
            sessionFactory.getCurrentSession().update(theCategory);
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Category theCategory) {

        try {
            sessionFactory.getCurrentSession().delete(theCategory);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery(selectAllCategories, Category.class);

        return query.getResultList();
    }
}
