package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders") // optional
public class OrdersController
{
    @Autowired
    private OrdersService ordersService;

}
