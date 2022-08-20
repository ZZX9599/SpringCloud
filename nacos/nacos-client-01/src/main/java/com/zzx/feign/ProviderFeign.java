package com.zzx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ZZX
 * @Date: 2022/6/29 9:43
 */
@FeignClient(value = "zzx-service")
public interface ProviderFeign {
    /**
     * feign远程调用zzx-service的provider的api
     * @return
     */
    @GetMapping("/provider")
    public String provider();
}
