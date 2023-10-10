package com.src.services;

import java.util.List;

import com.src.Dao.RequestBookingDao;
import com.src.Dao.RequestBookingDaoInterface;
import com.src.model.Request;
import com.src.model.TypeModel;

public class RequestBooking implements RequestBookingInterface {
	RequestBookingDaoInterface rbd = new RequestBookingDao();
	@Override
	public boolean addRequest(Request b) {
		// TODO Auto-generated method stub
		return rbd.addRequest(b);
	}

	@Override
	public boolean deleteRequest(Request b) {
		// TODO Auto-generated method stub
		return rbd.deleteRequest(b);
	}

	@Override
	public boolean setRequest(String username,String from,String to) {
		// TODO Auto-generated method stub
		return rbd.setRequest(username, from, to);
	}

	@Override
	public double getRouteDistance(String From, String To) {
		// TODO Auto-generated method stub
		return rbd.getRouteDistance(From, To);
	}

	@Override
	public double getRouteFare(String From, String To,TypeModel t,int maxnumberofpeopleavail) {
		// TODO Auto-generated method stub
		return rbd.getRouteFare(From, To, t, maxnumberofpeopleavail);
	}

	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return rbd.getAllRequests();
	}

	@Override
	public List<Request> getRequests(String username) {
		// TODO Auto-generated method stub
		return rbd.getRequests(username);
	}

	@Override
	public Request isBooked(String username) {
		// TODO Auto-generated method stub
		return rbd.isBooked(username);
	}

	@Override
	public boolean deleteRequest(String fromplace, String toplace, String username) {
		// TODO Auto-generated method stub
		return rbd.deleteRequest(fromplace, toplace, username);
	}

	@Override
	public List<Request> getRequests(String from, String to) {
		// TODO Auto-generated method stub
		return rbd.getRequests(from, to);
	}

	@Override
	public Request isRequested(String username) {
		return rbd.isRequested(username);
	}

	@Override
	public boolean deleteSetRequests() {
		// TODO Auto-generated method stub
		return rbd.deleteSetRequests();
	}

}
