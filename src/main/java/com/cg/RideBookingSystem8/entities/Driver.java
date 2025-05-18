package com.cg.RideBookingSystem8.entities;

import java.util.Objects;

import com.cg.RideBookingSystem8.entities.User;

/**
 * Child class Driver inherits properties of parent Class User
 * @author Prateek Sinha
 */
public class Driver extends User 
{
	
	private boolean field = true;
	/**
	 * Constructor to initialize the id, name of driver and field
	 * @param id
	 * @param name
	 * @param field
	 */
    public Driver(String id, String name, boolean field)
    {
    	super(id,name);
    	this.field=true;
    	
    	
    }
    
    /**
     * Overridden method to display name and id of driver
     */
    
    public void ShowProfile()
    {
    	System.out.println("Driver name and ID: \n " + "[ Driver name : " + this.name + " Driver ID : " + this.id); 
    }
    
    /**
     * Getter method to get availability of driver
     * @return
     */
    
    public boolean isAvailable()
    {
		return this.field;
    	
    }
    /**
     * Setter method to set availability of driver
     * @param field
     */
    public void setAvailable(boolean field)
    {
    	this.field=field;
    }
    
    /**
     * Getter method to get Driver id
     * @return
     */
    public String getdDriverId() {
    	return this.hashCode()+"";
    }

	@Override
	public int hashCode() {
		return Objects.hash(field);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return field == other.field;
	}
    
    
}
