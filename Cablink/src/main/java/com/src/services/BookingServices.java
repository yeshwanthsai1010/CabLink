package com.src.services;

import com.src.Dao.BookingServicesDao;
import com.src.Dao.BookingServicesDaoInterface;
import com.src.model.Booking;
import com.src.model.Request;

public class BookingServices implements BookingServicesInterface {
	BookingServicesDaoInterface bsdi = new BookingServicesDao();
	@Override
	public boolean addBooking(Booking b) {
		// TODO Auto-generated method stub
		return bsdi.addBooking(b);
	}

	@Override
	public boolean deleteBooking(Booking b) {
		// TODO Auto-generated method stub
		return bsdi.deleteBooking(b);
	}

	@Override
	public Booking getBooking(String from, String to, String cust_username, String driv_username) {
		// TODO Auto-generated method stub
		return bsdi.getBooking(from, to, cust_username, driv_username);
	}

	@Override
	public boolean deleteBooking(String from, String to, String custuname) {
		// TODO Auto-generated method stub
		return bsdi.deleteBooking(from, to, custuname);
	}

	@Override
	public Booking getBooking(String cust_username) {
		// TODO Auto-generated method stub
		return bsdi.getBooking(cust_username);
	}

	@Override
	public Booking getBooking(String from, String to, String driv_username) {
		// TODO Auto-generated method stub
		return bsdi.getBooking(from, to, driv_username);
	}




	@Override
	public boolean setBooking(String username, String from, String to) {
		// TODO Auto-generated method stub
		return bsdi.setBooking(username, from, to);
	}

	@Override
	public Booking isBooked(String username) {
		// TODO Auto-generated method stub
		return bsdi.isBooked(username);
	}

}
