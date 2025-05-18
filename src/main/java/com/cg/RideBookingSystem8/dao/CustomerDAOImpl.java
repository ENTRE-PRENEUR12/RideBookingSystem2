package com.cg.RideBookingSystem8.dao;

import java.util.ArrayList;
import java.util.List;
import com.cg.RideBookingSystem8.entities.Customer;

/**
 * Implementation of CustomerDAO interface using in-memory list storage.
 * @author SOUMYODIP SUTRADHAR
 */
public class CustomerDAOImpl implements CustomerDAO {

    private List<Customer> customers = new ArrayList<>();

    /**
     * Saves a new customer to the list.
     *
     * @param customer the customer to be saved
     */
    public void save(Customer customer) {
        customers.add(customer);
    }

    /**
     * Finds a customer by their ID.
     *
     * @param id the ID of the customer
     * @return the Customer object if found, otherwise null
     */
    public Customer findById(String id) {
        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Returns a list of all customers.
     *
     * @return list of customers
     */
    public List<Customer> findAll() {
        return customers;
    }

    /**
     * Updates the name of an existing customer.
     *
     * @param customer the customer with updated details
     */
    public void update(Customer customer) {
        Customer existingCustomer = findById(customer.getID());
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
        }
    }

    /**
     * Deletes a customer from the list by ID.
     *
     * @param id the ID of the customer to delete
     */
    public void delete(String id) {
        customers.removeIf(customer -> customer.getID().equals(id));
    }
}
