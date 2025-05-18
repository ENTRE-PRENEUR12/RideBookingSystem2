package com.cg.RideBookingSystem8.ui;

import java.util.*;


import com.cg.RideBookingSystem8.entities.Customer;
import com.cg.RideBookingSystem8.entities.Driver;
import com.cg.RideBookingSystem8.entities.Ride;
import com.cg.RideBookingSystem8.exceptions.*;
import com.cg.RideBookingSystem8.service.RideBookingSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.cg.RideBookingSystem8.dao.CustomerDAO;
import com.cg.RideBookingSystem8.dao.CustomerDAOImpl;
import com.cg.RideBookingSystem8.dao.DriverDAO;
import com.cg.RideBookingSystem8.dao.DriverDAOImpl;
import com.cg.RideBookingSystem8.dao.RideDAO;
import com.cg.RideBookingSystem8.dao.RideDAOImpl;
import com.cg.RideBookingSystem8.entities.*;



/**
 * This RideMain class is the starting point of the program
 * @author Sourav Mandal
 */
public class RideMain {
	
	/**
	 * This checkName method is used to check whether the name is in correct format
	 * @param name
	 * @return boolean
	 */

	
	/**
	 * This method is the starting point of execution. Here users are given a menu from where user can choose which action to perform
	 * @param args
	 * @throws Exception
	 */
	
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        RideBookingSystem system = new RideBookingSystem();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        DriverDAO driverDAO = new DriverDAOImpl();
        RideDAO rideDAO = new RideDAOImpl();
        RideBookingSystem system = new RideBookingSystem(customerDAO, driverDAO, rideDAO);
        system.loadDriversFromFile();

        
        

        String nameFormat = "^[a-zA-Z]+$";
        int id=3;
        
        while (true) {
            System.out.println("\n--- Ride Booking System Menu ---");
            System.out.println("1. Register a Customer");
            System.out.println("2. Register a Driver");
            System.out.println("3. Book a Ride");
            System.out.println("4. Show All Drivers");
            System.out.println("5. Save Data and Exit");
            System.out.println("6. Show all Customers");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    while(!customerName.matches(nameFormat)) {
                    	System.out.println("Enter the proper Name Format - ");
                    	customerName = scanner.nextLine();
                    }
                    Customer customer = new Customer(Integer.toString(id++), customerName);
                    system.registerCustomer(customer);
                    System.out.println("Customer registered successfully with id "+(id-1));
                    break;

                case 2:
                    System.out.print("Enter Driver Name: ");
                    String driverName = scanner.nextLine();
                    while(!driverName.matches(nameFormat)) {
                    	System.out.println("Enter the proper Name Format - ");
                    	customerName = scanner.nextLine();
                    }
                    Driver driver = new Driver(Integer.toString(id-1), driverName, true);
                    system.registerDriver(driver);
                    System.out.println("Driver registered successfully with id "+(id-1));
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    String inputId = scanner.nextLine();
                    Customer matchedCustomer = null;
                    for (Customer c : system.getCustomers()) {
                        if (c.getID().equals(inputId)) {
                            matchedCustomer = c;
                            break;
                        }
                    }
                    if (matchedCustomer != null) {
                        try {
                            Ride ride = system.bookRide(matchedCustomer);
                            System.out.println("Ride booked successfully:");
                            System.out.println(ride.rideDetails());
                        } catch (InvalidRideException e) {
                            System.out.println("Ride booking failed: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                	List<Driver> lid = system.getDrivers();
                    system.showAllDrivers(lid);
                    break;

                case 5:
                    system.saveRides();
                    system.saveDriversToFile();
                    System.out.println("Data saved. Exiting...");
                    return;
                    
                case 6:
                	List<Customer> lic = system.getCustomers();
                	system.showAllCustomers(lic);
                	break;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 6.");
                    
                    scanner.close();
            }
        }
    }
}
