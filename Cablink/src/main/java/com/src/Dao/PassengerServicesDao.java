package com.src.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Admin;
import com.src.model.Passenger;

public class PassengerServicesDao implements PassengerServicesDaoInterface {

	@Override
	public boolean addDetails(Passenger p) {
		System.out.println("Adding");
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "insert into Passenger values ('"+p.getUsername()+"','"+p.getPassword()+"',"
				+ "'"+p.getName()+"',"+p.getMobile()+",'"+p.getEmail()+"','"+p.getGender()+"',"
						+ "'"+p.getAddress()+"');";
		try {
			int res = st.executeUpdate(query);
			return res > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return false;
	}

	@Override
	public boolean deleteDetails(Passenger p) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from Passenger where username = '"+p.getUsername()+"';";
		try {
			int res = st.executeUpdate(query);
			return res > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return false;
	}

	@Override
	public boolean updateDetails(Passenger p) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "update Passenger set name = '"+p.getName()+"', mobile = "+p.getMobile()+", email = '"
				+ p.getEmail()+"',gender = '"+p.getGender()+"',address = '"+p.getAddress()+"' where username = '"+p.getUsername()+"';";
		try {
			int res = st.executeUpdate(query);
			return res > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return false;
	}

	@Override
	public Passenger getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Passenger where username = '"+uname+"' and password = '"+pwd+"';";
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next())
				return new Passenger(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public List<Passenger> getAllDetails() {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Passenger;";
		ArrayList<Passenger> al = new ArrayList();
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
				al.add(new Passenger(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7)));
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public Passenger getDetails(String uname) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Passenger where username = '"+uname+"';";
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next())
				return new Passenger(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

}
