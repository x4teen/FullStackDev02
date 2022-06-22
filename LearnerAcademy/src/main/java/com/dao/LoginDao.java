package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Login;
import com.bean.Subject;
import com.resource.DbResource;

public class LoginDao {
	
	public int createLoginDeatils(Login ll) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into login values(?,?)");
	        pstmt.setString(1, ll.getEmail());
	        pstmt.setString(2, ll.getPassword());
	        int res = pstmt.executeUpdate();
	        return res;
	        } 
		catch (Exception e) {
	            System.out.println("Something went wrong " +e.getMessage());
	            return 0;}
		}
	
	
	public Login checkLoginDetails(Login ll) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from login where email = ? and password = ?");
	        pstmt.setString(1, ll.getEmail());
	        pstmt.setString(2, ll.getPassword());
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	        	String email = rs.getString("email");
	        	String password = "success";
	        	String name = rs.getString("name");
	        	String role = rs.getString("role");
	        	Login user = new Login(email, password, name, role);
	        	return user;
	        } else {
	        	return null;
	        } 
	        } 
		catch (Exception e) {
	            System.out.println("Something went wrong " +e.getMessage());
	            return null;}
		}
		
}
		



