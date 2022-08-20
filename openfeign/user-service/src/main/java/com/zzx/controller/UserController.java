package com.zzx.controller;

import com.zzx.domain.Order;
import com.zzx.feign.UserOrderFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: ZZX
 * @Date: 2022/6/24 9:37
 */

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserOrderFeign userOrderFeign;

    @GetMapping("/userService")
    public String userController(){
        log.info("进入到用户模块");

        log.info("即将发起远程请求");

        String result = userOrderFeign.orderService();

        return result;
    }



    @GetMapping("/testParam")
    public String testParam() {
        String resultUrl = userOrderFeign.testUrl("zzx", 20);
        System.out.println(resultUrl);

        String resultOneParam = userOrderFeign.testGetOneParam("zzx");
        System.out.println(resultOneParam);

        String resultTwoParam = userOrderFeign.testGetTwoParam("zzx", 20);
        System.out.println(resultTwoParam);

        Order order = Order.builder().id("1001").name("牛排").price(102D).time(new Date()).build();
        String resultOneObj = userOrderFeign.testOneObj(order);
        System.out.println(resultOneObj);

        String resultObjAndParam = userOrderFeign.testObjAndParam(order, "张三");
        System.out.println(resultObjAndParam);

        Date date=new Date();
        System.out.println("发送时间:"+date);
        String testTime = userOrderFeign.testTime(date);
        System.out.println("收到的时间:"+testTime);
        return "ok";
    }
}
