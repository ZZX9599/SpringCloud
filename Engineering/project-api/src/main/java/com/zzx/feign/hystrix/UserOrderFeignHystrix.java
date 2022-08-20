package com.zzx.feign.hystrix;

import com.zzx.domain.Order;
import com.zzx.feign.UserOrderFeign;
import org.springframework.stereotype.Component;

/**
 * @Author: ZZX
 * @Date: 2022/6/26 18:02
 */

@Component
public class UserOrderFeignHystrix implements UserOrderFeign {
    @Override
    public Order getOrderByUserId(Integer userId) {
        return null;
    }
}
