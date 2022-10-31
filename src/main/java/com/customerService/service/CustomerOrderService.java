package com.customerService.service;

import com.customerService.model.CustomerOrder;
import com.customerService.model.CustomerOrderRequest;
import com.customerService.model.CustomerOrderResponse;

public interface CustomerOrderService {
    CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception;
    void deleteCustomerOrderById(Long id) throws Exception;
    CustomerOrder getCustomerOrderById(Long id);
}
