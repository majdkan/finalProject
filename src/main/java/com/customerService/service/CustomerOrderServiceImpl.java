package com.customerService.service;

import com.customerService.model.Customer;
import com.customerService.model.CustomerOrder;
import com.customerService.model.CustomerOrderRequest;
import com.customerService.model.CustomerOrderResponse;
import com.customerService.repository.CustomerOrderRepository;
import com.customerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Autowired
    CustomerService customerService;


    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws Exception {
        Customer selectedCustomer = customerOrderRequest.getCustomer();
        Customer customerForResponse = null;
        if(selectedCustomer != null){
            if(selectedCustomer.getId() != null ){
                Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());
                if(existingCustomer != null){
                    // create new customer order and associate to the customer
                    customerOrderRepository.createCustomerOrder(customerOrderRequest.toCustomerOrder());
                    customerForResponse = existingCustomer;
                } else {
                    throw new Exception("Can't create customerOrder with non existing customer id " + selectedCustomer.getId());
                }
            } else {
                Long createdCustomerId = customerService.createCustomer(selectedCustomer);
                CustomerOrder customerOrderToCreate = customerOrderRequest.toCustomerOrder();
                customerOrderToCreate.setCustomerId(createdCustomerId);
                customerOrderRepository.createCustomerOrder(customerOrderToCreate);
                customerForResponse = customerService.getCustomerById(createdCustomerId);
            }
        } else {
            throw new Exception("Can't create customerOrder with customer as null");
        }
        List<CustomerOrder> customerOrderList = customerOrderRepository.getCustomerOrdersByCustomerId(customerForResponse.getId());
        CustomerOrderResponse customerOrderResponse = customerOrderRequest.getCustomerOrder().toCustomerOrderResponse(customerForResponse, customerOrderList);
        return customerOrderResponse;
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
