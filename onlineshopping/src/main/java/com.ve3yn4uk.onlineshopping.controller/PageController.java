package com.ve3yn4uk.onlineshopping.controller;

import com.ve3yn4uk.shoppingbackend.dao.ICategoryDAO;
import com.ve3yn4uk.shoppingbackend.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 8e3Yn4uK on 22.04.2019
 */

@Controller
public class PageController {

    @Autowired
    private ICategoryDAO categoryDAO;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");
        mv.addObject("categories", categoryDAO.findActive());
        mv.addObject("userClickHome", true);
        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("userClickContact", true);
        return mv;
    }

    /**
     * Methods to load all the products based on category
     */
    @RequestMapping(value = "/show/all/products")
    public ModelAndView showAllProducts() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "All Products");
        mv.addObject("categories", categoryDAO.findActive());
        mv.addObject("userClickAllProducts", true);
        return mv;
    }
    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("page");
        Category category = null;
        category = categoryDAO.findById(id);
        mv.addObject("title", category.getName());
        mv.addObject("categories", categoryDAO.findActive());
        mv.addObject("category", category);
        mv.addObject("userClickCategoryProducts", true);
        return mv;
    }


}
