package com.example.Controller.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {
    private String[] patch={"000000","00000","0000","000","00","0",""};
    public String generator(String tele){
        int hash=tele.hashCode();
        int encryption=20206666;
        long result=hash ^ encryption;
        long nowtime=System.currentTimeMillis();
        result=result ^ nowtime;
        long code=result%1000000;
        code=code<0?-code:code;
        String codeStr=code+"";
        return patch[codeStr.length()]+codeStr;
    }



}
