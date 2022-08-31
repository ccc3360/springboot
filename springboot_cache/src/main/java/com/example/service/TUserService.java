package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86182
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-08-15 15:59:01
*/
public interface TUserService extends IService<TUser> {


    public IPage<TUser> getPage(Integer current,Integer Pagesize);

    IPage<TUser> getPage(Integer currentPage, Integer pagesize, TUser tUser);

    TUser getByIdCache(Long id);
}
