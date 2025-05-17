package com.cg.RideBookingSystem8.entities;

import java.util.ArrayList;

import java.util.Iterator;
import java.*;

import java.util.List;

import com.cg.RideBookingSystem8.annotations.SecurityCheck;

/**
 * This class is child of User class where annotation is used to put security check as Admin
 * @author Shivam Kumar
 */

@SecurityCheck(role ="Admin")
public class Admin extends User{
	List<Driver> drivers = new ArrayList<>();
	
	/**
	 * This is a constructor used to set the id and name of Admin by calling super
	 * @param id
	 * @param name
	 */
	
	public Admin(String id, String name) {
		super(id,name);
	}
	
	/**
	 * This method is used to display the admin details
	 */
	public void ShowProfile() {
		System.out.println("Admin Name : "+super.name+" Role : Admin");
	}
	
	/**
	 * This method is used to remove drivers from drivers list
	 * @param drivers
	 * @param driverId
	 */
	public void removeDriver(List drivers, String driverId) {
		Class<SecurityCheck> clazz = SecurityCheck.class;
		SecurityCheck s = clazz.getDeclaredAnnotation(SecurityCheck.class);
		boolean found = true;
		
		if(s.role().equals("Admin") && clazz.isAnnotationPresent(SecurityCheck.class)) {
			SecurityCheck sc = clazz.getAnnotation(SecurityCheck.class);
            if ("Admin".equals(sc.role())) {
                Iterator<Driver> iterator = drivers.iterator();
                while (iterator.hasNext()) {
                    Driver driver = iterator.next();
                    if (driver.id.equals(driverId)) {
                        iterator.remove();
                        System.out.println("Driver removed: " + driver.name);
                        return;
                    }
                }
                System.out.println("Driver ID not found.");
            }
		}
		
		
		for(int i=0;i<drivers.size();i++) {
			if(((User) drivers).getID().equals(driverId)) {
				drivers.remove(i);
				System.out.println("Driver deleted Successfully...");
				break;
			}
		}
	}

	
}
