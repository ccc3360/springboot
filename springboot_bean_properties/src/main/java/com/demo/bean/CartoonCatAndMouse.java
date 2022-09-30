package com.demo.bean;

import lombok.Data;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;
@ConditionalOnClass(name = "org.springframework.data.redis.core.RedisOperations")
@EnableConfigurationProperties(CartoonProperties.class)
@Data
public class CartoonCatAndMouse implements ApplicationContextAware {
    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    private Cat cat;
    private Mouse mouse;
    private CartoonProperties cartoonProperties;
    public CartoonCatAndMouse(CartoonProperties cartoonProperties) {
        this.cartoonProperties=cartoonProperties;
        cat=new Cat();
        mouse=new Mouse();
        cat.setName(cartoonProperties.getCat()!=null&&StringUtils.hasText(cartoonProperties.getCat().getName()) ? cartoonProperties.getCat().getName():"aaaa");
        cat.setAge(cartoonProperties.getCat()!=null&&cartoonProperties.getCat().getAge()!=null?cartoonProperties.getCat().getAge():2);
        mouse.setName(cartoonProperties.getMouse()!=null&&StringUtils.hasText(cartoonProperties.getMouse().getName()) ? cartoonProperties.getMouse().getName():"bbbb");
        mouse.setAge(cartoonProperties.getMouse()!=null&&cartoonProperties.getMouse().getAge()!=null?cartoonProperties.getMouse().getAge():2);
    }
    public void play(){
        System.out.println(cat.getName()+"  "+cat.getAge());
        System.out.println(mouse.getName()+"  "+mouse.getAge());
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
