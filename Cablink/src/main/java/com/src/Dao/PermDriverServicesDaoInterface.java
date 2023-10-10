package com.src.Dao;

import java.util.List;

import com.src.model.PermDriver;

public interface PermDriverServicesDaoInterface {
	public double chargeperkm = 6.78;
	public boolean addDetails(PermDriver pd);
	public boolean deleteDetails(PermDriver pd);
	public boolean updateDetails(PermDriver pd);
	public PermDriver getDetails(String uname,String pwd);
	public PermDriver getDetails(String uname);
	public List<PermDriver> getAllDetails();
	


}
