package com.wcl.productserver.controller;


import com.wcl.entity.User;
import com.wcl.productserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wcl
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/productserver/goods")
public class GoodsController {

    @Autowired
    public IUserService iUserService;

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return iUserService.getUser(id);
    }

    @GetMapping("session")
    public User sessionUser(){
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return (User)session.getAttribute("18765862338");
    }
}

