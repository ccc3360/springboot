package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 86182
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-08-15 15:59:01
* @Entity com.example.domain.TUser
*/
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);

}




