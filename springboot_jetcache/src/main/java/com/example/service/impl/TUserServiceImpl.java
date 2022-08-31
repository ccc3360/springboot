package com.example.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TUser;
import com.example.mapper.TUserMapper;
import com.example.service.TUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
//    模拟缓存
//    private HashMap<Long,TUser> cache=new HashMap<>();
//    @Override
//    public TUser getByIdCache(Long id) {
//        //若当前缓存中没有要查询的结果，进行查询，否则直接从缓存中获取
//        TUser tUser=cache.get(id);
//        if(tUser==null){
//            TUser queryTuser=tUserMapper.selectById(id);
//            cache.put(id,queryTuser);
//            return queryTuser;
//        }
//        return tUser;
//    }

    @Override
    @Cached(name = "user",key = "#id",expire = 60)
//    @CacheInvalidate(name = "",key = "")//更新数据时更新缓存
//    @CacheRefresh(refresh = 10)//缓存定时刷新
    public TUser getByIdCache(Long id) {

        return tUserMapper.selectById(id);
    }
}




