package com.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods")
public class Goods {

    @TableId(type = IdType.AUTO, value = "goodsid") //自增
    private Long goodsId;

    @TableField(value = "username")
    private String goodsName;


}
