package com.src.model;

import com.src.an.Constraint;
import com.src.an.Table;
import com.src.an.TableAnnotation;
@TableAnnotation
public class Booking {

	@Constraint(constraint="not null")
	private String fromplace;
	@Constraint(constraint="not null")
	private String toplace;
	@Constraint(constraint="not null")
	private String cust_username;
	@Constraint(constraint="not null")
	private String driv_username;
	private double bookingfare;
	private double routedistance;
	private boolean isset;
	
	public Booking() {
		if(this.getClass().isAnnotationPresent(TableAnnotation.class)) {
			Table.createTable(this.getClass().getCanonicalName());
		}
	}

	


	public Booking(String fromplace, String toplace, String cust_username, String driv_username, double bookingfare,
			double routedistance) {
		super();
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.cust_username = cust_username;
		this.driv_username = driv_username;
		this.bookingfare = bookingfare;
		this.routedistance = routedistance;
	}




	public Booking(String fromplace, String toplace, String cust_username, String driv_username, double bookingfare,
			double routedistance, boolean isset) {
		super();
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.cust_username = cust_username;
		this.driv_username = driv_username;
		this.bookingfare = bookingfare;
		this.routedistance = routedistance;
		this.isset = isset;
	}




	public String getfromplace() {
		return fromplace;
	}

	public void setfromplace(String fromplace) {
		this.fromplace = fromplace;
	}

	public String gettoplace() {
		return toplace;
	}

	public void settoplace(String toplace) {
		this.toplace = toplace;
	}

	public String getCust_username() {
		return cust_username;
	}

	public void setCust_username(String cust_username) {
		this.cust_username = cust_username;
	}

	public double getBookingfare() {
		return bookingfare;
	}

	public void setBookingfare(double bookingfare) {
		this.bookingfare = bookingfare;
	}

	public double getRoutedistance() {
		return routedistance;
	}

	public void setRoutedistance(double routedistance) {
		this.routedistance = routedistance;
	}




	public String getDriv_username() {
		return driv_username;
	}




	public void setDriv_username(String driv_username) {
		this.driv_username = driv_username;
	}




	public String getFromplace() {
		return fromplace;
	}




	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}




	public String getToplace() {
		return toplace;
	}




	public void setToplace(String toplace) {
		this.toplace = toplace;
	}




	public boolean isIsset() {
		return isset;
	}




	public void setIsset(boolean isset) {
		this.isset = isset;
	}


	
	
	
}
