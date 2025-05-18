package com.cg.RideBookingSystem8.annotations;

/**
 * Annotation to indicate that a class requires a security role check.
 * Used for specifying access control metadata at the class level.
 * 
 * @author Aniket Marik
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SecurityCheck {
    /**
     * Specifies the role required to access the annotated class.
     * 
     * @return the required role
     */
    String role();
}
