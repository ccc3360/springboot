package com.demo.config;

import com.demo.bean.MyImportSelector;
import com.demo.bean.MyRegistrar;
import org.springframework.context.annotation.Import;

//@Configuration
@Import(MyRegistrar.class)
public class SpringConfig5 {
}
