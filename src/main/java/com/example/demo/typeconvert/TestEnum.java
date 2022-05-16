package com.example.demo.typeconvert;

import lombok.Data;

public enum TestEnum {

    A("a"),B("b"),C("c");


    TestEnum() {
    }


    TestEnum(String test) {
        this.test = test;
    }

    private String test;


    public String getTest() {
        return test;
    }
}
