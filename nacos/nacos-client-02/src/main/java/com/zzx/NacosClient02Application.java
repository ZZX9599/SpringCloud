package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZZX
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClient02Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosClient02Application.class, args);
    }

}
