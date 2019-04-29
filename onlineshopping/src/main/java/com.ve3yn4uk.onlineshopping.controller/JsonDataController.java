package com.ve3yn4uk.onlineshopping.controller;

import com.ve3yn4uk.shoppingbackend.dao.IProductDAO;
import com.ve3yn4uk.shoppingbackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 29.04.2019
 */

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    private IProductDAO productDAO;

    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts(){

        return productDAO.findAllActive();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id){

        return productDAO.findActiveByCategory(id);
    }
}
