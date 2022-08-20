package com.zzx.controller;

import com.zzx.domain.Order;
import com.zzx.feign.UserOrderFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ZZX
 * @Date: 2022/6/26 17:55
 */

@RestController
public class UserController {

    @Resource
    private UserOrderFeign userOrderFeign;

    @GetMapping("/find")
    public Order findOrder(){
        return userOrderFeign.getOrderByUserId(1);
    }
}
