package com.src.services;

import java.util.List;

import com.src.Dao.AdminServicesDao;
import com.src.Dao.AdminServicesDaoInterface;
import com.src.model.Admin;

public class AdminServices implements AdminServicesInterface{
	AdminServicesDaoInterface asd = new AdminServicesDao();
	@Override
	public boolean addDetails(Admin ad) {
		// TODO Auto-generated method stub
		return asd.addDetails(ad);
	}

	@Override
	public boolean deleteDetails(Admin ad) {
		// TODO Auto-generated method stub
		return asd.deleteDetails(ad);
	}

	@Override
	public boolean updateDetails(Admin ad) {
		// TODO Auto-generated method stub
		return asd.updateDetails(ad);
	}

	@Override
	public Admin getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		return asd.getDetails(uname, pwd);
	}

	@Override
	public List<Admin> getAllDetails() {
		// TODO Auto-generated method stub
		return asd.getAllDetails();
	}

}
