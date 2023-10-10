package com.src.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.PermDriver;
import com.src.model.Request;
import com.src.model.TypeModel;
import com.src.services.PermDriverServicesInterface;
import com.src.services.TempDriverServices;

public class RequestBookingDao implements RequestBookingDaoInterface {
	public static int id = 0; 
	@Override
	public boolean addRequest(Request b) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "insert into Request values('"+b.getFromplace()+"','"+b.getToPlace()+"','"
				+ ""+b.getdriv_username()+"',"+b.getBookingfare()+","+b.getRoutedistance()+","+b.getMax_people()+",0);";
		System.out.println(query);
		try {
			int res = st.executeUpdate(query);
			System.out.println(res);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		Dao.closeMyStatement();
		return false;
	
	}

	@Override
	public boolean deleteRequest(Request b) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from Request where driv_username = '"+b.getdriv_username()+"' and isset = 1;";
		System.out.println(query);
		try {
			int res = st.executeUpdate(query);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return false;
		
	}


	@Override
	public boolean setRequest(String username,String from,String to) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		System.out.println(username+"-"+from+"-"+to);
		String query = "update request set isset = 1 where fromplace = '"+from+"' and toplace = '"+to+"' and driv_username = '"+username+"';";
		System.out.println(username);
		int rs = 0;
		ArrayList<Request> al = new ArrayList();
		try {
			rs = st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		
		return true;
	}

	@Override
	public double getRouteDistance(String From, String To) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select distance from routes where fromplace = '"+From+"' and toplace = '"+To+"';";
		try {
			ResultSet res = st.executeQuery(query);
			if(res.next())
				return Double.parseDouble(res.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return 0.0;
	}

	@Override
	public double getRouteFare(String From, String To,TypeModel t,int maxnumberofpeope) {
		// TODO Auto-generated method stub
		double distance = getRouteDistance(From, To);
		double fare = distance;
		if(t instanceof PermDriver) {
			fare *= PermDriverServicesInterface.chargeperkm;
		}
		else {
			fare *= TempDriverServices.getCharge(maxnumberofpeope, distance);
		}
		return fare;
	}

	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from request;";
		ResultSet rs;
		ArrayList<Request> al = new ArrayList();
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				al.add(new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6),rs.getBoolean(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return al;
	}

	@Override
	public List<Request> getRequests(String username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from request where driv_username = "+username+";";
		ResultSet rs;
		ArrayList<Request> al = new ArrayList();
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				al.add(new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6),rs.getBoolean(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return al;
	}

	@Override
	public Request isBooked(String username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		System.out.println("usr "+username);
		String query = "select * from request where driv_username = '"+username+"' and isset = 1;";
		ResultSet rs;
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("try");
				return new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6),rs.getBoolean(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public boolean deleteRequest(String fromplace, String toplace, String username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from request where fromplace = '"+fromplace+"' and toplace = '"+toplace+"' and driv_username = '"+username+"';";
		
		try {
			int res = st.executeUpdate(query);
			return res > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Request> getRequests(String from, String to) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from request where fromplace = '"+from+"' and toplace = '"+to+"' and isset = 0;";
		ResultSet rs;
		ArrayList<Request> al = new ArrayList();
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				al.add(new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6),rs.getBoolean(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return al;
	}

	@Override
	public Request isRequested(String username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		System.out.println("usr "+username);
		String query = "select * from request where driv_username = '"+username+"';";
		ResultSet rs;
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("try");
				return new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6),rs.getBoolean(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public boolean deleteSetRequests() {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from Request where isset = 1;";
		System.out.println(query);
		try {
			int res = st.executeUpdate(query);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return false;
	}

	


	

}
