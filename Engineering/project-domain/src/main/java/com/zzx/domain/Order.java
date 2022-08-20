package com.zzx.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZZX
 * @Date: 2022/6/26 17:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Integer id;
    private String name;
    private Double price;

}
