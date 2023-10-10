package com.src.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.src.model.Booking;
import com.src.model.Request;
import com.src.security.SecurityServices;
import com.src.security.SecurityServicesInterface;

public class BookingServicesDao implements BookingServicesDaoInterface {
	SecurityServicesInterface ssi = new SecurityServices();
	@Override
	public boolean addBooking(Booking b) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "insert into Booking values('" + b.getfromplace() + "','" + b.gettoplace() + "','"
				+ b.getCust_username() + "','"+b.getDriv_username()+"'," + b.getBookingfare() + "," + b.getRoutedistance() + ",0);";
		int res = 0;
		try {
			res = st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return res > 0;
	}

	@Override
	public boolean deleteBooking(Booking b) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from Booking where fromplace = '" + b.getfromplace() + "' and toplace = '"
				+ b.gettoplace() + "' and driv_username = '" + b.getDriv_username() + "' and cust_username = '"
				+ b.getCust_username() + "';";
		int res = 0;
		try {
			res = st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return res > 0;
	}

	@Override
	public Booking getBooking(String from, String to, String cust_username, String driv_username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Booking where fromplace = '" + from + "' and toplace = '" + to
				+ "' and driv_username = '" + driv_username + "' and cust_username = '" + cust_username + "';";
		ResultSet rs = null;

		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				return new Booking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDouble(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteBooking(String from, String to, String custuname) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from Booking where fromplace = '" + from + "' and toplace = '"
				+ to+ "' and cust_username = '"
				+ custuname + "';";
		int res = 0;
		try {
			res = st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return res > 0;
	}

	@Override
	public Booking getBooking(String cust_username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Booking where cust_username = '" + cust_username + "';";
		ResultSet rs = null;
		System.out.println(query);
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				return new Booking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDouble(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Booking getBooking(String from, String to, String driv_username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Booking where fromplace = '" + from + "' and toplace = '" + to
				+ "' and driv_username = '" + driv_username + "' ;";
		System.out.println(query);
		ResultSet rs = null;

		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
				return new Booking(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getDouble(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean setBooking(String username, String from, String to) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		System.out.println(username+"-"+from+"-"+to);
		String query = "update booking set isset = 1 where fromplace = '"+from+"' and toplace = '"+to+"' and driv_username = '"+username+"';";
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
	public Booking isBooked(String username) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		System.out.println("usr "+username);
		String query = "select * from booking where driv_username = '"+username+"' and isset = 1;";
		ResultSet rs;
		try {
			rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("try");
				return new Booking(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(4),rs.getDouble(5),rs.getBoolean(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao.closeMyStatement();
		return null;
	}

}
