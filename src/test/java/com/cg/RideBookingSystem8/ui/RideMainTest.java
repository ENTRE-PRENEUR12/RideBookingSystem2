package com.cg.RideBookingSystem8.ui;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RideMain class to simulate user interaction with the
 * ride booking system console application.
 * 
 * Tests include full flow scenarios, input validation, and error handling.
 * 
 * Author: Prateek Sinha
 */
class RideMainTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    /**
     * Redirects System.out to capture output before each test.
     */
    @BeforeEach
    void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**
     * Restores original System.in and System.out streams after each test.
     */
    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    /**
     * Provides input data as System.in for simulating user input.
     * 
     * @param data the input string to be provided
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        System.setIn(testIn);
    }

    /**
     * Retrieves the captured output from System.out.
     * 
     * @return the console output as a string
     */
    private String getOutput() {
        return testOut.toString();
    }

    /**
     * Tests a full user interaction flow including customer registration,
     * driver registration, booking a ride, displaying data, and exit.
     * 
     * @throws Exception if main method throws any exceptions
     */
    @Test
    void testFullFlow() throws Exception {
        String input = String.join("\n",
                "1",            // Register Customer
                "Alice",        // Valid name
                "2",            // Register Driver
                "Bob",          // Valid name
                "3",            // Book Ride
                "3",            // Customer ID = 3
                "4",            // Show All Drivers
                "6",            // Show All Customers
                "5"             // Save and Exit
        );
        provideInput(input);

        // Call main method
        RideMain.main(new String[]{});

        String output = getOutput();

        assertTrue(output.contains("Customer registered successfully with id 3"));
        assertTrue(output.contains("Driver registered successfully with id 3"));
        assertTrue(output.contains("Ride booked successfully:"));
        assertTrue(output.contains("Data saved. Exiting..."));
    }

    /**
     * Tests the behavior when an invalid menu choice (non-numeric) is provided.
     * 
     * @throws Exception if main method throws any exceptions
     */
    @Test
    void testInvalidMenuChoice() throws Exception {
        provideInput("invalid\n5\n");

        RideMain.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("Invalid input. Please enter a number."));
        assertTrue(output.contains("Data saved. Exiting..."));
    }

    /**
     * Tests the validation of customer name input during registration.
     * First input is invalid and second is valid.
     * 
     * @throws Exception if main method throws any exceptions
     */
    @Test
    void testInvalidCustomerName() throws Exception {
        provideInput(String.join("\n",
                "1",
                "123",     // invalid name
                "Alice",   // valid
                "5"        // exit
        ));
        RideMain.main(new String[]{});
        String output = getOutput();
        assertTrue(output.contains("Enter the proper Name Format"));
        assertTrue(output.contains("Customer registered successfully"));
    }

    /**
     * Tests booking a ride with an invalid (non-existent) customer ID.
     * 
     * @throws Exception if main method throws any exceptions
     */
    @Test
    void testBookRideWithInvalidCustomer() throws Exception {
        provideInput(String.join("\n",
                "3",
                "99",  // invalid customer ID
                "5"
        ));
        RideMain.main(new String[]{});
        String output = getOutput();
        assertTrue(output.contains("Customer not found."));
    }
}
