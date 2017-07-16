package com.da.theater;

import java.sql.SQLException;

import java.util.Random;


import com.da.dao.TheaterDAO;

public class RegScreen extends Screen {

	int totalAvailableSeats;
	int price = 10;

	public RegScreen(String ScreenType, int numOfRows, int numOfSeatsPerRow) {
		super(ScreenType, numOfRows, numOfSeatsPerRow);
		// TODO Auto-generated constructor stub
		char nameOfRow;
		for (int i = 0; i < numOfRows; i++) {
			nameOfRow = (char) ('A' + i);
			Row rowToPut = new Row(numOfSeatsPerRow, nameOfRow);
			rows.add(rowToPut);
		}

		totalAvailableSeats = numOfSeatsPerRow * numOfRows;
	}

	public RegScreen() {
		// TODO Auto-generated constructor stub
	}

	public void allocateRandomly(int seats) throws NotEnoughSeatsException, ClassNotFoundException, SQLException {
		Random rand = new Random();

		// check if requested number of seats are available
		// Go through each Row / each Seat until the requested number of seats
		// are filled
		int cSeats = 0;
		if(seats <= totalAvailableSeats){
			int confNumMade = rand.nextInt(1000000);                                                                                                                                                                                                                                                       
			TheaterDAO theaterDAO = new TheaterDAO();
			
			
			
			for(Row x:rows){
				for(Seat y:x.seats){
					if(y.isAvailable()){
						theaterDAO.reserveTicket(ScreenID, x.nameOfRow, y.number, y.booked, confNumMade);
						y.reserve();
						cSeats++;
						if(cSeats == seats){ 
							
							totalAvailableSeats = totalAvailableSeats - seats;
							theaterDAO.addTransaction("present", seats, true, false, rand.nextInt(1000000), rand.nextInt(1000000), price * seats, ScreenID, "movie x");
							return;
						}
					}
				}
			}
		}
		else{
			throw new NotEnoughSeatsException();
		}


	}

	public void cancel(int seatsToCancel) throws NotEnoughSeatsException, ClassNotFoundException, SQLException {
		Random rand = new Random();

		int cSeats = 0;
		if(seatsToCancel <= totalAvailableSeats){
			TheaterDAO v = new TheaterDAO();

			for(Row x:rows){
				for(Seat y:x.seats){
					if(y.isAvailable() == false){
						v.cancelTicket(ScreenID, x.nameOfRow, y.number, y.booked);
						y.cancel();
						cSeats++;
						if(cSeats == seatsToCancel){ 
							totalAvailableSeats = totalAvailableSeats + seatsToCancel;
							v.addTransaction("present", seatsToCancel, false, true, rand.nextInt(1000000), rand.nextInt(1000000), -(price * seatsToCancel), ScreenID, "movie x");

							return;
						}
					}
				}
			}
		}
		else{
			throw new NotEnoughSeatsException();
		}

	}

}
