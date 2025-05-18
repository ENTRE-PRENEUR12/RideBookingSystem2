package com.cg.RideBookingSystem8.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Driver class to verify constructor, getters, setters,
 * and output methods.
 * 
 * @author Sourav Mandal
 */
public class DriverTest {

    private Driver driver1;
    private Driver driver2;

    /**
     * Initializes two Driver objects before each test.
     */
    @BeforeEach
    public void setUp() {
        driver1 = new Driver("D001", "John", true);
        driver2 = new Driver("D002", "Doe", false);
    }

    /**
     * Tests the Driver constructor and the getter methods.
     * Verifies that the initial availability, ID, and name are correctly set.
     */
    @Test
    public void testConstructorAndGetter() {
        assertTrue(driver1.isAvailable());
        assertEquals("D001", driver1.getID());
        assertEquals("John", driver1.getName());
    }

    /**
     * Tests the setter and getter for the availability status of a Driver.
     * Verifies that availability can be toggled properly.
     */
    @Test
    public void testSetAvailable() {
        driver1.setAvailable(false);
        assertFalse(driver1.isAvailable());

        driver1.setAvailable(true);
        assertTrue(driver1.isAvailable());
    }

    /**
     * Tests the output of the ShowProfile method.
     * Captures system output and verifies expected content is printed.
     */
    @Test
    public void testShowProfileOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        driver1.ShowProfile();

        String expectedOutput = "Driver name and ID: \n [ Driver name : John Driver ID : D001";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out); // Reset System.out to original
    }

    /**
     * Tests the getdDriverId method to ensure it returns non-null,
     * unique IDs for different Driver instances.
     */
    @Test
    public void testGetdDriverId() {
        String id1 = driver1.getdDriverId();
        String id2 = driver2.getdDriverId();
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }
}
