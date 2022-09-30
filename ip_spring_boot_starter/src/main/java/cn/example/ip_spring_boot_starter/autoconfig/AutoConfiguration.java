package cn.example.ip_spring_boot_starter.autoconfig;

import cn.example.ip_spring_boot_starter.ipProperties.Ipproperties;
import cn.example.ip_spring_boot_starter.service.ipCountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableConfigurationProperties(Ipproperties.class)
@Import(Ipproperties.class)
public class AutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ipCountService ipCountService(){
        return new ipCountService();
    }
}
