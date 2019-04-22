package com.ve3yn4uk.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 8e3Yn4uK on 22.04.2019
 */

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("hello", "Welcome to Spring Web MVC");
        return mv;
    }


}
