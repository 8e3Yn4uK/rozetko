package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.dto.Category;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 26.04.2019
 */

public interface ICategoryDAO {

    List<Category> findAll();

    Category findById(int id);
}
