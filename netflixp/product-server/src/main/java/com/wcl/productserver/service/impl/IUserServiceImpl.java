package com.wcl.productserver.service.impl;

import com.wcl.entity.User;
import com.wcl.productserver.service.IUserService;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2021-04-25 17:37
 */
public class IUserServiceImpl implements IUserService {
    @Override
    public User getUser(Integer id) {
        User u = new User();
        u.setUname("幽灵喵喵");
        return u;
    }
}
