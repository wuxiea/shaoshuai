package com.test.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.entity.User;
import com.test.mapper.UserMapper;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findList() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserId,1);
        return userMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public IPage<User> selectPage(Page<User> page) {
        QueryWrapper<User> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.orderByDesc("userId");
        return userMapper.selectPage(page,QueryWrapper);
    }

    public int inster() {
        User user = new User();
        user.setUserName("我是谁");
        user.setPassword("12345");
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectListall(User user) {

        return userMapper.selectListall(user);
    }

    @Override
    public List<Map<String, Object>> selectListid(User user) {

        return userMapper.selectListid(user);
    }
}
