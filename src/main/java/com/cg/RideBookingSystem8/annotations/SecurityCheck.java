package com.cg.RideBookingSystem8.annotations;
/**
 * Used to create annotation known as security check
 * @author Aniket Marik
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SecurityCheck {
    String role();
}
