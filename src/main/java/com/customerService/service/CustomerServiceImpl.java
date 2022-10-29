package com.customerService.service;

import com.customerService.model.Customer;
import com.customerService.model.CustomerStatus;
import com.customerService.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createCustomer(Customer customer) throws Exception {
        System.out.println("Starting to create new customer as string: " + objectMapper.writeValueAsString(customer));
        String customerAsString = objectMapper.writeValueAsString(customer);
        Customer customerFromString = objectMapper.readValue(customerAsString, Customer.class);
        System.out.println("Starting to create new customer as object: " + customerFromString);
        if(customer.getStatus() == CustomerStatus.VIP){
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);
            if(vipCustomers.size() < 10 ) {
                customerRepository.createCustomer(customer);
            } else {
                throw new Exception("Can't create new customer with VIP status, Out of limit");
            }
        } else {
            customerRepository.createCustomer(customer);
        }
    }

    @Override
    public void updateCustomerById(Long customerId, Customer customer) throws Exception {
        if(customer.getStatus() == CustomerStatus.VIP){
            Customer existingCustomer = customerRepository.getCustomerById(customerId);
            if(existingCustomer.getStatus() != CustomerStatus.VIP){
                List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);
                if(vipCustomers.size() < 10){
                    customerRepository.updateCustomerById(customerId, customer);
                } else {
                    throw new Exception("Can't update customer status to VIP, Out of limit");
                }
            } else {
                customerRepository.updateCustomerById(customerId, customer);
            }
        } else {
            customerRepository.updateCustomerById(customerId, customer);
        }
    }

    @Override
    public void deleteCustomerById(Long id) {
        deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        return customerRepository.getCustomersByFirstName(firstName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Long> getCustomerIdsByFirstName(String firstName) {
        return customerRepository.getCustomerIdsByFirstName(firstName);
    }
}
