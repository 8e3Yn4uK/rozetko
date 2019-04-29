package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by 8e3Yn4uK on 29.04.2019
 */

public class ProductDAOTest {

    private static AnnotationConfigApplicationContext context;
    private static IProductDAO productDAO;
    private Product product;

    @BeforeClass
    public static void init(){

        context = new AnnotationConfigApplicationContext();
        context.scan("com.ve3yn4uk.shoppingbackend");
        context.refresh();

        productDAO = (IProductDAO) context.getBean("productDAO");
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void add() {

        product = new Product();
        product.setName("Test product");
        product.setBrand("brand for testing");
        product.setDescription("description for testing");
        product.setUnitPrice(125);
        product.setActive(true);
        product.setCategoryId(1);
        product.setSupplierId(1);

        assertEquals("Product adding error", true, productDAO.add(product));

        productDAO.delete(product);

    }

    @Test
    public void update() {

        product = new Product();
        product.setName("Test product");
        product.setBrand("brand for testing");
        product.setDescription("description for testing");
        product.setUnitPrice(125);
        product.setActive(true);
        product.setCategoryId(1);
        product.setSupplierId(1);

        productDAO.add(product);
        product.setName("Test Product 1");
        assertEquals("Product update error", true, productDAO.update(product));

        productDAO.delete(product);
    }

    @Test
    public void deactivate() {

        product = new Product();
        product.setName("Test product");
        product.setBrand("brand for testing");
        product.setDescription("description for testing");
        product.setUnitPrice(125);
        product.setActive(true);
        product.setCategoryId(1);
        product.setSupplierId(1);

        productDAO.add(product);

        assertEquals("Product deactivation problem", true, productDAO.deactivate(product));

        productDAO.delete(product);
    }


    @Test
    public void findAllActive() {

        product = new Product();
        product.setName("Test product");
        product.setActive(true);
        product.setCategoryId(1);
        product.setSupplierId(1);
        int cont = productDAO.findAllActive().size();
        productDAO.add(product);

        assertEquals("Finding all active products problem", ++cont, productDAO.findAllActive().size());

        productDAO.delete(product);

    }

    @Test
    public void findActiveByCategory() {

        product = new Product();
        product.setName("Test product");
        product.setActive(true);
        product.setCategoryId(1);
        product.setSupplierId(1);
        int count = productDAO.findActiveByCategory(1).size();
        productDAO.add(product);

        assertEquals("Finding all active by category problem", ++count,productDAO.findActiveByCategory(1).size());

        productDAO.delete(product);
    }

    @Test
    public void findLatestActive() {

        int count = 1;

        assertEquals("Finding letest active problem", count, productDAO.findLatestActive(count).size());
    }
}