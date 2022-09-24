package com.demo.config;

import com.demo.bean.Cat;
import com.demo.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//@Configuration(proxyBeanMethods = false)
//@Component
@ImportResource("applicationContext1.xml")
@Import({Dog.class})
public class SpringConfig3_2 {
    @Bean
    public Cat cat(){
        return new Cat();
    }
}
