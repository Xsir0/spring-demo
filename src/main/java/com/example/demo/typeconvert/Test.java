package com.example.demo.typeconvert;

import org.springframework.core.convert.converter.Converter;

public class Test {

    public static void main(String[] args) {
        StringToEnumConverterFactory stringToEnumConverterFactory = new StringToEnumConverterFactory();
        Converter<String, TestEnum> converter = stringToEnumConverterFactory.getConverter(TestEnum.class);
        TestEnum a = converter.convert("A");
        System.out.println(a.getTest());
    }

}
