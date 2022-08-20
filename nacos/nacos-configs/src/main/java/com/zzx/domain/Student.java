package com.zzx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 17:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
    private String address;
    private Integer score;
}
