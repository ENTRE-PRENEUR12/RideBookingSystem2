package com.cg.RideBookingSystem8.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Ride class.
 * @author Shreyanshi Das
 */
public class RideTest {

    private Customer customer;
    private Driver driver;
    private Ride ride;

    /**
     * Sets up Customer and Driver instances before each test.
     */
    @BeforeEach
    public void setUp() {
        customer = new Customer("C001", "John Doe");
        driver = new Driver("D001", "Alice", true);
    }

    /**
     * Tests Ride constructor and checks driver availability and ride status after booking.
     */
    @Test
    public void testConstructorAndAvailability() {
        ride = new Ride(customer, driver);
        assertFalse(driver.isAvailable());
        assertEquals("Booked", ride.getStatus());
    }

    /**
     * Tests that Ride constructor throws IllegalArgumentException if customer is null.
     */
    @Test
    public void testRideConstructorWithNullCustomer() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Ride(null, driver);
        });
        assertEquals("Customer and Driver cannot be null.", thrown.getMessage());
    }

    /**
     * Tests that Ride constructor throws IllegalArgumentException if driver is null.
     */
    @Test
    public void testRideConstructorWithNullDriver() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Ride(customer, null);
        });
        assertEquals("Customer and Driver cannot be null.", thrown.getMessage());
    }

    /**
     * Tests the rideDetails method for correct string output.
     */
    @Test
    public void testRideDetails() {
        ride = new Ride(customer, driver);
        String expectedDetails = "John Doe has Booked ride with Alice (driver id D001)";
        assertEquals(expectedDetails, ride.rideDetails());
    }

    /**
     * Tests that the ride status is "Booked" after creation.
     */
    @Test
    public void testStatusAfterBooking() {
        ride = new Ride(customer, driver);
        assertEquals("Booked", ride.getStatus());
    }
}

