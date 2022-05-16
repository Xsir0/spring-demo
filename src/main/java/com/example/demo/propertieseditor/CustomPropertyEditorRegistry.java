package com.example.demo.propertieseditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

public class CustomPropertyEditorRegistry implements PropertyEditorRegistry {

    @Override
    public void registerCustomEditor(Class<?> aClass, PropertyEditor propertyEditor) {

    }

    @Override
    public void registerCustomEditor(Class<?> aClass, String s, PropertyEditor propertyEditor) {
        
    }

    @Override
    public PropertyEditor findCustomEditor(Class<?> aClass, String s) {
        return null;
    }
}
