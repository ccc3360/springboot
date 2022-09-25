package com.demo.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        try {
            Class<?> clazz = Class.forName("com.demo.bean.Wolf");
            if (clazz!=null){
                return new String[]{"com.demo.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
            return new String[]{"com.demo.bean.Dog"};
        }
        return null;
    }
}
