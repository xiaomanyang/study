package com.wcl.userserver.sys.service.impl;

import com.wcl.userserver.sys.entity.User;
import com.wcl.userserver.sys.mapper.UserMapper;
import com.wcl.userserver.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wcl
 * @since 2021-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
