package com.item.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 功能描述:
 *
 * @Auth: zhang xiao kang
 * @Date: 2021-12-2021/12/25
 */

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
