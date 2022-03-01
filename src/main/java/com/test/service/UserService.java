package com.test.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> findList();

    IPage<User> selectPage(Page<User> page);

    List<User> selectListall(User user);

    List<Map<String, Object>> selectListid(User user);


}