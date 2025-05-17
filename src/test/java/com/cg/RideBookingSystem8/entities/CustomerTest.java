package com.cg.RideBookingSystem8.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("C001", "John");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("C001", customer.getID(), "Customer ID should match");
        assertEquals("John", customer.getName(), "Customer name should match");
    }

    @Test
    void testSetID() {
        customer.setID("C002");
        assertEquals("C002", customer.getID(), "Customer ID should update correctly");
    }

    @Test
    void testSetName() {
        customer.setName("Jane");
        assertEquals("Jane", customer.getName(), "Customer name should update correctly");
    }

    @Test
    void testShowProfile() {
        // Just check that it runs without error
        assertDoesNotThrow(() -> customer.ShowProfile(), "ShowProfile should not throw any exception");
    }
}
