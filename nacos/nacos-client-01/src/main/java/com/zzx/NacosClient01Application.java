package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZZX
 * 开启nacos
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosClient01Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosClient01Application.class, args);
    }

}
