package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.Optional;

public interface CustomerService {
    public Iterable<Customer> findAll();
    public Customer createCustomer(Customer customer);
    public Optional<Customer> findByName(String name);
    public void deleteCustomer(Long id);
}
