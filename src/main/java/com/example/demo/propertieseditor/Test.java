package com.example.demo.propertieseditor;

import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyEditorRegistrySupport;

import java.beans.PropertyEditor;

public class Test {

    public static void main(String[] args) {

        PropertyEditorRegistry propertyEditorRegistry = new PropertyEditorRegistrySupport();
        propertyEditorRegistry.registerCustomEditor(TestB.class,new TestBPropertyEditor());

        PropertyEditor customEditor = propertyEditorRegistry.findCustomEditor(TestB.class, null);

        customEditor.setAsText("a,b,c,d,e,f,g");
        System.out.println(customEditor.getValue());
    }

}
