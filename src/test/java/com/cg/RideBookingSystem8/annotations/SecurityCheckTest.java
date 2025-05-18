package com.cg.RideBookingSystem8.annotations;

import com.cg.RideBookingSystem8.entities.Admin;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for verifying the presence and properties of the @SecurityCheck annotation.
 * @author Aniket Adhikari
 */
public class SecurityCheckTest {

    /**
     * Tests that the @SecurityCheck annotation is present on the Admin class
     * and that its role is set to "Admin".
     */
    @Test
    public void testSecurityCheckAnnotationPresent() {
        // Get the @SecurityCheck annotation from Admin class using reflection
        Class<Admin> adminClass = Admin.class;
        SecurityCheck securityCheck = adminClass.getAnnotation(SecurityCheck.class);

        // Verify that the @SecurityCheck annotation is present
        assertNotNull(securityCheck, "SecurityCheck annotation should be present on Admin class.");

        // Verify that the role is set to "Admin"
        assertEquals("Admin", securityCheck.role(), "The role specified in the annotation should be 'Admin'.");
    }

    /**
     * Tests that the @SecurityCheck annotation is not present on a class
     * that does not declare it (e.g., String class).
     */
    @Test
    public void testSecurityCheckAnnotationAbsentOnOtherClass() {
        // Test a class that doesn't have the @SecurityCheck annotation
        Class<?> someOtherClass = String.class;
        SecurityCheck securityCheck = someOtherClass.getAnnotation(SecurityCheck.class);

        // Verify that no annotation is present
        assertNull(securityCheck, "SecurityCheck annotation should not be present on String class.");
    }
}

