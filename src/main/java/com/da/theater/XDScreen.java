package com.da.theater;

import java.util.ArrayList;
import java.util.List;

public class XDScreen extends Screen{
	int [] numOfSeatsPerRow;
	int totalNumOfSeatsAvailable;

	public XDScreen(String ScreenType, int numOfRows, int [] numOfSeatsPerRow) {
		super();
		this.ScreenType = ScreenType;
		this.numOfRows = numOfRows;
		this.numOfSeatsPerRow = numOfSeatsPerRow;
		char nameOfRow;
		if(numOfRows > numOfSeatsPerRow.length){
			System.err.println("Missing seat information for certain rows.");
		}
		else{
			for(int i = 0; i < numOfRows; i++){
				nameOfRow = (char) ('A' + i);
				Row rowToPut = new Row(numOfSeatsPerRow[i], nameOfRow);
				rows.add(rowToPut);
				totalNumOfSeatsAvailable = totalNumOfSeatsAvailable + numOfSeatsPerRow[i];
			}
		}
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public XDScreen() {
		// TODO Auto-generated constructor stub
	}



	public List<String> reserveSeats(int numberOfSeatsRequested) throws NotEnoughSeatsException
	{
		ArrayList<String> seatNumbers = new ArrayList<String>();
		
		// check if requested number of seats are available
		// Go through each Row / each Seat until the requested number of seats are filled
		int cSeats = 0;
		if(numberOfSeatsRequested <= totalNumOfSeatsAvailable){
			for(Row x:rows){
				if(x.getNumOfSeatsAvailable() <= numberOfSeatsRequested){
				for(Seat y:x.seats){
					if(y.isAvailable()){
						y.reserve();
						cSeats++;
						String seatNum = ""+x.getNameOfRow() + y.getNumber();
						seatNumbers.add(seatNum);
						if(cSeats == numberOfSeatsRequested){ 
							totalNumOfSeatsAvailable = totalNumOfSeatsAvailable - numberOfSeatsRequested;
							return seatNumbers;
						}
					}
				}
			}
		}
		
		}
		else{
			throw new NotEnoughSeatsException();
		}
		
		
		return seatNumbers;
	}
	
	public boolean cancelSeats(ArrayList<String> seatNumbers){
		int c = 0;
		for(String x : seatNumbers){
			char nameOfRow = x.charAt(0);
			String sSeatNum = x.substring(1);
			int SeatNum = Integer.parseInt(sSeatNum);
			for(Row q : rows){
				if(nameOfRow == q.getNameOfRow()){
					for(Seat w : q.seats){
						if(SeatNum == w.getNumber()){
							w.cancel();
							c++;
							if(c == seatNumbers.size()){
								return true;
							}
						}
					}
				}
				
			}
			
			
			
		} 
		return false;
		
		}

}
