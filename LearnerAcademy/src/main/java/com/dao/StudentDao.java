package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.resource.DbResource;

public class StudentDao {
	
	public int addStudent(Student st) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into students values(?,?,?)");
	        pstmt.setInt(1, st.getId());
	        pstmt.setString(2, st.getName());
	        pstmt.setInt(3, st.getCid());
	        int res = pstmt.executeUpdate();
	        return res;
	        } 
		catch (Exception e) {
	            System.out.println("Something went wrong " +e.getMessage());
	            return 0;}
		}
	
	public List<Student> getStudents() {
		List<Student> sl = new ArrayList<>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from students;");
	        ResultSet res = pstmt.executeQuery();
	        
	        while (res.next()) {
	        	int id = res.getInt("id");
	        	String StudentTitle = res.getString("name");
	        	int cid = res.getInt("cid");
	        	Student student = new Student(id, StudentTitle, cid);
	        	sl.add(student);
	        }
	        return sl;
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
		}
	
	
	public List<Student> getStudentsCourse(int courseId) {
		List<Student> sl = new ArrayList<>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from students where cid=(?);");
			pstmt.setInt(1, courseId);
	        ResultSet res = pstmt.executeQuery();
	        
	        while (res.next()) {
	        	int id = res.getInt("id");
	        	String StudentTitle = res.getString("name");
	        	int cid = res.getInt("cid");
	        	Student student = new Student(id, StudentTitle, cid);
	        	sl.add(student);
	        }
	        return sl;
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
		}
	
		
}

