package com.zzx.controller;

import com.zzx.domain.User;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.UUID;

/**
 * @Author: ZZX
 * @Date: 2022/6/27 15:39
 */

@RestController
public class LoginController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/doLogin")
    public String doLogin(){

        //假设已经查询了数据库
        User user=new User("1001","zzx","123",20);

        //拿到token
        String token = UUID.randomUUID().toString();

        //存入redis【为什么要存，因为HTTP是无状态协议】
        stringRedisTemplate.opsForValue().set(token,user.toString(), Duration.ofSeconds(7200));

        //返回token给前端
        return token;
    }
}
