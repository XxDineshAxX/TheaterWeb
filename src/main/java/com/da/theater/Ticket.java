package com.da.theater;

public class Ticket {
	int screenId;
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public char getRowId() {
		return rowId;
	}
	public void setRowId(char rowId) {
		this.rowId = rowId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	char rowId;
	int seatId;
	boolean booked;
	public Ticket(){}
	public Ticket(int screenId, char rowId, int seatId, boolean booked){
		this.screenId = screenId;
		this.rowId = rowId;
		this.seatId = seatId;
		this.booked = booked;
		
	}
}
