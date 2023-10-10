package com.src.services;

import com.src.model.Booking;
import com.src.model.Request;

public interface BookingServicesInterface {
	public boolean addBooking(Booking b);
	public boolean deleteBooking(Booking b);
	public boolean deleteBooking(String from,String to,String custuname);
	public Booking getBooking(String from,String to,String cust_username,String driv_username);
	public Booking getBooking(String cust_username);
	public Booking getBooking(String from,String to,String driv_username);
	public boolean setBooking(String username,String from,String to);
	public Booking isBooked(String username);
}
