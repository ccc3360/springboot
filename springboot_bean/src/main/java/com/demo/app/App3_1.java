package com.demo.app;

import com.demo.config.SpringConfig3_1;
import com.demo.config.SpringConfig3_2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App3_1 {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig3_1.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(ctx.getBean(SpringConfig3_1.class));
    }
}
