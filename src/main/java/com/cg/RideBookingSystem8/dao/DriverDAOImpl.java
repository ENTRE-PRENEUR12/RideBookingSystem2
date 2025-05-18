package com.cg.RideBookingSystem8.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.RideBookingSystem8.entities.Driver;

/**
 * Implementation of the DriverDAO interface using in-memory list storage.
 * @author Shivam Kumar
 */
public class DriverDAOImpl implements DriverDAO {

    private List<Driver> drivers = new ArrayList<>();

    /**
     * Saves a driver to the in-memory list.
     *
     * @param driver the driver to be added
     */
    public void save(Driver driver) {
        drivers.add(driver);
    }

    /**
     * Finds a driver by ID.
     *
     * @param id the ID of the driver
     * @return the Driver if found, otherwise null
     */
    public Driver findById(String id) {
        for (Driver driver : drivers) {
            if (driver.getID().equals(id)) {
                return driver;
            }
        }
        return null;
    }

    /**
     * Returns all drivers from the in-memory list.
     *
     * @return list of drivers
     */
    public List<Driver> findAll() {
        return drivers;
    }

    /**
     * Updates the details of an existing driver.
     *
     * @param driver the driver with updated information
     */
    public void update(Driver driver) {
        Driver existingDriver = findById(driver.getID());
        if (existingDriver != null) {
            existingDriver.setName(driver.getName());
            existingDriver.setAvailable(driver.isAvailable());
        }
    }

    /**
     * Deletes a driver by ID.
     *
     * @param id the ID of the driver to remove
     */
    public void delete(String id) {
        drivers.removeIf(driver -> driver.getID().equals(id));
    }
}

