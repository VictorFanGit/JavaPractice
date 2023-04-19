package com.victor.javapractice.java8.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

//订单类
@Data
@Accessors(chain = true)
public class Order {
    private Long id;
    private Long customerId;//顾客ID
    private String customerName;//顾客姓名
    private List<OrderItem> orderItemList = Lists.newArrayList();//订单商品明细
    private Double totalPrice;//总价格
    private LocalDateTime placedAt = LocalDateTime.now();//下单时间

}
