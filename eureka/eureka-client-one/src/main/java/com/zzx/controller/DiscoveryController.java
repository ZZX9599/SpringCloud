package com.zzx.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZZX
 * @Date: 2022/6/21 16:23
 */

@RestController
public class DiscoveryController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/test/{serviceName}")
    public String getDiscoveryInfo(@PathVariable String serviceName){
        //服务发现，通过微服务的名称来拿到服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

        ServiceInstance serviceInstance = instances.get(0);

        String ip = serviceInstance.getHost();

        int port = serviceInstance.getPort();

        return "ip:"+ip+"端口:"+port;
    }
}
