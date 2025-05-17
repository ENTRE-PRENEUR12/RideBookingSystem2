package com.cg.RideBookingSystem8.entities;


/**
 * Used to create abstract class type blueprint
 * @author Anushka De
 */
public abstract class User 
{
	
    protected String id;
	protected String name;
	
	/**
	 * Constructor to initialize variables
	 * @param id 
	 * @param name 
	 * @author Anushka De
	 */
	
	public User(String id, String name)   
	{
		this.setName(name);
		this.setID(id);	
	}
	
	
	/**
	 * Method to return the name of user or customer
	 * @return
	 * @author Anushka De
	 */
	public String getName()   
	{
		return this.name;
	}
	
	
	/**
	 * Method to set the name of driver or customer
	 * @param name
	 * @author Anushka De
	 */
	
	public void setName(String name) 
	{
		this.name=name;
	}
	
	
	
	/**
	 * Method to return the id or driver or customer
	 * @return
	 * @author Anushka De
	 */
	
	public String getID()  
	{
		return this.id;
	}
	
	
	/**
	 * Method to set id of the driver or customer
	 * @param id
	 * @author Anushka De
	 */
	
	public void setID(String id) 
	{
		this.id=id;
	}
	
	
	/**
	 * Abstract method ShowProfile which will be overridden by child classes
	 */
	public abstract void ShowProfile();

}
