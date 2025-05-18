package com.cg.RideBookingSystem.exceptions;
/**
 * Custom exception class to print a message when exception occurs
 * @author Aniket Adhikari
 */
public class InvalidRideException extends RuntimeException{
private String message;
	
	public InvalidRideException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}