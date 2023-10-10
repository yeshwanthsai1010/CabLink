package com.src.model;

import com.src.an.Constraint;
import com.src.an.Table;
import com.src.an.TableAnnotation;
import com.src.services.RequestBooking;
@TableAnnotation
public class Request {

	RequestBooking rb = new RequestBooking();
	@Constraint(constraint="not null")
	private String fromplace;
	@Constraint(constraint="not null")
	private String toplace;
	@Constraint(constraint="not null")
	private String driv_username;
	
	private double bookingfare;
	private double routedistance;
	private int max_people;
	private boolean isset;
	
	
	public Request() {
		if(this.getClass().isAnnotationPresent(TableAnnotation.class)) {
			Table.createTable(this.getClass().getCanonicalName());
		}
	}
	
	public Request(String fromplace, String toplace, String driv_username, double bookingfare, double routedistance,
			int max_people,boolean isset) {
		super();
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.driv_username = driv_username;
		this.bookingfare = bookingfare;
		this.routedistance = routedistance;
		this.max_people = max_people;
	}

	public Request(String fromplace, String toplace, String driv_username,int max_people,TypeModel t) {
		this.fromplace = fromplace;
		this.toplace = toplace;
		this.driv_username = driv_username;
		this.routedistance = rb.getRouteDistance(fromplace, toplace);
		this.bookingfare = rb.getRouteFare(fromplace, toplace,t,max_people);
		this.max_people = max_people;
	}

	public String getFromplace() {
		return fromplace;
	}

	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}

	public String getToPlace() {
		return toplace;
	}

	public void setToPlace(String toplace) {
		this.toplace = toplace;
	}

	public String getdriv_username() {
		return driv_username;
	}

	public void setdriv_username(String driv_username) {
		this.driv_username = driv_username;
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

	public int getMax_people() {
		return max_people;
	}

	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}

	public boolean isIsset() {
		return isset;
	}

	public void setIsset(boolean isset) {
		this.isset = isset;
	}
	
	

}
