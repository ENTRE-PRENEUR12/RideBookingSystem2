package com.cg.RideBookingSystem8.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for testing the Customer entity.
 * @author Anushka De
 */
class CustomerTest {

    private Customer customer;

    /**
     * Sets up the Customer instance before each test.
     */
    @BeforeEach
    void setUp() {
        customer = new Customer("C001", "John");
    }

    /**
     * Tests the constructor and getter methods of the Customer class.
     */
    @Test
    void testConstructorAndGetters() {
        assertEquals("C001", customer.getID(), "Customer ID should match");
        assertEquals("John", customer.getName(), "Customer name should match");
    }

    /**
     * Tests the setID method of the Customer class.
     */
    @Test
    void testSetID() {
        customer.setID("C002");
        assertEquals("C002", customer.getID(), "Customer ID should update correctly");
    }

    /**
     * Tests the setName method of the Customer class.
     */
    @Test
    void testSetName() {
        customer.setName("Jane");
        assertEquals("Jane", customer.getName(), "Customer name should update correctly");
    }

    /**
     * Tests that the ShowProfile method executes without throwing an exception.
     */
    @Test
    void testShowProfile() {
        // Just check that it runs without error
        assertDoesNotThrow(() -> customer.ShowProfile(), "ShowProfile should not throw any exception");
    }
}
