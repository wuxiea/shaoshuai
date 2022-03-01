package com.test.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.entity.Goods;
import com.test.mapper.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService{


    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findList() {
        return this.list(Wrappers.<Goods>lambdaQuery().eq(Goods::getGoodsName,"苹果"));
    }

    @Override
    @Transactional
    public int inster() {
        Goods goods1 = new Goods();
        goods1.setGoodsName("西瓜");
        goodsMapper.insterGoods(goods1);
        return 5/0;
    }

}
