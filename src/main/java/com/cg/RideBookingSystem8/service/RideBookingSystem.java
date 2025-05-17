
package com.cg.RideBookingSystem8.service;
import com.cg.RideBookingSystem.exceptions.*;


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
import com.cg.RideBookingSystem8.dao.DriverDAO;
import com.cg.RideBookingSystem8.dao.RideDAO;
import com.cg.RideBookingSystem8.entities.*;

/**
 * Class RideBookingSystem manages the entire booking process of a ride properly.
 * @author Soumyadeep Sutradhar
 */

public class RideBookingSystem {
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Driver> drivers = new ArrayList<Driver>();
    private List<Ride> rides = new ArrayList<Ride>();
	private CustomerDAO customerDAO;
    private DriverDAO driverDAO;
    private RideDAO rideDAO;
    
    public RideBookingSystem(CustomerDAO customerDAO, DriverDAO driverDAO, RideDAO rideDAO) {
        this.customerDAO = customerDAO;
        this.driverDAO = driverDAO;
        this.rideDAO = rideDAO;
    }
    
    /**
     * Method to register the customer.
     * @param customer
     */
    public void registerCustomer(Customer customer) {
        customerDAO.save(customer);
    }
    
    /**
     * Method to register a driver.
     * @param driver
     */

    public void registerDriver(Driver driver) {
        driverDAO.save(driver);
    }

    
    /**
     * Accepts the available driver for ride and throws exception if driver is not available for ride.
     * @param customer
     * @return
     */
    
    public Ride bookRide(Customer customer) {
        List<Driver> availableDrivers = driverDAO.findAll();
        Driver availableDriver = null;
        for (Driver driver : availableDrivers) {
            if (driver.isAvailable()) {
                availableDriver = driver;
                driver.setAvailable(false);  // Mark driver as unavailable
                break;
            }
        }
        
        if (availableDriver == null) {
            throw new InvalidRideException("No available Drivers.");
        }
        Ride ride = new Ride(customer, availableDriver);
        rideDAO.save(ride);
        return ride;
    }
    
    
    
    
     /**
      * Saves the rides in a file.
      * @throws Exception
      */
    public void saveRides(){
        String path = "C:\\Users\\Prateek\\OneDrive\\Desktop\\Users\\rides.txt";
        File file = new File(path);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (Ride ride : rides) {
                bw.write(ride.rideDetails());
                bw.newLine();
            }
        }catch(IOException e) {
        	System.out.println("Error!!! on Saving the Rides - "+e.getMessage());
        }
    }

    
    /**
     * Loads available drivers who were enrolled previously in a file.
     * @throws Exception
     */
    public void loadDriversFromFile(){
        String path = "C:\\Users\\Prateek\\OneDrive\\Desktop\\Users\\drivers.txt";
        File file = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    String id = values[0];
                    String name = values[1];
                    Driver driver = new Driver(id, name, true);
                    this.registerDriver(driver);
                }
            }
        }catch (IOException e) {
        	System.out.println("Error!!! on Loading the Drivers - "+e.getMessage());
        }
    }
    
    /**
     * Save the drivers into file.
     * @throws Exception
     */

    public void saveDriversToFile(){
        String path = "C:\\Users\\Prateek\\OneDrive\\Desktop\\Users\\drivers.txt";
        File file = new File(path);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            for (Driver driver : drivers) {
                String message = driver.getID() + "," + driver.getName() + "," + (driver.isAvailable() ? "Available" : "Unavailable");
                bw.write(message);
                bw.newLine();
            }
        }catch(IOException e) {
        	System.out.println("Error!!! on Saving Drivers - "+e.getMessage());
        }
    }
    
    /**
     * method call to display all the drivers with their name, id.
     */

    public void showAllDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
        	driver.ShowProfile();
        }
    }
    
    /**
     * method call to display all the customers with their name, id.
     */
    public void showAllCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            customer.ShowProfile();
        }
    }
//    
    /**
     * method to return the customers in list format
     */
    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }
    
    /**
     * method to set the customers in the list
     * @param customers
     */

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    
    /**
     * method to return the drivers in list format
     * @return
     */
    
    public List<Driver> getDrivers() {
        return driverDAO.findAll();
    }
    
    /**
     * method to return the rides in list format
     * @return
     */
    public List<Ride> getRides() {
        return rideDAO.findAll();
    }
}
