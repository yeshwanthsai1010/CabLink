package com.src.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Admin;

public class AdminServicesDao implements AdminServicesDaoInterface{

	@Override
	public boolean addDetails(Admin ad) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "insert into Admin values ('"+ad.getUsername()+"','"+ad.getPassword()+"',"
				+ "'"+ad.getName()+"',"+ad.getMobile()+",'"+ad.getEmail()+"','"+ad.getGender()+"',"
						+ "'"+ad.getAddress()+"');";
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
	public boolean deleteDetails(Admin ad) {
		Statement st = Dao.getMyStatement();
		String query = "delete from Admin where username = '"+ad.getUsername()+"';";
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
	public boolean updateDetails(Admin ad) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "update Admin set name = '"+ad.getName()+"', mobile = "+ad.getMobile()+", email = '"
				+ ad.getEmail()+"',gender = '"+ad.getGender()+"',address = '"+ad.getAddress()+"' where username = '"+ad.getUsername()+"';";
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
	public Admin getDetails(String uname, String pwd) {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Admin where username = '"+uname+"' && password = '"+pwd+"';";
		try {
			ResultSet res = st.executeQuery(query);
			return new Admin(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}

	@Override
	public List<Admin> getAllDetails() {
		// TODO Auto-generated method stub
		Statement st = Dao.getMyStatement();
		String query = "select * from Admin ;";
		ArrayList<Admin> al = new ArrayList();
		try {
			ResultSet res = st.executeQuery(query);
			while(res.next()) {
				al.add(new Admin(res.getString(1),res.getString(2),res.getString(3),res.getLong(4),res.getString(5),res.getString(6).charAt(0),res.getString(7)));
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dao.closeMyStatement();
		return null;
	}
	
}
