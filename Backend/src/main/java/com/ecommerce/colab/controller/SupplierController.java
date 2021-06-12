package com.ecommerce.colab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

@Controller
@RequestMapping("/api/supplier")
public class SupplierController {

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestParam(name = "productname",required = true) String productname, @RequestParam(name="price") int price,
                                         @RequestParam(name = "files",required = false)MultipartFile[] files,@RequestParam("discount") int discount,@RequestParam(name="description") String description){



        return null;
    }

    //@GetMapping("/get")
}
