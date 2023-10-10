package com.src.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.PermDriver;
import com.src.model.TempDriver;

public class PermDriverServicesDao implements PermDriverServicesDaoInterface{

	public PermDriverServicesDao(){
		new PermDriver();
	}
	@Override
	public boolean addDetails(PermDriver pd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "insert into PermDriver values ('"+pd.getUsername()+"','"+pd.getPassword()+"',"
				+ "'"+pd.getName()+"',"+pd.getMobile()+",'"+pd.getEmail()+"','"+pd.getGender()+"',"
						+ "'"+pd.getAddress()+"');";
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
	public boolean deleteDetails(PermDriver pd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "delete from PermDriver where username = '"+pd.getUsername()+"';";
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
	public boolean updateDetails(PermDriver pd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "update PermDriver set name = '"+pd.getName()+"', mobile = "+pd.getMobile()+", email = '"
				+ pd.getEmail()+"',gender = '"+pd.getGender()+"',address = '"+pd.getAddress()+"' where username = '"+pd.getUsername()+"';";
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
	public PermDriver getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from PermDriver where username = '"+uname+"' and password = '"+pwd+"';";
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next())
				return new PermDriver(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public List<PermDriver> getAllDetails() {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from PermDriver ;";
		ArrayList<PermDriver> al = new ArrayList();
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
				al.add(new PermDriver(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7)));
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
	public PermDriver getDetails(String uname) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from PermDriver where username = '"+uname+"';";
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next())
				return new PermDriver(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

}
