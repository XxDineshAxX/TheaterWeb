package com.da.theater;

import java.util.ArrayList;

public class Screen {
	int ScreenID;
	String ScreenType;
	int numOfRows;
	ArrayList<Row> rows = new ArrayList<Row>();
	int numOfSeatsPerRow;
	
	
	public Screen(String ScreenType, int numOfRows, int numOfSeatsPerRow){
		this.ScreenType = ScreenType;
		this.numOfRows = numOfRows;
		this.numOfSeatsPerRow = numOfSeatsPerRow; 
		
		
		
	}
	
	public Screen(){}
	
	private void addRow(Row Row){
		if (rows.size() < numOfRows){
			rows.add(Row);
		}
		
	}
	
	public void display(){
		for(Row mark : rows){
			System.out.println(rows);
		}
	}
	
}
