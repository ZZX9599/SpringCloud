package com.zzx.feign.hystrix;

import com.zzx.feign.CustomerFeignRentCar;
import org.springframework.stereotype.Component;

/**
 * @Author: ZZX
 * @Date: 2022/6/25 12:05
 * 这个是备选方案
 */

@Component
public class CustomerFeignRentCarHystrix implements CustomerFeignRentCar {
    @Override
    public String rentCar() {
        return "炸了";
    }
}
