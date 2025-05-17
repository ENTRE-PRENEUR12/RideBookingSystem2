package com.cg.RideBookingSystem8.dao;

import java.util.List;
import com.cg.RideBookingSystem8.entities.Ride;

public interface RideDAO {
	void save(Ride ride);
    Ride findById(String id);
    List<Ride> findAll();
    void update(Ride ride);
    void delete(String id);
}
