package com.cg.RideBookingSystem8.entities;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit test class for testing the Driver entity.
 * Verifies the correctness of getter, setter, and constructor methods of the Driver class.
 * 
 * Author: Sourav Mandol
 */
public class DriverTest {

    private Driver driver;

    /**
     * Sets up the Driver instance before each test.
     * Initializes a Driver object with ID "D001", name "Alice", and availability as true.
     */
    @Before
    public void setUp() {
        driver = new Driver("D001", "Alice", true);
    }

    /**
     * Tests the constructor and getter methods of the Driver class.
     * Verifies that the initial values set through the constructor are correctly retrieved.
     */
    @Test
    public void testConstructorAndGetters() {
        assertEquals("D001", driver.getID());
        assertEquals("Alice", driver.getName());
        assertTrue(driver.isAvailable());
    }

    /**
     * Tests the setID method of the Driver class.
     * Verifies that the driver's ID is correctly updated.
     */
    @Test
    public void testSetID() {
        driver.setID("D002");
        assertEquals("D002", driver.getID());
    }

    /**
     * Tests the setName method of the Driver class.
     * Verifies that the driver's name is correctly updated.
     */
    @Test
    public void testSetName() {
        driver.setName("Bob");
        assertEquals("Bob", driver.getName());
    }

    /**
     * Tests the setAvailable method of the Driver class.
     * Verifies that the driver's availability status is correctly updated.
     */
    @Test
    public void testSetAvailability() {
        driver.setAvailable(false);
        assertFalse(driver.isAvailable());
    }

    /*
     * @Test
     * public void testShowProfileOutput() {
     *     // Tests the output of ShowProfile method (commented out).
     *     // Would typically verify printed output using stream redirection.
     * }
     */
}