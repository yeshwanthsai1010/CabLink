package com.src.Dao;

import java.util.List;

import com.src.model.Request;
import com.src.model.TypeModel;

public interface RequestBookingDaoInterface {
	public boolean addRequest(Request b);
	public boolean deleteRequest(Request b);
	public boolean deleteRequest(String fromplace,String toplace,String username);
	public boolean deleteSetRequests();
	public boolean setRequest(String username,String from,String to);
	public double getRouteDistance(String From,String To);
	public double getRouteFare(String From,String To,TypeModel t,int maxnumberofpeople);
	public List<Request> getAllRequests();
	public List<Request> getRequests(String username);
	public List<Request> getRequests(String from,String to);
	public Request isBooked(String username);
	public Request isRequested(String username);
}
