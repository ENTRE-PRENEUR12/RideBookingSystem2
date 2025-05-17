package com.cg.RideBookingSystem8.entities;

import com.cg.RideBookingSystem8.entities.User;

/**
 * Class Customer extends Class User's properties
 * @author Anushka De
 */
public class Customer extends User 
{
	/**
	 * Constructor to initialize id and name of customer
	 * @param id
	 * @param name
	 */
   public Customer(String id, String name) 
   {
	   super(id, name);
   }
   
   /**
    * Overridden method which shows the customer name and id
    */
   public void ShowProfile()
   {
	   System.out.println("Customer name and id is as follows: \n " + "[ Customer Name : " + this.name + " Customer ID : " + this.id+" ]");
   }
	
}
