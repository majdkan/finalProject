package com.customerService.controller;


import com.customerService.model.Customer;
import com.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customer/create")
    public void createCustomer(@RequestBody Customer customer) throws Exception {
        customerService.createCustomer(customer);
    }

    @PutMapping(value = "/customer/{customerId}/update")
    public void updateCustomerById(@PathVariable Long customerId,
                                   @RequestBody Customer customer) throws Exception {
        customerService.updateCustomerById(customerId, customer);
    }

    @DeleteMapping(value = "/customer/{customerId}/delete")
    public void deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping(value = "/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(value = "/customer/{firstName}/all")
    public List<Customer> getCustomersByFirstName(@PathVariable String firstName){
        return customerService.getCustomersByFirstName(firstName);
    }

    @GetMapping(value = "/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/customerId/{firstName}/all")
    public List<Long> getCustomerIdsByFirstName(@PathVariable String firstName){
        return customerService.getCustomerIdsByFirstName(firstName);
    }
}

