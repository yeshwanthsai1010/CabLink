package com.src.Dao;

import java.util.List;

import com.src.model.TempDriver;

public interface TempDriverServicesDaoInterface {
	public boolean addDetails(TempDriver td);
	public boolean deleteDetails(TempDriver td);
	public boolean updateDetails(TempDriver td);
	public TempDriver getDetails(String uname,String pwd);
	public TempDriver getDetails(String uname);
	public List<TempDriver> getAllDetails();
	
}
