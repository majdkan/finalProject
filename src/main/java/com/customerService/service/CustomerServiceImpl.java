package com.customerService.service;

import com.customerService.model.Customer;
import com.customerService.model.CustomerStatus;
import com.customerService.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public Long createCustomer(Customer customer) throws Exception {
        if(customer.getStatus() == CustomerStatus.VIP){
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);
            if(vipCustomers.size() < 10 ) {
                return customerRepository.createCustomer(customer);
            } else {
                throw new Exception("Can't create new customer with VIP status, Out of limit");
            }
        } else {
            return customerRepository.createCustomer(customer);
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
    public void deleteCustomerById(Long id) throws Exception {
        Customer existingCustomer =  customerRepository.getCustomerById(id);
        if(existingCustomer != null){
            customerRepository.deleteCustomerById(id);
        } else {
            throw new Exception("The customer id: " + id + " is not existing, so we can't delete it");
        }
    }

    @Override
    public Customer getCustomerById(Long id) throws JsonProcessingException {
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
