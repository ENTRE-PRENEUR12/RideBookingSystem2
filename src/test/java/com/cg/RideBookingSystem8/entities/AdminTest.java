package com.cg.RideBookingSystem8.entities;

import com.cg.RideBookingSystem8.annotations.SecurityCheck;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Unit test class for testing the functionality of the Admin entity.
 * @author Prateek Sinha
 */
public class AdminTest {

    private Admin admin;
    private List<Driver> driverList;

    /**
     * Sets up test data before each test method.
     */
    @Before
    public void setUp() {
        admin = new Admin("A001", "SuperAdmin");
        driverList = new ArrayList<>();
        driverList.add(new Driver("D001", "DriverOne", true));
        driverList.add(new Driver("D002", "DriverTwo", true));
    }

    /**
     * Tests constructor and getter methods of Admin class.
     */
    @Test
    public void testConstructorAndGetters() {
        assertEquals("A001", admin.getID());
        assertEquals("SuperAdmin", admin.getName());
    }

    /**
     * Tests the output of ShowProfile() method.
     */
    @Test
    public void testShowProfileOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        admin.ShowProfile();

        assertTrue(out.toString().contains("Admin Name : SuperAdmin Role : Admin"));

        // Reset standard output
        System.setOut(System.out);
    }

    /*
     * Tests removal of an existing driver by Admin.
     */
    /*@Test
    public void testRemoveExistingDriver() {
        assertEquals(2, driverList.size());
        admin.removeDriver(driverList, "D001");
        assertEquals(1, driverList.size());
        assertEquals("D002", driverList.get(0).getID());
    }*/

    /*
     * Tests behavior when trying to remove a non-existing driver.
     */
    /*@Test
    public void testRemoveNonExistingDriver() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        admin.removeDriver(driverList, "D999");
        String output = out.toString();

        assertTrue(output.contains("Driver ID not found."));
        assertEquals(2, driverList.size());

        System.setOut(System.out);
    }*/

    /**
     * Tests whether the @SecurityCheck annotation is present on Admin class.
     */
    @Test
    public void testSecurityAnnotationPresent() {
        assertTrue(Admin.class.isAnnotationPresent(SecurityCheck.class));
        SecurityCheck sc = Admin.class.getAnnotation(SecurityCheck.class);
        assertEquals("Admin", sc.role());
    }
}
