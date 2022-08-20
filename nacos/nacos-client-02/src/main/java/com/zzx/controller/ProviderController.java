package com.zzx.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 9:37
 */
@RestController
public class ProviderController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/provider")
    public String provider(){
        List<ServiceInstance> instances = discoveryClient.getInstances("zzx-service");

        ServiceInstance serviceInstance = instances.get(0);

        return "提供者"+serviceInstance.getPort();
    }
}
