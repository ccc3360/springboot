package com.demo.app;

import com.demo.bean.Mouse;
import com.demo.config.SpringConfig3_1;
import com.demo.config.SpringConfig3_2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App3_2 {
    public static void main(String[] args) {
//        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig3_2.class);
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig3_2.class);
        ctx.registerBean("mouse", Mouse.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(ctx.getBean(SpringConfig3_2.class));
//        SpringConfig3_2 springConfig3_2 = ctx.getBean("springConfig3_2", SpringConfig3_2.class);
//        System.out.println(springConfig3_2.cat());
//        System.out.println(springConfig3_2.cat());
//        System.out.println(springConfig3_2.cat());
    }
}
