package com.cg.RideBookingSystem8.dao;

import java.util.List;

import com.cg.RideBookingSystem8.entities.Customer;

public interface CustomerDAO {
	void save(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();
    void update(Customer customer);
    void delete(String id);
}
