package com.example.demo.configurable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(preConstruction = true)
public class TestConfigurable {

    @Autowired
    private TestBean1 testBean1;

    public TestBean1 re(){
        return testBean1;
    }

}
