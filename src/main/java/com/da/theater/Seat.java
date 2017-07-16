package com.da.theater;

public class Seat implements SeatIF{
	int number;
	boolean booked;
	boolean recliner;
	
	public Seat(int number)
	{
		this.number = number;
	}
	
	public void reserve(){
		booked = true;
	}
	public void cancel(){
		booked = false;
	}
	
	public boolean isAvailable()
	{
		return !booked;
	}
	
	public void display(){
		if(booked == true){
			System.out.print("[X]");
		}
		else{
			System.out.print("[ ]");
		}
	}
	
	public int getNumber() {
		return number;
	}

	


}
