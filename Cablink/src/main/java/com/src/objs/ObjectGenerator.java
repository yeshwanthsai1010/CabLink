package com.src.objs;

import com.src.security.SecurityServices;
import com.src.security.SecurityServicesInterface;
import com.src.services.BookingServices;
import com.src.services.BookingServicesInterface;
import com.src.services.PassengerServiceInterface;
import com.src.services.PassengerServices;
import com.src.services.PermDriverServices;
import com.src.services.PermDriverServicesInterface;
import com.src.services.RequestBooking;
import com.src.services.RequestBookingInterface;
import com.src.services.TempDriverServices;
import com.src.services.TempDriverServicesInterface;

public class ObjectGenerator {
	static PassengerServiceInterface passengerservices = new PassengerServices();	
	static TempDriverServicesInterface tempdriverservices = new TempDriverServices();
	static PermDriverServicesInterface permdriverservices = new PermDriverServices();
	static BookingServicesInterface bookingservices = new BookingServices();
	static RequestBookingInterface requestservices = new RequestBooking();
	static SecurityServicesInterface securityservices = new SecurityServices();
	
	public PassengerServiceInterface getPassengerServices() {
		return passengerservices;
	}
	
	public TempDriverServicesInterface getTempDriverServices() {
		return tempdriverservices;
	}
	
	public PermDriverServicesInterface getPermDriverServices() {
		return permdriverservices;
	}
	
	public BookingServicesInterface getBookingServices() {
		return bookingservices;
	}
	
	
	public RequestBookingInterface getRequestDriverServices() {
		return requestservices;
	}
	
	public SecurityServicesInterface getSecurityServices() {
		return securityservices;
	}
}
