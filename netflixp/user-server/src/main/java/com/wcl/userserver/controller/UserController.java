package com.wcl.userserver.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2021-04-21 17:57
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello"+name;
    }
}
