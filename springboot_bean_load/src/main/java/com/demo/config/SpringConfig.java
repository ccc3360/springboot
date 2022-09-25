package com.demo.config;

import com.demo.bean.Cat;
import com.demo.bean.Dog;
import com.demo.bean.Mouse;
import com.demo.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

//@Import(MyImportSelector.class)
@Import({Mouse.class})
public class SpringConfig {
    @Bean
    @ConditionalOnClass(Mouse.class)
//    @ConditionalOnClass(name = "com.demo.bean.Mouse")
//    @ConditionalOnMissingClass("com.demo.bean.Dog")
//    @ConditionalOnBean(name = "jerry")
//    @ConditionalOnMissingBean(name = "com.demo.bean.Dog")
//    @ConditionalOnWebApplication
//    @ConditionalOnNotWebApplication
    public Cat tom(){
        return new Cat();
    }
}
