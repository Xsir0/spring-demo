package com.example.demo.typeconvert;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class TestConversionService {

    private ConversionService conversionService;

    public TestConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }


    public String tst1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        if (conversionService.canConvert(list.getClass(), String.class)){
            return conversionService.convert(list,String.class);
        }
        return null;
    }


}
