package com.da.theater;

import java.util.ArrayList;



          						
public class Theater {
	Address address;
	int c = 0;
	String name;
	int numOfScreens;
	ArrayList<Screen> screens;
	public ArrayList<String> movies;
	
	public Theater() {
		// TODO Auto-generated constructor stub

		
	}

	

	public Theater(int numOfScreens) {
		this.numOfScreens = numOfScreens;

	}

	public void addMovie(String movie) {

		movies.add(movie);
	}

	public void deleteMovie(String movie) {

		if(movies.contains(movie)){
			movies.remove(movie);
		}
		else{
			System.err.println(movie+" is not present in the list, it is either not there, or you might have spelled something wrong.");
		}

	}
	
	public void addScreen(Screen screen){
		screens.add(screen);		
	}
}
