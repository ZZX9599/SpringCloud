package com.zzx.controller;

import com.zzx.feign.ProviderFeign;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 9:29
 */

@RestController
public class TestController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private ProviderFeign providerFeign;


    @GetMapping("/test")
    public String test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("zzx-service");
        System.out.println(instances.size());
        if(instances.size()!=0){
            return "成功";
        }
        return "失败";
    }

    @GetMapping("/consumer")
    public String consumer(){
        String provider = providerFeign.provider();
        return "远程调用信息:"+provider;
    }

    @GetMapping("/info")
    public String info(String serviceName){
        //服务发现从nacos拿到服务集合
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        String result="";
        if(instances.size()!=0){
            ServiceInstance serviceInstance = instances.get(0);
            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            result=host+port;
        }
        return result;
    }
}
