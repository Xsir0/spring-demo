package com.example.demo.validate;


import org.springframework.validation.annotation.Validated;

import java.util.List;

public class User {

    private String name;

    private Integer age;

    private List<String> hello;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHello() {
        return hello;
    }

    public void setHello(List<String> hello) {
        this.hello = hello;
    }
}
