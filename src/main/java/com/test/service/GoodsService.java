package com.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.entity.Goods;

import java.util.List;

public interface GoodsService extends IService<Goods> {

    List<Goods> findList();

    int inster();
}
