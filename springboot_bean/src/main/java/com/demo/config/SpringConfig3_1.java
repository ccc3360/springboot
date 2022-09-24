package com.demo.config;

import com.demo.bean.Dog;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

//@Configuration
//@Component
@ImportResource("applicationContext1.xml")
@Import({Dog.class})
public class SpringConfig3_1 {
}
