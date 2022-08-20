package com.zzx.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * @Author: ZZX
 * @Date: 2022/6/27 15:59
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().
                route("test-id01",r -> r.path("/jxlzzx").uri("https://gitee.com/")).
                route("test-id02",r->r.path("/jxlzzx/projects").uri("https://gitee.com/")).build();
    }

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println(now);
    }
}
