package com.zzx.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ZZX
 * @Date: 2022/6/28 10:07
 * 请求一般放在请求头里面
 * 一般key叫做 Authorization
 * 一般value是 bearer token
 * 这是全局过滤器，不能直接先拿token，先拿到路径，如果是登录，放行，不是就验证token
 */

//@Component
public class CheckTokenFilter implements GlobalFilter, Ordered {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 放行的路径
     */

    private static final List<String> ALLOW_LIST = Arrays.asList("/login-service/doLogin");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //拿到url
        String path = exchange.getRequest().getURI().getPath();
        System.out.println(path);

        //判断
        if (ALLOW_LIST.contains(path)) {
            return chain.filter(exchange);
        }

        //检查token
        List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");

        if(authorization!=null&&authorization.size()!=0){
            //判断token是否有效
            String token = authorization.get(0);

            //一般value是 bearer token
            //所以我们还要去除bearer

            String[] s = token.split(" ");
            token= s[1];

            //这下来判断token是否和redis的key一致
            if (token.length() != 0 && stringRedisTemplate.hasKey(token)) {
                return chain.filter(exchange);
            }
        }

        //拦截
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().set("content-type","application/json;charset=utf-8");

        HashMap<String, Object> stringObjectHashMap = new HashMap<>(4);

        stringObjectHashMap.put("code", HttpStatus.UNAUTHORIZED.value());
        stringObjectHashMap.put("msg","未授权");

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes=null;
        try {
             bytes= objectMapper.writeValueAsBytes(stringObjectHashMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
