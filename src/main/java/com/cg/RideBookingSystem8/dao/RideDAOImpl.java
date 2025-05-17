package com.cg.RideBookingSystem8.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.RideBookingSystem8.entities.Ride;

public class RideDAOImpl implements RideDAO{
	private List<Ride> rides = new ArrayList<>();

    @Override
    public void save(Ride ride) {
        rides.add(ride);
    }

    @Override
    public Ride findById(String id) {
        for (Ride ride : rides) {
            if (ride.getDriver().getID().equals(id)) {
                return ride;
            }
        }
        return null;
    }
	
    @Override
    public List<Ride> findAll() {
        return rides;
    }

    @Override
    public void update(Ride ride) {
        // Ride status update logic if needed
    }

    @Override
    public void delete(String id) {
        rides.removeIf(ride -> ride.getDriver().getID().equals(id));
    }
}
