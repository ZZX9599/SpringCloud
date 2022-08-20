package com.zzx.feign;

import com.zzx.feign.hystrix.CustomerFeignRentCarHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ZZX
 * @Date: 2022/6/25 11:48
 * fallback：远程服务挂了，就走这个
 */

@FeignClient(value = "car-service",fallback = CustomerFeignRentCarHystrix.class)
public interface CustomerFeignRentCar {

    /**
     * 用户租车
     * @return
     */
    @GetMapping("/rentCar")
    public String rentCar();
}
