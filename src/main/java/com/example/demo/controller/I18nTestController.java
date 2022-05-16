package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;

@RestController
@RequestMapping("i18n")
public class I18nTestController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("t1")
    public String getMessage(String param){
        return context.getMessage("name",new Object[]{param},"guest", LocaleContextHolder.getLocale());
    }

}
