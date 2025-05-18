package com.cg.RideBookingSystem8.dao;

import java.util.List;
import com.cg.RideBookingSystem8.entities.Ride;

/**
 * Data Access Object interface for Ride entity.
 * Defines basic CRUD operations for Ride.
 * @author Shivam Kumar
 */
public interface RideDAO {

    /**
     * Saves a new Ride.
     *
     * @param ride the Ride to save
     */
    void save(Ride ride);

    /**
     * Finds a Ride by its ID.
     *
     * @param id the ID of the Ride
     * @return the Ride if found, otherwise null
     */
    Ride findById(String id);

    /**
     * Returns a list of all Rides.
     *
     * @return list of all Rides
     */
    List<Ride> findAll();

    /**
     * Updates an existing Ride.
     *
     * @param ride the Ride with updated information
     */
    void update(Ride ride);

    /**
     * Deletes a Ride by its ID.
     *
     * @param id the ID of the Ride to delete
     */
    void delete(String id);
}
