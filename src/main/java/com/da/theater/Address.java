package com.da.theater;

public class Address {
	
	String houseNumber;
	String streetName;
	String city;
	String state;
	int zipCode;
	
	
	public boolean equals(Address std){
		if(this.houseNumber == std.houseNumber && 
				this.streetName == std.streetName &&
				this.city == std.city &&
				this.state == std.state &&
				this.zipCode == std.zipCode)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void display()
	{
		System.out.println(houseNumber+" "+streetName+", "+city+" "+state+" "+zipCode);
	}
	
	public Address(String houseNumber, String streetName, String city, String state, int zipCode)
	{
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

}


// 647 Cowboys Pkwy, Irving TX 75063