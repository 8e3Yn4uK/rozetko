package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Category;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 26.04.2019
 */

public interface ICategoryDAO {

    /**
     * Getting list of active categories
     */
    List<Category> findActive();

    /**
     * Getting single category by id
     */
    Category findById(int id);

    /**
     * Adding new category
     */
    boolean add(Category theCategory);

    /**
     * Updating existing category
     */
    boolean update(Category theCategory);

    /**
     * Deactivating existing category
     */
    boolean deactivate(Category theCategory);

    /**
     * Deleting existing category (for testing)
     */
    boolean delete(Category theCategory);

    /**
     * Getting list of all existing categories (for testing)
     */
    List<Category> findAll();
}
