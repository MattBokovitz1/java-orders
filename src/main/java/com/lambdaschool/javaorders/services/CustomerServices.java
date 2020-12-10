package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;

import java.util.List;

public interface CustomerServices {
    List<Customer> findAllCustomers();
    Customer findCustomerById(long custcode);
    List<Customer> findCustomerLikeName(String subname);

    Customer save(Customer customer);

    void deleteAllCustomers();
    void delete(long custcode);

    Customer update(
            Customer updateCustomer,
            long custcode);
}
