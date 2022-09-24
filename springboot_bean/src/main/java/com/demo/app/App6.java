package com.demo.app;


import com.demo.config.SpringConfig5;
import com.demo.config.SpringConfig6;
import com.demo.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App6 {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig6.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        BookService bean = ctx.getBean("bookService",BookService.class);
        bean.check();


    }
}
