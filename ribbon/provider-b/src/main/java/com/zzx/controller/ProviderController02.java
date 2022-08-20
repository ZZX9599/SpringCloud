package com.zzx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZZX
 * @Date: 2022/6/23 8:59
 */

@RestController
public class ProviderController02 {

    @GetMapping("/hello")
    public String hello(){
        return "我是provider-b";
    }
}
