package com.cg.RideBookingSystem8.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RideTest {

    private Customer customer;
    private Driver driver;
    private Ride ride;

    @BeforeEach
    public void setUp() {
        customer = new Customer("C001", "John Doe");
        driver = new Driver("D001", "Alice", true); // Assuming Driver constructor is available
    }

    @Test
    public void testConstructorAndAvailability() {
        // Ensure that the Ride is created successfully
        ride = new Ride(customer, driver);

        // Check that the driver is marked as unavailable after ride is booked
        assertFalse(driver.isAvailable()); // Driver should now be unavailable

        // Check that the status is "Booked"
        assertEquals("Booked", ride.getStatus());
    }

    @Test
    public void testRideConstructorWithNullCustomer() {
        // Attempt to create a ride with a null customer
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Ride(null, driver);
        });
        assertEquals("Customer and Driver cannot be null.", thrown.getMessage());
    }

    @Test
    public void testRideConstructorWithNullDriver() {
        // Attempt to create a ride with a null driver
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Ride(customer, null);
        });
        assertEquals("Customer and Driver cannot be null.", thrown.getMessage());
    }

    @Test
    public void testRideDetails() {
        // Create the ride
        ride = new Ride(customer, driver);

        // Check the ride details output
        String expectedDetails = "John Doe has Booked ride with Alice (driver id D001)";
        assertEquals(expectedDetails, ride.rideDetails());
    }

    @Test
    public void testStatusAfterBooking() {
        ride = new Ride(customer, driver);
        assertEquals("Booked", ride.getStatus());
    }
}
