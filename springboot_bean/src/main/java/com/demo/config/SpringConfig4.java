package com.demo.config;

import com.demo.bean.Dog;
import com.demo.bean.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
//@Configuration
@Import(MyImportSelector.class)
public class SpringConfig4 {
}
