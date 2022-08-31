package com.example.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.Controller.utils.CodeUtils;
import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;

    @CreateCache(area = "default",name = "jetCache_",cacheType = CacheType.REMOTE,expire = 3600)//过期时间
    //缓存类型：BOTH,LOCAL,REMOTE
    private Cache<String,String> jetCache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=smsCode.getCode();
        String checkcode=jetCache.get(smsCode.getTele());
        return code.equals(checkcode);
    }

}
