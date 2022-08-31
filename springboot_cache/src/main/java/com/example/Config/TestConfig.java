package com.example.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;

@Data
@ConfigurationProperties(prefix = "test")
//开启对于当前bean的属性注入校验
@Validated
public class TestConfig {
    private String ipAddress;
    @Max(value = 8888,message = "最大值不超过8888")
    private int port;
    private long timeout;
}
