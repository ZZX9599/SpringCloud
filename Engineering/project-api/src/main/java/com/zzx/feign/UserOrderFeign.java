package com.zzx.feign;

import com.zzx.domain.Order;
import com.zzx.feign.hystrix.UserOrderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: ZZX
 * @Date: 2022/6/26 17:33
 */

@FeignClient(value = "order-service",fallback = UserOrderFeignHystrix.class)
public interface UserOrderFeign {
    /**
     * 根据id查询订单
     * @param userId
     * @return
     */
    @GetMapping("/getOrderByUserId")
    Order getOrderByUserId(@RequestParam Integer userId);
}
