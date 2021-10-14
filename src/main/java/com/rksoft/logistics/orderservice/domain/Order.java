package com.rksoft.logistics.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private String orderName;
    private List<Item> lineItems;
}
