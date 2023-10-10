package com.src.services;

import java.util.List;

import com.src.Dao.PassengerServicesDao;
import com.src.Dao.PassengerServicesDaoInterface;
import com.src.Dao.PermDriverServicesDaoInterface;
import com.src.model.Passenger;

public class PassengerServices implements PassengerServiceInterface{
	PassengerServicesDaoInterface psd = new PassengerServicesDao();
	@Override
	public boolean addDetails(Passenger p) {
		new Passenger();
		// TODO Auto-generated method stub
		return psd.addDetails(p);
	}

	@Override
	public boolean deleteDetails(Passenger p) {
		// TODO Auto-generated method stub
		return psd.deleteDetails(p);
	}

	@Override
	public boolean updateDetails(Passenger p) {
		// TODO Auto-generated method stub
		return psd.updateDetails(p);
	}

	@Override
	public Passenger getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		return psd.getDetails(uname, pwd);
	}

	@Override
	public List<Passenger> getAllDetails() {
		// TODO Auto-generated method stub
		return psd.getAllDetails();
	}

	@Override
	public double getCharge(double routedistance) {
		// TODO Auto-generated method stub
		return (PermDriverServicesDaoInterface.chargeperkm)*routedistance;
	}

	@Override
	public Passenger getDetails(String uname) {
		// TODO Auto-generated method stub
		return psd.getDetails(uname);
	}

}
