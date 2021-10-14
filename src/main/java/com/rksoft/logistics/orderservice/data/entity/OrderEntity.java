package com.rksoft.logistics.orderservice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "id")
    private Integer orderId;
    @Column(name = "name")
    private String orderName;
}
