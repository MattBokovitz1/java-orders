package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping
public class OrderController {
    @Autowired
    OrderServices orderServices;

    // http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{ordnum}", produces = "application/json")
    public ResponseEntity<?> listOrderById(@PathVariable long ordnum)
    {
        Order rtnOrd = orderServices.findOrderById(ordnum);
        return new ResponseEntity<>(rtnOrd, HttpStatus.OK);
    }

    // http://localhost:2019/orders/order
    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewOrder(@RequestBody Order newOrder)
    {
        newOrder.setOrdnum(0);
        newOrder = orderServices.save(newOrder);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newOrderURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ordnum}")
                .buildAndExpand(newOrder.getOrdnum())
                .toUri();
        responseHeaders.setLocation(newOrderURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // http://localhost:2019/orders/order/63
    @PutMapping(value = "/order/{ordnum}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFullOrder(@PathVariable long ordnum, @RequestBody Order updateOrder)
    {
        updateOrder.setOrdnum(ordnum);
        updateOrder = orderServices.save(updateOrder);

        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    // http://localhost:2019/orders/order/58
    @DeleteMapping(value = "/order/{ordnum}")
    public ResponseEntity<?> deleteOrderById(@PathVariable long ordnum)
    {
        orderServices.delete(ordnum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
