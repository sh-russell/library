package com.example.library.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.security.core.userdetails.User;

import java.nio.file.Files;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
public class CacheConfig {
    public Caffeine caffeine() {
        return Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES);
    }

    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine());
        return cacheManager;

    }
}
