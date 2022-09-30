package cn.example.ip_spring_boot_starter.interceptor;

import cn.example.ip_spring_boot_starter.service.ipCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class IpCountInterceptor implements HandlerInterceptor {
    @Autowired
    private ipCountService ipCountService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCountService.count();
        return true;
    }
}
