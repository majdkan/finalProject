package com.customerService.controller;

import com.customerService.model.CustomerOrder;
import com.customerService.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping(value = "/customerOrder/create")
    public void createCustomerOrder(@RequestBody CustomerOrder customerOrder) throws Exception {
        customerOrderService.createCustomerOrder(customerOrder);
    }

    @PutMapping(value = "/customerOrder/{customerOrderId}/update")
    public void updateCustomerOrderById(@PathVariable Long customerOrderId,
                                   @RequestBody CustomerOrder customerOrder) throws Exception {
        customerOrderService.updateCustomerOrderById(customerOrderId, customerOrder);
    }

    @DeleteMapping(value = "/customerOrder/{customerOrderId}/delete")
    public void deleteCustomerOrderById(@PathVariable Long customerOrderId) throws Exception {
        customerOrderService.deleteCustomerOrderById(customerOrderId);
    }

    @GetMapping(value = "/customerOrder/{customerOrderId}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long customerOrderId) {
        return customerOrderService.getCustomerOrderById(customerOrderId);
    }
}

