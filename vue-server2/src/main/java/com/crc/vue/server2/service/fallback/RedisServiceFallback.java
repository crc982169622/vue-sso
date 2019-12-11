package com.crc.vue.server2.service.fallback;

import com.crc.vue.server2.service.RedisCacheService;
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
