package com.example.demo.propertieseditor;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        TestB testB =  TestB.builder().t1("t1").t2(12).t3(new ArrayList<>()).build();
        if (null != text){
            testB.setT3(Arrays.asList(text.split(",",-1)));
        }
        setValue(testB);
    }

    @Override
    public Object getValue() {
        return super.getValue();
    }
}
