package com.example;

import com.example.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootJetcacheApplicationTests {
    @Autowired
    private TUserService tUserService;

    @Test
    void contextLoads() {
        System.out.println(tUserService.getById(1));
    }

}
