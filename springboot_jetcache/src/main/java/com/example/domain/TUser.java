package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class TUser implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
//    解决前端精度丢失，，使数据转换为String类型，防止因数据过长，导致前端拿到数据变成0000
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String name;
    private Integer age;
    private String email;

//    private SexEnum sex;

    private Integer sex;

    //逻辑删除字段，标价当前记录是否被删除，可以在全局配置中设置
//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
    @Version
    private Integer version;

//    @TableField(exist = false)
//    @DurationUnit(ChronoUnit.MINUTES)
//    private Duration serverTimeOut;
//
//    @TableField(exist = false)
//    @DataSizeUnit(DataUnit.MEGABYTES)
//    private DataSize dataSize;
}