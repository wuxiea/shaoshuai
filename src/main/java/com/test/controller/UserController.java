package com.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.entities.Result;
import com.test.entity.User;
import com.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController()
public class UserController {

    @Resource
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("user/findList")
    public Result findList() {
        List<User> list = userService.findList();
        logger.info("UserController.findList:"+list);
        if (list != null && list.size() > 0) {
            return new Result(true, "查询成功", list);
        } else {
            return new Result(false, "查询失败");
        }
    }

    @GetMapping("user/selectPage/{page}/{size}")
    public IPage<User> selectPage(@PathVariable("page") int page,@PathVariable("size") int size) {
        /**
         * Page(current,size)
         * current:当前页,long类型
         * size:每页显示的数量,long类型
         * 可参考其构造方法
         */
        IPage<User> userIPage = userService.selectPage(new Page<>(page, size));
        logger.info("UserController.selectPage:"+userIPage);
        return userIPage;
    }

    @RequestMapping("user/inster")
    public void inster() {
        User user1 = new User();
//        user1.setUserId((long) 213);
        user1.setUserName("eee");
        user1.setPassword("22333");
        User user2 = new User();
//        user2.setUserId((long) 213);
        user2.setUserName("fff");
        user2.setPassword("4314");
        List<User> users = Arrays.asList(user1, user2);
        userService.getBaseMapper().insert(user1);
    }

    @RequestMapping("user/selectlistall")
    public List<User> selectListall() {
        User user1 = new User();
        user1.setUserId((long) 1);
        List<User> selectlist = userService.selectListall(user1);
        return selectlist;
    }

    @RequestMapping("user/selectlistid")
    public List<Map<String, Object>> selectListid() {
        User user1 = new User();
        user1.setUserName("eee");
        List<Map<String, Object>> stringObjectMap = userService.selectListid(user1);
        return stringObjectMap;
    }
}
