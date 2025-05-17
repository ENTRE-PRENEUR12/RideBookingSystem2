package com.cg.RideBookingSystem8.entities;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DriverTest {

    private Driver driver;

    @Before
    public void setUp() {
        driver = new Driver("D001", "Alice", true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("D001", driver.getID());
        assertEquals("Alice", driver.getName());
        assertTrue(driver.isAvailable());
    }

    @Test
    public void testSetID() {
        driver.setID("D002");
        assertEquals("D002", driver.getID());
    }

    @Test
    public void testSetName() {
        driver.setName("Bob");
        assertEquals("Bob", driver.getName());
    }

    @Test
    public void testSetAvailability() {
        driver.setAvailable(false);
        assertFalse(driver.isAvailable());
    }

    /*@Test
    public void testShowProfileOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        driver.ShowProfile();

        String expectedOutput = "Driver name and id is as follows: \n [ Driver Name : Alice Driver ID : D001 ]";
        assertTrue(outContent.toString().trim().contains(expectedOutput));

        // Reset System.out
        System.setOut(System.out);
    }*/
}
