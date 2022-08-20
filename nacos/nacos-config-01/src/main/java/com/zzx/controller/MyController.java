package com.zzx.controller;

import com.zzx.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 11:02
 */

@RestController
public class MyController {

    @Resource
    private Student student;

    @GetMapping("/info")
    public String info(){
        return "学生信息:"+student;
    }
}
