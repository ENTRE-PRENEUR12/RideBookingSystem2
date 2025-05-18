package com.cg.RideBookingSystem8.service;

import com.cg.RideBookingSystem.exceptions.InvalidRideException;
import com.cg.RideBookingSystem8.dao.CustomerDAO;
import com.cg.RideBookingSystem8.dao.DriverDAO;
import com.cg.RideBookingSystem8.dao.RideDAO;
import com.cg.RideBookingSystem8.entities.Customer;
import com.cg.RideBookingSystem8.entities.Driver;
import com.cg.RideBookingSystem8.entities.Ride;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test class for RideBookingSystem service layer.
 * It verifies core functionalities like customer/driver registration
 * and ride booking with mock DAO implementations.
 * @author Aniket ADhikari
 */
public class RideBookingSystemTest {

    private RideBookingSystem rideBookingSystem;
    private CustomerDAO customerDAO;
    private DriverDAO driverDAO;
    private RideDAO rideDAO;

    /**
     * Sets up the test environment with in-memory anonymous DAO implementations.
     * Initializes the RideBookingSystem with mock data sources before each test.
     */
    @Before
    public void setUp() {
        // Anonymous implementation of CustomerDAO
        customerDAO = new CustomerDAO() {
            private List<Customer> customers = new ArrayList<>();

            @Override
            public void save(Customer customer) {
                customers.add(customer);
            }

            @Override
            public List<Customer> findAll() {
                return new ArrayList<>(customers);
            }

            @Override
            public Customer findById(String id) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void update(Customer customer) {
                // TODO Auto-generated method stub
            }

            @Override
            public void delete(String id) {
                // TODO Auto-generated method stub
            }
        };

        // Anonymous implementation of DriverDAO
        driverDAO = new DriverDAO() {
            private List<Driver> drivers = new ArrayList<>();

            @Override
            public void save(Driver driver) {
                drivers.add(driver);
            }

            @Override
            public List<Driver> findAll() {
                return new ArrayList<>(drivers);
            }

            @Override
            public Driver findById(String id) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void update(Driver driver) {
                // TODO Auto-generated method stub
            }

            @Override
            public void delete(String id) {
                // TODO Auto-generated method stub
            }
        };

        // Anonymous implementation of RideDAO
        rideDAO = new RideDAO() {
            private List<Ride> rides = new ArrayList<>();

            @Override
            public void save(Ride ride) {
                rides.add(ride);
            }

            @Override
            public List<Ride> findAll() {
                return new ArrayList<>(rides);
            }

            @Override
            public Ride findById(String id) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void update(Ride ride) {
                // TODO Auto-generated method stub
            }

            @Override
            public void delete(String id) {
                // TODO Auto-generated method stub
            }
        };

        rideBookingSystem = new RideBookingSystem(customerDAO, driverDAO, rideDAO);
    }

    /**
     * Tests the registration of a customer in the RideBookingSystem.
     * Verifies that the customer is added to the internal customer list.
     */
    @Test
    public void testRegisterCustomer() {
        Customer customer = new Customer("1001", "Alice");
        rideBookingSystem.registerCustomer(customer);
        List<Customer> customers = rideBookingSystem.getCustomers();
        assertEquals(1, customers.size());
        assertEquals("Alice", customers.get(0).getName());
    }

    /**
     * Tests the registration of a driver in the RideBookingSystem.
     * Verifies that the driver is added to the internal driver list.
     */
    @Test
    public void testRegisterDriver() {
        Driver driver = new Driver("D01", "Bob", true);
        rideBookingSystem.registerDriver(driver);
        List<Driver> drivers = rideBookingSystem.getDrivers();
        assertEquals(1, drivers.size());
        assertEquals("Bob", drivers.get(0).getName());
    }

    /**
     * Tests the successful booking of a ride when an available driver is present.
     * Verifies that a ride object is returned and associated entities match.
     */
    @Test
    public void testBookRideSuccessfully() {
        Customer customer = new Customer("1002", "Charlie");
        Driver driver = new Driver("D02", "David", true);
        rideBookingSystem.registerCustomer(customer);
        rideBookingSystem.registerDriver(driver);

        Ride ride = rideBookingSystem.bookRide(customer);

        assertNotNull(ride);
        assertEquals("Charlie", ride.getCustomer().getName());
        assertEquals("David", ride.getDriver().getName());
    }

    /**
     * Tests the scenario where no drivers are available for a ride booking.
     * Expects an InvalidRideException to be thrown.
     */
    @Test(expected = InvalidRideException.class)
    public void testBookRideNoAvailableDriver() {
        Customer customer = new Customer("1003", "Emma");
        rideBookingSystem.registerCustomer(customer);

        // No driver registered, so booking ride should throw exception
        rideBookingSystem.bookRide(customer);
    }
}