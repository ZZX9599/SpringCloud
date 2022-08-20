package com.zzx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZZX
 * @Date: 2022/6/24 9:23
 */

@RestController
public class OrderController {

    @GetMapping("/orderService")
    public String orderService(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "买了包子";
    }

}
