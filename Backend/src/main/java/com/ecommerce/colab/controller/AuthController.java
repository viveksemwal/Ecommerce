package com.ecommerce.colab.controller;

import com.ecommerce.colab.dto.SignupDto;

import com.ecommerce.colab.service.AddService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AddService addService;


    @PostMapping("/signUp")
    public ResponseEntity<String> signup(@RequestBody SignupDto signupDto){

        boolean b=addService.addUser(signupDto);
        if(b) {
            return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
        }else{
            throw new RuntimeException("unable to add user check values");
        }
    }


}
