package com.cg.RideBookingSystem.dao;

import java.util.List;
import com.cg.RideBookingSystem8.entities.Driver;

public interface DriverDAO {
	void save(Driver driver);
    Driver findById(String id);
    List<Driver> findAll();
    void update(Driver driver);
    void delete(String id);
}
