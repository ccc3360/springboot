package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TUser;
import com.example.service.TUserService;
import com.example.mapper.TUserMapper;
import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86182
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-08-15 15:59:01
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{
    @Autowired
    private TUserMapper tUserMapper;
    @Override
    public IPage<TUser> getPage(Integer current, Integer Pagesize) {
        IPage page=new Page(current,Pagesize);
        tUserMapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<TUser> getPage(Integer currentPage, Integer pagesize, TUser tUser) {
        LambdaQueryWrapper<TUser> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(tUser.getName()),TUser::getName,tUser.getName());
        lambdaQueryWrapper.eq(null!=tUser.getSex(),TUser::getSex,tUser.getSex());
        IPage page=new Page(currentPage,pagesize);
        tUserMapper.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}




