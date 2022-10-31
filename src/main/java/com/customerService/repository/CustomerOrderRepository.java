package com.customerService.repository;

import com.customerService.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository {
    void createCustomerOrder(CustomerOrder customerOrder) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception;
    void deleteCustomerOrderById(Long id) throws Exception;
    CustomerOrder getCustomerOrderById(Long id);
    List<CustomerOrder> getCustomerOrdersByCustomerId(Long customerId);
}
