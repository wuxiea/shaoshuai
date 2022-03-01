package com.test.controller;

import com.test.entities.Result;
import com.test.entity.Goods;
import com.test.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController()
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping("goods/findList")
    public Result findList() {
        List<Goods> list = goodsService.findList();
        if (list != null && list.size() > 0) {
            return new Result(true, "查询成功", list);
        } else {
            return new Result(false, "查询失败");
        }
    }

    @GetMapping("goods/inster")
    public int inster() {
        int inster = goodsService.inster();
        return inster;
    }
}
