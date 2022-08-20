package com.zzx.feign;

import com.zzx.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: ZZX
 * @Date: 2022/6/24 9:42
 * FeignClient开启注解  value就是远程调用的微服务名称
 */

@FeignClient(value = "order-service")

public interface UserOrderFeign {

    /**
     * 远程调用orderService
     * @return
     */
    @GetMapping("/orderService")
    public String orderService();

    /**
     * 测试URL传递参数,res风格
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/testUrl/{name}/and/{age}")
    public String testUrl(@PathVariable("name") String name, @PathVariable Integer age);

    /**
     * get传递一个参数
     * @param name
     * @return
     */
    @GetMapping("/testGetOneParam")
    public String testGetOneParam(@RequestParam String name);

    /**
     * get传递两个参数
     * @param name
     * @return
     */
    @GetMapping("/testGetTwoParam")
    public String testGetTwoParam(@RequestParam String name,@RequestParam Integer age);

    /**
     * post传递一个对象
     * @param order
     * @return
     */
    @PostMapping("/testOneObj")
    public String testOneObj(@RequestBody Order order);

    /**
     * post传递一个对象+一个参数
     * @param order
     * @return
     */
    @PostMapping("/testObjAndParam")
    public String testObjAndParam(@RequestBody Order order,@RequestParam String name);

    /**
     * 测试时间
     * 不建议单独发送时间
     * 1：可以放在对象里面或者字符串里面
     * 2：可以使用LocalDate.now方法  年月日【没有差错】
     * 3：可以使用LocalDate.time方法  时间 【缺少秒】
     * @param date
     * @return
     */
    @GetMapping("/testTime")
    public String testTime(@RequestParam Date date);
}
