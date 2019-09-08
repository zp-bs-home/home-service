package org.nix.home.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping
    public Object set() {
        redisTemplate.opsForValue().set("zhangpei", "zhangpei", 5, TimeUnit.SECONDS);
        return "ok";
    }

}
