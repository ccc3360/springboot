package com.example.Controller;

import com.example.Controller.utils.Result;
import com.example.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class LogDemoController {
//    创建记录日志的对象,,也可以使用注解@Slf4j
//    private static final Logger log= LoggerFactory.getLogger(LogDemoController.class);

//    @GetMapping
//    public String getdemo(){
//        log.info("info....");
//        log.debug("debug...");//在配置文件中添加debug：true
//        log.warn("warn...");
//        log.error("error.....");
//        return "";
//    }

    @PostMapping
    public String testStatus(){
        System.out.println("testStatus.....");
        return "spring boot";
    }

    @Autowired
    private TUserService tUserService;

    @GetMapping
    public Result testJson(){
        return new Result(true,tUserService.list());
    }

}
