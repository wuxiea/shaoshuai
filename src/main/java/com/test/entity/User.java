package com.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {

    @TableId(value = "userId",type = IdType.INPUT) //自增
    private Long userId;

    @TableField(value = "userName")
    private String userName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "status")
    private int status;
}