package com.demo;

import com.demo.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
