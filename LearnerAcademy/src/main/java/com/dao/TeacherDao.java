package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Teacher;
import com.resource.DbResource;

public class TeacherDao {
	
	public int addTeacher(Teacher tt) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into Teachers values(?,?)");
	        pstmt.setInt(1, tt.getTid());
	        pstmt.setString(2, tt.getTeacherName());
	        int res = pstmt.executeUpdate();
	        return res;
	        } 
		catch (Exception e) {
	            System.out.println("Something went wrong " +e.getMessage());
	            return 0;}
		}
	
	public List<Teacher> getTeachers() {
		List<Teacher> tl = new ArrayList<>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from teachers;");
	        ResultSet res = pstmt.executeQuery();
	        
	        while (res.next()) {
	        	int tid = res.getInt("tid");
	        	String teacherName = res.getString("teacherName");
	        	Teacher teacher = new Teacher(tid, teacherName);
	        	tl.add(teacher);
	        }
	        return tl;
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
		}
	
	public Teacher getTeachertDetails(int teacherId) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from teachers where tid=(?);");
			pstmt.setInt(1, teacherId);
	        ResultSet res = pstmt.executeQuery();
	        
	        if (res.next()) {
	        	int tid = res.getInt("tid");
	        	String teacherName = res.getString("teacherName");
	        	Teacher teacher = new Teacher(tid, teacherName);
	        	return teacher;
	        } else {
	        	return null;}
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
	}
		
		
}

