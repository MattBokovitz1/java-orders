package com.lambdaschool.orders.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lambdaschool.orders.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
