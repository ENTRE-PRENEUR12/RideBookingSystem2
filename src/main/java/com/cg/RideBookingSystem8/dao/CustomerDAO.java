package com.cg.RideBookingSystem8.dao;

import java.util.List;

import com.cg.RideBookingSystem8.entities.Customer;

/**
 * DAO interface for managing Customer entities.
 * @author SOUMYODIP SUTRADHAR
 */
public interface CustomerDAO {

    /**
     * Saves a new customer to the data source.
     * 
     * @param customer the customer to save
     */
    void save(Customer customer);

    /**
     * Finds a customer by their ID.
     * 
     * @param id the ID of the customer
     * @return the Customer object if found, otherwise null
     */
    Customer findById(String id);

    /**
     * Retrieves all customers from the data source.
     * 
     * @return a list of all customers
     */
    List<Customer> findAll();

    /**
     * Updates the information of an existing customer.
     * 
     * @param customer the customer with updated information
     */
    void update(Customer customer);

    /**
     * Deletes a customer by their ID.
     * 
     * @param id the ID of the customer to delete
     */
    void delete(String id);
}
