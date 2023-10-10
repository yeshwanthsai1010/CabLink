package com.src.services;

import java.util.List;

import com.src.model.TempDriver;

public interface TempDriverServicesInterface {
	double chargeperkm = 0.66;

	public boolean addDetails(TempDriver td);
	public boolean deleteDetails(TempDriver td);
	public boolean updateDetails(TempDriver td);
	public TempDriver getDetails(String uname,String pwd);
	public TempDriver getDetails(String uname);
	public List<TempDriver> getAllDetails();
}
