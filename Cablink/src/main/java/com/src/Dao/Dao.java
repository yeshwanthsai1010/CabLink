package com.src.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {


	private static Connection con=null;
	private static Statement st=null;
	
	public static Statement getMyStatement()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// step 1 
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=yesh;integratedSecurity=true ;encrypt=true;trustServerCertificate=true");//step 2
			st=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;		
	}
	
	public static void closeMyStatement()
	{
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
