package com.zzx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @Author: ZZX
 * @Date: 2022/6/28 16:51
 */

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        CorsConfiguration config = new CorsConfiguration();
        //允许所有方法
        config.addAllowedMethod("*");
        //允许所有源头
        config.addAllowedOrigin("*");
        //允许所有请求头
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        //作用所有路径
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
