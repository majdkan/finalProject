package com.customerService.repository;

import com.customerService.model.CustomerOrder;
import com.customerService.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository{

    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME + " (customer_id, item_name, price, currency) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customerOrder.getCustomerId(), customerOrder.getItemName(), customerOrder.getPrice(), customerOrder.getCurrency().name());
    }

    @Override
    public void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME + " SET customer_id=?, item_name=?, price=?, currency=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, customerOrder.getCustomerId(), customerOrder.getItemName(), customerOrder.getPrice(), customerOrder.getCurrency().name(), customerOrderId);
    }

    @Override
    public void deleteCustomerOrderById(Long id) throws Exception {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerOrderMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<CustomerOrder> getCustomerOrdersByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try {
            return jdbcTemplate.query(sql, new CustomerOrderMapper(), customerId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}
