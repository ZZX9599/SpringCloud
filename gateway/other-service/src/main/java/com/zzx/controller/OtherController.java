package com.zzx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZZX
 * @Date: 2022/6/28 10:40
 */

@RestController
public class OtherController {

    @GetMapping("/other")
    public String other(){
        return "成功！";
    }
}
