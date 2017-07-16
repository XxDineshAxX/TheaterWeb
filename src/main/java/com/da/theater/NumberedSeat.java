package com.da.theater;

public class NumberedSeat extends Seat implements Recliner {
	private int number;
	
	public NumberedSeat(int number){
		super(number);
		this.number = number;
	}
}
