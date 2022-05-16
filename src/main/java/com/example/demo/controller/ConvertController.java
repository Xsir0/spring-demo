package com.example.demo.controller;


import com.example.demo.typeconvert.TestConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cv")
public class ConvertController {

    @Autowired
    private TestConversionService conversionService;


    @GetMapping
    @RequestMapping("t1")
    public Object test1(){
        return conversionService.tst1();
    }


}
