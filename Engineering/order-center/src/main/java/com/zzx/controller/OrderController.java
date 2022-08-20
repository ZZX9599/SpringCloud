package com.zzx.controller;

import com.zzx.domain.Order;
import com.zzx.feign.UserOrderFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZZX
 * @Date: 2022/6/26 17:32
 */

@RestController
public class OrderController implements UserOrderFeign {

    @Override
    public Order getOrderByUserId(Integer userId) {

        System.out.println("用户id:"+userId);

        Order order = Order.builder()
                .id(1)
                .name("回锅肉")
                .price(20D).build();

        return order;
    }
}
