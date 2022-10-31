package com.customerService.service;

import com.customerService.model.CustomerOrder;

public interface CustomerOrderService {
    void createCustomerOrder(CustomerOrder customerOrder) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception;
    void deleteCustomerOrderById(Long id) throws Exception;
    CustomerOrder getCustomerOrderById(Long id);
}
