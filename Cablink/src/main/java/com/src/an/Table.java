package com.src.an;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Table {
	static Statement st = null;
	static Connection c = null;
	public static Statement getConn() {
		try {
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=yesh;integratedSecurity=true ;encrypt=true;trustServerCertificate=true");
			st = c.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;

	}

	public static void closeConn() {
		try {
			c.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean createTable(String name) {
		Class c = null;
		try {
			c = Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] f = c.getDeclaredFields();
		StringBuilder query = new StringBuilder("create table "+c.getSimpleName()+"(");
		for(Field tf:f) {
			
			String name1 = tf.getType().getSimpleName();
			String actname = null;
			if(name1.equals("int"))
				actname = "int";
			else if(name1.equals("boolean"))
				actname = "bit";
			else if(name1.equals("byte"))
				actname = "tinyint";
			else if(name1.equals("short"))
				actname = "smallint";
			else if(name1.equals("long"))
				actname = "bigint";
			else if(name1.equals("float"))
				actname = "real";
			else if(name1.equals("double"))
				actname = "float";
			else if(name1.equals("char"))
				actname = "char";
			else if(name1.equals("String"))
				actname = "varchar(30)";
			else 
				continue;
			query.append(tf.getName()+" "+actname);
//			System.out.println(tf.getA);
			if(tf.isAnnotationPresent(Constraint.class)) {
				query.append(" "+tf.getAnnotation(Constraint.class).constraint());
			}
			query.append(",");
		}
		query.deleteCharAt(query.length()-1);
		query.append(");");
		getConn();
		System.out.println(query);
		boolean check = false;
		
		try {
			check = st.execute(query.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
		closeConn();
 
		return check;
		
	}
}
