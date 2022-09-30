package com.example;

import com.example.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEmailApplicationTests {

    @Autowired
    private SendMailService service;

    @Test
    void contextLoads() {
        service.sendMail();
    }

}
