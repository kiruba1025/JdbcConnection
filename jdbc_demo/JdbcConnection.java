package com.ebrain.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/dbms_april_2023",
				"dbms_april_2023", "Ebrain@20");
		return con;
	}
	public static void saveven(Integer id, String name, String code, String email, String phone,
			String contact_person, String contact_person_phone, String status, String created_date, String created_by,
			String modified_date, String modified_by) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String insertQuery = "INSERT INTO tb_customer_kiruba values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(insertQuery);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, code);
		pst.setString(4, email);
		pst.setString(5, phone);
		pst.setString(6, contact_person);
		pst.setString(7, contact_person_phone);
		pst.setString(8, status);
		pst.setString(9, created_date);
		pst.setString(10, created_by);
		pst.setString(11, modified_date);
		pst.setString(12, modified_by);
		pst.executeUpdate();
	}
	public static void getallcustomer()throws ClassNotFoundException, SQLException {
		Connection con= getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT id, name,code, email,  phone,contact_person_name, contact_person_phone,  status,  created_date, created_by,modified_date, modified_by FROM tb_customer_kiruba");
		ResultSet res =pst.executeQuery();
		while(res.next()) {
			Integer id =res.getInt(1);
			String name =res.getString(2);
			String code =res.getString(3);
			String email =res.getString(4);
			String phone =res.getString(5);
			String contact_person_name =res.getString(6);
			String contact_person_phone =res.getString(7);
			String status =res.getString(8);
			String created_date =res.getString(9);
			String created_by =res.getString(10);
			String modified_date =res.getString(11);
			String modified_by =res.getString(12);
			System.out.println(id +" ,"+name+", "+code+","+email+","+phone+"," +contact_person_name+","+contact_person_phone+","+status+","+created_date+","+created_by+","+modified_date+","+modified_by);
		}
	}
		
	
	
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
//		saveven(12, "Kiru", "1021", "kirubaBd@gmail.com", "9626421511", "kaviyac", "9743283217", "active",
//				"2023-05-30", "ADMIN", "2023-05-30", "ddddd");
//		saveven(13, "Kiru", "1021", "kirubaBd@gmail.com", "9626421511", "kaviyac", "9743283217", "active",
//				"2023-05-30", "ADMIN", "2023-05-30", "ddddd");
		getallcustomer();
		System.out.println("added");
	}
}
