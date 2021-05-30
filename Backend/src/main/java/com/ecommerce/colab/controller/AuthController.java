package com.ecommerce.colab.controller;

import com.ecommerce.colab.dto.SignupDto;

import com.ecommerce.colab.service.AddService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    AddService addService;


    @PostMapping("/signUpCustomer")
    public ResponseEntity<String> signupCustomer(@RequestParam(required = true,name = "username") String username, @RequestParam String password, @RequestParam String email){
        boolean b=addService.addUser(new SignupDto(username,password,email),"Role_CUSTOMER");
        return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
    }

    @PostMapping("/signUpSupplier")
    public ResponseEntity<String> signupSupplier(@RequestParam(required = true,name = "username") String username, @RequestParam String password, @RequestParam String email){
        boolean b=addService.addUser(new SignupDto(username,password,email),"Role_SUPPLIER");
        return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
    }

}
