package com.sboot.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sboot.study.dao.UserMapper;
import com.sboot.study.domain.Greeting;
import com.sboot.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2019-10-08 9:46
 */
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/users")
    public JSONObject users(){
        JSONObject j = new JSONObject();
        j.put("user", userMapper.selectByPrimaryKey(1));
        PageHelper.startPage(1,20);
        List<User> users = userMapper.selectAll();
        j.put("usersm", new PageInfo(users));
        /*String sql="select * from sys_user";
        RowMapper<SysUser> rowMapper=new BeanPropertyRowMapper<SysUser>(SysUser.class);
        List users= jdbcTemplate.query(sql, rowMapper);
        j.put("users", users);*/
        return j;
    }
}
