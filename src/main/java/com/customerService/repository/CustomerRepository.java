package com.customerService.repository;

import com.customerService.model.Customer;
import com.customerService.model.CustomerStatus;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CustomerRepository {
    Long createCustomer(Customer customer);
    void updateCustomerById(Long customerId, Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id) throws JsonProcessingException;
    List<Customer> getCustomersByFirstName(String firstName);
    List<Customer> getAllCustomers();
    List<Long> getCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus status);
}
