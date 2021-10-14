package com.rksoft.logistics.orderservice.controller;

import com.rksoft.logistics.orderservice.domain.Order;
import com.rksoft.logistics.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("save-order")
    public Order SaveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return order;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable(name = "id") Integer orderId) {
        try {
            return orderService.getOrderById(orderId);
        } catch (URISyntaxException e) {
          return null;
        }
    }
}
