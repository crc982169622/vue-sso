package com.crc.vue.sso.redis.service;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/12/1 17:31
 **/
public interface RedisServerService {

    void put(String key, Object value, long seconds);

    Object get(String key);
}
