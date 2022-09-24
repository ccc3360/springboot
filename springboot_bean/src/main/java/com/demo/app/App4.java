package com.demo.app;


import com.demo.config.SpringConfig4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App4 {
    public static void main(String[] args) {
//        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig3_2.class);
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig4.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }


    }
}
