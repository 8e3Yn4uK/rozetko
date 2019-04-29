package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Product;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 29.04.2019
 */

public interface IProductDAO {

    Product findById(int id);
    List<Product> findAll();
    boolean add(Product theProduct);
    boolean update(Product theProduct);
    boolean deactivate(Product theProduct);
    boolean delete(Product theProduct);

    List<Product> findAllActive();
    List<Product> findActiveByCategory(int categoryId);
    List<Product> findLatestActive(int count);
}
