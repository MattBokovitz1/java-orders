package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;

public interface OrderServices {
    Order findOrderById(long ordum);

    Order save(Order order);

    void deleteAllOrders();

    void delete(long ordnum);
}
