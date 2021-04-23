package com.wcl.userserver.sys.controller;


import com.wcl.userserver.sys.entity.User;
import com.wcl.userserver.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wcl
 * @since 2021-04-22
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    public IUserService iUserService;
    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @GetMapping("get/{id}")
    public User getById(@PathVariable("id") Integer id){
        redisTemplate.opsForValue().increment(String.valueOf(id));
        User user = iUserService.getById(id);
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        session.setAttribute(user.getAccount(), user);
        return user;
    }

    @GetMapping("save")
    public boolean save(){
        User user = new User();
        user.setAccount("18765862338");
        user.setUname("manyang");
        user.setUpwd("habuha");
        return iUserService.save(user);
    }
}

