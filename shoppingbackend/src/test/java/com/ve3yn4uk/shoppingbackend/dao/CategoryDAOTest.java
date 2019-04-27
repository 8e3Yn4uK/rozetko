package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.dto.Category;
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

        assertEquals("Category added successful)", true, categoryDAO.addCategory(category));
    }
}