package com.example.demo.propertieseditor;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.List;


@Data
@Builder
public class TestB {


    @Tolerate
    public TestB() {
    }

    private String t1;

    private Integer t2;

    private List<String> t3;

}
