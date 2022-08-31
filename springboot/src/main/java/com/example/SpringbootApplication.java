package com.example;

import com.example.Config.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(TestConfig.class)
public class SpringbootApplication {

    public static void main(String[] args) {
//        args:命令行的临时参数
//        System.out.println(Arrays.toString(args));
//        去掉args可以防止命令行属性为程序传递启动属性
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        TestConfig bean = run.getBean(TestConfig.class);
        System.out.println(bean);
    }

}
