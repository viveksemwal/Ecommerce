package com.ecommerce.colab.service;

import com.ecommerce.colab.dto.SignupDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AddServiceImplTest {
    @Autowired
    AddService addService;



    @Test
    void addUser_when_null_is_passed() {
        //given
        SignupDto signupDto=null;

        //when
        Executable executable=()->addService.addUser(signupDto);


        //then
       assertThrows(NullPointerException.class, executable);
    }
}