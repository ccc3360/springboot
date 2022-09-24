package com.demo.config;

import com.demo.bean.MyPostProcessor;
import com.demo.bean.MyRegistrar;
import com.demo.service.BookService;
import com.demo.service.Impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

//@Configuration
@Import({BookServiceImpl1.class,MyRegistrar.class,MyPostProcessor.class})
public class SpringConfig6 {
}
