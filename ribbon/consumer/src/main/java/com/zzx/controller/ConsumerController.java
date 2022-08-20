package com.zzx.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: ZZX
 * @Date: 2022/6/23 9:07
 */

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/testRibbon")
    public String testRibbon(String applicationName){

        //正常来说，url需要用ip和端口，这里我们把提供者注册到了注册中心，直接写微服务名称即可

        //ribbon会把注册中心里面的微服务解析为ip+port

        //ribbon首先会拦截，从eureka里面拿到服务集合，再通过负载均衡算法来拿到一个服务的ip+port

        String url="http://"+applicationName+"/hello";

        String result = restTemplate.getForObject(url, String.class);

        return result;
    }

    /**
     * 核心是负载均衡
     * @param applicationName
     * @return
     */
    @GetMapping("/testRibbonRule")
    public String testRibbonRule(String applicationName){

        ServiceInstance choose = loadBalancerClient.choose(applicationName);

        return choose.toString();
    }

}
