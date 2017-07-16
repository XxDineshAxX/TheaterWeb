package com.da.theater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.da.dao.TheaterDAO;

public class TheaterAdmin {
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/rt",
				"root", "root");

	}
	public static void main(String[] args) throws NotEnoughSeatsException, SQLException, ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		String action = "continue";
		while (action.equals("continue")) {
			System.out
					.println("Type 1 to initialize screen, type 2 to add movies, type 3 to delete a movie, type 4 to reserve tickets, type 5 to cancel tickets, type 6 to exit.");
			int strt1 = scan.nextInt();
			if (strt1 == 1) {
				System.out.println("What is the theater name.");
				String tName = scan.nextLine();
				System.out.println("What is the theater address.");
				String tAdd = scan.nextLine();
				System.out.println("What is the theater id.");
				String tId = scan.nextLine();
				System.out.println("How many screens do you want to create?");
				int numOfScreens = scan.nextInt();
				TheaterDAO theaterDAO = new TheaterDAO();
				theaterDAO.addTheater(tName, tAdd, tId, numOfScreens);
				for (int i = -1; i < numOfScreens; i++) {
					// Repeating here
					System.out.println("What type of screen do you want screen "+ (i + 1)+ ", type reg for a normal screen, type XD for an XDScreen.");
					String screenSelect = scan.nextLine();
					

					
					if (screenSelect.equals("reg")) {
						System.out.println("How many rows do you want?");
						int numOfRowsGiven = scan.nextInt();
						System.out.println("How many seats per row do you want.");
						int numOfSeatsPerRowGiven = scan.nextInt();
						RegScreen x = new RegScreen(screenSelect,numOfRowsGiven, numOfSeatsPerRowGiven);
						int total = numOfRowsGiven * numOfSeatsPerRowGiven;
						theaterDAO.addScreen(i, tId, screenSelect, numOfRowsGiven, numOfSeatsPerRowGiven, total);
						
						// For re
						
					} else if (screenSelect.equals("XD")) {
						System.out.println("How many rows do you want?");
						int numOfRowsGiven = scan.nextInt();
						int[] p = new int[numOfRowsGiven];
						for (int l = 0; l < numOfRowsGiven; l++) {
							System.out.println("How many seats do you want in row "+ (l + 1));
							int numOfSeatsInRowGiven = scan.nextInt();
							
							p[l] = numOfSeatsInRowGiven;
							theaterDAO.addXDScreen(tId, i, (char) ('l'+64), numOfSeatsInRowGiven);
							

						}
						XDScreen x = new XDScreen(screenSelect, numOfRowsGiven,
								p);
						

					}
				}
			}

			if (strt1 == 2) {
				System.out.println("How many movies do you want to add?");
				int numOfMov = scan.nextInt();
				for (int s = 0; s < numOfMov; s++) {
					System.out.println("What do you want movie " + (s + 1)
							+ " to be.");
					String mov = scan.nextLine();
					Theater z = new Theater();
					z.addMovie(mov);
				}
			}

			if (strt1 == 3) {
				System.out.println("How many movies do you want to delete?");
				int numOfMov = scan.nextInt();
				for (int s = 0; s < numOfMov; s++) {
					System.out.println("What movie do you want to delete.");
					String mov = scan.nextLine();
					Theater z = new Theater();
					z.deleteMovie(mov);

				}
			}
			if (strt1 == 4) {
				System.out
						.println("What screen are you going to, type XD for XDScreen, or Reg for regular screen.");
				String screenTGT = scan.nextLine();
				if (screenTGT.equals("Reg")) {
					System.out.println("How many seats are you booking");
					int numOfSeatsBooked = scan.nextInt();
					RegScreen c = new RegScreen();
					c.allocateRandomly(numOfSeatsBooked);
					Random rand = new Random();
					int confNum = rand.nextInt(100000000);
					
				}
				if (screenTGT.equals("XD")) {
					System.out.println("How many seats are you booking");
					int numOfSeatsBooked = scan.nextInt();
					XDScreen c = new XDScreen();
					c.reserveSeats(numOfSeatsBooked);

				}

			}
			if (strt1 == 5) {
				System.out
						.println("Which screen did you buy tickets in, type XD for XDScreen, or Reg for regular screen.");
				String screenInfo = scan.nextLine();
				if (screenInfo.equals("XD")) {
					//Need help here 
				}
				if (screenInfo.equals("Reg")) {
					System.out.println("How many seats do you want to cancel?");
					int numOSTC = scan.nextInt();
					RegScreen c = new RegScreen();
					c.cancel(numOSTC);
				}

			}
			if(strt1 == 6){
				action = "exit";
			}
		}
	}

}
		