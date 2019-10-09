package com.sboot.study.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2019-10-08 16:53
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private RedisTemplate redisTemplate;

    public boolean setValue(){
        stringRedisTemplate.opsForValue().set("redisKey","study1");
        System.out.println(stringRedisTemplate.opsForValue().get("redisKey"));
        return false;
    }
}
