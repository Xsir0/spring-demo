package com.example.demo.controller;

import com.example.demo.source.LoadSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("rs")
public class ResourceController {

    @Autowired
    private LoadSource loadSource;

    @GetMapping
    @RequestMapping("load")
    public Object load() throws IOException {
        return loadSource.classPathResource();
    }


}
