package com.ebrain.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

		
public class DatabaseConnection{


	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 
	    Connection con =DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/dbms_april_2023","dbms_april_2023","Ebrain@20");
		System.out.println("completed");
	}
	
}

