package com.rksoft.logistics.orderservice.service;

import com.rksoft.logistics.orderservice.data.entity.OrderEntity;
import com.rksoft.logistics.orderservice.data.repository.OrderRepository;
import com.rksoft.logistics.orderservice.domain.Item;
import com.rksoft.logistics.orderservice.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;

    public void saveOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity(order.getOrderId(), order.getOrderName());
        orderRepository.save(orderEntity);
    }

    public List<Order> getOrders() {
      return  Arrays.asList(new Order(101, "Laptop", null));
    }

    public Order getOrderById(Integer orderId) throws URISyntaxException {
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
        if (optionalOrderEntity.isPresent()) {
            Item[] items = restTemplate.getForObject(new URI("http://ITEM-SERVICE/items"), Item[].class);
            return new Order(optionalOrderEntity.get().getOrderId(), optionalOrderEntity.get().getOrderName(), Arrays.asList(items));
        } else {
            return null;
        }
    }
}
