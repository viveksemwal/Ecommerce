package com.ecommerce.colab.controller;

import com.ecommerce.colab.dto.SignupDto;
import com.ecommerce.colab.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/signUp")
    public ModelAndView signupform(ModelAndView modelAndView){
        modelAndView.addObject("user",new SignupDto());
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signupSubmit(@RequestParam(required = true,name = "username") String username, @RequestParam String password, @RequestParam String email){
        User user=Us

        return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED)
    }

}
