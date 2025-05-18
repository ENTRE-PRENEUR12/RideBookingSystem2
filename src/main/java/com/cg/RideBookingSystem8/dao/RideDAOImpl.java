package com.cg.RideBookingSystem8.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.RideBookingSystem8.entities.Ride;

/**
 * Implementation of the RideDAO interface.
 * Uses an in-memory list to store Ride objects.
 * @author Shivam Kumar
 */
public class RideDAOImpl implements RideDAO {
    private List<Ride> rides = new ArrayList<>();

    /**
     * Saves a new Ride to the list.
     *
     * @param ride the Ride to save
     */
    @Override
    public void save(Ride ride) {
        rides.add(ride);
    }

    /**
     * Finds a Ride by the driver's ID.
     *
     * @param id the ID of the Driver associated with the Ride
     * @return the Ride if found, otherwise null
     */
    @Override
    public Ride findById(String id) {
        for (Ride ride : rides) {
            if (ride.getDriver().getID().equals(id)) {
                return ride;
            }
        }
        return null;
    }

    /**
     * Returns all stored Rides.
     *
     * @return list of all Rides
     */
    @Override
    public List<Ride> findAll() {
        return rides;
    }

    /**
     * Placeholder for updating a Ride.
     * Currently does not implement any update logic.
     *
     * @param ride the Ride to update
     */
    @Override
    public void update(Ride ride) {
        // Ride status update logic if needed
    }

    /**
     * Deletes a Ride by the driver's ID.
     *
     * @param id the ID of the Driver associated with the Ride
     */
    @Override
    public void delete(String id) {
        rides.removeIf(ride -> ride.getDriver().getID().equals(id));
    }
}
