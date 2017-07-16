package com.da.theater;

public class NotEnoughSeatsException extends Exception {
	public NotEnoughSeatsException (){
		super("There are not enough seats left available");
		
	}

}
