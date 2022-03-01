package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.entity.Goods;

public interface GoodsMapper extends BaseMapper<Goods> {
    int insterGoods(Goods goods);
}
