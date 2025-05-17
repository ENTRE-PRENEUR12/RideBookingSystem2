package com.cg.RideBookingSystem8.entities;

/**
 * This class is used to create rides object
 * @author Shreyanshi Das
 */

public class Ride {
    private Customer customer;
    private Driver driver;
    private String status;
    
    /**
     * This is a constructor to store the customer and driver object inside ride object
     * @param customer
     * @param driver
     */

    public Ride(Customer customer, Driver driver) {
        if (customer == null || driver == null) {
            throw new IllegalArgumentException("Customer and Driver cannot be null.");
        }

//        if (!driver.isAvailable()) {
//             throw new IllegalStateException("Driver is not available for the ride.");
//        }
        this.customer = customer;
        this.driver = driver;
        this.status = "Booked";
        driver.setAvailable(false); 
    }
    
    

    /*public void completeRide() {
        if ("Completed".equals(this.status)) {
            throw new IllegalStateException("Ride is already completed.");
        }
        this.status = "Completed";
        driver.setAvailable(true);
    }*/
    
    /**
     * This is getter method used to get status
     * @return String
     */

    public String getStatus() {
        return this.status;
    }
    
    /**
     * This is a method used to print the ride details
     * @return String
     */

    public String rideDetails() {
        return customer.getName() + " has " + status + " ride with " + driver.getName() + " (driver id " + driver.getID() + ")";
    }
    
    /**
     * This is getter method used to get the driver object
     * @return Driver
     */

	
	public Driver getDriver() {
		return this.driver;
	}
}




