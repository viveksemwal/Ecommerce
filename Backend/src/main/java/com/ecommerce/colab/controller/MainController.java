package com.ecommerce.colab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/")
    public ModelAndView Index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("name","vivek");
        return modelAndView;
    }

    //@PostMapping
}
