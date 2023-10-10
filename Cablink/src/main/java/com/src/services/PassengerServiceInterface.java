package com.src.services;

import java.util.List;

import com.src.model.Passenger;

public interface PassengerServiceInterface {
 
	public boolean addDetails(Passenger p);
	public boolean deleteDetails(Passenger p);
	public boolean updateDetails(Passenger p);
	public Passenger getDetails(String uname,String pwd);
	public Passenger getDetails(String uname);
	public List<Passenger> getAllDetails();
	public double getCharge(double routedistance);
}
