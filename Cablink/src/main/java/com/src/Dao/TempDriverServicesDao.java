package com.src.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Passenger;
import com.src.model.TempDriver;

public class TempDriverServicesDao implements TempDriverServicesDaoInterface{

	@Override
	public boolean addDetails(TempDriver td) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "insert into TempDriver values ('"+td.getUsername()+"','"+td.getPassword()+"',"
				+ "'"+td.getName()+"',"+td.getMobile()+",'"+td.getEmail()+"','"+td.getGender()+"',"
						+ "'"+td.getAddress()+"');";
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
	public boolean deleteDetails(TempDriver td) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from TempDriver where username = '"+td.getUsername()+"';";
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
	public boolean updateDetails(TempDriver td) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "update TempDriver set name = '"+td.getName()+"', mobile = "+td.getMobile()+", email = '"
				+ td.getEmail()+"',gender = '"+td.getGender()+"',address = '"+td.getAddress()+"' where username = '"+td.getUsername()+"';";
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
	public TempDriver getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from TempDriver where username = '"+uname+"' and password = '"+pwd+"';";
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next())
				return new TempDriver(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public List<TempDriver> getAllDetails() {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from TempDriver ;";
		ArrayList<TempDriver> al = new ArrayList();
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
				al.add(new TempDriver(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7)));
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
	public TempDriver getDetails(String uname) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from TempDriver where username = '"+uname+"';";
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next())
				return new TempDriver(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

}
