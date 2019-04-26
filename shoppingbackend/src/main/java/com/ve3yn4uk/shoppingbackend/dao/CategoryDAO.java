package com.ve3yn4uk.shoppingbackend.dao;

import com.ve3yn4uk.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 8e3Yn4uK on 26.04.2019
 */

@Repository
public class CategoryDAO implements ICategoryDAO {

    private static List<Category> categories = new ArrayList<>();

        static {
            Category category = new Category();
            category.setId(1);
            category.setName("Television");
            category.setDescription("Some description for TV");
            category.setImageURL("CAT_1.png");
            categories.add(category);
            Category category2 = new Category();
            category2.setId(2);
            category2.setName("Mobile");
            category2.setDescription("Some description for Mobile");
            category2.setImageURL("CAT_2.png");
            categories.add(category2);
            Category category3 = new Category();
            category3.setId(3);
            category3.setName("Laptop");
            category3.setDescription("Some description for Laptop");
            category3.setImageURL("CAT_3.png");
            categories.add(category3);
        }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category findById(int id) {

            for (Category tempCategory: categories){
                if (tempCategory.getId() == id) return tempCategory;
            }
            return null;
    }
}
