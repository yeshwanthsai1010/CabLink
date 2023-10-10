package com.src.Dao;

import java.util.List;

import com.src.model.Passenger;

public interface PassengerServicesDaoInterface {
	public boolean addDetails(Passenger p);
	public boolean deleteDetails(Passenger p);
	public boolean updateDetails(Passenger p);
	public Passenger getDetails(String uname,String pwd);
	public Passenger getDetails(String uname);
	public List<Passenger> getAllDetails();
	
}
