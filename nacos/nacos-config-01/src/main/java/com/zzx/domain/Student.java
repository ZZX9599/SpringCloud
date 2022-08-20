package com.zzx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 11:34
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RefreshScope
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
}
