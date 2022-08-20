package com.zzx.controller;

import com.zzx.feign.CustomerFeignRentCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author: ZZX
 * @Date: 2022/6/25 11:50
 */

@RestController
public class CustomerController {

    @Resource
    private CustomerFeignRentCar customerFeignRentCar;

    @GetMapping("/customer")
    public String customer(){
        String rentCarMsg = customerFeignRentCar.rentCar();
        return rentCarMsg;
    }
}
