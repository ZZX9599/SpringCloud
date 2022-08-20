package com.zzx.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ZZX
 * @Date: 2022/6/28 9:09
 * 登陆的ip拦截
 */
//@Component
public class IPCheckFilter implements GlobalFilter, Ordered {
    /**
     * 黑名单
     */
    private static final List<String> BLACK_LIST= Arrays.asList("127.0.0.1");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //拿到ip
        ServerHttpRequest request = exchange.getRequest();

        String ip = request.getHeaders().getHost().toString();

        System.out.println("ip===="+ip);

        //查询数据库看是否为黑名单ip【网关的速度远大于数据库】所以一般使用redis
        if (BLACK_LIST.contains(ip)) {
            //拦截
            ServerHttpResponse response = exchange.getResponse();

            response.getHeaders().set("content-type","application/json;charset=urf-8");

            HashMap<String, Object> stringObjectHashMap = new HashMap<>(4);

            //自定义的438
            stringObjectHashMap.put("code", 438);

            stringObjectHashMap.put("msg","ip受限制");

            ObjectMapper objectMapper = new ObjectMapper();

            byte[] bytes = new byte[0];
            try {
                bytes = objectMapper.writeValueAsBytes(stringObjectHashMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            DataBuffer wrap = response.bufferFactory().wrap(bytes);

            return response.writeWith(Mono.just(wrap));

        }
        //放行
        Mono<Void> filter = chain.filter(exchange);
        return filter;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
