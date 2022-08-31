package com.example.Controller;

import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {
    @Autowired
    private SMSCodeService service;
    @GetMapping
    public String getCode(String tele){
        String code = service.sendCodeToSMS(tele);
        return code;
    }
    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode){
        return service.checkCode(smsCode);
    }

}
