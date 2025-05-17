package com.cg.RideBookingSystem8.entities;

import com.cg.RideBookingSystem8.annotations.SecurityCheck;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

public class AdminTest {

    private Admin admin;
    private List<Driver> driverList;

    @Before
    public void setUp() {
        admin = new Admin("A001", "SuperAdmin");
        driverList = new ArrayList<>();
        driverList.add(new Driver("D001", "DriverOne", true));
        driverList.add(new Driver("D002", "DriverTwo", true));
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("A001", admin.getID());
        assertEquals("SuperAdmin", admin.getName());
    }

    @Test
    public void testShowProfileOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        admin.ShowProfile();

        assertTrue(out.toString().contains("Admin Name : SuperAdmin Role : Admin"));

        // Reset standard output
        System.setOut(System.out);
    }

    /*@Test
    public void testRemoveExistingDriver() {
        assertEquals(2, driverList.size());
        admin.removeDriver(driverList, "D001");
        assertEquals(1, driverList.size());
        assertEquals("D002", driverList.get(0).getID());
    }*/

   /* @Test
    public void testRemoveNonExistingDriver() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        admin.removeDriver(driverList, "D999");
        String output = out.toString();

        assertTrue(output.contains("Driver ID not found."));
        assertEquals(2, driverList.size());

        System.setOut(System.out);
    }*/

    @Test
    public void testSecurityAnnotationPresent() {
        assertTrue(Admin.class.isAnnotationPresent(SecurityCheck.class));
        SecurityCheck sc = Admin.class.getAnnotation(SecurityCheck.class);
        assertEquals("Admin", sc.role());
    }
}
