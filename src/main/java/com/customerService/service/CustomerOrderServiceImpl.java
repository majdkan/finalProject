package com.customerService.service;

import com.customerService.model.CustomerOrder;
import com.customerService.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) throws Exception {
        customerOrderRepository.createCustomerOrder(customerOrder);
    }

    @Override
    public void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception {
        customerOrderRepository.updateCustomerOrderById(customerOrderId, customerOrder);

    }

    @Override
    public void deleteCustomerOrderById(Long id) throws Exception {
        customerOrderRepository.deleteCustomerOrderById(id);

    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
