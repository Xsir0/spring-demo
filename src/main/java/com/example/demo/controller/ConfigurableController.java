package com.example.demo.controller;

import com.example.demo.configurable.TestConfigurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("configurable")
public class ConfigurableController {

    @GetMapping
    @RequestMapping("t")
    public Object test(){
        return new TestConfigurable().re().te();
    }

}
