package com.ecommerce.colab.controller;

import com.ecommerce.colab.dto.SignupDto;

import com.ecommerce.colab.model.User;
import com.ecommerce.colab.repository.UserRepository;
import com.ecommerce.colab.service.allinterface.AddService;

import com.ecommerce.colab.service.allinterface.EnableAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AddService addService;

    @Autowired
    private EnableAccountService enableAccountService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/signUp")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupDto signupDto){

        boolean b=addService.addUser(signupDto);
        System.out.println(b);
        if(b) {
            return new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
        }else{
            throw new RuntimeException("unable to add user check values");
        }
    }

    @GetMapping("/verification/verify")
    @ResponseBody
    public User verifyUser(@RequestParam String code){
        long id=enableAccountService.enableUser(code);
        if(id!=0) {
            return userRepository.getById(id);
        }else{
            throw new RuntimeException("unable to find verfication token");
        }
    }


}
