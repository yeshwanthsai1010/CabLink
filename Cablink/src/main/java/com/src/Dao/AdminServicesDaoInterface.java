package com.src.Dao;

import java.util.List;

import com.src.model.Admin;

public interface AdminServicesDaoInterface {
	public boolean addDetails(Admin ad);
	public boolean deleteDetails(Admin ad);
	public boolean updateDetails(Admin ad);
	public Admin getDetails(String uname,String pwd);
	public List<Admin> getAllDetails();
	
}
