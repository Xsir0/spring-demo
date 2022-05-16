package com.example.demo.controller;

import com.example.demo.validate.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vd")
public class ValidateController {

    @GetMapping
    public Object vd(@Validated User user){
        return user;
    }

}
