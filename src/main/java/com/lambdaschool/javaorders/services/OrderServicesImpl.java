package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.OrderRepository;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices{

    @Autowired
    OrderRepository orderrepos;

    @Autowired
    PaymentRepository payrepos;

    @Override
    public Order findOrderById(long ordnum){
        Order rtnOrd = orderrepos.findById(ordnum)
                .orElseThrow(() -> new EntityNotFoundException("Order " + ordnum + " Not Found"));
        return rtnOrd;
    }

    @Transactional
    @Override
    public Order save(Order order){
        Order newOrder = new Order();

        if(order.getOrdnum() != 0){
            findOrderById(order.getOrdnum());
            newOrder.setOrdnum(order.getOrdnum());
        }

        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setOrderdescription(order.getOrderdescription());
        newOrder.setCustomer(order.getCustomer());

        // collections
        newOrder.getPayments().clear();
        for (Payment p : order.getPayments())
        {
            Payment newPayment = payrepos.findById(p.getPaymentid())
                    .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " Not Found"));
            newOrder.getPayments().add(newPayment);
        }

        return orderrepos.save(newOrder);
    }

    @Transactional
    @Override
    public void deleteAllOrders()
    {
        orderrepos.deleteAll();
    }

    @Transactional
    @Override
    public void delete(long ordnum)
    {
        if (orderrepos.findById(ordnum)
                .isPresent())
        {
            orderrepos.deleteById(ordnum);
        } else
        {
            throw new EntityNotFoundException("Order " + ordnum + " Not Found");
        }
    }
}
