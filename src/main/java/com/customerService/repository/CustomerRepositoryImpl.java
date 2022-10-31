package com.customerService.repository;

import com.customerService.model.Customer;
import com.customerService.model.CustomerStatus;
import com.customerService.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " (first_name, last_name, email, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getStatus().name());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateCustomerById(Long customerId, Customer customer) {
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME + " SET first_name=?, last_name=?, email=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customerId);
    }

    @Override
    public void deleteCustomerById(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, new CustomerMapper(), firstName);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new CustomerMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Long> getCustomerIdsByFirstName(String firstName) {
        String sql = "SELECT c.id FROM " + CUSTOMER_TABLE_NAME + " AS c WHERE c.first_name = ?";
        try {
            return jdbcTemplate.queryForList(sql, Long.class, firstName);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomersByStatus(CustomerStatus status) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " AS C WHERE C.status = ?";
        try {
            return jdbcTemplate.query(sql, new CustomerMapper(), status.name());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}
