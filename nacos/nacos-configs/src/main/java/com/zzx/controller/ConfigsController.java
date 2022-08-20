package com.zzx.controller;

import com.zzx.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 17:30
 */

@RestController
public class ConfigsController {

    @Resource
    private Student student;

    @GetMapping("/configs")
    public String configs(){
        return student.toString();
    }
}
