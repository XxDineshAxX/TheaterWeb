package com.da.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.da.theater.Ticket;


public class TheaterDAO {
	
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/da",
				"root", "root");

	}
	
	public String addTheater(String tName, String tAdd, String tId, int numOfScreens) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		;
		String query = "insert into Theater(theaterName, numOfScreens, theaterAddress, theaterID) values('" + tName + "','" + numOfScreens + "','" + tAdd + "','" + tId + "')";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public String addScreen(int screenID, String tId, String screenType, int numOfRows, int numOfSeatsPerRow, int totalNumOfSeats) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "insert into Screen(theaterID, screenID, screenType, numOfRows, numOfSeatsPerRow, totalNumOfSeats) values('" + tId + "','" + screenID + "','" + screenType + "','" + numOfRows + "','" + numOfSeatsPerRow + "','" + totalNumOfSeats + "')";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public String addXDScreen(String tId, int screenId, char rowId, int numOfSeatsInRow) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "insert into XDScreen(theaterID, screenID, rowID, numOfSeatsInRow) values('" + tId + "','" + screenId + "','" + rowId + "','" + numOfSeatsInRow + "')";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public String addTicket(int screenId, char rowId, int seatId, boolean booked, int confNum) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "insert into Tickets(screenID, rowID, seatID, booked, confNum) values('" + screenId + "','" + rowId + "','" + seatId + "','" + booked + "','" + confNum + "')";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public String reserveTicket(int screenId, char rowId, int seatId, boolean booked, int confNum) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "update Tickets set booked = true and confNum = '"+confNum+"' where screenID = '"+screenId+"' and rowID = '"+rowId+"' and seatID = '"+seatId+"'";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public String cancelTicket(int screenId, char rowId, int seatId, boolean booked) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "update Tickets set booked = false and confNum = null where screenID = '"+screenId+"' and rowID = '"+rowId+"' and seatID = '"+seatId+"'";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public String addTransaction(String dateOfTransaction, int numOfTickets, boolean reserve, boolean cancel, int id, int confNum, int price, int screenId, String movieId) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "insert into Transaction(dateOfTransaction, numOfTickets, reserve, cancel, id, confNum, price, screenID, movieID) values('" + dateOfTransaction + "','" + numOfTickets + "','" + reserve + "','" + cancel + "','" + id + "','" + confNum + "','" + price + "','" + screenId + "','" + movieId + "')";
		stmt.execute(query);
		conn.close();
		return query;
	}
	public ArrayList getSeatsList(int screenID) throws ClassNotFoundException, SQLException{
		String sql = "select rowID, seatID, booked from Tickets where screenID=? order by rowID";
		PreparedStatement ptst = getConn().prepareStatement(sql);
		ptst.setInt(1, screenID);
		ResultSet rs = ptst.executeQuery();
		ArrayList<Ticket> ars = new ArrayList<Ticket>();
		while(rs.next()){
		Ticket ticket = new Ticket();
		ticket.setBooked(rs.getBoolean("booked"));
		ticket.setRowId(rs.getString("rowID").charAt(0));
		System.out.println(rs.getString("rowID").charAt(0));
		ticket.setScreenId(screenID);
		ticket.setSeatId(rs.getInt("seatID"));
		ars.add(ticket);
		}
		return ars;
		
	}
	public String addTicket(int screenId, char rowId, int seatId) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();

		Statement stmt = conn.createStatement();
		
		String query = "insert into Tickets(screenID, rowID, seatID) values('" + screenId + "','" + rowId + "','" + seatId + "')";
		stmt.execute(query);
		conn.close();
		return query;
	}
	
	public int getNumOfScreens() throws SQLException, ClassNotFoundException{
		Connection conn = getConn();
		Statement stmt = conn.createStatement();
		String query = "select numOfScreens from Theater";
		ResultSet nos = stmt.executeQuery(query);
		int numOfScreens = 0;
		if(nos.next()){
			numOfScreens = nos.getInt(1);
		}
		return numOfScreens;
		
	}
}

