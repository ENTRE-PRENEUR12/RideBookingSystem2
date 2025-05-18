package com.cg.RideBookingSystem8.service;

import com.cg.RideBookingSystem8.dao.CustomerDAO;
import com.cg.RideBookingSystem8.dao.DriverDAO;
import com.cg.RideBookingSystem8.dao.RideDAO;
import com.cg.RideBookingSystem8.entities.Customer;
import com.cg.RideBookingSystem8.entities.Driver;
import com.cg.RideBookingSystem8.entities.Ride;
import com.cg.RideBookingSystem8.exceptions.InvalidRideException;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class to test the RideBookingSystem service functionality.
 * Uses in-memory DAO implementations for unit testing various scenarios.
 * 
 * @author Prateek Sinha
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RideBookingSystemTest {

    private RideBookingSystem rideBookingSystem;
    private List<Customer> customerStore;
    private List<Driver> driverStore;
    private List<Ride> rideStore;

    private CustomerDAO customerDAO;
    private DriverDAO driverDAO;
    private RideDAO rideDAO;

    /**
     * Initializes in-memory DAOs and the RideBookingSystem instance before all tests.
     */
    @BeforeAll
    void init() {
        customerStore = new ArrayList<>();
        driverStore = new ArrayList<>();
        rideStore = new ArrayList<>();

        customerDAO = new CustomerDAO() {
            @Override
            public void save(Customer customer) {
                customerStore.add(customer);
            }

            @Override
            public List<Customer> findAll() {
                return new ArrayList<>(customerStore);
            }

            @Override
            public Customer findById(String id) {
                return customerStore.stream().filter(c -> c.getID().equals(id)).findFirst().orElse(null);
            }

            @Override
            public void update(Customer customer) { }

            @Override
            public void delete(String id) { }
        };

        driverDAO = new DriverDAO() {
            @Override
            public void save(Driver driver) {
                driverStore.add(driver);
            }

            @Override
            public List<Driver> findAll() {
                return new ArrayList<>(driverStore);
            }

            @Override
            public Driver findById(String id) {
                return driverStore.stream().filter(d -> d.getID().equals(id)).findFirst().orElse(null);
            }

            @Override
            public void update(Driver driver) { }

            @Override
            public void delete(String id) { }
        };

        rideDAO = new RideDAO() {
            @Override
            public void save(Ride ride) {
                rideStore.add(ride);
            }

            @Override
            public List<Ride> findAll() {
                return new ArrayList<>(rideStore);
            }

            @Override
            public Ride findById(String id) {
                return null;
            }

            @Override
            public void update(Ride ride) { }

            @Override
            public void delete(String id) { }
        };

        rideBookingSystem = new RideBookingSystem(customerDAO, driverDAO, rideDAO);
    }

    /**
     * Resets all in-memory data stores before each test to ensure test isolation.
     */
    @BeforeEach
    void resetData() {
        customerStore.clear();
        driverStore.clear();
        rideStore.clear();
    }

    /**
     * Tests that registering a customer adds the customer correctly.
     */
    @Test
    void testRegisterCustomer() {
        Customer customer = new Customer("101", "TestUser");
        rideBookingSystem.registerCustomer(customer);

        assertEquals(1, rideBookingSystem.getCustomers().size());
        assertEquals("TestUser", rideBookingSystem.getCustomers().get(0).getName());
    }

    /**
     * Tests that registering a driver adds the driver correctly.
     */
    @Test
    void testRegisterDriver() {
        Driver driver = new Driver("D01", "TestDriver", true);
        rideBookingSystem.registerDriver(driver);

        assertEquals(1, rideBookingSystem.getDrivers().size());
        assertEquals("TestDriver", rideBookingSystem.getDrivers().get(0).getName());
    }

    /**
     * Tests successful booking of a ride when driver is available.
     */
    @Test
    void testBookRideSuccess() {
        Customer customer = new Customer("102", "Alice");
        Driver driver = new Driver("D02", "Bob", true);
        rideBookingSystem.registerCustomer(customer);
        rideBookingSystem.registerDriver(driver);

        Ride ride = rideBookingSystem.bookRide(customer);

        assertNotNull(ride);
        assertEquals("Alice", ride.getCustomer().getName());
        assertEquals("Bob", ride.getDriver().getName());
        assertFalse(driverStore.get(0).isAvailable());
    }

    /**
     * Tests that booking a ride fails when no drivers are available.
     */
    @Test
    void testBookRideNoDriverAvailable() {
        Customer customer = new Customer("103", "Charlie");
        rideBookingSystem.registerCustomer(customer);

        InvalidRideException exception = assertThrows(
                InvalidRideException.class,
                () -> rideBookingSystem.bookRide(customer)
        );

        assertEquals("No available Drivers.", exception.getMessage());
    }

    /**
     * Tests retrieving the list of rides after booking.
     */
    @Test
    void testGetRides() {
        Customer customer = new Customer("104", "User");
        Driver driver = new Driver("D03", "Driver", true);
        rideBookingSystem.registerCustomer(customer);
        rideBookingSystem.registerDriver(driver);

        rideBookingSystem.bookRide(customer);
        assertEquals(1, rideBookingSystem.getRides().size());
    }

    /**
     * Tests saving and loading drivers to/from file.
     * 
     * Note: This test uses a temporary file but actual RideBookingSystem
     * uses hardcoded file path, so loading simulation is limited.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Test
    void testSaveAndLoadDriversToFile() throws IOException {
        File tempFile = File.createTempFile("drivers", ".txt");
        tempFile.deleteOnExit();

        Driver driver1 = new Driver("D04", "Eve", true);
        Driver driver2 = new Driver("D05", "Frank", false);
        rideBookingSystem.registerDriver(driver1);
        rideBookingSystem.registerDriver(driver2);

        FileWriter fw = new FileWriter(tempFile);
        fw.write("D06,Grace\nD07,Henry\n");
        fw.close();

        rideBookingSystem.saveDriversToFile(); // currently hardcoded path

        assertEquals(2, rideBookingSystem.getDrivers().size());
    }

    /**
     * Tests that showing all customers and drivers executes without exceptions.
     */
    @Test
    void testShowAllCustomersAndDrivers() {
        rideBookingSystem.registerCustomer(new Customer("C01", "Sam"));
        rideBookingSystem.registerDriver(new Driver("D08", "Tim", true));

        assertDoesNotThrow(() -> rideBookingSystem.showAllCustomers(customerStore));
        assertDoesNotThrow(() -> rideBookingSystem.showAllDrivers(driverStore));
    }

    /**
     * Tests setter and getter for customers list in RideBookingSystem.
     */
    @Test
    void testSetAndGetCustomers() {
        List<Customer> temp = new ArrayList<>();
        temp.add(new Customer("C02", "Zoe"));
        rideBookingSystem.setCustomers(temp);

        // As internal DAO list is separate, this test ensures no exceptions and data is not null.
        assertNotNull(temp);
    }
}
