package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Category;
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


    @Override
    public List<Category> findActive() {

        String selectActiveCategories = "FROM Category WHERE active = :active";
        Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories);
        query.setParameter("active", true);

        return query.getResultList();
    }

    @Override
    public Category findById(int id) {   ///

        return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }

    @Override
    public boolean add(Category category) {    ///

        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category category) {    ///

        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deactivate(Category category) {  ///

        category.setActive(false);

        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    @Override
    public void delete(Category category) {

        sessionFactory.getCurrentSession().delete(category);
    }

    @Override
    public List<Category> findAll() {

        String selectActiveCategories = "FROM Category";
        Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories);

        return query.getResultList();
    }
}
