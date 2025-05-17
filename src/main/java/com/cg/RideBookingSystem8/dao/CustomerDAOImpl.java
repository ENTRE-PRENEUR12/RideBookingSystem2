package com.cg.RideBookingSystem8.dao;

import java.util.ArrayList;
import java.util.List;
import com.cg.RideBookingSystem8.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	private List<Customer> customers = new ArrayList<>();


    public void save(Customer customer) {
        customers.add(customer);
    }


    public Customer findById(String id) {
        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                return customer;
            }
        }
        return null;
    }


    public List<Customer> findAll() {
        return customers;
    }


    public void update(Customer customer) {
        Customer existingCustomer = findById(customer.getID());
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
        }
    }
    

    public void delete(String id) {
        customers.removeIf(customer -> customer.getID().equals(id));
    }
}
