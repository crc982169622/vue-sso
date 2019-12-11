package com.crc.vue.sso.server.service.fallback;

import com.crc.vue.sso.server.service.RedisCacheService;
import org.springframework.stereotype.Component;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/12/1 18:11
 **/
@Component
public class RedisServiceFallback implements RedisCacheService {
    @Override
    public void put(String key, String value, long seconds) {
    }

    @Override
    public String get(String key) {
        return null;
    }

}
