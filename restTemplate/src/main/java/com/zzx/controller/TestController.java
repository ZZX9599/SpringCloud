package com.zzx.controller;

import com.zzx.domain.Student;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZZX
 * @Date: 2022/6/22 15:25
 */

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/get")
    public String get(String name){
        return name;
    }

    @PostMapping("/post01")
    public String post01(@RequestBody Student student){
        return student.toString();
    }

    @PostMapping("/post02")
    public String post02(Student student){
        return student.toString();
    }
}
