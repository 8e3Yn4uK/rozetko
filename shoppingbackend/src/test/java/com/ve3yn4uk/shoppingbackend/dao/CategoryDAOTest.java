package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.entity.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by 8e3Yn4uK on 27.04.2019
 */

public class CategoryDAOTest {

    private static AnnotationConfigApplicationContext context;
    private static ICategoryDAO categoryDAO;
    private Category category;

    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("com.ve3yn4uk.shoppingbackend");
        context.refresh();

        categoryDAO = (ICategoryDAO) context.getBean("categoryDAO");
    }

    @Test
    public void addCategory() {

        category = new Category();
        category.setName("Television");
        category.setDescription("Some description for TV");
        category.setImageURL("CAT_1.png");

        assertEquals("Category adding error", true, categoryDAO.add(category));

        categoryDAO.delete(category);
    }

    @Test
    public void getCategory(){

        Category tempCategory = new Category();
        tempCategory.setName("Television");
        tempCategory.setDescription("Some description for TV");
        tempCategory.setImageURL("CAT_1.png");
        categoryDAO.add(tempCategory);
        int myId = tempCategory.getId();
        category = categoryDAO.findById(myId);

        assertEquals("Category fetching error", myId, category.getId());

        categoryDAO.delete(tempCategory);
    }

    @Test
    public void updateCategory(){

        category = new Category();
        category.setName("TestCatrgory");
        category.setDescription("TestDescription");
        category.setImageURL("TEST_1.png");
        categoryDAO.add(category);
        int myId = category.getId();
        category = categoryDAO.findById(myId);
        category.setName("Tv");

        assertEquals("Category updating error", true, categoryDAO.update(category));

        categoryDAO.delete(category);
    }

    @Test
    public void deactivateCategory(){

        category = new Category();
        category.setName("TestCatrgory");
        category.setDescription("TestDescription");
        category.setImageURL("TEST_1.png");
        categoryDAO.add(category);
        int myId = category.getId();
        category = categoryDAO.findById(myId);

        assertEquals("Category deleting error", true, categoryDAO.deactivate(category));

        categoryDAO.delete(category);
    }

    @Test
    public void findActiveCategories(){

        int count = categoryDAO.findActive().size();
        category = new Category();
        category.setName("TestCatrgory");
        category.setDescription("TestDescription");
        category.setImageURL("TEST_1.png");
        categoryDAO.add(category);
        assertEquals("Categories fetching error", count+1, categoryDAO.findActive().size());

        categoryDAO.delete(category);
    }




}