package com.zzx.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: ZZX
 * @Date: 2022/6/28 15:59
 * 自定义请求限流
 */

@Configuration
public class RequestLimitConfig {
    /**
     * 针对ip限流
     */
    @Bean
    @Primary
    public KeyResolver ipLimit(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
            }
        };
    }

    /**
     * 针对接口名称实现限制
     */
    //@Bean
    public KeyResolver apiLimit(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getPath().value());
            }
        };
    }
}
