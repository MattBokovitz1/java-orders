package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "paymentServices")
public class PaymentServicesImpl implements PaymentServices{
    @Autowired
    PaymentRepository payrepos;

    @Transactional
    @Override
    public Payment save(Payment payment){
        return payrepos.save(payment);
    }

    @Autowired
    public void deleteAllPayments(){

    }
}
