package com.customerService.model;

import java.util.List;

public class CustomerOrderResponse {
    private Customer customer;
    private List<CustomerOrder> customerOrders;

    public CustomerOrderResponse(Customer customer, List<CustomerOrder> customerOrders) {
        this.customer = customer;
        this.customerOrders = customerOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
