package com.da.theater;

import java.util.ArrayList;

public class Row {
	
	int numOfSeatsAvailable;
	char nameOfRow;	
	ArrayList<Seat> seats = new ArrayList<Seat>(); 
	
	public Row(int numOfSeats, char nameOfRow){
		this.nameOfRow = nameOfRow;
		
		for(int i = 0; i < numOfSeats; i ++){
			Seat seatToPut = new Seat(i+1);
			seats.add(seatToPut);
		}
	}
	
	public int getNumOfSeatsAvailable() {
		return numOfSeatsAvailable;
	}
	
	public char getNameOfRow() {
		return nameOfRow;
	}

	

	
	

}
