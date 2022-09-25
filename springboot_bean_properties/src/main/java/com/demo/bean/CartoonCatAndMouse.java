package com.demo.bean;

import lombok.Data;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.util.StringUtils;

@EnableConfigurationProperties(CartoonProperties.class)
@Data
public class CartoonCatAndMouse {
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
    }
}
