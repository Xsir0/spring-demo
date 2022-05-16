package com.example.demo.controller;

import com.example.demo.event.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EmailService emailService;

    @GetMapping
    @RequestMapping("S")
    public String send(){
        emailService.setBlockedList(new ArrayList<>());
        emailService.sendEmail("123@gmail.com","test");
        return "success";
    }


}
