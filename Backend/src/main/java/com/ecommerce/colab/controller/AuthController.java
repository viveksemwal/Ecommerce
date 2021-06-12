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


    @PostMapping("/signUpCustomer")
    public ResponseEntity<String> signupCustomer(@RequestParam(required = true,name = "username") String username, @RequestParam(required = true,name = "password")  String password, @RequestParam(required = true,name = "email")  String email){
        System.out.println(username+password+email);
        boolean b=addService.addUser(new SignupDto(username,password,email));
        if(b) {
            return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Sucessfully created", HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/signUpSupplier")
    public ResponseEntity<String> signupSupplier(@RequestParam(required = true,name = "username") String username, @RequestParam String password, @RequestParam String email){
        boolean b=addService.addUser(new SignupDto(username,password,email));
        return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
    }

}
