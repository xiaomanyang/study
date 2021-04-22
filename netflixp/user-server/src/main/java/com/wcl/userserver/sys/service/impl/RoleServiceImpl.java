package com.wcl.userserver.sys.service.impl;

import com.wcl.userserver.sys.entity.Role;
import com.wcl.userserver.sys.mapper.RoleMapper;
import com.wcl.userserver.sys.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
