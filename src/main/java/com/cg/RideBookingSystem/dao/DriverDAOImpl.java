package com.cg.RideBookingSystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.RideBookingSystem8.entities.Driver;

public class DriverDAOImpl implements DriverDAO{
	private List<Driver> drivers = new ArrayList<>();


    public void save(Driver driver) {
        drivers.add(driver);
    }


    public Driver findById(String id) {
        for (Driver driver : drivers) {
            if (driver.getID().equals(id)) {
                return driver;
            }
        }
        return null;
    }
    

    public List<Driver> findAll() {
        return drivers;
    }


    public void update(Driver driver) {
        Driver existingDriver = findById(driver.getID());
        if (existingDriver != null) {
            existingDriver.setName(driver.getName());
            existingDriver.setAvailable(driver.isAvailable());
        }
    }
    

    public void delete(String id) {
        drivers.removeIf(driver -> driver.getID().equals(id));
    }
}
