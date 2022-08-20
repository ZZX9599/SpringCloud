package com.zzx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: ZZX
 * @Date: 2022/6/25 9:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String name;
    private Double price;
    private Date time;
}
