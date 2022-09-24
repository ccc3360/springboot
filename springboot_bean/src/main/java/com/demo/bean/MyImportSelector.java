package com.demo.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        boolean hasAnnotation = annotationMetadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        if (hasAnnotation){
            return new String[]{"com.demo.bean.Dog"};
        }
        return new String[]{"com.demo.bean.Cat"};
    }
}
