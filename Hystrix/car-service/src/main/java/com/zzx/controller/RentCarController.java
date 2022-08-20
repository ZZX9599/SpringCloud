package com.zzx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZZX
 * @Date: 2022/6/25 11:44
 */

@RestController
public class RentCarController {

    @GetMapping("/rentCar")
    public String rentCar(){
        return "租车成功";
    }
}
