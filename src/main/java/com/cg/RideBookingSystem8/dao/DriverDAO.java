package com.cg.RideBookingSystem8.dao;

import java.util.List;
import com.cg.RideBookingSystem8.entities.Driver;

/**
 * Data Access Object interface for Driver entity.
 * @author Shivam Kumar
 */
public interface DriverDAO {

    /**
     * Saves a driver to the data store.
     *
     * @param driver the driver to be saved
     */
    void save(Driver driver);

    /**
     * Finds a driver by their ID.
     *
     * @param id the ID of the driver
     * @return the Driver object if found, otherwise null
     */
    Driver findById(String id);

    /**
     * Returns a list of all drivers.
     *
     * @return list of drivers
     */
    List<Driver> findAll();

    /**
     * Updates an existing driver.
     *
     * @param driver the driver with updated details
     */
    void update(Driver driver);

    /**
     * Deletes a driver by ID.
     *
     * @param id the ID of the driver to delete
     */
    void delete(String id);
}
