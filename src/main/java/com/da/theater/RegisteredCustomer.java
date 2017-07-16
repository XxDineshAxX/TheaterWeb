package com.da.theater;

public class RegisteredCustomer extends Customer{
	public RegisteredCustomer(String fn, String ln, String email,
			int phoneNumber) {
		super();
		// TODO Auto-generated constructor stub
	}
	int rewardsPoints;
	public void addPoints(){
		rewardsPoints = rewardsPoints + 5;
	}
	public String sendPromotion(){
		String promotion = "You can get 5% off your new ticket";
		return promotion;
		
	}

}
