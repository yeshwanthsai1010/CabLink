package com.src.services;

import java.util.List;

import com.src.model.PermDriver;

public interface PermDriverServicesInterface {
	double chargeperkm = 35.89;
	public boolean addDetails(PermDriver pd);
	public boolean deleteDetails(PermDriver pd);
	public boolean updateDetails(PermDriver pd);
	public PermDriver getDetails(String uname,String pwd);
	public PermDriver getDetails(String uname);
	public List<PermDriver> getAllDetails();
	public double getCharge(double routedistance);
}
