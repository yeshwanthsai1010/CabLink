package com.src.services;

import java.util.List;

import com.src.Dao.PermDriverServicesDao;
import com.src.Dao.PermDriverServicesDaoInterface;
import com.src.model.PermDriver;

public class PermDriverServices implements PermDriverServicesInterface {
	PermDriverServicesDaoInterface psd = new PermDriverServicesDao();
	@Override
	public boolean addDetails(PermDriver pd) {
		// TODO Auto-generated method stub
		return psd.addDetails(pd);
	}

	@Override
	public boolean deleteDetails(PermDriver pd) {
		// TODO Auto-generated method stub
		return psd.deleteDetails(pd);
	}

	@Override
	public boolean updateDetails(PermDriver pd) {
		// TODO Auto-generated method stub
		return psd.updateDetails(pd);
	}

	@Override
	public PermDriver getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		return psd.getDetails(uname, pwd);
	}

	@Override
	public List<PermDriver> getAllDetails() {
		// TODO Auto-generated method stub
		return psd.getAllDetails();
	}

	@Override
	public double getCharge(double routedistance) {
		// TODO Auto-generated method stub
		return routedistance * PermDriverServicesInterface.chargeperkm;
	}

	@Override
	public PermDriver getDetails(String uname) {
		// TODO Auto-generated method stub
		return psd.getDetails(uname);
	}

}
