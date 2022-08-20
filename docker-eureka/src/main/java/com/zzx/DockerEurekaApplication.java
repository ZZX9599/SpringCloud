package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: ZZX
 * @Date: 2022/7/9 21:32
 */

@SpringBootApplication
@EnableEurekaServer
public class DockerEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerEurekaApplication.class,args);
    }
}
