package com.wcl.productserver.service;

import com.wcl.entity.User;
import com.wcl.productserver.service.impl.IUserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wcl
 * @since 2021-04-23
 */
@FeignClient(value = "userserver", path = "/user", fallback = IUserServiceImpl.class)
public interface IUserService {

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    User getUser(@PathVariable("id") Integer id);
}
