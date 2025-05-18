package com.cg.RideBookingSystem8.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import com.cg.RideBookingSystem8.dao.*;
import com.cg.RideBookingSystem8.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.RideBookingSystem8.entities.Customer;
import com.cg.RideBookingSystem8.entities.Driver;
import com.cg.RideBookingSystem8.entities.Ride;
import com.cg.RideBookingSystem8.exceptions.InvalidRideException;
import com.cg.RideBookingSystem8.service.RideBookingSystem;

/**
 * Unit test class for the main functionality of the RideBookingSystem through its UI.
 * Uses actual DAO implementations to verify real interactions between components.
 * @author Prateek Sinha
 */
public class MainClassTest {
	
	private RideBookingSystem system;
	
	/**
     * Initializes the RideBookingSystem instance with real DAO implementations
     * before each test method.
     */
	@BeforeEach
    void setUp() {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        DriverDAO driverDAO = new DriverDAOImpl();
        RideDAO rideDAO = new RideDAOImpl();
        system = new RideBookingSystem(customerDAO, driverDAO, rideDAO);
    }

    /**
     * Tests registering a customer and verifies that the customer is stored in the system.
     */
    @Test
    void testRegisterCustomer() {
        Customer customer = new Customer("1", "Alice");
        system.registerCustomer(customer);
        List<Customer> customers = system.getCustomers();
        assertTrue(customers.contains(customer), "Customer should be registered");
    }

    /**
     * Tests registering a driver and verifies that the driver is stored in the system.
     */
    @Test
    void testRegisterDriver() {
        Driver driver = new Driver("2", "Bob", true);
        system.registerDriver(driver);
        List<Driver> drivers = system.getDrivers();
        assertTrue(drivers.contains(driver), "Driver should be registered");
    }

    /**
     * Tests successful booking of a ride when an available driver is registered.
     * Verifies that the ride is created and has the correct status.
     *
     * @throws InvalidRideException if booking fails (which should not happen in this test)
     */
    @Test
    void testBookRideSuccess() throws InvalidRideException {
        Customer customer = new Customer("3", "Charlie");
        system.registerCustomer(customer);
        Driver driver = new Driver("4", "Dave", true);
        system.registerDriver(driver);

        Ride ride = system.bookRide(customer);
        assertNotNull(ride);
        //assertEquals(customer.getID(), ride.getCustomer().getID());
        assertEquals("Booked", ride.getStatus());
    }

    /*
     * Tests failure of booking a ride when no drivers are available.
     * Expects an InvalidRideException to be thrown with appropriate message.
     *
     * @Test
     * void testBookRideFailure_NoDrivers() {
     *     Customer customer = new Customer("5", "Eve");
     *     system.registerCustomer(customer);
     *     InvalidRideException thrown = assertThrows(InvalidRideException.class, () -> {
     *         system.bookRide(customer);
     *     });
     *     assertEquals("No available drivers at the moment.", thrown.getMessage());
     * }
     */

    /**
     * Tests retrieval of all customers and drivers after registration.
     * Verifies the count of registered users.
     */
    @Test
    void testGetAllCustomersAndDrivers() {
        Customer customer = new Customer("6", "Frank");
        Driver driver = new Driver("7", "Grace", true);
        system.registerCustomer(customer);
        system.registerDriver(driver);

        assertEquals(1, system.getCustomers().size());
        assertEquals(1, system.getDrivers().size());
    }
}