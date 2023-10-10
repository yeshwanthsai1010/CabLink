package com.src.services;

import java.util.List;

import com.src.Dao.TempDriverServicesDao;
import com.src.Dao.TempDriverServicesDaoInterface;
import com.src.model.TempDriver;

public class TempDriverServices implements TempDriverServicesInterface{
	TempDriverServicesDaoInterface tsd = new TempDriverServicesDao();
	@Override
	public boolean addDetails(TempDriver td) {
		// TODO Auto-generated method stub
		return tsd.addDetails(td);
	}

	@Override
	public boolean deleteDetails(TempDriver td) {
		// TODO Auto-generated method stub
		return tsd.deleteDetails(td);
	}

	@Override
	public boolean updateDetails(TempDriver td) {
		// TODO Auto-generated method stub
		return tsd.updateDetails(td);
	}

	@Override
	public TempDriver getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		return tsd.getDetails(uname, pwd);
	}

	@Override
	public List<TempDriver> getAllDetails() {
		// TODO Auto-generated method stub
		return tsd.getAllDetails();
	}

	public static double getCharge(int numberofpassengers, double routedistance) {
		// TODO Auto-generated method stub
		return (routedistance*(TempDriverServicesInterface.chargeperkm))/(double)numberofpassengers;
	}

	@Override
	public TempDriver getDetails(String uname) {
		// TODO Auto-generated method stub
		return tsd.getDetails(uname);
	}

}
