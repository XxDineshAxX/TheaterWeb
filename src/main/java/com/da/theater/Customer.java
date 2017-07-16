package com.da.theater;

import java.io.Serializable;

public class Customer implements Serializable{
	public String fn;
	String ln;
	public transient String ssn;
	String age;
	String gender;
	String email;
	int phoneNumber;
	public Customer(String fn,String ln,String email,int phoneNumber, String age, String gender){
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender = gender;
		
	}
	public Customer(){}
	
	public Customer(String fn){
		this.fn = fn;
	}
	public Customer(String fn, String ssn){
		this.fn = fn;
		this.ssn = ssn;
	}

}
