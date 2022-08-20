package com.zzx.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;

/**
 * @Author: ZZX
 * @Date: 2022/6/27 17:35
 */

//@Component
public class MyFilter implements GlobalFilter, Ordered {

    /**
     * 全局过滤器
     * 过滤器链【叫做责任链模式】
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //注意区分HttpServletRequest和HttpServletResponse

        //请求
        ServerHttpRequest request = exchange.getRequest();

        URI uri = request.getURI();
        System.out.println("请求的URI:"+uri.toString());
        System.out.println("路径:"+uri.getPath());
        HttpHeaders headers = request.getHeaders();
        System.out.println("请求头:"+headers);
        String name = request.getMethod().name();
        System.out.println("请求方式:"+name);
        String hostName = request.getRemoteAddress().getHostName();
        System.out.println("ip:"+hostName);


        //响应
        ServerHttpResponse response = exchange.getResponse();
        /**
         * 使用了网关，肯定已经前后分离了，一般使用json交互
         *  {
         *  "code":200,
         *  "msg":"ok"
         *  }
         */
        //设置响应编码
        response.getHeaders().set("content-type","application/json;charset=utf-8");

        return chain.filter(exchange);
    }

    /**
     * 指定过滤器顺序，越小越先执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
