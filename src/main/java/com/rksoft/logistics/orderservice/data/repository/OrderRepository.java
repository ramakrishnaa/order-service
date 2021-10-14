package com.rksoft.logistics.orderservice.data.repository;

import com.rksoft.logistics.orderservice.data.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
