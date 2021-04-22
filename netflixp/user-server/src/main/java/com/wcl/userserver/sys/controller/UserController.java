package com.wcl.userserver.sys.controller;


import com.wcl.userserver.sys.entity.User;
import com.wcl.userserver.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("get/{id}")
    public User getById(@PathVariable("id") Integer id){
        return iUserService.getById(id);
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

