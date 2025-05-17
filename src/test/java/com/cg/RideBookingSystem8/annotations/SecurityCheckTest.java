package com.cg.RideBookingSystem8.annotations;

import com.cg.RideBookingSystem8.entities.Admin;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityCheckTest {

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

    @Test
    public void testSecurityCheckAnnotationAbsentOnOtherClass() {
        // Test a class that doesn't have the @SecurityCheck annotation
        Class<?> someOtherClass = String.class;
        SecurityCheck securityCheck = someOtherClass.getAnnotation(SecurityCheck.class);

        // Verify that no annotation is present
        assertNull(securityCheck, "SecurityCheck annotation should not be present on String class.");
    }
}
